package weather;

public class Sunny extends Weather {

  // perfect weather no effect on battle
  private int sunIntensity = 10;
  
  public Sunny() {
    super("Sunny");
    super.setSeverity(sunIntensity);
  }
  
} // class
