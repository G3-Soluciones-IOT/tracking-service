package pe.edu.upc.center.jameoFit.tracking.application.internal.queryservices;

import pe.edu.upc.center.jameoFit.tracking.domain.model.Entities.MacronutrientValues;
import pe.edu.upc.center.jameoFit.tracking.domain.model.queries.GetMacronutrientValuesByIdQuery;
import pe.edu.upc.center.jameoFit.tracking.domain.services.MacronutrientValuesQueryService;
import pe.edu.upc.center.jameoFit.tracking.infrastructure.persistence.jpa.repositories.MacronutrientValuesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MacronutrientValuesQueryServiceImpl implements MacronutrientValuesQueryService {

    private final MacronutrientValuesRepository macronutrientValuesRepository;

    public MacronutrientValuesQueryServiceImpl(MacronutrientValuesRepository macronutrientValuesRepository) {
        this.macronutrientValuesRepository = macronutrientValuesRepository;
    }

    // MÃ©todos existentes...

    @Override
    public Optional<MacronutrientValues> handle(GetMacronutrientValuesByIdQuery query) {
        return macronutrientValuesRepository.findById(query.macronutrientValuesId());
    }
}
