package pe.edu.upc.center.jameoFit.tracking.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.center.jameoFit.tracking.domain.model.Entities.MealPlanType;
import pe.edu.upc.center.jameoFit.tracking.domain.model.valueobjects.MealPlanTypes;

import java.util.Optional;

@Repository
public interface TrackingMealPlanTypeRepository extends JpaRepository<MealPlanType, Long> {
    boolean existsByName(MealPlanTypes mealPlanType);
    Optional<MealPlanType> findByName(MealPlanTypes name);
}
