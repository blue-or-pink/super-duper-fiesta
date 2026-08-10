import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static  int pronounsListLength = 0;
    public static  int adjectivesListLength = 0;
    public static  int prepositionsListLength = 0;
    public static  int verbsListLength = 0;
    public static  int nounsListLength = 0;
    public static  int linkingsListLength = 0;

    //numbers
    public static String one = "ʊs";
    public static String two = "ɛm";
    public static String three = "ɔd";
    public static String four = "ni.sʊ";
    public static String five = "lik";
    public static String six = "bɔ.ŋɛf";
    public static String seven = "məg";
    public static String eight = "ək";
    public static String nine = "zu";
    public static String ten = "lət";
    public static String eleven = "əv";
    public static String twelve = "jɑz";

    public static final List<String> punctuationList = new ArrayList<>();// = {"?",".",",","!","(",")"};


    public Constants() {
        punctuationList.add("?");
        punctuationList.add(".");
        punctuationList.add(",");
        punctuationList.add("!");
        punctuationList.add("(");
        punctuationList.add(")");
        punctuationList.add(":");


        
    }
    // public static final int pronounsListLength = 49;
    // public static final int adjectivesListLength = 56;
    // public static final int prepositionsListLength = 71;
    // public static final int verbsListLength = 51;
    // public static final int nounsListLength = 377;
    // public static final int linkingsListLength = 10;
}
