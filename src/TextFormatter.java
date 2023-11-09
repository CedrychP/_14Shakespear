import java.io.*;
import java.util.Random;

public class TextFormatter {

  public static String formatWord(String word) {
    Random random = new Random();
    StringBuilder formattedWord = new StringBuilder();
    formattedWord.append(word.charAt(0));

    for (int i = 1; i < word.length(); i++) {
      char currentChar = word.charAt(i);

      if (Character.isLetter(currentChar)) {
        if (random.nextBoolean()) {
          formattedWord.append(Character.toUpperCase(currentChar));
        } else {
          formattedWord.append(Character.toLowerCase(currentChar));
        }
      } else {
        formattedWord.append(currentChar);
      }
    }

    return formattedWord.toString();
  }

  public static void main(String[] args) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
      BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
      String line;

      while ((line = reader.readLine()) != null) {
        String[] words = line.split("\\s+");

        for (String word : words) {
          writer.write(formatWord(word) + " ");
        }

        writer.newLine();
      }

      reader.close();
      writer.close();

      System.out.println("Text formatting complete.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}