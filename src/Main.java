import java.util.Random;  // must import Random (like we do Scanner)
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        Random rnd = new Random(); // create a Random object called rnd.

        int rndBirthMonthOff = rnd.nextInt(12);  // generates a random value from 0 – 11
        int rndBirthMonth = rnd.nextInt(12) + 1; // What we want: 1 -12 so we shift it by adding 1

        int dieOff = rnd.nextInt(6);  // generates a random int between 0 and 5
        int die = rnd.nextInt(6) + 1; // generates a random int between 1 and 6 what we want for dice


        boolean done = false;
        boolean playAgain = false;
        boolean thePoint = false;
        boolean questionPrompt = false;
        String response = "";
        int sum = 0;
        int point = 0;

        do
        {

            do
            {
                int die1 = rnd.nextInt(6) + 1;
                int die2 = rnd.nextInt(6) + 1;

                System.out.println("Rolling your dice!");
                System.out.println("Your first die rolled a: " + die1 + " and your second die rolled a: " + die2);
                sum = die1 + die2;


                if (sum == 2 || sum == 3 || sum == 12)
                {
                    System.out.println("Your total is: " + sum + ". craps! You lose!");
                    done = true;
                }

                else if (sum == 7 || sum == 11)
                {
                    System.out.println("Your total is: " + sum + ". natural! You win!");
                    done = true;
                }

                else
                {
                    System.out.println("Your total is: " + sum + ". You get a point! You will now keep rolling until you either roll a 7 (lose) or your points total " + sum + " (win)");
                    point++;
                    do
                    {
                        int pointDie1 = rnd.nextInt(6) + 1;
                        int pointDie2 = rnd.nextInt(6) + 1;

                        System.out.println("Rolling your dice!");
                        System.out.println("Your first die rolled a: " + pointDie1 + " and your second die rolled a: " + pointDie2);

                        int pointSum = pointDie1 + pointDie2;
                        if (pointSum == 7)
                        {
                            System.out.println("You lose! Your point total was " + point);
                            thePoint = true;
                            done = true;

                        }
                        else
                        {
                            point++;
                            System.out.println("Your point total is: " + point);
                        }

                        if (point == sum)
                        {
                            System.out.println("You won! Your point total is: " + point);
                            thePoint = true;
                        }


                    }while(!thePoint);


                }

            }while(!done);

            do
            {
                System.out.println("Do you want to play again?[YN]");
                response = scan.nextLine();
                if (response.equalsIgnoreCase("Y"))
                {
                    System.out.println("You chose to play again!");
                    questionPrompt = true;
                }
                else if (response.equalsIgnoreCase("N"))
                {
                    System.out.println("You chose not to play again.");
                    playAgain = true;
                    questionPrompt = true;
                }
                else
                    System.out.println("You must enter a y or n! [YN]");
            }while(!questionPrompt);


        }while (!playAgain);


    }
}