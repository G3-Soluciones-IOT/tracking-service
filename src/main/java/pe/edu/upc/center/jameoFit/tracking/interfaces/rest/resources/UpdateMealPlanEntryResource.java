package pe.edu.upc.center.jameoFit.tracking.interfaces.rest.resources;

public record UpdateMealPlanEntryResource(
        Long trackingId,
        Long recipeId,
        String mealPlanType,
        int dayNumber
) {}
