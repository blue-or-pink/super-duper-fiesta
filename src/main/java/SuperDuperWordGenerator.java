import java.util.Random;
//

public class SuperDuperWordGenerator {
    private static final String[] consonants = {
        "p",
        "b",
        "t",
        "d",
        "k",
        "g",
        "m",
        "n",
        "ŋ",
        "f",
        "v",
        "s",
        "z",
        "ʃ",
        "h",
        "ɹ",
        "j",
        "l",
        "ʒ"
    };

    private static final String[] vowels = {
        "i",
        "u",
        "ɪ",
        "ʊ",
        "ə",
        "ɛ",
        "ɔ",
        "æ",
        "ɑ"
    };

    private static final String[] syllableStructures = {
        "cv",
        "cvc",
        "vc"
    };
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        //num words to generate
        for (int i = 0; i < 12; i++) { 
            String word = "/";
            //max num syllables
            int syllables = rand.nextInt(3);
            if (syllables == 0) {
                syllables = 1;
            }
            for (int a = 0; a < syllables; a++) {
                String structure = syllableStructures[rand.nextInt(3)];
                for (int b = 0; b < structure.length(); b++) {
                    if (String.valueOf(structure.charAt(b)).equals("c")) {
                        word = word + consonants[rand.nextInt(consonants.length)];
                    }
                    else if (String.valueOf(structure.charAt(b)).equals("v")) {
                        word = word + vowels[rand.nextInt(vowels.length)];
                    }
                }
                if (a != syllables - 1) {
                    word = word + ".";
                }
                else {
                    word = word + "/";
                }
            }
            System.out.println(word);
        }
    }
}
