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
        List<String> pronounsStrs = Spreadsheet.getPronouns();
    }
}