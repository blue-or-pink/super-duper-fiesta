import Enums.Gender;

public class WordTypes {
    public class Noun() {

    }
    public class Adjective() {

    }
    public class Verb() {

    }

    public class Pronoun(
        String word, Gender gender, Boolean plural, int person) {
        this.word = word;
        this.gender = gender;
        this.plural = plural;
        this.person = person;
    }
}