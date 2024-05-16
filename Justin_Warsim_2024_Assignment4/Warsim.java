import warrior.*;
import weapon.*;
import weather.*;
import armour.*;
//import items.HealingPotion;
import utility.*;

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Warsim {
  // Objects
  public static Scanner input = new Scanner(System.in);
  public static Random randNum = new Random();
  public static Ink ink = new Ink();
  public static IO io = new IO();
  public static List<Object> things = new ArrayList<>();
  
  public static Warrior player; // player
  public static Weapon pWeapon; // player weapon
  public static Armour pArmour; // player armour
  public static Weather weather;

  public static Warrior enemy; // enemy
  public static Weapon eWeapon; // enemy weapon
  public static Armour eArmour; // enemy armour
  

  // Game Vars
  public static boolean gameOver = false;
  public static boolean playerTurn = true; // player starts
  public static String who = "Player";
  public static String winner = "";
  public static int choice = 0;
  public static int attackType = 0;
  public static int pDamage = 0;
  public static int eDamage = 0;
  
  
  //================>>
  // main method
  public static void main(String[] args) {

    // Prints welcome message w/ASCII art ;)
    ink.welcome();

    // set a random weather for the battle
    int weatherType = randNum.nextInt(4) + 1;
    createWeather(weatherType);

    String filePath = "./gameSave.txt"; // specify the file path
    File file = new File(filePath); // create the file

    // Check if the file exists
    if (file.exists()){
      // if the file exists give them the option!
      // Prompt the player to either a) continue b) play new game
      boolean isContinue = ink.continueGame(input);
      if(isContinue){
        //open saved file
        things = io.loadGame(player, pWeapon, pArmour, enemy, eWeapon, eArmour);
        player = (Warrior)things.get(0); // sets our local player
        pWeapon = (Weapon)things.get(1);
        pArmour = (Armour)things.get(2);
        enemy = (Warrior)things.get(3);
        eWeapon = (Weapon)things.get(4);
        eArmour = (Armour)things.get(5);
        
        ink.printGameState(player, pWeapon, pArmour, enemy, eWeapon, eArmour);
        // read in stats
        // create objects from stats
        // start the game
      } else {
        createGame();
      }
    } else {
      createGame();
    }
    
    // Main Game Loop
    while(!gameOver) {
      if(playerTurn) {
        // player code
        ink.printTurnMenu();
        attackType = input.nextInt();
        if(attackType == 3) {
          gameOver = !gameOver;
          break; // breaks out of the while loop
        }
        if(attackType == 4) {
          // save game
          io.saveGame(player, pWeapon, pArmour, enemy, eWeapon, eArmour);
          gameOver = !gameOver;
          break;
        }
        if (attackType == 5){
             // Healing potion
          
        }
        eDamage = pWeapon.strike(attackType, player.getDexterity(), player.getStrength(), weather.getSeverity());
        if (eDamage > 0) {
          eDamage = eArmour.getFinalDamage(eDamage);
          enemy.takeDamage(eDamage);
          System.out.println("Player dealt: " + eDamage + " damage to the enemy!");
          System.out.println("Enemy Health = " + enemy.getHealth());
          if (enemy.getHealth() <= 0) {
            winner = "Player";
            gameOver = true;
          }
        } else {
          System.out.println("Missed! No damage dealt.");
        }
      } else {
        // enemy code
        System.out.println(); // blank line
        System.out.println("Enemy Turn!");
        attackType = randNum.nextInt(2) + 1;
        pDamage = eWeapon.strike(attackType, enemy.getDexterity(), enemy.getStrength(), weather.getSeverity());
        if (pDamage > 0) {
          pDamage = pArmour.getFinalDamage(pDamage);
          player.takeDamage(pDamage);  // as1sign the damage amount to the player
          System.out.println("Enemy dealt: " + pDamage + " damage to you!");
          System.out.println("Player Health = " + player.getHealth());
          if (player.getHealth() <= 0) {
            winner = "Enemy";
            gameOver = true;
          }
        } else {
          System.out.println("Enemy missed! No damage dealt.");
        }
      }
      playerTurn = !playerTurn; // toggles turn each iteration
    } // while
    if(attackType != 4)
      ink.printGameOver(winner);
    else 
      ink.printSaveConfirmation();
  } // main()

  //========================>>
  // Helper Methods
  public static void createWarrior(String who, int choice) {
    if(who.equals("Player")) { // player warrior creation
      switch (choice) {
        case 1: // Human
          player = new Human();
          player.setWarriorType("Human");
          break;
        case 2: // Elf
          player = new Elf();
          player.setWarriorType("Elf");
          break;
        case 3: // Orc
          player = new Orc();
          player.setWarriorType("Orc");
          break;
        default:
          System.out.println("Oops!");
          break;
      } // switch
    } else { // enemy warrior creation
      switch (choice) {
        case 1: // Human
          enemy = new Human();
          enemy.setWarriorType("Human");
          break;
        case 2: // Elf
          enemy = new Elf();
          enemy.setWarriorType("Elf");
          break;
        case 3: // Orc
          enemy = new Orc();
          enemy.setWarriorType("Orc");
          break;
        default:
          System.out.println("Oops!");
          break;
      } // switch
    }
  } // createWarrior()

  public static void createWeapon(String who, int choice) {
    switch (choice) {
      case 1: // Dagger
        if(who.equals("Player")) {
          pWeapon = new Dagger("Dagger");
        } else {
          eWeapon = new Dagger("Dagger");
        }
        break;
      case 2: // Sword
        if(who.equals("Player")) {
          pWeapon = new Sword("Sword");
        } else {
          eWeapon = new Sword("Sword");
        }
        break;
      case 3: // Axe
        if(who.equals("Player")) {
          pWeapon = new Axe("Axe");
        } else {
          eWeapon = new Axe("Axe");
        }
        break;
        case 4: // Crossbow
        if(who.equals("Player")) {
          pWeapon = new Crossbow("Crossbow");
        } else {
          eWeapon = new Crossbow("Crossbow");
        }
        break;
      default:
        System.out.println("Oops!");
        break;
    } // switch
  } // createWeapon()

  public static void createArmour(String who, int choice) {
    switch (choice) {
      case 1: // Leather
        if(who.equals("Player")) {
          pArmour = new Leather("Leather");
        } else {
          eArmour = new Leather("Leather");
        }
        break;
      case 2: // Chainmail
        if(who.equals("Player")) {
          pArmour = new Chainmail("Chainmail");
        } else {
          eArmour = new Chainmail("Chainmail");
        }
        break;
      case 3: // Platemail
        if(who.equals("Player")) {
          pArmour = new Platemail("Platemail");
        } else {
          eArmour = new Platemail("Platemail");
        }
        break;
      default:
        System.out.println("Oops!");
        break;
        
    } // switch
  } // createArmour()

  public static void createWeather(int weatherType) {
    switch (weatherType) {
      case 1: // sun 
        weather = new Sunny();
        break;
      case 2: // rain
        weather = new Rainy();
        break;
      case 3: // wind
        weather = new Windy();
        break;
      case 4: // storm
        weather = new Stormy();
        break;
      default:
        System.out.println("HELP");
        break;
    } // switch
  } // createWeather()


  //=====================>>
  // Player Creation
  // Warrior
  public static void createGame() {
    ink.printWarriorMenu();
    choice = input.nextInt();
    createWarrior(who, choice);
    
    // Weapon
    ink.printWeaponMenu();
    choice = input.nextInt();
    createWeapon(who, choice);
    
    // Armour
    ink.printArmourMenu();
    choice = input.nextInt();
    createArmour(who, choice);

    // player is all setup
    // switch 'who' to Enemy
    who = "Enemy";

    //=====================>>
    // Enemy Creation
    // Warrior
    choice = randNum.nextInt(3) + 1;
    createWarrior(who, choice);

    // Weapon
    choice = randNum.nextInt(4) + 1; 
    createWeapon(who, choice);

    // Armour
    choice = randNum.nextInt(3) + 1; 
    createArmour(who, choice);

    ink.printWarriorStats(player, enemy);
    ink.printWeaponType(pWeapon, eWeapon);
    ink.printArmourType(pArmour, eArmour);
    ink.printWeatherType(weather);
  } // create game
} // class
