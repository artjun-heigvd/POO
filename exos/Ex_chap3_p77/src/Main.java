public class Main {


    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static void printInstancesCount(Object[] array){
        InstanceCount[] ic = new InstanceCount[array.length];
        for(Object o : array){
            Class ref = o.getClass();
        }
    }
}