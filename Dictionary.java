import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    // public static final Noun[] Nouns = {

    // };
    // public static final Adjective[] Adjectives = {

    // };
    // public static final Verb[] Verbs = {

    // };
    //
    public static final List<Pronoun> pronouns = new ArrayList<>();
    
    public Dictionary() throws Exception{
        List<String> pronounsStrings = Spreadsheet.getPronouns();

        for (int i = 0; i < 39; i++){
            String word = "";
            String gender = null;
            Boolean plural = null;
            int person = 0;
            String curString = pronounsStrings.get(i);
            String curVar = "";
            int curVarNum = 1;

            for (int a = 0; a < curString.length(); a++){
                char curChar = curString.charAt(a);
                if (String.valueOf(curChar) != ",") {
                    curVar = curVar + curChar;
                } else {
                    if (curVarNum == 1){
                        word = curVar;
                    } else if (curVarNum == 2){
                        gender = curVar;
                    } else if (curVarNum == 3){
                        if (curVar == "TRUE"){
                            plural = true;
                        } else if (curVar == "FALSE"){
                            plural = false;
                        }
                    } else if (curVarNum == 4){
                        person = Integer.parseInt(curVar);
                    }
                    curVarNum +=1;
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