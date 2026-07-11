DO $$
BEGIN
    IF to_regclass('public.mealplan_type') IS NOT NULL
       AND to_regclass('public.mealplan_types') IS NULL THEN
        ALTER TABLE mealplan_type RENAME TO mealplan_types;
    END IF;

    IF to_regclass('public.tracking_goal') IS NOT NULL
       AND to_regclass('public.tracking_goals') IS NULL THEN
        ALTER TABLE tracking_goal RENAME TO tracking_goals;
    END IF;

    IF to_regclass('public.tracking') IS NOT NULL
       AND to_regclass('public.trackings') IS NULL THEN
        ALTER TABLE tracking RENAME TO trackings;
    END IF;

    IF to_regclass('public.tracking_meal_plan_entry') IS NOT NULL
       AND to_regclass('public.tracking_meal_plan_entries') IS NULL THEN
        ALTER TABLE tracking_meal_plan_entry RENAME TO tracking_meal_plan_entries;
    END IF;
END $$;
