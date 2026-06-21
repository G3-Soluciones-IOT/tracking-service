package pe.edu.upc.tracking_service.tracking.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.tracking_service.tracking.domain.model.Entities.WaterIntake;

import java.time.LocalDate;
import java.util.List;

public interface WaterIntakeRepository extends JpaRepository<WaterIntake, Long> {
    List<WaterIntake> findByUserIdAndIntakeDate(Long userId, LocalDate intakeDate);

    List<WaterIntake> findByUserIdAndIntakeDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
}
