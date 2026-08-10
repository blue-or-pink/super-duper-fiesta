import java.util.ArrayList;
import java.util.List;
import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.Lexicon;
import simplenlg.framework.WordElement;
import simplenlg.framework.LexicalCategory;
import wordtypes.*;
import java.util.Scanner;


public class EngToSDFTranslate {
    private static final Dictionary dictionary = Main.dictionary;
    private static final Lexicon lexicon = Lexicon.getDefaultLexicon();

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
    public static String baseForm(String a) {
        return lexicon.lookupWord(a,LexicalCategory.VERB).getBaseForm();
    }
    public static String engToSDFTranslate(String sentence) throws Exception {
       String curWord = "";
        String wordType ="";
        List<String> punctuation = new ArrayList<>();
        for (int i = 0; i < sentence.length(); i++){
            Boolean lemmatized = false;
            char curChar = sentence.charAt(i);
            
            if (!(curChar == ' ')){
                if (curChar == '.' || curChar == '?' || curChar == '!' || curChar == ',') {
                   //System.out.println("_"+curChar+"_");
                    punctuation.add(String.valueOf(curChar));

                }
                else {
                    curWord = curWord + curChar;
                }
                
            } else {
               // System.out.println(curWord);
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
                        if (dictionary.getVerbsList().get(a).engWord.equals(curWord) ||
                            dictionary.getVerbsList().get(a).engWord.equals(baseForm(curWord))){
                            wordType = "verb";
                            if (!dictionary.getVerbsList().get(a).engWord.equals(curWord)) {
                                lemmatized = true;
                            }
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

                //System.out.println(curWord+" "+wordType);
                String x = lemmatized ? baseForm(curWord) : curWord;
                sentenceWords.add(new words(x, wordType));
                curWord = "";
                wordType = "";
                //System.out.println(str);
                for (String str: punctuation) {
                    sentenceWords.add(new words(str, "punctuation"));
                }
                punctuation = new ArrayList<>();

                
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
            //beginning of pronoun section
            if (type == "pronoun") {
                Scanner scanner = new Scanner(System.in);
                System.out.println("engWord for the pronoun is " + engWord);
                if (engWord.equalsIgnoreCase("i") || engWord.equals("me")){
                    Boolean valid = false;
                    while (valid == false){
                        System.out.println("Is the speaker");
                        System.out.println("(a) female");
                        System.out.println("(b) male");
                        System.out.println("(c) other");
                        String answer = scanner.nextLine();
                        if (answer.equalsIgnoreCase("a")){
                            word = "tɪ";
                            valid = true;
                        } else if (answer.equalsIgnoreCase("b")){
                            word = "dɪ";
                            valid = true;
                        } else if (answer.equalsIgnoreCase("c")){
                            word = "sɪ";
                            valid = true;
                        } else {
                            System.out.println("Error, please type either a, b, or c");
                        }
                    }
                } 
                else if (engWord.equals("you")){
                    Boolean valid = false;
                    int person = 2;
                    Boolean plural = false;
                    while (valid == false){
                        System.out.println("Is you refering to..");
                        System.out.println("(a) one person");
                        System.out.println("(b) multiple people");
                        String answer = scanner.nextLine();
                        if (answer.equalsIgnoreCase("a")){
                            plural = false;
                            valid = true;
                        } else if (answer.equalsIgnoreCase("b")){
                            plural = true;
                            valid = true;
                        } else {
                            System.out.println("Error, please type either a or b"); 
                        }
                    }
                    valid = false;
                    //gender
                    while (valid == false){
                        if (plural == false){
                            System.out.println("What is their gender?");
                            System.out.println("(a) female");
                            System.out.println("(b) male");
                            System.out.println("(c) other");
                            Boolean validTwo = false;
                            while (validTwo == false){
                                String answer = scanner.nextLine();
                                //work from here
                                System.out.println("you typed " + answer);
                                if (answer.equalsIgnoreCase("a")){
                                    word = "tɪs";
                                    validTwo = true;
                                } else if (answer.equalsIgnoreCase("b")){
                                    word = "dɪs";
                                    validTwo = true;
                                } else if (answer.equalsIgnoreCase("c")){
                                    word = "sɪs";
                                    validTwo = true;
                                } else {
                                    System.out.println("Error, please type either a, b, or c");
                                }
                            }
                            valid = true;
                        } else if (plural == true){
                            System.out.println("Type one f and one m and one o for each person of that gender in the group described by you");
                            System.out.println("Ex: ffmo");
                            int numF = 0;
                            int numM = 0;
                            int numO = 0;
                            String answer = scanner.nextLine();
                            for (int a = 0; a<answer.length(); a++){
                                if (answer.charAt(a) == 'f'){
                                    numF += 1;
                                } else if (answer.charAt(a) == 'm'){
                                    numM += 1;
                                } else if (answer.charAt(a) == 'o'){
                                    numO += 1;
                                }
                            }
                            if (numF == 0 && numO == 0){
                                word = "dʊup";
                            } else if (numM == 0 && numO == 0){
                                word = "tʊup";
                            } else if (numF == 0 && numM == 0){
                                word = "sʊup";
                            } else if (numF == numM && numM == numO){
                                word = "tʊdʊs";
                            } else if (numF == numM && numO == 0){
                                word = "tʊd";
                            } else if (numF == numO && numM == 0){
                                word = "tʊs";
                            } else if (numM == numO && numF == 0){
                                word = "dʊs";
                            } else if (numF == numM && numO != numM && numO != 0){
                                word = "fʊmis";
                            } else if (numM == numO && numF != numO && numF != 0){
                                word = "dʊsif";
                            } else if (numF == numO && numO != numM && numM != 0){
                                word = "tʊsid";
                            } else if (numF > numM && numF > numO){
                                word = "tʊhi";
                            } else if (numM > numF && numM > numO){
                                word = "dʊhi";
                            } else if (numO > numF && numO > numM){
                                word = "sʊhi";
                            } else {
                                word = "ERROR";
                            }     
                        } 
                        valid = true;
                    }
                } else if (engWord.equals("she") || engWord.equals("her")){
                    word = "tə";
                } else if (engWord.equals("he") || engWord.equals("him")) {
                    word = "də";
                } else if (engWord.equals("they") || engWord.equals("them")){
                    System.out.println("Does they refer to..");
                    System.out.println("(a) one person");
                    System.out.println("(b) multiple people");
                    //NONE OF THIS IS WORKING
                    Boolean valid = false;
                    while (!valid){
                        String answer = scanner.nextLine();
                        if (answer.equalsIgnoreCase("a")){
                            //singular
                            valid = true;
                            Boolean validTwo = false;
                            System.out.println("What is their gender?");
                            System.out.println("(a) female");
                            System.out.println("(b) male");
                            System.out.println("(c) other");
                            while (!validTwo){
                                answer = scanner.nextLine();
                                if (answer.equals("a")){
                                    word = "tə";
                                    validTwo = true;
                                } else if (answer.equals("b")){
                                    word = "də";
                                    validTwo = true;
                                } else if (answer.equals("c")){
                                    word = "sə";
                                    validTwo = true;
                                } else {
                                    System.out.println("Error, please type either a, b, or c");
                                }
                            }
                        //plural
                        } else if (answer.equalsIgnoreCase("b")){
                            Boolean plural = true;
                            valid = true;
                            System.out.println("Type one f and one m and one o for each person of that gender in the group described by you");
                            System.out.println("Ex: ffmo");
                            int numF = 0;
                            int numM = 0;
                            int numO = 0;
                            answer = scanner.nextLine();
                            for (int a = 0; a<answer.length(); a++){
                                if (answer.charAt(a) == 'f'){
                                    numF += 1;
                                } else if (answer.charAt(a) == 'm'){
                                    numM += 1;
                                } else if (answer.charAt(a) == 'o'){
                                    numO += 1;
                                }
                            }
                            if (numM == 0 && numO == 0){
                                word = "tɑ";
                            } else if (numF == 0 && numO == 0){
                                word = "dɑ";
                            } else if (numF == 0 && numM == 0){
                                word = "sɑ";
                            } else if (numF == numM && numM == numO){
                                word = "tɑdas";
                            } else if (numF == numM && numO == 0){
                                word = "tɑd";
                            } else if (numF == numO && numM == 0){
                                word = "tɑs";
                            } else if (numM == numO && numF == 0){
                                word = "dɑs";
                            } else if (numF == numM && numO > 0){
                                word = "tɑdis";
                            } else if (numM == numO && numF > 0){
                                word = "dɑsif";
                            } else if (numF == numO && numM > 0){
                                word = "tɑsid";
                            } else if (numF > numM && numF > numO){
                                word = "tɑhi";
                            } else if (numM > numF && numM > numO){
                                word = "dɑhi";
                            } else if (numO > numM && numO > numF){
                                word = "sɑhi";
                            } else {
                                word = "ERROR";
                            }

                            
                        } else {
                            System.out.println("Error, please type either a or b");
                        }
                    }
                }
                 str = str + word + " ";
            }







            //need add we still!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                        
            //end of pronouns section
            if (type == "linking") {
                for (Linking x: dictionary.getLinkingsList()) {
                    if (x.engWord.equals(engWord)) {
                        word = x.word;
                    }
                }
                 str = str + word + " ";
            }
            if (type == "verb") {
                Boolean lemmatized = false;
                String lemmatizedWord = "";
                for (Verb x: dictionary.getVerbsList()) {
                    if (baseForm(x.engWord).equals(engWord)) {
                        word = x.word;
                        lemmatizedWord = word;
                        if (!engWord.equals(x.engWord)) {
                            lemmatized = true;
                            lemmatizedWord = baseForm(x.engWord);
                        }
                        // TODO: test & add checking for past/future etc to add back marker pre/suffixes
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
                 str = str + lemmatizedWord + " ";
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
                if (str.charAt(str.length() - 1) == ' ') {
                    str = removeLastChar(str); // remove the extra space
                }
                str = str + engWord + " ";
            }
           
        }
        for (String adj: adjective) {
            str = str + adj;
        }
        System.out.println(str);
        return str;
    }   
}