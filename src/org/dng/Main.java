package org.dng;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Pet pet = new Pet("Chubais");
        Pet pet = Service.readGame();


        try(Scanner sc = new Scanner(System.in)){
            while (true) {
                System.out.println();
                System.out.println("1 - Feed the pet");
                System.out.println("2 - Play with a pet");
                System.out.println("3 - sleep");
                System.out.println("4 - wait");
                System.out.println("5 - Status pet");
                System.out.println("7 - Resurrect the pet");
                System.out.println("0 - game over ))");
                int input = sc.nextInt();
                switch (input) {
                    case 0 -> {
                        Service.saveGame(pet);
                        return;
                    }
                    case 1->{
                        pet.eat();
                        System.out.println(pet);
                    }
                    case 2-> {
                        pet.play();
                        System.out.println(pet);
                    }
                    case 3-> {
                        pet.sleep();
                        System.out.println(pet);
                    }
                    case 4-> {
                        pet.live();
                        System.out.println(pet);
                    }
                    case 5-> {
                        System.out.println(pet);
                    }
                    case 7->{pet.resurrection();}

                    default-> {
                        System.out.println("Wrong input...");
                    }
                }
            }

        }
    }
}
