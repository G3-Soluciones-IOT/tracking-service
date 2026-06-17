// TrackingGoalResourceFromEntityAssembler.java
package pe.edu.upc.center.jameoFit.tracking.interfaces.rest.transform;

import pe.edu.upc.center.jameoFit.tracking.domain.model.Entities.TrackingGoal;
import pe.edu.upc.center.jameoFit.tracking.interfaces.rest.resources.TrackingGoalResource;

public class TrackingGoalResourceFromEntityAssembler {
    public static TrackingGoalResource toResource(TrackingGoal entity) {
        var targetMacros = MacronutrientValuesResourceFromEntityAssembler.toResource(entity.getTargetMacros());

        return new TrackingGoalResource(
                entity.getId(),
                entity.getUserId().userId(),
                targetMacros
        );
    }
}
