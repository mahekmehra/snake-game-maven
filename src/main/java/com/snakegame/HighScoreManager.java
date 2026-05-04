// HighScoreManager.java
package com.snakegame;
import java.io.*;

public class HighScoreManager {

    private static final String FILE_NAME = "highscore.txt";

    // Read high score
    public static int getHighScore() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            return Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            return 0; // default if file doesn't exist
        }
    }

    // Save high score
    public static void setHighScore(int score) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(String.valueOf(score));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}