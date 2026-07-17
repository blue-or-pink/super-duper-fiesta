import java.util.List;
import java.util.Scanner;

public final class Main{
   public static final Dictionary dictionary;

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
            EngToSDFTranslate.engToSDFTranslate((sentence + " ").toLowerCase());
       // }
    }
}
