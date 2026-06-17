package pe.edu.upc.center.jameoFit.tracking.infrastructure.persistence.jpa.repositories;

import pe.edu.upc.center.jameoFit.tracking.domain.model.Entities.TrackingGoal;
import pe.edu.upc.center.jameoFit.tracking.domain.model.valueobjects.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrackingGoalRepository extends JpaRepository<TrackingGoal, Long> {
    Optional<TrackingGoal> findByUserId(UserId userId);
    boolean existsByUserId(UserId userId);
    //Optional<MacronutrientValues> findTargetMacrosByTrackingGoalId(Long trackingGoalId);
}
