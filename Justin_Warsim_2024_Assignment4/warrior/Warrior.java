package warrior;
import java.util.Random;

// abstract makes it a parent class!
// also protects it from being instantiated!
public abstract class Warrior {
  // public(open to everyone!)
  // private(closed to everyone except the class itself)
  // protected(private outside, public inside)
  protected Random randNum = new Random();
  private int health;
  private int strength;
  private int dexterity;
  private String warriorType = "";
  private int maxHealth;

  public Warrior() {
    // do nothing
  }
  // called when we are reloading the save game
  public Warrior(int health, int strength, int dexterity, String warriorType) {
    this.health = health;
    this.strength = strength;
    this.dexterity = dexterity;
    this.warriorType = warriorType;
  }

  //============>>
  // GETTERS
  public int getHealth() {
    return this.health;
  }
  public int getStrength() {
    return this.strength;
  }
  public int getDexterity() {
    return this.dexterity;
  }
  public String getWarriorType() {
    return this.warriorType;
  }
  public int getMaxHealth(){
    return this.maxHealth;
  }
  //============>>
  // SETTERS
  public void setHealth(int health) {
    this.health = health;
  }
  public void setStrength(int strength) {
    this.strength = strength;
  }
  public void setDexterity(int dexterity) {
    this.dexterity = dexterity;
  }
  public void setWarriorType(String warriorType) {
    this.warriorType = warriorType;
  }
  public void takeDamage(int damageAmount) {
    if(damageAmount > 0) {
      this.health -= damageAmount;
    }   
  }
  
  
} // class