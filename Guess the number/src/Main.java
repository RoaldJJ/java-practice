//Stap 1: Laat het programma een random getal tussen de 0 en 1000 kiezen.
//
//Stap 2: Vraag aan de gebruiker om input van een getal.
//
//Stap 3: Geef feedback aan de gebruiker: moet die hoger of lager raden? Of is het al goed?.
//
//Stap 4: Zorg dat het programma de gebruiker 10 beurten geeft om het getal te raden.
// Als de gebruiker het getal heeft geraden dan stopt het programma.
// Als de gebruiker na 10 beurten het getal niet heeft geraden dan stopt het programma en krijgt de gebruiker het getal te zien.
//
//stap 5: Zorg dat de gebruiker opnieuw kan spelen zonder het programma opnieuw op te starten.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scannerObj = new Scanner(System.in);

        int playOption = 1;
        while (playOption == 1) {

            System.out.println("Do you want to guess my number? (1=yes 0=no):");
            playOption = scannerObj.nextInt();

            if (playOption == 0) {
                break;
            }

            System.out.println("Choose the max number to guess from (range=0-max):");
            int maxNumber = scannerObj.nextInt();

            System.out.println("Choose the number of guesses you want to make:");
            int maxTurns = scannerObj.nextInt();

            //Random int 0-1000 (incl.)
            float randomFloat = (float) (Math.random() * maxNumber);
            int randomNum = Math.round(randomFloat);

            int guessedNumber = maxNumber+2000;
            int turns = 0;

            while (guessedNumber != randomNum && turns != maxTurns) {

                turns = turns + 1;
                //Scanner numberIn = new Scanner(System.in);
                System.out.printf("turn number %s\n", turns);
                System.out.printf("Integer number(0-%s):\n", maxNumber);
                guessedNumber = scannerObj.nextInt();

                //System.out.println("another one");
                //int anotherNumber = scannerObj.nextInt();

                if (guessedNumber != randomNum) {
                    System.out.println("Guess incorrect");

                    if (guessedNumber > randomNum) {
                        System.out.println("Need to lower your guess");
                    } else {
                        System.out.println("Need to increase your guess");
                    }
                } else {
                    System.out.println("Guessed correctly");
                }
            }
            if (turns == maxTurns && guessedNumber != randomNum) {
                System.out.printf("Out of guesses. The correct number was %s", randomNum);
            }
        }
        scannerObj.close();
    }
}