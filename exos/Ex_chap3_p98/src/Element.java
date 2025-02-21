class Element<T> {
    T data;
    Element<T> next;

    Element(T o){
        data = o;
        next = null;
    }

    Element(T o, Element<T> next){
        data = o;
        this.next = next;
    }
}
