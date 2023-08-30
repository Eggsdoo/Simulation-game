import warrior.*;
import armor.*;
import weapon.*;
import utility.*;
//import java.io.*;
//import java.io.IOException;
//import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    private static Scanner input = new Scanner(System.in);    
    private static Random randNum = new Random();
    private static Printer ink = new Printer();
    private static Announcer announcer = new Announcer();
    private static Validator validator = new Validator();
    //private static File folder;
    private static Warrior pWarrior; // human is-a warrior
    private static Warrior eWarrior;
    private static Armor pArmor;
    private static Armor eArmor;
    private static Weapon pWeapon;
    private static Weapon eWeapon;


    private static boolean gameOver = false;
    private static boolean isPlayerTurn = true;
    private static boolean pSpecialActive = false;
    private static boolean eSpecialActive = false;
    private static boolean isValid = false;
    private static boolean playAgain = true;
    private static boolean saveGame = true;
    private static String winner = "";
    //private static String fileName;
    private static int choice = 0;
    private static int damage = 0;
    private static int pAbilitiesLeft = 2;
    private static int eAbilitiesLeft = 2;

    // end of game stats

    private static int totalPTurns = 0;
    private static int totalETurns = 0;
    private static int totalPDamage = 0;
    private static int totalEDamage = 0;
    private static int numberOfGames = 0;
    private static int playerWins = 0;
    private static int enemyWins = 0;

    public static void main(String[] args) {
        ink.welcome();
        
        // Player setup //

        // Username Setup // 

        System.out.println("What will you name your warrior: ");
        String playerName = input.nextLine();


        // Warrior type
        createWarrior(validator.validateMenuOptions("warrior"), "player");
        // Armor type
        createArmor(validator.validateMenuOptions("armor"), "player");
        // Weapon type
        createWeapon(validator.validateMenuOptions("weapon"), "player");

        pWarrior.setName(playerName);

        // Enemy Setup //
        // Warrior type //
        createWarrior(randNum.nextInt(3) + 1, "enemy");
        // Armor type //
        createArmor(randNum.nextInt(3) + 1, "enemy");
        // Weapon type //
        createWeapon(randNum.nextInt(3) +1, "enemy");

        eWarrior.setName(EnemyNames.getRandomName());
        System.out.println(eWarrior.getName());

        ink.stats(pWarrior, pArmor, pWeapon, eWarrior, eArmor, eWeapon);


        // game loop
        while(!gameOver) {
            if(isPlayerTurn) { // player
                // prompt for attack type
                choice = validator.validateAttackOptions(pAbilitiesLeft, pSpecialActive);

                // attempt to strike
                if(choice != 3) {
                    damage = pWeapon.strike(pWarrior, pArmor, choice, eArmor);
                    pWarrior.removeBuff();
                    pSpecialActive = false;
                }
                else {
                    pWarrior.specialAbility();
                    pSpecialActive = true;
                    pAbilitiesLeft--; // takes one ability away
                }


                totalPTurns++; // adds 1 to the total player turns

                // process damage 0 or more
                if(damage > 0) {
                    eWarrior.takeDamage(damage);
                    System.out.println(announcer.getHitComment());
                    totalPDamage += damage;
                }
                else {
                    if(choice != 3) {
                        System.out.println(announcer.getMissComment());
                    }
                }

                // printing results for the strike
                ink.turnResult(damage, eWarrior, playerName); // playerName
                
                //check for pulse
                if(eWarrior.getHealth() <= 0) {
                    winner = "Player";
                    gameOver = true;
                    playerWins++;
                }
                //if no pulse you win
                //game over
                //
            }
            else { // enemy
                // choose attack type
                choice = randNum.nextInt(3) + 1;
                // attempt to strike
                if(choice != 3) {
                    damage = eWeapon.strike(eWarrior, eArmor, choice, pArmor);
                    eWarrior.removeBuff();
                    eSpecialActive = false;
                }
                else {
                    eWarrior.specialAbility();
                    eSpecialActive = true;
                    eAbilitiesLeft--; // takes one ability away
                }

                totalETurns++; // adds 1 to the total enemy turns

                // process damage 0 or more
                if(damage > 0) {
                    pWarrior.takeDamage(damage);
                    System.out.println(announcer.getHitComment());
                    totalEDamage += damage;
                }
                else {
                    if(choice != 3) {
                        System.out.println(announcer.getMissComment());
                    }
                }

                // printing results for the strike
                ink.turnResult(damage, pWarrior, eWarrior.getName());

                //check for pulse
                if(pWarrior.getHealth() <= 0) {
                    winner = "Enemy";
                    gameOver = true;
                    enemyWins++;
                }

                //if no pulse enemy wins
                //game over
                //

            }
            // toggles whos turn it is
            isPlayerTurn = !isPlayerTurn;

            if(pWarrior.getHealth() <= 100) { 
                System.out.println("You have sustained life-threatening injuries, would you like to surrender? (yes/no)");
                String surrender = input.nextLine();
                while(!surrender.equalsIgnoreCase("yes") && !surrender.equalsIgnoreCase("no")) {
                    System.out.println("Invalid input, please choose 'yes' or 'no'");
                    surrender = input.nextLine();
                }
                if(surrender.equalsIgnoreCase("yes")) { // very obnoxious 'NOOB' ASCII for surrendering
                    System.out.println("You're a..");
                    System.out.println("NNNNNNNN        NNNNNNNN     OOOOOOOOO          OOOOOOOOO     BBBBBBBBBBBBBBBBB");  
                    System.out.println("N:::::::N       N::::::N   OO:::::::::OO      OO:::::::::OO   B::::::::::::::::B");
                    System.out.println("N::::::::N      N::::::N OO:::::::::::::OO  OO:::::::::::::OO B::::::BBBBBB:::::B");
                    System.out.println("N:::::::::N     N::::::NO:::::::OOO:::::::OO:::::::OOO:::::::OBB:::::B     B:::::B");
                    System.out.println("N::::::::::N    N::::::NO::::::O   O::::::OO::::::O   O::::::O  B::::B     B:::::B");
                    System.out.println("N:::::::::::N   N::::::NO:::::O     O:::::OO:::::O     O:::::O  B::::B     B:::::B");
                    System.out.println("N:::::::N::::N  N::::::NO:::::O     O:::::OO:::::O     O:::::O  B::::BBBBBB:::::B)");
                    System.out.println("N::::::N N::::N N::::::NO:::::O     O:::::OO:::::O     O:::::O  B:::::::::::::BB");
                    System.out.println("N::::::N  N::::N:::::::NO:::::O     O:::::OO:::::O     O:::::O  B::::BBBBBB:::::B");
                    System.out.println("N::::::N   N:::::::::::NO:::::O     O:::::OO:::::O     O:::::O  B::::B     B:::::B");
                    System.out.println("N::::::N    N::::::::::NO:::::O     O:::::OO:::::O     O:::::O  B::::B     B:::::B");
                    System.out.println("N::::::N     N:::::::::NO::::::O   O::::::OO::::::O   O::::::O  B::::B     B:::::B");
                    System.out.println("N::::::N      N::::::::NO:::::::OOO:::::::OO:::::::OOO:::::::OBB:::::BBBBBB::::::B");
                    System.out.println("N::::::N       N:::::::N OO:::::::::::::OO  OO:::::::::::::OO B:::::::::::::::::B ");
                    System.out.println("N::::::N        N::::::N   OO:::::::::OO      OO:::::::::OO   B::::::::::::::::B");
                    System.out.println("NNNNNNNN         NNNNNNN     OOOOOOOOO          OOOOOOOOO     BBBBBBBBBBBBBBBBB");
                    noob();
                }
                
            }
            
            if(pWarrior.getHealth() <= 0 || eWarrior.getHealth() <= 0) {
                numberOfGames++;
            }

            if(gameOver) { // added numberOfGames, playerWins, and enemyWins
                ink.gameOver(totalPTurns, totalPDamage, totalETurns, totalEDamage, winner, numberOfGames, playerWins, enemyWins);
            
            while(saveGame) { // allows the user to decide whether to save game or not
                System.out.println("Do you want to save your game? (yes/no): ");
                String saveResponse = input.nextLine();
                    if (saveResponse.equalsIgnoreCase("no")) {
                        gameOver = true;
                        playAgain = true;
                        break;
                    } else if(saveResponse.equalsIgnoreCase("yes")) {
                        System.out.println("Saving the game..");
                        //fileName = input.nextLine() + ".txt"; 
                        //System.out.println("New " + fileName + " file created.");
                        //saveGame(fileName);
                        playAgain = true;
                        break;
                    } else {
                        System.out.println("Invalid input, please choose yes or no:");
                    }
                }

            while(playAgain) { // allows the user to play again with new warrior stats and randomized enemy stats
                    
                System.out.println("Do you want to play again? (yes/no): ");
                String playResponse = input.nextLine();
                    if (playResponse.equalsIgnoreCase("no")) {
                        playAgain = false;
                    }
                    if(playResponse.equalsIgnoreCase("yes")) {
                        reset();
                        //resumeGame("pens.txt");

                        isPlayerTurn = !isPlayerTurn;
                                // Warrior type
                            createWarrior(validator.validateMenuOptions("warrior"), "player");
                                // Armor type
                            createArmor(validator.validateMenuOptions("armor"), "player");
                                // Weapon type
                            createWeapon(validator.validateMenuOptions("weapon"), "player");

                                // Enemy Setup //
                                // Warrior type //
                            createWarrior(randNum.nextInt(3) + 1, "enemy");
                                // Armor type //
                            createArmor(randNum.nextInt(3) + 1, "enemy");
                                // Weapon type //
                            createWeapon(randNum.nextInt(3) +1, "enemy");

                            eWarrior.setName(EnemyNames.getRandomName());

                            ink.stats(pWarrior, pArmor, pWeapon, eWarrior, eArmor, eWeapon);
                    }
                    else {
                        //System.out.println("Invalid input, please choose yes/no:"); // not needed
                        // playResponse = input.nextLine(); <-- don't need
                    }
                }
            }
        }



    } // main()

    public class EnemyNames { // creates enemy with any of the following name
        private static String[] names = {"Behemoth", "Thor", "Albert the 3rd", "The Oil Man", "Donald Trump", "Justin Trudeau", "Barrack", "Joe"};


        public static String getRandomName() { // random choosing of the names in the array
            int randomIndex = (int)(Math.random() * names.length);
            return names[randomIndex];
        }
    }

    public static void noob() {
        winner = "Enemy";
        gameOver = true;
        enemyWins++;
    }

    public static void reset() {
        System.out.println("Resetting the game, please wait.");
        gameOver = false;
        playAgain = false;
        pAbilitiesLeft = 2;
        eAbilitiesLeft = 2;
    }

    /*
     * ====================================
     * HELPER METHODS
     */

    private static void createWarrior(int choice, String who) {
        switch(choice) {
            case 1: { // human
                if(who.equals("player")) {
                    pWarrior = new Human();
                }
                else {
                    eWarrior = new Human();
                }
                break;
            }
            case 2: { // elf
                if(who.equals("player")) {
                    pWarrior = new Elf();
                    pAbilitiesLeft = 2;
                }
                else {
                    eWarrior = new Elf();
                    eAbilitiesLeft = 2;
                }
                break;
            }
            case 3: { // orc
                if(who.equals("player")) {
                    pWarrior = new Orc();
                    pAbilitiesLeft = 2;
                }
                else {
                    eWarrior = new Orc();
                    eAbilitiesLeft = 2;
                }
                break;
            }
            default: {
                // do nothing 
            }
        } // switch
    } // createWarrior()

    private static void createArmor(int choice, String who) {
        switch(choice) {
            case 1: { // leather
                if(who.equals("player"))
                    pArmor = new Leather();
                else
                    eArmor = new Leather();
                break;
            }
            case 2: { // chainmail
                if(who.equals("player"))
                    pArmor = new Chainmail();
                else
                    eArmor = new Chainmail();
                break;
            }
            case 3: { // platemail
                if(who.equals("player"))
                    pArmor = new Platemail();
                else
                    eArmor = new Platemail();
                break;
            }
            default: {
                // do nothing 
            }
        } // switch
    }

    private static void createWeapon(int choice, String who) {
        switch(choice) {
            case 1: { // dagger
                if(who.equals("player"))
                    pWeapon = new Dagger();
                else
                    eWeapon = new Dagger();
                break;
            }
            case 2: { // sword
                if(who.equals("player"))
                    pWeapon = new Sword();
                else
                    eWeapon = new Sword();
                break;
            }
            case 3: { // axe
                if(who.equals("player"))
                    pWeapon = new Axe();
                else
                    eWeapon = new Axe();
                break;
            }
            default: {
                // do nothing 
            }
        } // switch
    }
} // class