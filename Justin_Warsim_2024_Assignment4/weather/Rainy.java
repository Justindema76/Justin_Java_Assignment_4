package weather;

public class Rainy extends Weather {

  private int rainIntensity = 10;
  
  public Rainy() {
    super("Rainy");
    super.setSeverity(super.randNum.nextInt(rainIntensity) + 10);
  }

} // class
