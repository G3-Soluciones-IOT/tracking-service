package pe.edu.upc.tracking_service.tracking.interfaces.rest;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.tracking_service.tracking.application.internal.services.WaterIntakeService;
import pe.edu.upc.tracking_service.tracking.interfaces.rest.resources.CreateWaterIntakeResource;
import pe.edu.upc.tracking_service.tracking.interfaces.rest.resources.DailyWaterIntakeResource;
import pe.edu.upc.tracking_service.tracking.interfaces.rest.resources.WeeklyWaterIntakeResource;

@RestController
@RequestMapping(value = "/api/v1/water-intakes", produces = MediaType.APPLICATION_JSON_VALUE)
public class WaterIntakesController {
    private final WaterIntakeService waterIntakeService;

    public WaterIntakesController(WaterIntakeService waterIntakeService) {
        this.waterIntakeService = waterIntakeService;
    }

    @PostMapping
    public ResponseEntity<DailyWaterIntakeResource> register(
            @Valid @RequestBody CreateWaterIntakeResource resource
    ) {
        var dailyWaterIntake = waterIntakeService.register(resource.userId(), resource.amountMl());
        return ResponseEntity.status(HttpStatus.CREATED).body(dailyWaterIntake);
    }

    @GetMapping("/user/{userId}/today")
    public ResponseEntity<DailyWaterIntakeResource> getToday(@PathVariable Long userId) {
        return ResponseEntity.ok(waterIntakeService.getToday(userId));
    }

    @GetMapping("/user/{userId}/weekly-summary")
    public ResponseEntity<WeeklyWaterIntakeResource> getWeeklySummary(@PathVariable Long userId) {
        return ResponseEntity.ok(waterIntakeService.getWeeklySummary(userId));
    }
}
