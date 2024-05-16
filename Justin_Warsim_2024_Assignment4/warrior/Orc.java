package warrior;

public class Orc extends Warrior {

  private int minHealth = 175;
  private int maxHealth = 220;
  private int minStrength = 200;
  private int maxStrength = 200;
  private int minDexterity = 30;
  private int maxDexterity = 30;
  
  public Orc() {
    super(); // must be called first!
    super.setHealth(super.randNum.nextInt(maxHealth) + minHealth);
    super.setStrength(super.randNum.nextInt(maxStrength) + minStrength);
    super.setDexterity(super.randNum.nextInt(maxDexterity) + minDexterity);
  } // contructor

  public Orc(int pHealth, int pStrength, int pDexterity, String pType) {
    super(pHealth, pStrength, pDexterity, pType); // must be called first!
  } // contructor
} // class
