package pe.edu.upc.center.jameoFit.tracking.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.center.jameoFit.tracking.domain.model.Entities.TrackingMealPlanEntry;

import java.util.List;

@Repository
public interface TrackingMealPlanEntryRepository extends JpaRepository<TrackingMealPlanEntry, Long> {

    // CORREGIDO: usar el patron correcto para buscar por el id del objeto asociado 'tracking'
    List<TrackingMealPlanEntry> findAllByTracking_Id(Long trackingId);
}
