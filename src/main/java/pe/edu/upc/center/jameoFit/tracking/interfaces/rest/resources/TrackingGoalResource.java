package pe.edu.upc.center.jameoFit.tracking.interfaces.rest.resources;
//para get y put
public record TrackingGoalResource(
        Long id,
        Long userId,
        MacronutrientValuesResource targetMacros
){ }
