package pe.edu.upc.center.jameoFit.tracking.interfaces.rest.resources;
//para post
public record CreateTrackingGoalResource(
        Long userId,
        CreateMacronutrientValuesResource targetMacros
) {
}
