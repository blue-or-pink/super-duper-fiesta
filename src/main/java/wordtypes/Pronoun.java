package src.main.java.wordtypes;

public class Pronoun{
    //
    public String word = "";
    public String engWord = "";
    public String gender = "";
    public String plural = "";
    public int person = 0;
    //
    public Pronoun(String word, String gender, String plural, int person, String engWord) {
        this.word = word;
        this.engWord = engWord;
        this.gender = gender;
        this.plural = plural;
        this.person = person;
    }
}