package pe.edu.upc.tracking_service.tracking.interfaces.rest.resources;

public record WeeklyWaterIntakeResource(
        Long userId,
        Integer averageWaterMl,
        Integer daysBelowGoal,
        Integer bestDayMl
) {
}
