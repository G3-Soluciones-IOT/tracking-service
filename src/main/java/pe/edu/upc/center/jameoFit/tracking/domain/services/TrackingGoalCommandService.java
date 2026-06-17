package pe.edu.upc.center.jameoFit.tracking.domain.services;


import pe.edu.upc.center.jameoFit.tracking.domain.model.commands.CreateTrackingGoalCommand;
import pe.edu.upc.center.jameoFit.tracking.domain.model.commands.UpdateTrackingGoalCommand;

public interface TrackingGoalCommandService {
    Long handle(CreateTrackingGoalCommand command);
    void handle(UpdateTrackingGoalCommand command);
}
