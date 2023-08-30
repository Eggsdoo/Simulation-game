package utility;
import warrior.*;
import armor.*;
import weapon.*;

public class Printer {
        // Declaring ANSI_RESET so that we can reset the colour
        public static final String ANSI_RESET = "\u001B[0m";

        // Declaring the colour to a custom declaration
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001b[34m";
        public static final String ANSI_RED = "\u001b[31m";
        public static final String ANSI_CYAN = "\u001b[36m";

    public Printer() {
    }

    public void welcome() {
        System.out.println(ANSI_RED + "Welcome to War Sim 23" + ANSI_RESET);
    } // welcome()

    public void attackOptions(int abilityPoints, boolean specialActive) {
        System.out.println("Choose your attack: ");
        System.out.println("1) Basic"); // no hit per penalty but base damage
        System.out.println("2) Heavy"); // hit per penalty plus damage bonus
        if(abilityPoints > 0 && specialActive == false) { // use the character special ability
            System.out.printf("3) Special Ability(%d)\n", abilityPoints);
        }
    }
    public void warriorOptions() {
        System.out.println("What kind of Warrior would you like to portray?");
        System.out.println("1) Human");
        System.out.println("2) Elf");
        System.out.println("3) Orc");
    } // printWarriorOptions()

    public void armorOptions() {
        System.out.println("What kind of Armor would you like to wear?");
        System.out.println("1) Leather");
        System.out.println("2) Chainmail");
        System.out.println("3) Platemail");
    } // printArmorOptions

    public void weaponOptions() {
        System.out.println("What kind of Weapon would you like to wield?");
        System.out.println("1) Dagger");
        System.out.println("2) Sword");
        System.out.println("3) Axe");
    }

    public void turnResult(int damage, Warrior warrior, String playerName) {
        if(damage > 0) {
            System.out.println(ANSI_CYAN + playerName + " has dealt " + damage + " damage!!" + ANSI_RESET);
            System.out.println("Your enemy has " + warrior.getHealth() + " points left!\n\n");
        }
        else {
            System.out.println("Your enemy has " + warrior.getHealth() + " points left!\n\n");
        }
    }

    public void stats(Warrior pWarr, Armor pArm, Weapon pWep, Warrior eWarr, Armor eArm, Weapon eWep) {
        ///// Player Stats /////
        System.out.println("//===============================>>");
        System.out.println("Player Stats:");
        System.out.printf("\tHealth: %d%s\n", pWarr.getHealth(), " points");
        System.out.printf("\tStrength: %d%s\n", pWarr.getStrength(), " points");
        System.out.printf("\tDexterity: %d%s\n", pWarr.getDexterity(), " points");
        System.out.println("Player Armor:");
        System.out.printf("\tProtection: %d%s\n", pArm.getProtection(), " points");
        System.out.printf("\tEncumbrance: %d%s\n", pArm.getEncumbrance(), " points");
        System.out.println("Player Weapon:");
        System.out.printf("\tDamage: %d%s\n", pWep.getDamage(), " points");
        System.out.printf("\tWeight: %d%s\n", pWep.getWeight(), " pounds");
        System.out.println("//===============================>>\n\n");
        ////////////////////
        // enemy stats
        System.out.println("//===============================>>");
        System.out.println("Enemy Stats:");
        System.out.printf("\tHealth: %d%s\n", eWarr.getHealth(), " points");
        System.out.printf("\tStrength: %d%s\n", eWarr.getStrength(), " points");
        System.out.printf("\tDexterity: %d%s\n", eWarr.getDexterity(), " points");
        System.out.println("Enemy Armor:");
        System.out.printf("\tProtection: %d%s\n", eArm.getProtection(), " points");
        System.out.printf("\tEncumbrance: %d%s\n", eArm.getEncumbrance(), " points");
        System.out.println("Enemy Weapon:");
        System.out.printf("\tDamage: %d%s\n", eWep.getDamage(), " points");
        System.out.printf("\tWeight: %d%s\n", eWep.getWeight(), " pounds");
        System.out.println("//===============================>>\n\n");
    }

    public void gameOver(int pTurns, int pDamage, int eTurns, int eDamage, String winner, int numberOfGames, int playerWins, int enemyWins) {
        System.out.println(ANSI_YELLOW + "//***********************************************************//" + ANSI_RESET);
        System.out.printf("Player Stats: \t total turns: %d \t total damage: %d\n", pTurns, pDamage);
        System.out.printf("Enemy Stats: \t total turns: %d \t total damage: %d\n", eTurns, eDamage);
        System.out.printf("Total games played: %d\t\n", numberOfGames);
        System.out.printf("The player has %d wins\n", playerWins);
        System.out.printf("The enemy has %d wins\n", enemyWins);
        System.out.printf(ANSI_RED + "The Winner is the " + winner + "\n" + ANSI_RESET);
        System.out.println("Thank You for playing, have a great day!");
        System.out.println(ANSI_YELLOW + "//***********************************************************//" + ANSI_RESET);
    } // gameOver()

} // class

// printf
// %d = decimal integer
// %s = string placeholder
// %b = boolean

// escape sequence
// \ the escape character
// \n is an escape sequence
// \t for tab
// \r for return

// the sample for printf
/*
    // printf with right column alignment
    // formats to 10 characters wide, 2 decimal places
    System.out.printf("%10.2f%n", 2.28);
    System.out.printf("%15s%n", "Polymorphism");

    // printf with left column alignment
    // also formats to 10 characters wide, 2 decimal places
    System.out.printf("%-10.2f%n", 2.28);
    System.out.printf("%-15s%n", "Polymorphism");
*/