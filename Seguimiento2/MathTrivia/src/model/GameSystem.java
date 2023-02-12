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

    public String print(){
        String list = "";
        list = print(this.head, list);
        return list;
    }

    private String print(Node current, String list){
        if (this.head == null && this.tail == null){
            list = "la lista esta vacia";
            return list;
        }
        if(current == this.tail){
            list += "[" + current.getValue() + "]";
            return list;
        }

        list += "[" + current.getValue() + "]";
        return print(current.getNext(), list);
    }

    public String createNodes(int numberNodes){
        String msj = "";
        for (int i=1; i < numberNodes+1 ;i++){
            addLast(new Node("" + i + ""));
            msj += "\n Node number " + i + " successful created.";
        }
        return msj;
    }
}
