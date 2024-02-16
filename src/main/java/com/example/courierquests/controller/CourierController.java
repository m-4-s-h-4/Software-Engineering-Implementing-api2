package com.example.courierquests.controller;

import com.harbour.eats.model.CourierAchievements;
import com.harbour.eats.model.CourierId;
import com.harbour.eats.model.CurrentQuestProgress;
import com.example.courierquests.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/v1/couriers")
public class CourierController {

    private final CourierService courierService;

    @Autowired
    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    @PostMapping
    public ResponseEntity<CourierId> createCourier(@RequestBody CourierId courierId) {
        CourierId createdCourier = courierService.createCourier(courierId);
        return new ResponseEntity<>(createdCourier, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllCourierIds() {
        List<String> courierIds = courierService.getAllCourierIds();
        return ResponseEntity.ok(courierIds);
    }

    @GetMapping("/{courierId}/current-quest")
    public ResponseEntity<CurrentQuestProgress> getCurrentQuestProgress(@PathVariable String courierId) {
        return courierService.getCurrentQuestProgress(courierId)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Current quest progress not found for courier ID: " + courierId));
    }
    @GetMapping("/{courierId}/achievements")
    public ResponseEntity<CourierAchievements> getCourierAchievements(@PathVariable String courierId) {
        return courierService.getCourierAchievements(courierId)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Achievements not found for courier ID: " + courierId));
    }
    @PostMapping("/{courierId}/current-quest")
    public ResponseEntity<Void> updateCurrentQuestProgress(@PathVariable String courierId, @RequestBody CurrentQuestProgress progress) {
        courierService.updateCurrentQuestProgress(courierId, progress);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/{courierId}/achievements")
    public ResponseEntity<Void> updateCourierAchievements(@PathVariable String courierId, @RequestBody CourierAchievements achievements) {
        courierService.updateCourierAchievements(courierId, achievements);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
