package by.bsuir;

public class LinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public LinkedList(){
        first = new Node<>(null);
        last = new Node<>(null);
        first.next = last;
        first.prev= null;
        last.next = null;
        last.prev= first;
        size = 0;
    }

    public void addFigure(T figure){
        Node<T> node = last;
        node.setFigure(figure);
        last = new Node<>(null,null,node);
        node.next = last;
        size++;
    }

    public T getFigure(int index){
        if(index < 0 || index > size-1){
            return null;
        }
        Node<T> current = first.next;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.getFigure();
    }

    int getSize(){
        return size;
    }

    static class Node<T>{
        private T figure;
        private Node<T> next;
        private Node<T> prev;


        public Node(T figure, Node<T> next, Node<T> prev) {
            this.figure = figure;
            this.next = next;
            this.prev = prev;
        }

        public Node(T figure){
            this.figure = figure;
        }

        public void setFigure(T figure) {
            this.figure = figure;
        }

        public T getFigure() {
            return figure;
        }
    }
}