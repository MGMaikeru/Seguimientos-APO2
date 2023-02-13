package iu;
import model.*;

import java.util.Scanner;

public class Main {
    private static GameSystem controller;
    private static Scanner reader;

        public Main(){
            controller = new GameSystem();
            reader = new Scanner(System.in);
        }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("Welcome to a math game (really?)");
        String name = getName();
        int numberlevels = getNumberNodes();
        System.out.println(controller.createNodes(numberlevels));

        for (int i = 0; i<numberlevels; i++){
            controller.levelMarker();
            System.out.println(controller.print());
            System.out.println(controller.showOperation());
            System.out.println("Type answer:");
            int answer = reader.nextInt();
            controller.levelAdvance(answer);
        }
        System.out.println(controller.printReport(name));
    }

    public static String getName(){
        System.out.println("Enter your player name:");
        String name = reader.next();
        return name;
    }

    public static int getNumberNodes(){
        System.out.println("Enter the number of levels:");
        int numberLevels = reader.nextInt();
        return numberLevels;
    }
}