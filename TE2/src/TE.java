import java.net.InterfaceAddress;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

class TE
{
  public static boolean verify(Bike b, Collection<Bike> c) {
    return c.contains(b);
  }

  public static void main(String[] args) {
    System.out.println("-- Prototypes");
    Bike p1 = new Bike(Model.City, "pro-1"); 
    Bike p2 = new Bike(Model.Mountain, "pro-2"); 
    Bike p3 = new Bike(Model.Gravel, "pro-3"); 

    System.out.println(p1.model());
    System.out.println(p1);
    System.out.println(p2); 
    System.out.println(p3); 

    p1.submitWarrantyClaim();
    System.out.println("-- Mass production"); 
    Factory aigle = new Factory("Aigle"); 
    Bike a1 = aigle.produceBike(Model.Gravel); 
    Bike a2 = aigle.produceBike(Model.Gravel); 
    Bike a3 = aigle.produceBike(Model.Mountain); 
    Factory begnins = new Factory("Begnins"); 
    Bike b1 = begnins.produceBike(Model.City); 
    Bike b2 = begnins.produceBike(Model.Mountain); 

    System.out.println("-- Warranty claims"); 
    b1.submitWarrantyClaim(); 
    a1.submitWarrantyClaim(); 
    a3.submitWarrantyClaim(); 

    Factory.qualityReport();

    Ebike e1 = new Ebike(Model.City, "epro-1", 250);
    Ebike e2 = new Ebike(Model.City, "epro-2", 250);
    Ebike e3 = new Ebike(Model.City, "epro-3", 100);
    System.out.println(e1);

    List<Bike> bikes = List.of(p2, p3, a2, a3, b2, e2);
    System.out.println("p1: " + verify(p1, bikes)); // false
    System.out.println("a1: " + verify(a1, bikes)); // true
    System.out.println("b1: " + verify(b1, bikes)); // false
    System.out.println("e1: " + verify(e1, bikes)); // true
    System.out.println("e3: " + verify(e3, bikes)); // false

  }
}

class Bike{
  private final String serial;

  private final Model model;

  public Bike(Model model, String serial){
    this.serial = serial;
    this.model = model;
  }

  public void submitWarrantyClaim (){
    System.out.println("Customer filled warranty claim for " + this);
  }

  @Override
  public String toString(){
    return model.getTwoLettersCode() + "-" + serial;
  }

  public Model model(){
    return model;
  }

  //TODO séparer les prototypes des produits
  @Override
  public boolean equals(Object o) {
    return this == o || o != null && getClass() == o.getClass() && model.equals(((Bike) o).model);
  }

  @Override
  public int hashCode() {
    return model.hashCode();
  }
}

enum Model{
  City("CT"),
  Mountain("MT"),
  Gravel("GV");

  private final String twoLettersCode;

  Model(String twolettersCode){
    this.twoLettersCode = twolettersCode;
  }

  public String getTwoLettersCode() {
    return twoLettersCode;
  }

  @Override
  public String toString(){
    return name() + " (" + twoLettersCode + ")";
  }
}

class Factory{
  private static List<Factory> factories = new LinkedList<>();
  private final String name;

  private int nbOfBike;

  private int nbWarrantyClaim;

  public Factory(String name){
    this.name = name;
    nbOfBike = 0;
    factories.add(this);
  }

  public Bike produceBike(Model m){
    String serialProd = name + "-" + ++nbOfBike;
    System.out.println("Production of bike " + serialProd);
    return new Bike(m, serialProd){
      @Override
      public void submitWarrantyClaim() {
        System.out.println(name + ": warranty claim for" + this);
        nbWarrantyClaim++;
      }
    };
  }

  public static void qualityReport(){
    for(Factory f : factories) {
      double percentClaims = (double) f.nbWarrantyClaim / f.nbOfBike;
      System.out.printf(f.name + " : of %d bikes there were %d warranty claims (%.1f)\n", f.nbOfBike, f.nbWarrantyClaim, percentClaims * 100);
    }
  }
}

class Ebike extends Bike{

  private final int power;

  public Ebike(Model model, String serial, int power){
    super(model, serial);
    this.power = power;
  }

  @Override
  public String toString(){
    return "E-" + super.toString() + ", " + power + "W";
  }

  @Override
  public boolean equals(Object o){
    return super.equals(o) && power == ((Ebike) o).power;
  }

  @Override
  public int hashCode() {
    return super.hashCode() + power;
  }
}