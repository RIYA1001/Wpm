import java.util.Random;
import java.util.Scanner;

public class Wpm {
    private static final int WORD_LENGTH = 5;
    private static final int GAME_DURATION_SEC = 30;

    public static void main(String[] args) {
        System.out.println("Welcome to Typeracer!");
        System.out.println("Type the given words as fast as you can.");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int wordCount = 0;
        int correctWords = 0;
        long startTime = System.currentTimeMillis();

        while ((System.currentTimeMillis() - startTime) / 1000 < GAME_DURATION_SEC) {
            String word = generateRandomWord(random);
            System.out.print(word + " ");
            String typedWord = scanner.next();
            if (typedWord.equals(word)) {
                correctWords++;
            }
            wordCount++;
        }

        long endTime = System.currentTimeMillis();
        long elapsedTimeSec = (endTime - startTime) / 1000;
        double wpm = calculateWPM(wordCount, elapsedTimeSec);

        System.out.println("\nGame Over!");
        System.out.println("You typed " + correctWords + " out of " + wordCount + " words correctly.");
        System.out.println("Your typing speed: " + wpm + " words per minute.");
    }

    private static String generateRandomWord(Random random) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < WORD_LENGTH; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            sb.append(c);
        }
        return sb.toString();
    }

    private static double calculateWPM(int wordCount, long elapsedTimeSec) {
        double minutes = elapsedTimeSec / 60.0;
        return (wordCount / minutes);
    }
}
