package org.dng;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Pet implements Serializable {
    @Serial
    private static final long serialVersionUID = 4L;

    private String name;


    private int health = 100;
    private int hungry = 0;
    private int happiness = 50;
    private boolean isAnabiosis;

    public Pet(String name) {
        this.name = name;
    }

    public void test(){
        if (hungry > 100){
            health -= (hungry - 100);
            hungry = 100;
        }

        if(health <= 20){
            isAnabiosis = true;
            System.out.println("Pet is in anabiosis - need reanimation!");
        }
        else {
            if (isAnabiosis){
                isAnabiosis = false;
                System.out.println("Pet gets out of anabiosis !");
            }
        }
    }

    public void live(){
        if (isAnabiosis){
            System.out.println("Pet is in anabiosis - need reanimation!");
            return;
        }
        hungry += 10;
        happiness -= 10;
        test();
    }


    public void eat(){
        if (isAnabiosis){
            System.out.println("Pet is in anabiosis - need reanimation!");
            return;
        }
        hungry = Math.max(0, (hungry -= 20));
        health = Math.min(100, (health+=10));
        happiness = Math.min(100, (happiness += 10));
        test();
    }

    public void play(){
        if (isAnabiosis){
            System.out.println("Pet is in anabiosis - need reanimation!");
            return;
        }
        hungry += 15;
        health = Math.min(100, (health+=5));
        happiness = Math.min(100, (happiness += 10));
        test();
    }

    public void sleep(){
        if (isAnabiosis){
            System.out.println("Pet is in anabiosis - need reanimation!");
            return;
        }
        hungry += 10;
        health = Math.min(100, (health+=5));
        happiness = Math.min(100, (happiness += 5));
        test();
    }

    public void resurrection(){
        if (isAnabiosis){
            health = 100;
            hungry = 0;
            happiness = 50;
            isAnabiosis = false;
            System.out.println(name+" is resurrected! ))");
        }
    }


    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", hungry=" + hungry +
                ", happiness=" + happiness +
                ", isAnabiosis=" + isAnabiosis +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return health == pet.health && hungry == pet.hungry && happiness == pet.happiness && isAnabiosis == pet.isAnabiosis && name.equals(pet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, hungry, happiness, isAnabiosis);
    }

}
