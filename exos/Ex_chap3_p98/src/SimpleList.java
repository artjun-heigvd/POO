public class SimpleList<T> {
    private Element<T> head;


    public Examinator<T> examinator(){
        return new Examinator<T>(head);
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        Examinator<T> e = this.examinator();
        int size = 0;
        while(e.hasNext()){
            e.next();
            ++size;
        }
        return size;
    }

    public void insert(T o){
        Element<T> temp = head;
        head = new Element<T>(o, temp);
    }

    public void append(T o){
        Element<T> temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Element<T>(o);
    }

    public void remove(T o){
        Element<T> temp = head;
        while(temp.next.data != o){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public T get(int index){
        Examinator<T> e = this.examinator();
        for(int i = 0; e.hasNext() && i < index; i++){
            e.next();
        }
        return e.next();
    }
}
