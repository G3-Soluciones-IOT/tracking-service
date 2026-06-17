package pe.edu.upc.center.jameoFit.tracking.domain.services;

import pe.edu.upc.center.jameoFit.tracking.domain.model.commands.SeedTrackingMasterDataCommand;

public interface TrackingMasterDataCommandService {
    void handle(SeedTrackingMasterDataCommand command);
}
