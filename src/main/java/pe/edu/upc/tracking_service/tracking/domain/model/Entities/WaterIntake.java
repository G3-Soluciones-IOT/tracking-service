package pe.edu.upc.tracking_service.tracking.domain.model.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import pe.edu.upc.tracking_service.shared.domain.model.entities.AuditableModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "water_intakes")
public class WaterIntake extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Integer amountMl;

    @Column(nullable = false)
    private LocalDate intakeDate;

    @Column(nullable = false)
    private LocalDateTime registeredAt;

    public WaterIntake() {
    }

    public WaterIntake(Long userId, Integer amountMl, LocalDate intakeDate, LocalDateTime registeredAt) {
        this.userId = userId;
        this.amountMl = amountMl;
        this.intakeDate = intakeDate;
        this.registeredAt = registeredAt;
    }
}
