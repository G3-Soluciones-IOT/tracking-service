package pe.edu.upc.tracking_service.tracking.interfaces.rest.resources;

import java.time.LocalDate;

public record DailyWaterIntakeResource(
        Long userId,
        LocalDate date,
        Integer totalWaterMl
) {
}
