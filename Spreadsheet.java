import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Spreadsheet {
    
    public static List<String> getPronouns() throws Exception {
        List<String> strList = new ArrayList<>();
        System.out.println("hello");
        String sheetId = "1mmHHsdA1KO5w34oGJ7ABZ3UsTe1n_4I6KMJBFKwToxQ";
        String urlString = "https://docs.google.com/spreadsheets/d/" + sheetId + "/export?format=csv";

        URL url = new URL(urlString);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))){
            String line;
            while ((line = in.readLine()) != null) {
                strList.add(line);
            }
        }

        return strList;

    }
}