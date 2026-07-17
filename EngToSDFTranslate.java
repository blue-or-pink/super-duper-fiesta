import java.util.ArrayList;
import java.util.List;

public class EngToSDFTranslate {
    private static final Dictionary dictionary = Main.dictionary;

    public static class words {
        String word = "";
        String wordType = "";
        public words(String word, String wordType){
            this.word = word;
            this.wordType = wordType;
        }
    }

    public static List<words> sentenceWords = new ArrayList<>();

    public static String engToSDFTranslate(String sentence) throws Exception {
       String curWord = "";
        String wordType ="";
        for (int i = 0; i < sentence.length(); i++){
            char curChar = sentence.charAt(i);
            

            if (curChar != ' '){
                curWord = curWord + curChar;    

            } else if (curChar == ' '){
                //System.out.println(curWord);
                for (int a = 0; a < dictionary.getPronounsList().size(); a++){
                    if (dictionary.getPronounsList().get(a).engWord.equals(curWord)){
                        wordType = "pronoun";
                        //System.out.println(curWord + " is a pronoun");
                    }
                }
                // for (int a = 0; a < dictionary.getMarkersList().size(); a++){
                //     if (dictionary.getMarkersList().get(a).engWord.equals(curWord)){
                //         wordType = "marker";
                //         System.out.println(curWord + " is a marker");
                //     }
                // }
                for (int a = 0; a < dictionary.getPrepositionsList().size(); a++){
                    if (dictionary.getPrepositionsList().get(a).engWord.equals(curWord)){
                        wordType = "preposition";
                        //System.out.println(curWord + " is a preposition");
                    }
                }
                for (int a = 0; a < dictionary.getVerbsList().size(); a++){
                    if (dictionary.getVerbsList().get(a).engWord.equals(curWord)){
                        wordType = "verb";
                        //System.out.println(curWord + " is a verb");
                    }
                }
                for (int a = 0; a < dictionary.getAdjectivesList().size(); a++){
                    if (dictionary.getAdjectivesList().get(a).engWord.equals(curWord)){
                        wordType = "adjective";
                        //System.out.println(curWord + " is an adjective");
                    }
                }
                for (int a = 0; a < dictionary.getNounsList().size(); a++){
                    if (dictionary.getNounsList().get(a).engWord.equals(curWord)){
                        wordType = "noun";
                       //System.out.println(curWord + " is a noun");
                    }
                }

                sentenceWords.add(new words(curWord, wordType));
                curWord = "";
                wordType = "";

            }



        }
        String str = "";
        String adjective = "";

        for (int i=0;i<sentenceWords.size();i++) {
            String engWord = sentenceWords.get(i).word;
            String type = sentenceWords.get(i).wordType;
            String word = "";
            if (type == "adjective") {
                for (Adjective x: dictionary.getAdjectivesList()) {
                    //System.out.println(x.engWord + " " + engWord + " "+ (x.engWord == engWord));
                    if (x.engWord.equals(engWord)) {
                      //  System.out.println("ihoiuhu");
                        adjective = x.word;
                    }
                }
                 //str = str + word + " ";
            }
            if (type == "noun") {
                for (Noun x: dictionary.getNounsList()) {
                    if (x.engWord.equals(engWord)) {
                        word = x.word;
                    }
                }
                 str = str + word + " ";
                 str = str + adjective + " ";
                 adjective = "";
            }
            if (type == "preposition") {
                for (Preposition x: dictionary.getPrepositionsList()) {
                    if (x.engWord.equals(engWord)) {
                        word = x.word;
                    }
                }
                 str = str + word + " ";
            }
            if (type == "pronoun") {
                for (Pronoun x: dictionary.getPronounsList()) {
                    if (x.engWord.equals(engWord)) {
                        word = x.word;
                    }
                }
                 str = str + word + " ";
            }
            if (type == "verb") {
                for (Verb x: dictionary.getVerbsList()) {
                    if (x.engWord.equals(engWord)) {
                        word = x.word;
                    }
                }
                 str = str + word + " ";
            }
           
        }
        System.out.println(str);
        return str;
    }   
}