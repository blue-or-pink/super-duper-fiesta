package src.main.java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Spreadsheet {

    public static List<String> getPronouns() throws Exception {
        List<String> strList = new ArrayList<>();
        String sheetId = "1mmHHsdA1KO5w34oGJ7ABZ3UsTe1n_4I6KMJBFKwToxQ";
        String urlString = "https://docs.google.com/spreadsheets/d/" + sheetId + "/export?format=csv";

        URL url = new URL(urlString);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))){
            String line;
            while ((line = in.readLine()) != null) {
                strList.add(line + ",");
            }
        }

        return strList;

    }
    public static List<String> getAdjectives() throws Exception {
        List<String> strList = new ArrayList<>();
        String sheetId = "17x8fLCwjP3jJRFHtoQnI2Z7stnwMtNKWdryqhqvSxSI";
        String urlString = "https://docs.google.com/spreadsheets/d/" + sheetId + "/export?format=csv";

        URL url = new URL(urlString);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))){
            String line;
            while ((line = in.readLine()) != null) {
                strList.add(line + ",");
            }
        }

        return strList;

    }
    public static List<String> getLinking() throws Exception {
        List<String> strList = new ArrayList<>();
        String sheetId = "1XbgSABu94Khz-NsHtKTDcnP0t5dJ1DKLxVk0MlrMSuE";
        String urlString = "https://docs.google.com/spreadsheets/d/" + sheetId + "/export?format=csv";

        URL url = new URL(urlString);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))){
            String line;
            while ((line = in.readLine()) != null) {
                strList.add(line + ",");
                
            }
        }

        return strList;

    }
    public static List<String> getPrepositions() throws Exception {
        List<String> strList = new ArrayList<>();
        String sheetId = "1IiD5X5MO1dluMwtVciErDDFuJW0axhhC73Zi1KYMZi0";
        String urlString = "https://docs.google.com/spreadsheets/d/" + sheetId + "/export?format=csv";

        URL url = new URL(urlString);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))){
            String line;
            while ((line = in.readLine()) != null) {
                strList.add(line + ",");
            }
        }

        return strList;

        
    }
    public static List<String> getNouns() throws Exception {
        List<String> strList = new ArrayList<>();
        String sheetId = "1cNTBin8Fqo-A71xKde4KHMMU1lDNOOpPWSj6O-lK8Bw";
        String urlString = "https://docs.google.com/spreadsheets/d/" + sheetId + "/export?format=csv";

        URL url = new URL(urlString);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))){
            String line;
            while ((line = in.readLine()) != null) {
                strList.add(line + ",");
            }
        }

        return strList;

    }
    public static List<String> getVerbs() throws Exception {
        List<String> strList = new ArrayList<>();
        String sheetId = "1UCxWUYNICjtcbTz7q9NG-uDWelHvdhtHY61hybTaNBs";
        String urlString = "https://docs.google.com/spreadsheets/d/" + sheetId + "/export?format=csv";

        URL url = new URL(urlString);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))){
            String line;
            while ((line = in.readLine()) != null) {
                strList.add(line + ",");
            }
        }

        return strList;

    }
}