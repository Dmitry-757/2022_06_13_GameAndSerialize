package org.dng;

import java.io.Serial;
import java.io.Serializable;

public class Pet implements Serializable {
    @Serial
    private static final long serialVersionUID = 4L;

    private int health = 100;
    private int hungry = 0;
    private int happiness = 50;
    private boolean isAnabiosis;


    public void test(){
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
        if (hungry > 100){
            health = (hungry - 100);
            hungry = 100;
        }
    }


    public void eat(){
        if (isAnabiosis){
            System.out.println("Pet is in anabiosis - need reanimation!");
            return;
        }
        hungry = Math.min(0, (hungry -= 10));
        health = Math.max(100, (health+=10));
        happiness += 10;
        test();
    }

    public void play(){
        if (isAnabiosis){
            System.out.println("Pet is in anabiosis - need reanimation!");
            return;
        }
        hungry += 10;
        health = Math.max(100, (health+=5));
        happiness += 10;
        test();
    }

    public void sleep(){
        if (isAnabiosis){
            System.out.println("Pet is in anabiosis - need reanimation!");
            return;
        }
        hungry += 5;
        health = Math.max(100, (health+=5));
        happiness += 5;
        test();
    }


}
