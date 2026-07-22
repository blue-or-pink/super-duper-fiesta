import java.util.ArrayList;
import java.util.List;

public class IdentifySDF {
    private static final Dictionary dictionary = Main.dictionary;

    public static class words {
        public words(String word, String wordType){
        }
    }

    public static List<words> sentenceWords = new ArrayList<>();

    public static void identifySDF(String sentence) throws Exception {
        String curWord = "";
        String wordType ="";
        for (int i = 0; i < sentence.length(); i++){
            char curChar = sentence.charAt(i);
            

            if (curChar != ' '){
                curWord = curWord + curChar;    

            } else if (curChar == ' '){
                System.out.println(curWord);
                for (int a = 0; a < dictionary.getPronounsList().size(); a++){
                    if (dictionary.getPronounsList().get(a).word.equals(curWord)){
                        wordType = "pronoun";
                        System.out.println(curWord + " is a pronoun");
                    }
                }
                for (int a = 0; a < dictionary.getMarkersList().size(); a++){
                    if (dictionary.getMarkersList().get(a).word.equals(curWord)){
                        wordType = "marker";
                        System.out.println(curWord + " is a marker");
                    }
                }
                for (int a = 0; a < dictionary.getPrepositionsList().size(); a++){
                    if (dictionary.getPrepositionsList().get(a).word.equals(curWord)){
                        wordType = "preposition";
                        System.out.println(curWord + " is a preposition");
                    }
                }
                for (int a = 0; a < dictionary.getVerbsList().size(); a++){
                    if (dictionary.getVerbsList().get(a).word.equals(curWord)){
                        wordType = "verb";
                        System.out.println(curWord + " is a verb");
                    }
                }
                for (int a = 0; a < dictionary.getAdjectivesList().size(); a++){
                    if (dictionary.getAdjectivesList().get(a).word.equals(curWord)){
                        wordType = "adjective";
                        System.out.println(curWord + " is an adjective");
                    }
                }
                for (int a = 0; a < dictionary.getNounsList().size(); a++){
                    if (dictionary.getNounsList().get(a).word.equals(curWord)){
                        wordType = "noun";
                        System.out.println(curWord + " is a noun");
                    }
                }

                sentenceWords.add(new words(curWord, wordType));
                curWord = "";
                wordType = "";

            }

        }
    }   
}