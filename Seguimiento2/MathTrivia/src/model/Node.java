package model;
import java.util.Random;

public class Node {
    private String value;
    private int result;
    private String operation;
    private Node next;

    public Node(String value){
        Random r = new Random();
        int randomOperator = r.nextInt(4)+1;
        this.value = value;
        int a = getA();
        int b = getB();
        this.operation = getOperation(a, b, randomOperator);
        this.result = getResult(a, b, randomOperator);
    }

    public String getValue(){
        return this.value;
    }

    public void setValue(String value){
        this.value= value;
    }

    public Node getNext(){
        return this.next;
    }

    public String getOperation(){ return this.operation;}

    public int getResult(){ return this.result;}

    public void setNext(Node next){
        this.next = next;
    }


    public int getA(){
        Random r = new Random();
        int a = r.nextInt(100);
        return a;
    }

    public int getB(){
        Random r = new Random();
        int b = r.nextInt(100);
        return b;
    }
    public String getOperation(int a, int b, int random){
        String operation = "";
        switch (random){
            case 1:
                operation = "" + a + " " + "+" + " " + b + "";
                this.result = a+b;
                break;

            case 2:
                operation = "" + a + " " + "-" + " " + b + "";
                this.result = a-b;
                break;

            case 3:
                operation = "" + a + " " + "*" + " " + b + "";
                this.result = a*b;
                break;

            case 4:
                operation = "" + a + " " + "/" + " " + b + "";
                break;
        }

        return operation;

    }

    public int getResult(int a, int b, int random){
        int Result = 0;
        switch (random){
            case 1:
                result = a+b;
                break;

            case 2:
                result = a-b;
                break;

            case 3:
                result = a*b;
                break;

            case 4:
                result = a/b;
                break;
        }

        return result;

    }
}