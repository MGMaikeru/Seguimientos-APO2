package model;

public class GameSystem {
    private Node head;
    private Node tail;
    private int score;

    public GameSystem(){
        this.score = 0;
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
            list = "List empty";
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

    public String showOperation(){ return showOperation(this.head);}

    private String showOperation(Node current){
        if (!current.getValue().equals("+") && !current.getValue().equals("X")){
            current.setValue(current.getValue() + "*");
            return current.getOperation();
        }
        return showOperation(current.getNext());
    }

    public void levelMarker(){ levelMarker(this.head);}
    private void levelMarker(Node current){
        /*if (!this.head.getValue().equals("+") || !this.head.getValue().equals("X")){
            this.head.setValue(this.head.getValue() + "*");
            return this.head.getOperation();
        }
        if (!this.tail.getValue().equals("+") || !this.tail.getValue().equals("X")){
            this.tail.setValue(this.tail.getValue() + "*");
            return this.tail.getOperation();
        }*/
        if (!current.getValue().equals("+") && !current.getValue().equals("X")){
            current.setValue(current.getValue() + "*");
            return;
        }
        levelMarker(current.getNext());
    }

    public String levelAdvance(String answer){ return levelAdvance(this.head, answer);}

    private String levelAdvance(Node current, String answer){
        /*if (!this.head.getValue().equals("+") || !this.head.getValue().equals("X")){
            this.head.setValue(corroborateResult(this.head, answer));
            return this.head.getOperation();
        }
        if (!this.tail.getValue().equals("+") || !this.tail.getValue().equals("X")){
            this.tail.setValue(corroborateResult(this.tail, answer));
            return this.tail.getOperation();
        }*/
        if (!current.getValue().equals("+") && !current.getValue().equals("X")){
            current.setValue(corroborateResult(current, answer));
            return current.getOperation();
        }
        return levelAdvance(current.getNext(), answer);
    }
    private String corroborateResult(Node node, String answer){
        String marker = "";
        if (answer.equals("PASS")){
            marker = "";
            this.score -= 3;
            eliminateNode(this.head, this.head.getNext());
        }else{
            int number = 0;
            try {
                number = Integer.parseInt(answer);
                System.out.println(number);
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
            if (number == node.getResult()) {
                marker = "+";
                this.score += 1;
                node.setStatus("Correct");
            }else{
                marker = "X";
                node.setStatus("Incorrect");
            }
        }
        return marker;
    }

    public String printReport(String name){
        String list = print() + "\n";
        return printReport(this.head, list, name);
    }
    public String printReport(Node current, String list, String name){
        if (this.head == null && this.tail == null){
            list = "List empty";
            return list;
        }
        if(current == this.tail){
            list += "" + this.tail.getOperation() + "  " + this.tail.getStatus() + "\n" +
                    name + ", your score it's of: " + this.score;
            return list;
        }

        list += "" + current.getOperation() + "  " + current.getStatus() + "\n";
        return printReport(current.getNext(), list, name);
    }

    private void eliminateNode(Node previous, Node current){
        if (current == null) {
            return;
        }
        if (!this.head.getValue().equals("+") && !this.head.getValue().equals("X") && previous.equals(this.head)) {
            this.head = head.getNext();
            previous.setNext(null);
            return;
        }
        if (!this.tail.getValue().equals("+") && !this.tail.getValue().equals("X") && current.equals(this.tail)) {
            this.tail = previous;
            current.setNext(null);
            return;
        }
        if (!current.getValue().equals("+") && !current.getValue().equals("X")) {
            previous.setNext(current.getNext());
            current = null;
            return;
        }
        eliminateNode(previous.getNext(), current.getNext());
    }
}
