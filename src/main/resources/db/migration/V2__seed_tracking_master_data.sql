INSERT INTO mealplan_type (name)
SELECT 'BREAKFAST'
WHERE NOT EXISTS (SELECT 1 FROM mealplan_type WHERE name = 'BREAKFAST');

INSERT INTO mealplan_type (name)
SELECT 'LUNCH'
WHERE NOT EXISTS (SELECT 1 FROM mealplan_type WHERE name = 'LUNCH');

INSERT INTO mealplan_type (name)
SELECT 'DINNER'
WHERE NOT EXISTS (SELECT 1 FROM mealplan_type WHERE name = 'DINNER');

INSERT INTO mealplan_type (name)
SELECT 'HEALTHY'
WHERE NOT EXISTS (SELECT 1 FROM mealplan_type WHERE name = 'HEALTHY');

INSERT INTO macronutrient_values (calories, carbs, proteins, fats)
SELECT 2000.0, 250.0, 125.0, 55.6
WHERE NOT EXISTS (
    SELECT 1 FROM macronutrient_values
    WHERE calories = 2000.0 AND carbs = 250.0 AND proteins = 125.0 AND fats = 55.6
);

INSERT INTO macronutrient_values (calories, carbs, proteins, fats)
SELECT 1500.0, 150.0, 131.25, 41.7
WHERE NOT EXISTS (
    SELECT 1 FROM macronutrient_values
    WHERE calories = 1500.0 AND carbs = 150.0 AND proteins = 131.25 AND fats = 41.7
);

INSERT INTO macronutrient_values (calories, carbs, proteins, fats)
SELECT 2500.0, 343.75, 156.25, 55.6
WHERE NOT EXISTS (
    SELECT 1 FROM macronutrient_values
    WHERE calories = 2500.0 AND carbs = 343.75 AND proteins = 156.25 AND fats = 55.6
);

INSERT INTO macronutrient_values (calories, carbs, proteins, fats)
SELECT 1800.0, 22.5, 112.5, 140.0
WHERE NOT EXISTS (
    SELECT 1 FROM macronutrient_values
    WHERE calories = 1800.0 AND carbs = 22.5 AND proteins = 112.5 AND fats = 140.0
);
