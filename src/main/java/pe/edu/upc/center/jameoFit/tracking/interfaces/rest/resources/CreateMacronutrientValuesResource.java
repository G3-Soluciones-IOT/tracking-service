package pe.edu.upc.center.jameoFit.tracking.interfaces.rest.resources;
//para post
public record CreateMacronutrientValuesResource(
        double calories,
        double carbs,
        double proteins,
        double fats
) {
}
