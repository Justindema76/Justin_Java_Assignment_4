package weapon;



public class Crossbow extends Weapon {
  private int damageAmount = 100;
  private int dexterityCost = 100;
  private int baseHitChance = 60; // out of 100 the odds of hitting
  
  public Crossbow(String weaponType) {
    super(weaponType);
    super.setDamageAmount(damageAmount);
    super.setDexterityCost(dexterityCost);
    super.setWeaponType("Crossbow");
  } // constructor

  public int strike(int attackType, int dexterity, int strength, int weatherIntensity) {
    int damage = 0;
    int roll = super.randNum.nextInt(100) + 1;
    
    if((roll - attackType * 3) + (dexterity / 8 - this.dexterityCost) 
        <= baseHitChance) { // hit!
      damage = this.damageAmount + (strength / 5) + (attackType * 2) + 2 - weatherIntensity;;
     
    }
    else { // miss
      damage = 0;
    }
    return damage;
  } // strike
} // class
