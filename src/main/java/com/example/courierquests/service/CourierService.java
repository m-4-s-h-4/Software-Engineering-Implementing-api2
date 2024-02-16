package com.example.courierquests.service;

import com.harbour.eats.model.CourierAchievements;
import com.harbour.eats.model.CourierId;
import com.harbour.eats.model.CurrentQuestProgress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CourierService {

    private static final Logger logger = LoggerFactory.getLogger(CourierService.class);

    private final Map<String, CourierId> couriers = new HashMap<>();
    private final Map<String, CurrentQuestProgress> questProgressMap = new HashMap<>();
    private final Map<String, CourierAchievements> courierAchievementsMap = new HashMap<>();

    public CourierId createCourier(CourierId courierId) {
        logger.info("Creating courier with ID: {}", courierId.getCourierId());
        couriers.put(courierId.getCourierId(), courierId);
        return courierId;
    }

    public List<String> getAllCourierIds() {
        return List.copyOf(couriers.keySet());
    }

    public Optional<CurrentQuestProgress> getCurrentQuestProgress(String courierId) {
        return Optional.ofNullable(questProgressMap.get(courierId));
    }

    public Optional<CourierAchievements> getCourierAchievements(String courierId) {
        return Optional.ofNullable(courierAchievementsMap.get(courierId));
    }
    public void updateCurrentQuestProgress(String courierId, CurrentQuestProgress progress) {
        if (!couriers.containsKey(courierId)) {
            logger.error("Cannot update quest progress. Courier ID not found: {}", courierId);
            throw new IllegalArgumentException("Courier ID not found");
        }
        questProgressMap.put(courierId, progress);
        logger.info("Updated current quest progress for courier ID: {}", courierId);
    }
    public void updateCourierAchievements(String courierId, CourierAchievements achievements) {
        if (!couriers.containsKey(courierId)) {
            logger.error("Cannot update achievements. Courier ID not found: {}", courierId);
            throw new IllegalArgumentException("Courier ID not found");
        }
        courierAchievementsMap.put(courierId, achievements);
        logger.info("Updated achievements for courier ID: {}", courierId);
    }
}
