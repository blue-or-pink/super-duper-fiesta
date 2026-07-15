
public class Pronoun{
    //
    public String word = "";
    public String gender = null;
    public Boolean plural = null;
    public int person = 0;
    //
    public Pronoun(String word, String gender, Boolean plural, int person) {
        this.word = word;
        this.gender = gender;
        this.plural = plural;
        this.person = person;
    }
}