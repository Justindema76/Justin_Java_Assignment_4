package weapon;

public class Sword extends Weapon {
  private int damageAmount = 150;
  private int dexterityCost = 75;
  private int baseHitChance = 70; // out of 100 the odds of hitting

  public Sword(String weaponType) {
    super(weaponType);
    super.setDamageAmount(damageAmount);
    super.setDexterityCost(dexterityCost);
    super.setWeaponType("Sword");
  } // constructor

  public int strike(int attackType, int dexterity, int strength, int weatherIntensity) {
    int damage = 0;
    int roll = super.randNum.nextInt(100) + 1;
    
    if((roll - attackType * 5) + (dexterity / 10 - this.dexterityCost) 
        <= baseHitChance) { // hit!
      damage = this.damageAmount + (strength / 10) + (attackType * 5) + 2 - weatherIntensity;;
    }
    else { // miss
      damage = 0;
    }
    return damage;
  } // strike
} // class
