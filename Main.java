import java.util.List;
import java.util.Scanner;

public final class Main{
   private static final Dictionary dictionary;

    static {
        try {
            dictionary = new Dictionary();
        } catch (Exception e) {
            // Handle the exception appropriately
            e.printStackTrace();
            // You might want to throw a RuntimeException if the dictionary fails to load
            throw new RuntimeException("Failed to initialize Dictionary", e);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
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
            } 
        }


       // for (int i = 0; i < Constants.pronounsListLength; i++) {
        //     System.out.println(
        //         dictionary.getPronounsList().get(i).word + " " +
        //         dictionary.getPronounsList().get(i).gender + " " +
        //         dictionary.getPronounsList().get(i).plural + " " +
        //         dictionary.getPronounsList().get(i).person);
        // }
    }
}
