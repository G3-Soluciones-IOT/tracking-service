package pe.edu.upc.center.jameoFit.tracking.interfaces.rest.transform;

import pe.edu.upc.center.jameoFit.tracking.domain.model.Entities.MacronutrientValues;
import pe.edu.upc.center.jameoFit.tracking.domain.model.commands.CreateTrackingGoalCommand;
import pe.edu.upc.center.jameoFit.tracking.domain.model.valueobjects.UserId;
import pe.edu.upc.center.jameoFit.tracking.interfaces.rest.resources.CreateTrackingGoalResource;

public class CreateTrackingGoalCommandFromResourceAssembler {

    private CreateTrackingGoalCommandFromResourceAssembler() {
        // Private constructor to prevent instantiation
    }

    public static CreateTrackingGoalCommand toCommand(CreateTrackingGoalResource resource) {
        UserId userId = new UserId(resource.userId());

        MacronutrientValues targetMacros = new MacronutrientValues(
                resource.targetMacros().calories(),
                resource.targetMacros().carbs(),
                resource.targetMacros().proteins(),
                resource.targetMacros().fats()
        );

        return new CreateTrackingGoalCommand(userId, targetMacros);
    }
}
