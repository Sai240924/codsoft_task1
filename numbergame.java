import java.util.*;
public class numbergame {
    private static final int max_attempts = 6;
    private static final int min_range = 1;     //Minimum number in range
    private static final int max_range = 100;   //Maximum number in range

    public static void main(String[] args){
        boolean play = true;
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int rounds=0; int score = 0;
        while(play){
            int rn = r.nextInt(max_range-min_range+1)+min_range;    //Generated random number
            int attempts=0;
            boolean won=false;
            rounds++;
            System.out.println("Round-"+rounds+", guess the number between "+min_range+" & "+max_range);
            while (attempts<max_attempts) {
                System.out.println("Guess a number : ");
                int g = s.nextInt();                                //User's guess
                attempts++;
                if (g==rn) {
                    System.out.println("You have guessed the correct number");
                    won=true;
                    score+=(max_attempts-attempts+1);
                    break;
                }
                else if (g<rn && (rn-g)<=10){                       //if guess is lower & closer to random number
                    System.out.println("You are closer, guess a higher number.");
                }
                else if (g<rn){
                    System.out.println("Your guess is smaller than the number, Try Again");
                }
                else if (g>rn && (g-rn)<=10){                       //if guess is higher & closer to random number
                    System.out.println("You are closer, guess a smaller number.");
                }
                else if(g>rn){
                    System.out.println("Your guess is higher than the number, Try Again");
                }
            }
            if (!won) {
                System.out.println("You have no more attempts left. The generated number is "+rn);
            }
            System.out.println("Do you want to play again (yes/no) : ");
            play=s.next().equalsIgnoreCase("yes");
        }
        System.out.println("Game Over! \nYou have played " + rounds + " rounds and scored " + score + " points.");
        s.close();;
    }
}