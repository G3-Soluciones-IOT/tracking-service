package pe.edu.upc.center.jameoFit.tracking.interfaces.rest.resources;

import java.time.LocalDate;
import java.util.List;

//para get y put
public record TrackingResource(
        Long id,
        Long userId,
        //@JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate date,
        MacronutrientValuesResource consumedMacros,
        List<MealPlanEntriesResource> mealPlanEntries
) { }
