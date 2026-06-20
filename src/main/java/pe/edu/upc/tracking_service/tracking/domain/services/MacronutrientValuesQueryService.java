package pe.edu.upc.tracking_service.tracking.domain.services;

import pe.edu.upc.tracking_service.tracking.domain.model.Entities.MacronutrientValues;

import pe.edu.upc.tracking_service.tracking.domain.model.queries.GetMacronutrientValuesByIdQuery;

import java.util.Optional;

public interface MacronutrientValuesQueryService {

    // MÃ©todos existentes...

    /**
     * Obtiene MacronutrientValues por ID
     */
    Optional<MacronutrientValues> handle(GetMacronutrientValuesByIdQuery query);
}
