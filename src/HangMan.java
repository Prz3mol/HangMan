import javax.management.StringValueExp;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangMan {
    private List<String> words = List.of("siano", "zakupy", "praca");
    private String word;
    private char[] guessword;

    private int health = 3;
    private List<Character> guessedLetters = new ArrayList<>();
    public void play() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        word = words.get(random.nextInt(words.size()));
        guessword = new char[word.length()];
        Arrays.fill(guessword, '_');


        while (!gameEnded()){
            System.out.println("Liczba żyć:" + health);
            System.out.println(guessword);
            System.out.println();
            System.out.println("Podaj kolejną litere");
            char letter = scanner.nextLine().charAt(0);

            checkLetter(letter);

        }
        if (health==0){
            System.out.println("Przegrałeś sprój szczęścia jeszcze raz :)");
        }else {
            System.out.println("Brawo zgadłeś hasło");
        }
        scanner.close();
    }

    private void checkLetter(char letter) {
        boolean foundLetter = false;

        if (guessedLetters.contains(letter)) {
            System.out.println("Już zgadywałeś tę literę. Tracisz życie!");
            health--;
        } else {
            guessedLetters.add(letter);
        }


        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i)==letter){
                guessword[i] = letter;
                foundLetter = true;

            }
        }


        if (!foundLetter){
            System.out.println("Nie trafiłeś spróbój jescze raz");
            health--;
        }

    }

    private boolean gameEnded() {
        return word.equals(String.valueOf(guessword)) || health == 0;
    }
}
