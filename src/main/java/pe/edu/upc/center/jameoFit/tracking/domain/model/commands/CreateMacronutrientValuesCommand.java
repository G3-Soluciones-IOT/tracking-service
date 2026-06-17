package pe.edu.upc.center.jameoFit.tracking.domain.model.commands;

public record CreateMacronutrientValuesCommand(Long id, double calories, double carbs, double proteins, double fats) {
}
