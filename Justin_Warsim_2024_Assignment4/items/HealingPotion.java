package items;

import warrior.Warrior;

public abstract class HealingPotion {
    private int healingAmount;
    
    public HealingPotion(int healingAmount){
        this.healingAmount = healingAmount;
    }
    //==============>>
  // GETTERS
  public int getHealingAmount() {
    return this.healingAmount;
  }
  //==============>>
  // SETTERS
  public void setHealingAmout(int healingAmount){
    this.healingAmount = healingAmount;
  }
   
   
    // Define the use method to heal the specified warrior
  public void use(Warrior warrior) {
    int newHealth = warrior.getHealth() + healingAmount;
    if (newHealth > warrior.getMaxHealth()) {
        warrior.setHealth(warrior.getMaxHealth()); // Cap health at maxHealth
    } else {
        warrior.setHealth(newHealth);
  }
}
}
