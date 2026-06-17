package pe.edu.upc.center.jameoFit.tracking.interfaces.rest.resources;

import pe.edu.upc.center.jameoFit.tracking.domain.model.valueobjects.GoalTypes;

public record UpdateTrackingGoalResource(
        GoalTypes goalType
) {
}
