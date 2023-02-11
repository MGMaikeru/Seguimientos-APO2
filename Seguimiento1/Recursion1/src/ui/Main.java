package ui;

import model.Si;

public class Main{

    public static void main(String[] args) {

        Si r = new Si();
        System.out.println("Recursion Examples!!");

        System.out.println("Sum Array: ");

        // así se inicializa un arreglo ... ( ¬_¬)
        int[] array = {12, -1, 15, 2, 4 , 14};
        System.out.println(r.sum(array));

        System.out.println("Word reverse: ");
        String word = "Pitote";
        System.out.println(r.reverse(word.length()-1, word));

        System.out.println("Prom: ");
        double[] array1 = {1, 2, 3, 4, 5, 6};
        System.out.println(r.prom(array1));

        System.out.println("Search: ");
        int[] array2 = {1, 15, 8, 19, 21, 40, -4, 10};
        int number = -1;
        System.out.println("El numero " + number + " esta en la posición " + r.searchNumber(array2, number));

        System.out.println("Division: ");
        int divisor = 2;
        int numerando = 8;
        System.out.println("El numero " + numerando + " dividido en "+ divisor +" da un resultado de " + r.division(divisor, numerando));

        System.out.println("M.C.D: ");
        int a = 36;
        int b = 80;
        System.out.println("El M.C.D de " + a + " y  "+ b +" es de " + r.mcd(a, b));

        System.out.println("Pay: ");
        System.out.println(r.pay(82550, 0));
    }
}