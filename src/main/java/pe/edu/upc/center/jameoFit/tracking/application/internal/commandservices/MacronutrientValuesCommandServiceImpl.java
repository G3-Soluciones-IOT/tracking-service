package pe.edu.upc.center.jameoFit.tracking.application.internal.commandservices;

import pe.edu.upc.center.jameoFit.tracking.domain.model.Entities.MacronutrientValues;
import pe.edu.upc.center.jameoFit.tracking.domain.model.commands.CreateMacronutrientValuesCommand;
import pe.edu.upc.center.jameoFit.tracking.domain.services.MacronutrientValuesCommandService;
import pe.edu.upc.center.jameoFit.tracking.infrastructure.persistence.jpa.repositories.MacronutrientValuesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class MacronutrientValuesCommandServiceImpl implements MacronutrientValuesCommandService {

    private final MacronutrientValuesRepository macronutrientValuesRepository;

    public MacronutrientValuesCommandServiceImpl(MacronutrientValuesRepository macronutrientValuesRepository) {
        this.macronutrientValuesRepository = macronutrientValuesRepository;
    }

    @Transactional
    public Long handle(CreateMacronutrientValuesCommand command) {
        MacronutrientValues values = new MacronutrientValues(
                command.calories(),
                command.carbs(),
                command.proteins(),
                command.fats()
        );

        MacronutrientValues saved = macronutrientValuesRepository.save(values);
        return saved.getId();
    }
}
