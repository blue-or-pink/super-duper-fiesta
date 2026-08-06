public class Enums {
//    // public enum Gender {
//         MALE,
//         FEMALE,
//         OTHER,
//         ALL_EQUAL,
//         FM_EQUAL,
//         FO_EQUAL,
//         MO_EQUAL,
//         FM_EQUAL_aO,
//         MO_EQUAL_aF,
//         FO_EQUAL_aM,
//         MOST_F,
//         MOST_M,
//         MOST_O
//     }
}

import java.util.Scanner;

import gov.nih.nlm.nls.lvg.Lib.Gender;
import wordtypes.Pronoun;



if (type == "pronoun") {
    Scanner scanner = new Scanner(System.in);
    if (x.engWord.equals("I") || x.engWord.equals("me")){
        Boolean valid = false;
        while (valid == false){
            System.out.println("Is the speaker");
            System.out.println("(a) female");
            System.out.println("(b) male");
            System.out.println("(c) other");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("a")){
                word = "tɪ";
                valid = true;
            } else if (answer.equalsIgnoreCase("b")){
                word = "dɪ";
                valid = true;
            } else if (answer.equalsIgnoreCase("c")){
                word = "sɪ";
                valid = true;
            } else {
                System.out.println("Error, please type either a, b, or c");
            }
        }
    } else if (x.engWord.equals("you")){
        Boolean valid = false;
        int person = 2;
        Boolean plural;
        while (valid == false){
            System.out.println("Is you refering to..");
            System.out.println("(a) one person");
            System.out.println("(b) multiple people");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("a")){
                plural = false;
                valid = true;
            } else if (answer.equalsIgnoreCase("b")){
                plural = true;
                valid = true;
            } else {
                System.out.println("Error, please type either a or b");
            }
        }
        valid = false;
        //gender
        while (valid == false){
            if (plural == false){
                System.out.println("What is their gender?");
                System.out.println("(a) female");
                System.out.println("(b) male");
                System.out.println("(c) other");
                Boolean validTwo = false;
                while (validTwo == false){
                    String answer = scanner.nextLine();
                    //work from here
                    if (answer.equalsIgnoreCase("a")){
                        word = "tɪs";
                        validTwo = true;
                    } else if (answer.equalsIgnoreCase("b")){
                        word = "dɪs";
                        validTwo = true;
                    } else if (answer.equalsIgnoreCase("c")){
                        word = "sɪs";
                        validTwo = true;
                    } else {
                        System.out.println("Error, please type either a, b, or c");
                    }
                }
            } else if (plural == true){
                System.out.println("Type one f and one m and one o for each person of that gender in the group described by you");
                System.out.println("Ex: ffmo");
                int numF = 0;
                int numM = 0;
                int numO = 0;
                String answer = scanner.nextLine();
                for (int i = 0; i<answer.length(); i++){
                    if (answer.charAt(i) == 'f'){
                        numF += 1;
                    } else if (answer.charAt(i) == 'm'){
                        numM += 1;
                    } else if (answer.charAt(i) == 'o'){
                        numO += 1;
                    }
                }
                if (numF == 0 && numO == 0){
                    word = "dʊup";
                } else if (numM == 0 && numO == 0){
                    word = "tʊup";
                } else if (numF == 0 && numM == 0){
                    word = "sʊup";
                } else if (numF == numM && numM == numO){
                    word = "tʊdʊs";
                } else if (numF == numM && numO == 0){
                    word = "tʊd";
                } else if (numF == numO && numM == 0){
                    word = "tʊs";
                } else if (numM == numO && numF == 0){
                    word = "dʊs";
                } else if (numF == numM && numO != numM && numO != 0){
                    word = "fʊmis";
                } else if (numM == numO && numF != numO && numF != 0){
                    word = "dʊsif";
                } else if (numF == numO && numO != numM && numM != 0){
                    word = "tʊsid";
                } else if (numF > numM && numF > numO){
                    word = "tʊhi";
                } else if (numM > numF && numM > numO){
                    word = "dʊhi";
                } else if (numO > numF && numO > numM){
                    word = "sʊhi";
                } else {
                    word = "ERROR";
                }
            } 
        }
    } else if (x.engWord.equals("she") || x.engWord.equals("her")){
        word = "tə";
    } else if (x.engWord.equals("he") || x.engWord.equals("him")) {
        word = "də";
    } else if (x.engWord.equals("they" || x.engWord.equals("them"))){
        System.out.println("Does they refer to..");
        System.out.println("(a) one person");
        System.out.println("(b) multiple people");
        String answer = scanner.nextLine();
        valid = false;
        while (valid = false){
            answer = scanner.nextLine();
            //singular
            if (answer.equalsIgnoreCase("a")){
                Boolean plural = false;
                valid = true;
                Boolean validTwo = false;
                System.out.println("What is their gender?");
                System.out.println("(a) female");
                System.out.println("(b) male");
                System.out.println("(c) other");
                while (validTwo = false){
                    answer = scanner.nextLine();
                    if (answer.equals("a")){
                        word = "tə";
                        validTwo = true;
                    } else if (answer.equals("b")){
                        word = "də";
                        validTwo = true;
                    } else if (answer.equals("c")){
                        word = "sə";
                        validTwo = true;
                    } else {
                        System.out.println("Error, please type either a, b, or c");
                    }
                }
            

            //plural
            } else if (answer.equalsIgnoreCase("b")){
                Boolean plural = true;
                Boolean valid = true;
                System.out.println("Type one f and one m and one o for each person of that gender in the group described by you");
                System.out.println("Ex: ffmo");
                int numF = 0;
                int numM = 0;
                int numO = 0;
                answer = scanner.nextLine();
                for (int i = 0; i<answer.length(); i++){
                    if (answer.charAt(i) == 'f'){
                        numF += 1;
                    } else if (answer.charAt(i) == 'm'){
                        numM += 1;
                    } else if (answer.charAt(i) == 'o'){
                        numO += 1;
                    }
                }
                if (numM == 0 && numO == 0){
                    word = "tɑ";
                } else if (numF == 0 && numO == 0){
                    word = "dɑ";
                } else if (numF == 0 && numM == 0){
                    word = "sɑ";
                } else if (numF == numM && numM == numO){
                    word = "tɑdas";
                } else if (numF == numM && numO == 0){
                    word = "tɑd";
                } else if (numF == numO && numM == 0){
                    word = "tɑs";
                } else if (numM == numO && numF == 0){
                    word = "dɑs";
                } else if (numF == numM && numO > 0){
                    word = "tɑdis";
                } else if (numM == numO && numF > 0){
                    word = "dɑsif";
                } else if (numF == numO && numM > 0){
                    word = "tɑsid";
                } else if (numF > numM && numF > numO){
                    word = "tɑhi";
                } else if (numM > numF && numM > numO){
                    word = "dɑhi";
                } else if (numO > numM && numO > numF){
                    word = "sɑhi";
                } else {
                    word = "ERROR";
                }
                
                //need add we



            } else {
                System.out.println("Error, please type either a or b");
            }
        }

        


    }

    // for (Pronoun x: dictionary.getPronounsList()) {
    //     if (x.engWord.equals(engWord)) {
    //         word = x.word;
    //     }
    // }
        str = str + word + " ";
}


    System.out.println("");







// NOTE: NOT FINISHED!!!
/*      Scanner scanner = new Scanner(System.in);
        System.out.println("What is the gender?");
        System.out.println("(a) all female");
        System.out.println("(b) all male");
        System.out.println("(c) all other");
        System.out.println("(d) equal number of all genders");
        System.out.println("(e) equal number of males and females");
        System.out.println("(f) equal number of females and other");
        System.out.println("(g) equal number of males and other");
        System.out.println("(h) the most numerous gender is female");
        System.out.println("(i) the most numerous gender is male");
        System.out.println("(j) the most numerous gender is other");
        String gender = scanner.nextLine();
        if (gender.equals("a")){
            gender = "f";
        } else if (gender.equals("b")){
            gender = "m";
        } else if (gender.equals("c")){
            gender = "o";
        } else if (gender.equals("d")){
            gender = "f=m=o";
        } else if (gender.equals("e")){
            gender = "f=m";
        } else if (gender.equals("f")){
            gender = "f=o";
        } else if (gender.equals("g")){
            gender = "m=o";
        } else if (gender.equals("h")){
            gender = "f>";
        } else if (gender.equals("i")){
            gender = "m>";
        } else if (gender.equals("j")){
            gender = "o>";
        }
        System.out.println("What is the person? (1, 2, 3)");
        int person = Integer.parseInt(scanner.nextLine());
        System.out.println("Is it plural? (yes/no)");
        String pluralString = scanner.nextLine();
        String plural = "";
        if (pluralString.equals("yes")){
            plural = "true";
        } else if (pluralString.equals("no")){
            plural = "false";
        }

        for (int i = 0; i<Constants.pronounsListLength; i++){
            if (gender.equals(dictionary.getPronounsList().get(i).gender) && person == dictionary.getPronounsList().get(i).person && plural.equals(dictionary.getPronounsList().get(i).plural)){
                System.out.println("The correct pronoun is " + dictionary.getPronounsList().get(i).word);
                System.out.println("It means " + dictionary.getPronounsList().get(i).engWord + " in English.");
            } 
        }






       // for (int i = 0; i < Constants.pronounsListLength; i++) {
        //     System.out.println(
        //         dictionary.getPronounsList().get(i).word + " " +
        //         dictionary.getPronounsList().get(i).gender + " " +
        //         dictionary.getPronounsList().get(i).plural + " " +
        //         dictionary.getPronounsList().get(i).person) + "" +
                   dictionary.getPronounsList().get(i).engWord;
        // } 
*/