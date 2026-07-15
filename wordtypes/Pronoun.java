import Enums.Gender;
public class Pronoun{
    //
    public String word = "";
    public Gender gender = null;
    public Boolean plural = null;
    public int person = 0;
    //
    public Pronoun(String word, Gender gender, Boolean plural, int person) {
        this.word = word;
        this.gender = gender;
        this.plural = plural;
        this.person = person;
    }
}