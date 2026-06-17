package pe.edu.upc.center.jameoFit.tracking.domain.services;

import pe.edu.upc.center.jameoFit.tracking.domain.model.commands.CreateMacronutrientValuesCommand;


public interface MacronutrientValuesCommandService {
    Long handle(CreateMacronutrientValuesCommand command);
}
