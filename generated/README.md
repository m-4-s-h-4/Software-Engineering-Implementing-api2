# HarbourEats Application

Documentation for the Courier Service API, outlining the available endpoints and their usage.

## Endpoints

### Create a New Courier

Create a new courier entry in the system.

```bash
curl -X POST http://localhost:8080/v1/couriers \
-H "Content-Type: application/json" \
-d '{"courierId": "12345"}'
```

### Get All Couriers
Retrieve information about all couriers currently registered.

```bash
curl http://localhost:8080/v1/couriers
```

### Update Current Quest Progress for a Courier
Update the current quest progress for a specific courier.

```bash
curl -X POST http://localhost:8080/v1/couriers/12345/current-quest \
-H "Content-Type: application/json" \
-d '{"courierId": "12345", "currentTier": "silver", "nextTier": "gold", "ordersCompleted": 10, "ordersNeededForNextTier": 20, "rewardForCurrentTier": 50.0, "timeLeftToCompleteTier": "PT1H30M"}'
```

### Get Current Quest Progress for a Courier
Retrieve the current quest progress for a specific courier.
```bash
curl http://localhost:8080/v1/couriers/12345/current-quest
```

### Update Courier Achievements
Update the achievements for a specific courier.

```bash
curl -X POST http://localhost:8080/v1/couriers/12345/achievements \
-H "Content-Type: application/json" \
-d '{"courierId": "12345", "totalDeliveries": 50, "totalEarnings": 250.0, "currentTier": "gold", "ordersLeftForNextTier": 5}'
```

### Get Achievements for a Courier
```bash
curl http://localhost:8080/v1/couriers/12345/achievements
```