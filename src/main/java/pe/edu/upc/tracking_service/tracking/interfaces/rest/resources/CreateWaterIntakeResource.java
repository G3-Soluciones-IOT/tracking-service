package pe.edu.upc.tracking_service.tracking.interfaces.rest.resources;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CreateWaterIntakeResource(
        @NotNull Long userId,
        @NotNull @Min(1) Integer amountMl
) {
}
