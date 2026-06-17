package pe.edu.upc.center.jameoFit.tracking.domain.model.commands;

import pe.edu.upc.center.jameoFit.tracking.domain.model.Entities.MealPlanType;
import pe.edu.upc.center.jameoFit.tracking.domain.model.valueobjects.RecipeId;
import pe.edu.upc.center.jameoFit.tracking.domain.model.valueobjects.UserId;

public record CreateMealPlanEntryToTrackingCommand(UserId userId, Long TrackingId, RecipeId recipeId, MealPlanType mealPlanType, int DayNumber) {
}
