package pe.edu.upc.center.jameoFit.tracking.interfaces.rest.resources;

public record MacroProgressResource(
        double consumed,
        double target,
        double percent
) { }
