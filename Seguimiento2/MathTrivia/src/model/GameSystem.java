package model;

public class GameSystem {
    private Node head;
    private Node tail;

    public GameSystem(){

    }

    public void addLast(Node node){
        if(this.head == null & this.tail == null){
            this.head= node;
            this.tail = node;
        }else{
            this.tail.setNext(node);
            this.tail = (node);
        }
    }

    public void addFirst(Node node){
        if(this.head == null & this.tail == null){
            this.head= node;
            this.tail = node;
        }else{
            this.head.setNext(node);
            this.head = (node);
        }
    }

    public void print(){
        print(this.head);
    }

    private void print(Node current){
        if (this.head == null && this.tail == null){
            System.out.println("la lista esta vacia");
            return;
        }
        if(current == this.tail){
            System.out.println(current.getValue());
            return;
        }

        System.out.println(current.getValue());
        print(current.getNext());
    }

    public String createNodes(int numberNodes){
        String msj = "";
        for (int i=1; i < numberNodes+1 ;i++){
            addLast(new Node(i));
            msj += "\n Node number " + i + " successful created.";
        }
        return msj;
    }
}
