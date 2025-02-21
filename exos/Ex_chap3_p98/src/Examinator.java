public class Examinator<T> {
    private Element<T> current;

    Examinator(Element<T> curr){
        current = curr;
    }

    public boolean hasNext(){
        return current.next != null;
    }

    public T next(){
        current = current.next;
        return current.data;
    }
}
