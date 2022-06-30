package test;

import org.dng.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.lang.reflect.Field;


class PetTest {
    private Pet pet;

    @BeforeEach
    void setUp() {
        pet = new Pet("Chubaice");
    }

    @org.junit.jupiter.api.Test
    void live() {
//        hungry += 10;
//        happiness -= 10;
        int hungryBefore = -1;
        int happinessBefore = -1;
        int hungryAfter = -1;
        int happinessAfter = -1;
        try {
            Field hungry = pet.getClass().getDeclaredField("hungry");
            hungry.setAccessible(true);
            hungryBefore = (int)hungry.get(pet);
            Field happiness = pet.getClass().getDeclaredField("happiness");
            happiness.setAccessible(true);
            happinessBefore = (int)happiness.get(pet);

            pet.live();

            hungryAfter = (int)hungry.get(pet);
            happinessAfter = (int)happiness.get(pet);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Exception! "+e.getMessage());
            e.printStackTrace();
        }

        Assertions.assertEquals(hungryBefore+10, hungryAfter);
        Assertions.assertEquals(happinessBefore-10, happinessAfter);

    }

    @org.junit.jupiter.api.Test
    void eat() {
//        hungry = Math.max(0, (hungry -= 20));
//        health = Math.min(100, (health+=10));
//        happiness = Math.min(100, (happiness += 10));

        int hungryBefore = -1;
        int hungryAfter = -1;
        int happinessBefore = -1;
        int happinessAfter = -1;
        int healthBefore = -1;
        int healthAfter = -1;

        try {
            Field hungry = pet.getClass().getDeclaredField("hungry");
            hungry.setAccessible(true);
            hungryBefore = (int)hungry.get(pet);
            Field happiness = pet.getClass().getDeclaredField("happiness");
            happiness.setAccessible(true);
            happinessBefore = (int)happiness.get(pet);

            Field health = pet.getClass().getDeclaredField("health");
            health.setAccessible(true);
            healthBefore = (int)health.get(pet);

            pet.eat();

            hungryAfter = (int)hungry.get(pet);
            happinessAfter = (int)happiness.get(pet);
            healthAfter = (int)health.get(pet);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Exception! "+e.getMessage());
            e.printStackTrace();
        }


//        hungry = Math.max(0, (hungry -= 20));
//        health = Math.min(100, (health+=10));
//        happiness = Math.min(100, (happiness += 10));
        int hungryExpected = Math.max(0, (hungryBefore -= 20));
        int healthExpected = Math.min(100, (healthBefore+=10));
        int happinessExpected = Math.min(100, (happinessBefore += 10));
        Assertions.assertEquals(hungryExpected, hungryAfter);
        Assertions.assertEquals(healthExpected,healthAfter);
        Assertions.assertEquals(happinessExpected, happinessAfter);

    }

    @org.junit.jupiter.api.Test
    void play() {

        int hungryBefore = -1;
        int hungryAfter = -1;
        int happinessBefore = -1;
        int happinessAfter = -1;
        int healthBefore = -1;
        int healthAfter = -1;

        try {
            Field hungry = pet.getClass().getDeclaredField("hungry");
            hungry.setAccessible(true);
            hungryBefore = (int)hungry.get(pet);
            Field happiness = pet.getClass().getDeclaredField("happiness");
            happiness.setAccessible(true);
            happinessBefore = (int)happiness.get(pet);

            Field health = pet.getClass().getDeclaredField("health");
            health.setAccessible(true);
            healthBefore = (int)health.get(pet);

            pet.play();

            hungryAfter = (int)hungry.get(pet);
            happinessAfter = (int)happiness.get(pet);
            healthAfter = (int)health.get(pet);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Exception! "+e.getMessage());
            e.printStackTrace();
        }


//        hungry += 15;
//        health = Math.min(100, (health+=5));
//        happiness = Math.min(100, (happiness += 10));
        int hungryExpected = (hungryBefore += 15);
        int healthExpected = Math.min(100, (healthBefore+=5));
        int happinessExpected = Math.min(100, (happinessBefore += 10));

        Assertions.assertEquals(hungryExpected, hungryAfter);
        Assertions.assertEquals(healthExpected,healthAfter);
        Assertions.assertEquals(happinessExpected, happinessAfter);

    }

    @org.junit.jupiter.api.Test
    void sleep() {
        int hungryBefore = -1;
        int hungryAfter = -1;
        int happinessBefore = -1;
        int happinessAfter = -1;
        int healthBefore = -1;
        int healthAfter = -1;

        try {
            Field hungry = pet.getClass().getDeclaredField("hungry");
            hungry.setAccessible(true);
            hungryBefore = (int)hungry.get(pet);
            Field happiness = pet.getClass().getDeclaredField("happiness");
            happiness.setAccessible(true);
            happinessBefore = (int)happiness.get(pet);

            Field health = pet.getClass().getDeclaredField("health");
            health.setAccessible(true);
            healthBefore = (int)health.get(pet);

            pet.sleep();

            hungryAfter = (int)hungry.get(pet);
            happinessAfter = (int)happiness.get(pet);
            healthAfter = (int)health.get(pet);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Exception! "+e.getMessage());
            e.printStackTrace();
        }

//        hungry += 10;
//        health = Math.min(100, (health+=5));
//        happiness = Math.min(100, (happiness += 5));
        int hungryExpected = (hungryBefore += 10);
        int healthExpected = Math.min(100, (healthBefore+=5));
        int happinessExpected = Math.min(100, (happinessBefore += 5));

        Assertions.assertEquals(hungryExpected, hungryAfter);
        Assertions.assertEquals(healthExpected,healthAfter);
        Assertions.assertEquals(happinessExpected, happinessAfter);

    }

    @org.junit.jupiter.api.Test
    void resurrection() {
    }
}