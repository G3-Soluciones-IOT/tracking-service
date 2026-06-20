package pe.edu.upc.tracking_service.tracking.infrastructure.persistence.jpa.repositories;



import pe.edu.upc.tracking_service.tracking.domain.model.aggregates.Tracking;
import pe.edu.upc.tracking_service.tracking.domain.model.valueobjects.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrackingRepository extends JpaRepository<Tracking, Long> {
    Optional<Tracking> findByUserId(UserId userId);
    boolean existsByUserId(UserId userId);
}
