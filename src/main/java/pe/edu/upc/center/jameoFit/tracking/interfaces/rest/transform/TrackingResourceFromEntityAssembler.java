// TrackingResourceFromEntityAssembler.java
package pe.edu.upc.center.jameoFit.tracking.interfaces.rest.transform;

import pe.edu.upc.center.jameoFit.tracking.domain.model.aggregates.Tracking;
import pe.edu.upc.center.jameoFit.tracking.interfaces.rest.resources.TrackingResource;

public class TrackingResourceFromEntityAssembler {
    public static TrackingResource toResource(Tracking entity) {
        var consumedMacros = MacronutrientValuesResourceFromEntityAssembler.toResource(entity.getConsumedMacros());
        var mealPlanEntries = entity.getMealPlanEntries().getMealPlanEntries().stream()
                .map(MealPlanEntriesResourceFromEntityAssembler::toResource)
                .toList();

        return new TrackingResource(
                entity.getId(),
                entity.getUserId().userId(),
                entity.getDate(),
                consumedMacros,
                mealPlanEntries
        );
    }
}
