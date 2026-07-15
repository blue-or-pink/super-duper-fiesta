import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Spreadsheet {
    public static void main(String[] args) throws Exception {
        System.out.println("hello");
        String sheetId = "1mmHHsdA1KO5w34oGJ7ABZ3UsTe1n_4I6KMJBFKwToxQ";
        String urlString = "https://docs.google.com/spreadsheets/d/" + sheetId + "/export?format=csv";

        URL url = new URL(urlString);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))){
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}