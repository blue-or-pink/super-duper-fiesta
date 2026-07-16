import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    public static final List<Adjective> adjectives = new ArrayList<>();
    public static final List<Verb> verbs = new ArrayList<>();
    public static final List<Article> articles = new ArrayList<>();
    public static final List<Preposition> prepositions = new ArrayList<>();
    public static final List<Marker> markers = new ArrayList<>();
    public static final List<Pronoun> pronouns = new ArrayList<>();
    
    public Dictionary() throws Exception{
        List<String> pronounsStrings = Spreadsheet.getPronouns();

        for (int i = 0; i < 38; i++){
            String word = "";
            String gender = null;
            String plural = "";
            int person = 0;
            String curString = pronounsStrings.get(i);
            String curVar = "";
            int curVarNum = 1;

            for (int a = 0; a < curString.length(); a++){
                char curChar = curString.charAt(a); 
                if (!String.valueOf(curChar).equals(",")) { //it was == earlier which doesn't work for strings apparently
                    curVar = curVar + curChar;
                } else {
                    if (curVarNum == 1){
                        word = curVar;
                    } else if (curVarNum == 2){
                        gender = curVar;
                    } else if (curVarNum == 3){
                        if (curVar.equals("TRUE")){ //the issue here was the same, it was == instead of .equals so it was never true
                            plural = "true";
                        } else if (curVar.equals("FALSE")){
                            plural = "false";
                        }
                    } else if (curVarNum == 4){
                        person = Integer.parseInt(curVar);
                    }
                    curVarNum +=1;
                    curVar = ""; //it never reset curVar earlier so it wasn't actually separating the values
                }      
            }
            pronouns.add(new Pronoun(word, gender, plural, person));
        }
    }
    //
    public List<Pronoun> getPronounsList() {
        return pronouns;
    }
}