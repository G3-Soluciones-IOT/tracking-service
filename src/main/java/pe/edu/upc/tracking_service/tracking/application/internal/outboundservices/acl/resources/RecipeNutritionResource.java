package pe.edu.upc.tracking_service.tracking.application.internal.outboundservices.acl.resources;

public record RecipeNutritionResource(
        double calories,
        double carbs,
        double proteins,
        double fats
) {
}
