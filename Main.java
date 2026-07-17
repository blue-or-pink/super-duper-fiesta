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
        IdentifyEng.identifyEng("sɪ jəghə lætɪs fo vittɑkin.");

    }
}
