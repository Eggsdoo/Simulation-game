package utility;
import java.util.Scanner;

public class Validator {
    private Scanner input = new Scanner(System.in);
    private Printer ink = new Printer();
    private boolean isValid = false;
    int choice;


    public Validator() {
    }

    public int validateMenuOptions(String menu) {
        isValid = false;
        choice = 0;  
        while(!isValid) {
            switch(menu) {
                case "warrior": {
                    ink.warriorOptions();
                    break;
                }
                case "armor": {
                    ink.armorOptions();
                    break;
                }
                case "weapon": {
                    ink.weaponOptions();
                    break;
                }
            } // switch
            try { // code that could crash app
                choice = input.nextInt();
                if(choice >= 1 && choice <= 3)
                    isValid = true;
            }
            catch (Exception elvis) { // when the error happens
                isValid = false; // resets the isValid boolean
            }
            finally { // runs everytime
                input.nextLine(); // flushes the scanner, resets
            }
        } // while

        return choice;
    } // validateMenuOptions()

    public int validateAttackOptions(int abilityCount, boolean specialActive) {
        isValid = false;
        choice = 0;
        while(!isValid) {
            ink.attackOptions(abilityCount, specialActive);
            try { // code that could crash our app
                choice = input.nextInt();
                if(abilityCount > 0 && specialActive == false) {
                    if(choice >= 1 && choice <= 3) {
                        isValid = true;
                    }
                }
                else {
                    if(choice >= 1 && choice <= 2) {
                        isValid = true;
                    }
                }
            } 
            catch (Exception elvis) { // when the error occurs
                isValid = false; // resets isValid
            }
            finally { // runs every single time
                input.nextLine(); // flushes scanner
            }
        } // while
        return choice;
    } // validateAttackOptions()
} // class
