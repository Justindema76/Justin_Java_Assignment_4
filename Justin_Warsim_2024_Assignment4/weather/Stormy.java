package weather;

public class Stormy extends Weather {

    private int stormIntensity = 30;
  
    public Stormy() {
      super("Stormy");
      super.setSeverity(super.randNum.nextInt(stormIntensity) + 10);
    }
    
}
