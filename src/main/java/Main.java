package src.main.java;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public final class Main{
   public static final Dictionary dictionary;
    public static String translated = "";
    static {
        try {
            dictionary = new Dictionary();
        } catch (Exception e) {
            // Handle the exception appropriately
            e.printStackTrace();
            // You might want to throw a RuntimeException if the dictionary fails to load
            throw new RuntimeException("Failed to initialize Dictionary", e);
        }
    }

    public static void main(String[] args) throws Exception {
        // IdentifySDF.identifySDF("sɪ jəg tɪs ŋʊjʊtɔʃzɪ vittɑkin tʊtmʊʒŋəvpɔ ");
        // IdentifyEng.identifyEng("i call clear you in school ");
       // while (true) {
            Scanner scanner = new Scanner(System.in);
            String sentence = scanner.nextLine();
            translated = EngToSDFTranslate.engToSDFTranslate((sentence + " ").toLowerCase());
       // }
       // Write the string directly to a simple text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            writer.write(translated);
            System.out.println("Saved string to data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // TODO: maybe make word order factor into this for more complex sentences?

}
