package org.dng;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Service {
    private static String fileName = "game.sav";

    public static Pet readGame(){
        Pet pet = null;
        if (!Files.exists(Path.of(fileName))){
            System.out.println("File with saved game was not found! Create new pet.");
            return new Pet("Chubais");
        }

        try(FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            pet = (Pet) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException "+e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException "+e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException "+e.getMessage());
            e.printStackTrace();
        }
        return pet;
    }

    public static void saveGame(Pet pet) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(pet);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
            e.printStackTrace();
        }
    }

}
