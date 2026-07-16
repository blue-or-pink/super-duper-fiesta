
public class Pronoun{
    //
    public String word = "";
    public String engWord = "";
    public String gender = "";
    public String plural = "";
    public int person = 0;
    //
    public Pronoun(String word, String engWord, String gender, String plural, int person) {
        this.word = word;
        this.engWord = engWord;
        this.gender = gender;
        this.plural = plural;
        this.person = person;
    }
}