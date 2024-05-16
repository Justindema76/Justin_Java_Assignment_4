package weather;

public class Windy extends Weather {

  private int windIntensity = 25;
  
  public Windy() {
    super("Windy");
    super.setSeverity(super.randNum.nextInt(windIntensity) + 10);
  }
  
} // class