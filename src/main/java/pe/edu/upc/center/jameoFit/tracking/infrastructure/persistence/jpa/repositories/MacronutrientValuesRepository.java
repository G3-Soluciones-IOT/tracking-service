package pe.edu.upc.center.jameoFit.tracking.infrastructure.persistence.jpa.repositories;


import pe.edu.upc.center.jameoFit.tracking.domain.model.Entities.MacronutrientValues;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MacronutrientValuesRepository extends JpaRepository<MacronutrientValues, Long> {
    //Consumed Macros
    //Target Macros
    //Optional<MacronutrientValues> findTargetMacrosByTrackingGoalId(@Param("trackingGoalId") Long trackingGoalId);

    boolean existsByCaloriesAndCarbsAndProteinsAndFats(double calories, double carbs, double proteins, double fats);
}
