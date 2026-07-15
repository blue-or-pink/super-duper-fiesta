
public class Pronoun{
    //
    public String word = "";
    public Enums.Gender gender = null;
    public Boolean plural = null;
    public int person = 0;
    //
    public Pronoun(String word, Enums.Gender gender, Boolean plural, int person) {
        this.word = word;
        this.gender = gender;
        this.plural = plural;
        this.person = person;
    }
}