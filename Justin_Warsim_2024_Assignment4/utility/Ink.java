package utility;

import java.util.Scanner;
import armour.Armour;
import warrior.Warrior;
import weapon.Weapon;
import weather.Weather;

public class Ink {

    // ANSI escape codes for colors and formatting
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";

    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String REVERSED = "\u001B[7m";

    public Ink() {
        // do nothing
    } // constructor

    public void welcome() {
        System.out.printf("""
          %s%s%s
          __        __             _             ____   ___ ____  _  _   
          \\ \\      / /_ _ _ __ ___(_)_ __ ___   |___ \\ / _ \\___ \\| || |  
           \\ \\ /\\ / / _` | '__/ __| | '_ ` _ \\    __) | | | |__) | || |_ 
            \\ V  V / (_| | |  \\__ \\ | | | | | |  / __/| |_| / __/|__   _|
             \\_/\\_/ \\__,_|_|  |___/_|_| |_| |_| |_____|\\___/_____|  |_|  
            %s%s
            """, CYAN_BACKGROUND, BLACK, BOLD, RESET, RESET);
    } // welcome()

    public boolean continueGame(Scanner input) {
        boolean isContinue = false;
        System.out.println(CYAN_BACKGROUND + BLACK + "****************************************************" + RESET);
        System.out.println(BOLD + "        (1) CONTINUE GAME  |  (2) NEW GAME" + RESET);
        System.out.println(CYAN_BACKGROUND + BLACK + "****************************************************" + RESET);
        int choice = input.nextInt();
        if (choice == 1) {
            isContinue = true;
        } else if (choice == 2) {
            isContinue = false;
        } else {
            System.out.println(RED + "Invalid choice, please enter 1 or 2." + RESET);
        }
        return isContinue;
    }

    public void printGameState(Warrior player, Weapon pWeapon, Armour pArmour, 
                               Warrior enemy, Weapon eWeapon, Armour eArmour) {
        // Print player stats
        System.out.println(GREEN_BACKGROUND + BLACK + "Player Stats:" + RESET);
        System.out.printf("%s %s %s\n", player.getWarriorType(), pWeapon.getWeaponType(), pArmour.getArmourType());
        System.out.printf("%d %d %d\n", player.getHealth(), player.getStrength(), player.getDexterity());

        // Print enemy stats
        System.out.println(RED_BACKGROUND + BLACK + "Enemy Stats:" + RESET);
        System.out.printf("%s %s %s\n", enemy.getWarriorType(), eWeapon.getWeaponType(), eArmour.getArmourType());
        System.out.printf("%d %d %d\n", enemy.getHealth(), enemy.getStrength(), enemy.getDexterity());
    }

    public void printWarriorMenu() {
        System.out.println(); // blank line
        System.out.println(); // blank line
        System.out.println(BLUE_BACKGROUND + WHITE + "**********************(WARRIOR)*********************" + RESET);
        System.out.println(BOLD + "       (1) HUMAN   |   (2) ELF   |   (3)   ORC" + RESET);
        System.out.println(BLUE_BACKGROUND + WHITE + "****************************************************" + RESET);
    }

    public void printWeaponMenu() {
        System.out.println(YELLOW_BACKGROUND + BLACK + "**************************(WEAPON)*************************" + RESET);
        System.out.println(BOLD + "(1) DAGGER  |   (2) SWORD   |   (3) AXE   |   (4) CROSSBOW" + RESET);
        System.out.println(YELLOW_BACKGROUND + BLACK + "***********************************************************" + RESET);
    }

    public void printArmourMenu() {
        System.out.println(PURPLE_BACKGROUND + WHITE + "***************************(ARMOUR)************************" + RESET);
        System.out.println(BOLD + "   (1) LEATHER   |   (2) PLATEMAIL   |   (3) CHAINMAIL" + RESET);
        System.out.println(PURPLE_BACKGROUND + WHITE + "***********************************************************" + RESET);
    }

    public void printSaveConfirmation() {
        System.out.println(GREEN + "Your game has been saved!" + RESET);
    } // printSaveConfirmation()

    public void printTurnMenu() {
        System.out.println(RED_BACKGROUND + BLACK + "******************************************************************" + RESET);
        System.out.println(BOLD + "ATTACK : (1) NORMAL | (2) HEAVY | (3) HEAL | (4) SAVE | (5) EXIT" + RESET);
        System.out.println(RED_BACKGROUND + BLACK + "******************************************************************" + RESET);
    }
    

    public void printWarriorStats(Warrior player, Warrior enemy) {
        System.out.println(GREEN_BACKGROUND + BLACK + "*********************(WARRIOR)************************" + RESET);
        System.out.printf("%s* %-33s%-33s%s\n", BOLD, "Player: " + player.getWarriorType(), "Enemy: " + enemy.getWarriorType(), RESET);
        System.out.printf("%s* Health: %-25dHealth: %-25d%s\n", BOLD, player.getHealth(), enemy.getHealth(), RESET);
        System.out.printf("%s* Strength: %-23dStrength: %-23d%s\n", BOLD, player.getStrength(), enemy.getStrength(), RESET);
        System.out.printf("%s* Dexterity: %-22dDexterity: %-22d%s\n", BOLD, player.getDexterity(), enemy.getDexterity(), RESET);
        System.out.println(GREEN_BACKGROUND + BLACK + "******************************************************" + RESET);
    }

    public void printWeaponType(Weapon playerWeapon, Weapon enemyWeapon) {
        System.out.println(YELLOW_BACKGROUND + BLACK + "**********************(WEAPON)************************" + RESET);
        System.out.printf("%s* %-33s%-33s%s\n", BOLD, "Player: " + playerWeapon.getWeaponType(), "Enemy: " + enemyWeapon.getWeaponType(), RESET);
        System.out.printf("%s* Damage Amount: %-18dDamage Amount: %-18d%s\n", BOLD, playerWeapon.getDamageAmount(), enemyWeapon.getDamageAmount(), RESET);
        System.out.printf("%s* Dexterity: %-22dDexterity: %-22d%s\n", BOLD, playerWeapon.getDexterityCost(), enemyWeapon.getDexterityCost(), RESET);
        System.out.println(YELLOW_BACKGROUND + BLACK + "******************************************************" + RESET);
    }

    public void printArmourType(Armour playerArmour, Armour enemyArmour) {
        System.out.println(PURPLE_BACKGROUND + WHITE + "**********************(ARMOUR)************************" + RESET);
        System.out.printf("%s* %-33s%-33s%s\n", BOLD, "Player: " + playerArmour.getArmourType(), "Enemy: " + enemyArmour.getArmourType(), RESET);
        System.out.printf("%s* Armour Amount: %-18dArmour Amount: %-18d%s\n", BOLD, playerArmour.getArmourAmount(), enemyArmour.getArmourAmount(), RESET);
        System.out.printf("%s* Dexterity: %-22dDexterity: %-22d%s\n", BOLD, playerArmour.getDexterityCost(), enemyArmour.getDexterityCost(), RESET);
        System.out.println(PURPLE_BACKGROUND + WHITE + "******************************************************" + RESET);
    }

    public void printWeatherType(Weather weatherType) {
        System.out.println(CYAN_BACKGROUND + BLACK + "**********************(WEATHER)************************" + RESET);
        System.out.println(BOLD + "The weather will be " + weatherType.getWeatherType() + RESET);
        System.out.printf(BOLD + "The Severity of the weather is %d%n" + RESET, weatherType.getSeverity());
        System.out.println(CYAN_BACKGROUND + BLACK + "******************************************************" + RESET);
    }

    public void printHealthAfterTurn(Warrior player, Warrior enemy) {
      System.out.println(GREEN_BACKGROUND + BLACK + "Total health after turn:" + RESET);
      System.out.println(BOLD + "Player Health: " + player.getHealth() + RESET);
      System.out.println(BOLD + "Enemy Health: " + enemy.getHealth() + RESET);
  }

  public void printGameOver(String winner) {
      System.out.printf(CYAN_BACKGROUND + BLACK + BOLD + """
         ____                         ___                 
        / ___| __ _ _ __ ___   ___   / _ \\__   _____ _ __ 
       | |  _ / _` | '_ ` _ \\ / _ \\ | | | \\ \\ / / _ \\ '__|
       | |_| | (_| | | | | | |  __/ | |_| |\\ V /  __/ |   
        \\____|\\__,_|_| |_| |_|\\___|  \\___/  \\_/ \\___|_|\n %s   
          """ + RESET, winner + " wins!");
  } // printGameOver()

} // class




