import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import simplenlg.framework.LexicalCategory;
import simplenlg.lexicon.Lexicon;

public final class Main{
   public static final Dictionary dictionary;
    private static final Lexicon lexicon = Lexicon.getDefaultLexicon();

    // public static String baseForm(String a) {
    //     return lexicon.lookupWord(a,LexicalCategory.VERB).getBaseForm();
    // }
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
    //    System.out.println(lexicon.lookupWord("helping")+" "+baseForm("helping"));
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
