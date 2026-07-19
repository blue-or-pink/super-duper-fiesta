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
    public static String removeLastChar(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, str.length() - 1);
    }
    public static List<words> sentenceWords = new ArrayList<>();

    public static String engToSDFTranslate(String sentence) throws Exception {
       String curWord = "";
        String wordType ="";
        for (int i = 0; i < sentence.length(); i++){
            char curChar = sentence.charAt(i);
            
            if (!(curChar == ' ')){
                if (curChar == '.' || curChar == '?' || curChar == '!') {
                   // System.out.println("eij"+curChar+"fwea");
                }
                else {
                    curWord = curWord + curChar;
                }
                
            } else {
               // System.out.println(curWord);
                if (!(curWord == "!" || curWord == "?" || curWord == "." )) {
                    for (int a = 0; a < dictionary.getPronounsList().size(); a++){
                        if (dictionary.getPronounsList().get(a).engWord.equals(curWord)){
                            wordType = "pronoun";
                            //System.out.println(curWord + " is a pronoun");
                        }
                    }
                    for (int a = 0; a < dictionary.getLinkingsList().size(); a++){
                        if (dictionary.getLinkingsList().get(a).engWord.equals(curWord)){
                            wordType = "linking";
                            // System.out.println(curWord + " is a linking word");
                        }
                    }
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
                        String e = dictionary.getAdjectivesList().get(a).engWord;
                        if (e.equals(curWord)
                        || (e+"ly").equals(curWord)){
                            wordType = "adjective";
                            //System.out.println(curWord + " is an adjective");
                        }
                        // also detects adjective form "-ly" ^^^                        
                    }  
                    for (int a = 0; a < dictionary.getNounsList().size(); a++){
                        String e = dictionary.getNounsList().get(a).engWord;
                        if (e.equals(curWord)
                        || (e+"s").equals(curWord) || 
                        (e+"es").equals(curWord) || 
                        (removeLastChar(e)+"ies").equals(curWord)){
                            wordType = "noun";
                        //System.out.println(curWord + " is a noun");
                        }
                    }
                    if (curWord.equals("a") || curWord.equals("an") || curWord.equals("the")) {
                        wordType = "article";
                    }
                    // to check if it still doesnt have a type:
                    // TODO: make it check if a punctuation list contains curChar its much more efficient! vvv
                    else if (wordType.equals("")) {
                        wordType = "proper_noun";
                    }
                }
                else {
                    wordType = "punctuation";
                }
                sentenceWords.add(new words(curWord, wordType));
                curWord = "";
                wordType = "";

            }



        }
        String str = "";
        List<String> adjective = new ArrayList<>();

        for (int i=0;i<sentenceWords.size();i++) {
            String engWord = sentenceWords.get(i).word;
            String type = sentenceWords.get(i).wordType;
            String word = "";
            if (type == "adjective") {
                for (Adjective x: dictionary.getAdjectivesList()) {
                    //System.out.println(x.engWord + " " + engWord + " "+ (x.engWord == engWord));
                    if (x.engWord.equals(engWord) || (x.engWord+"ly").equals(engWord)) {
                      //  System.out.println("ihoiuhu");
                        adjective.add(x.word);
                    }
                }
                 //str = str + word + " ";
            }
            if (type == "noun") {
                String pluralMarker = "";
                    // TODO: prolly should define these somewhere else or make the dict lists
                    // easier to search thru but idk
                for (Marker marker: dictionary.getMarkersList()) {
                    if (marker.purpose == "plural") {
                        pluralMarker = marker.word;
                    }
                }
                for (Noun x: dictionary.getNounsList()) {
                    // accounts for plurals now vvv
                    if (x.engWord.equals(engWord)) {
                        word = x.word;
                    }
                    else if (
                    (x.engWord+"s").equals(engWord) || 
                    (x.engWord+"es").equals(engWord) || 
                    // -y +ies
                    (removeLastChar(x.engWord)+"ies").equals(engWord)) {
                        word = pluralMarker + x.word;
                    }
                }
                 str = str + word + " ";
                 for (String adj: adjective) {
                    str = str + adj + " ";
                 }
                adjective = new ArrayList<>();

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
            if (type == "linking") {
                for (Linking x: dictionary.getLinkingsList()) {
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
                String adverbMarker = "";
                    // TODO: prolly should define these somewhere else or make the dict lists
                    // easier to search thru but idk
                for (Marker marker: dictionary.getMarkersList()) {
                    if (marker.purpose == "adverb") {
                        adverbMarker = marker.word;
                    }
                }
                 str = str + word + " ";
                 for (String adj: adjective) {
                    str = str + adj + adverbMarker + " ";
                 }
                adjective = new ArrayList<>();
            }
            if (type == "proper_noun") {
                // first letter capitalized vvv
                if (engWord.length() > 0){
                    String x = engWord.substring(0, 1).toUpperCase() + engWord.substring(1);
                    str = str + x + " ";
                }
            }
            if (type == "punctuation") {
                for (String adj: adjective) {
                    str = str + adj;
                }
                str = str + word;
            }
           
        }
        for (String adj: adjective) {
            str = str + adj;
        }
        System.out.println(str);
        return str;
    }   
}