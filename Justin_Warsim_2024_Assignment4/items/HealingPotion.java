package items;

import warrior.Warrior;

public abstract class HealingPotion {
    private int healingAmount;
    
    public HealingPotion(int healingAmount) {
        this.healingAmount = healingAmount;
    }
    
    // GETTER
    public int getHealingAmount() {
        return this.healingAmount;
    }
    
    // SETTER
    public void setHealingAmount(int healingAmount) {
        this.healingAmount = healingAmount;
    }
   
    public int use(Warrior warrior) {
        int newHealth = warrior.getHealth() + healingAmount; // Add the healing amount to the warrior's existing health
        warrior.setHealth(newHealth); // Set the warrior's health to the new calculated value
  
        return newHealth; // Return the new health value
    }
}
