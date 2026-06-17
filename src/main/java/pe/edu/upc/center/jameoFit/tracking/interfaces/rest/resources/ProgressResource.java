package pe.edu.upc.center.jameoFit.tracking.interfaces.rest.resources;

public record ProgressResource(
        MacroProgressResource calories,
        MacroProgressResource carbs,
        MacroProgressResource proteins,
        MacroProgressResource fats
) { }
