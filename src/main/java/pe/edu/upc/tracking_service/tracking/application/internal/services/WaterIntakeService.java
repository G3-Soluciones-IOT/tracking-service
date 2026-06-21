package pe.edu.upc.tracking_service.tracking.application.internal.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.tracking_service.tracking.domain.model.Entities.WaterIntake;
import pe.edu.upc.tracking_service.tracking.infrastructure.persistence.jpa.repositories.WaterIntakeRepository;
import pe.edu.upc.tracking_service.tracking.interfaces.rest.resources.DailyWaterIntakeResource;
import pe.edu.upc.tracking_service.tracking.interfaces.rest.resources.WeeklyWaterIntakeResource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WaterIntakeService {
    private static final int DAILY_WATER_GOAL_ML = 2000;
    private static final int WEEK_DAYS = 7;

    private final WaterIntakeRepository waterIntakeRepository;

    public WaterIntakeService(WaterIntakeRepository waterIntakeRepository) {
        this.waterIntakeRepository = waterIntakeRepository;
    }

    @Transactional
    public DailyWaterIntakeResource register(Long userId, Integer amountMl) {
        var today = LocalDate.now();
        var waterIntake = new WaterIntake(userId, amountMl, today, LocalDateTime.now());
        waterIntakeRepository.save(waterIntake);

        return getDailyTotal(userId, today);
    }

    @Transactional(readOnly = true)
    public DailyWaterIntakeResource getToday(Long userId) {
        return getDailyTotal(userId, LocalDate.now());
    }

    @Transactional(readOnly = true)
    public WeeklyWaterIntakeResource getWeeklySummary(Long userId) {
        var endDate = LocalDate.now();
        var startDate = endDate.minusDays(WEEK_DAYS - 1L);
        var intakes = waterIntakeRepository.findByUserIdAndIntakeDateBetween(userId, startDate, endDate);
        Map<LocalDate, Integer> totalsByDate = intakes.stream()
                .collect(Collectors.groupingBy(
                        WaterIntake::getIntakeDate,
                        Collectors.summingInt(WaterIntake::getAmountMl)
                ));

        int totalWeekMl = 0;
        int daysBelowGoal = 0;
        int bestDayMl = 0;

        for (int day = 0; day < WEEK_DAYS; day++) {
            var date = startDate.plusDays(day);
            int dailyTotal = totalsByDate.getOrDefault(date, 0);
            totalWeekMl += dailyTotal;
            bestDayMl = Math.max(bestDayMl, dailyTotal);

            if (dailyTotal < DAILY_WATER_GOAL_ML) {
                daysBelowGoal++;
            }
        }

        return new WeeklyWaterIntakeResource(userId, totalWeekMl / WEEK_DAYS, daysBelowGoal, bestDayMl);
    }

    private DailyWaterIntakeResource getDailyTotal(Long userId, LocalDate date) {
        int totalWaterMl = waterIntakeRepository.findByUserIdAndIntakeDate(userId, date)
                .stream()
                .mapToInt(WaterIntake::getAmountMl)
                .sum();

        return new DailyWaterIntakeResource(userId, date, totalWaterMl);
    }
}
