package model;

import java.util.ArrayList;
public class Si {

    private ArrayList<Integer> dp;
    public static final int[] S = {100000, 50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50};


    public Si(){
        dp = new ArrayList<Integer>();
    }

    public int sum(int[] array){
        return sum(1, array, array[0]);
    }

    private int sum(int index, int[] array, int result){
        if(index == array.length){
            return result;
        }
        result += array[index];
        return sum(++index, array, result);
    }

    public String reverse(int index, String word){
        if(index==0){
            return word.charAt(index) + "";
        }

        return word.charAt(index) + reverse(--index, word);
    }


    public double prom(double[] array){
        return prom(1, array, array[0]);
    }
    private double prom(int index, double[] array, double result){
        if(index == array.length){
            return result/index;
        }
        result += array[index];
        return prom(++index, array, result);
    }


    public int searchNumber(int[] array, int number){
        return searchNumber(0, array, number);
    }
    public int searchNumber(int index, int[] array, int number){
        if(number == array[index] || index<array.length){
            return index;
        }
        return searchNumber(++index, array, number);
    }


    public int division(int divisor, int numerando){
        return division(divisor, numerando, 0);
    }

    private int division(int divisor, int numerando, int result){
        if (numerando < divisor){
            return result;
        }
        result +=1;
        numerando -= divisor;
        return division(divisor, numerando, result);
    }

    public int mcd1(int a, int b){
        if (a>=b){
            return mcd(a,b);
        }
        return mcd(b,a);
    }

    public int mcd(int a, int b){
        if (b == 0){
            return a;
        }
        int c = a;
        a=b;
        b= c%b;
        return mcd(a,b);
    }

    public ArrayList<Integer> pay(int target, int index) {
        if (target == 0) {
            return dp;
        }

        if (target < S[index]) {
            return pay(target, ++index);
        }
        dp.add(S[index]);
        target -= S[index];
        return pay(target, index);
    }
}
