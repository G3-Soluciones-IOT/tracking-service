package pe.edu.upc.center.jameoFit.tracking.domain.model.commands;

import pe.edu.upc.center.jameoFit.tracking.domain.model.valueobjects.GoalTypes;
import pe.edu.upc.center.jameoFit.tracking.domain.model.valueobjects.UserId;

public record UpdateTrackingGoalCommand(
        UserId userId,
        GoalTypes goalType
) {
}
