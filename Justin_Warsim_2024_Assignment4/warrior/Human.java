package warrior;

public class Human extends Warrior {

  private int minHealth = 100;
  private int maxHealth = 200;
  private int minStrength = 150;
  private int maxStrength = 150;
  private int minDexterity = 75;
  private int maxDexterity = 50;
  
  public Human() {
    super(); // must be called first!
    super.setHealth(super.randNum.nextInt(maxHealth) + minHealth);
    super.setStrength(super.randNum.nextInt(maxStrength) + minStrength);
    super.setDexterity(super.randNum.nextInt(maxDexterity) + minDexterity);
  } // contructor

  public Human(int pHealth, int pStrength, int pDexterity, String pType) {
    super(pHealth, pStrength, pDexterity, pType); // must be called first!
  } // contructor
  

  
} // class
