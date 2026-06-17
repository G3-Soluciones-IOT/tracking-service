package pe.edu.upc.center.jameoFit.tracking.domain.model.commands;

import pe.edu.upc.center.jameoFit.tracking.domain.model.Entities.MacronutrientValues;
import pe.edu.upc.center.jameoFit.tracking.domain.model.valueobjects.UserId;

public record CreateTrackingGoalCommand(UserId profile, MacronutrientValues macronutrientValues) {
}
