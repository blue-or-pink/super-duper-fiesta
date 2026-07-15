import java.util.List;

public final class Main{
   private static final Dictionary dictionary;

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
        for (int i = 0; i < 38; i++) {
            System.out.println(
                dictionary.getPronounsList().get(i).word + " " +
                dictionary.getPronounsList().get(i).gender + " " +
                dictionary.getPronounsList().get(i).plural + " " +
                dictionary.getPronounsList().get(i).person);
        }
    }
}
