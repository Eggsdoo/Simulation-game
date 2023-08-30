package utility;
import java.util.Random;

public class Announcer {
    private Random die = new Random();
    // the collection of the collections
    private String[][] missComments = {
        { "it's a swing", "and a miss!" },
        { "a mighty swing", "ouch that's a miss" },
        { "calculated attack", "and another miss!" },
        { "angry attack", "but a miss!" }
    };    
    private String[][] hitComments = {
        { "it's a swing", "and a smashing hit!" },
        { "a mighty swing", "that's gonna leave a mark!" },
        { "calculated attack", "and a hit!" },
        { "angry attack", "and lots of damage!" },
        { "a swing", "and a great hit!" },
        { "angry attack", "wow what percision!" },
    };
    
    public String getMissComment() {
        String s1 = "";
        String s2 = "";
        int row = die.nextInt(missComments.length); // 0, 1, 2, 3, and so on
        s1 = missComments[row][0];
        s2 = missComments[row][1];
        return s1 + " " + s2;
    } // getMissComment()

    public String getHitComment() {
        int row = die.nextInt(missComments.length); // 0, 1, 2, 3, 4, 5, and so on
        return hitComments[row][0] + " " + hitComments[row][1];
    } // getHitComment()

} // class