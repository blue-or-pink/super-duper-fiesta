package src.main.java;
import java.util.ArrayList;
import java.util.List;

import src.main.java.wordtypes.*;

public class Dictionary {
    public static final List<Adjective> adjectives = new ArrayList<>();
    public static final List<Verb> verbs = new ArrayList<>();
    public static final List<Preposition> prepositions = new ArrayList<>();
    public static final List<Marker> markers = new ArrayList<>();
    public static final List<Pronoun> pronouns = new ArrayList<>();
    public static final List<Noun> nouns = new ArrayList<>();
    public static final List<Linking> linkings = new ArrayList<>();
    
    public Dictionary() throws Exception{
        List<String> pronounsStrings = Spreadsheet.getPronouns();
        List<String> adjectivesStrings = Spreadsheet.getAdjectives();
        List<String> verbsStrings = Spreadsheet.getVerbs();
        List<String> prepositionsStrings = Spreadsheet.getPrepositions();
        List<String> nounsStrings = Spreadsheet.getNouns();
        List<String> linkingsStrings = Spreadsheet.getLinking();
        // if there are a few more of these they should probably have their own spreadsheet,
        // but for now its ok
        // and overall maybe making the translator more versatile with these is better? but idk it fine
        markers.add(new Marker("past", "hə", "start"));
        markers.add(new Marker("future", "hə", "end"));
        markers.add(new Marker("conditional", "hi", "end"));
        markers.add(new Marker("adverb", "ræ", "end"));
        markers.add(new Marker("plural", "ji", "start"));

        for (int i = 0; i < Constants.pronounsListLength; i++){
            String word = "";
            String gender = null;
            String plural = "";
            int person = 0;
            String engWord = "";
            String curString = pronounsStrings.get(i);
            String curVar = "";
            int curVarNum = 1;

            for (int a = 0; a < curString.length(); a++){
                char curChar = curString.charAt(a); 
                if (!String.valueOf(curChar).equals(",")) { //it was == earlier which doesn't work for strings apparently, you need to do .equals
                    curVar = curVar + curChar;
                } else {
                    if (curVarNum == 1){
                        word = curVar;
                    } else if (curVarNum == 2){
                        gender = curVar;
                    } else if (curVarNum == 3){
                        if (curVar.equals("TRUE")){ //the issue here was the same, it was == instead of .equals so it was never true
                            plural = "true";
                        } else if (curVar.equals("FALSE")){
                            plural = "false";
                        }
                    } else if (curVarNum == 4){
                        person = Integer.parseInt(curVar);
                    } else if (curVarNum == 5){
                        engWord = curVar;
                    }
                    curVarNum +=1;
                    curVar = ""; //it never reset curVar earlier so it wasn't actually separating the values
                }      
            }
            pronouns.add(new Pronoun(word, gender, plural, person, engWord));
        }

        //prepositions, verbs
        for (int i = 0; i < Constants.adjectivesListLength; i++){
            String engWord = "";
            String word = "";
            String curString = adjectivesStrings.get(i);
            String curVar = "";
            int curVarNum = 1;

            for (int a = 0; a < curString.length(); a++){
                char curChar = curString.charAt(a); 
                if (!String.valueOf(curChar).equals(",")) {
                    curVar = curVar + curChar;
                } else {
                    if (curVarNum == 1){
                        engWord = curVar;
                    } else if (curVarNum == 2){
                        word = curVar;
                    }
                    curVarNum +=1;
                    curVar = "";
                }      
            }
            adjectives.add(new Adjective(engWord, word));
        }

        for (int i = 0; i < Constants.linkingsListLength; i++){
            String engWord = "";
            String word = "";
            String curString = linkingsStrings.get(i);
            String curVar = "";
            int curVarNum = 1;

            for (int a = 0; a < curString.length(); a++){
                char curChar = curString.charAt(a); 
                if (!String.valueOf(curChar).equals(",")) {
                    curVar = curVar + curChar;
                } else {
                    if (curVarNum == 1){
                        engWord = curVar;
                    } else if (curVarNum == 2){
                        word = curVar;
                    }
                    curVarNum +=1;
                    curVar = "";
                }      
            }
            linkings.add(new Linking(engWord, word));
            //System.out.println(engWord);
        }

        for (int i = 0; i < Constants.prepositionsListLength; i++){
            String engWord = "";
            String word = "";
            String curString = prepositionsStrings.get(i);
            String curVar = "";
            int curVarNum = 1;

            for (int a = 0; a < curString.length(); a++){
                char curChar = curString.charAt(a); 
                if (!String.valueOf(curChar).equals(",")) {
                    curVar = curVar + curChar;
                } else {
                    if (curVarNum == 1){
                        engWord = curVar;
                    } else if (curVarNum == 2){
                        word = curVar;
                    }
                    curVarNum +=1;
                    curVar = "";
                }      
            }
            prepositions.add(new Preposition(engWord, word));
        }

        for (int i = 0; i < Constants.verbsListLength; i++){
            String engWord = "";
            String word = "";
            String curString = verbsStrings.get(i);
            String curVar = "";
            int curVarNum = 1;

            for (int a = 0; a < curString.length(); a++){
                char curChar = curString.charAt(a); 
                if (!String.valueOf(curChar).equals(",")) {
                    curVar = curVar + curChar;
                } else {
                    if (curVarNum == 1){
                        engWord = curVar;
                    } else if (curVarNum == 2){
                        word = curVar;
                    }
                    curVarNum +=1;
                    curVar = "";
                }      
            }
            verbs.add(new Verb(engWord, word));
        }

        for (int i = 0; i < Constants.nounsListLength; i++){
            String engWord = "";
            String word = "";
            String curString = nounsStrings.get(i);
            String curVar = "";
            int curVarNum = 1;

            for (int a = 0; a < curString.length(); a++){
                char curChar = curString.charAt(a); 
                if (!String.valueOf(curChar).equals(",")) {
                    curVar = curVar + curChar;
                } else {
                    if (curVarNum == 1){
                        engWord = curVar;
                    } else if (curVarNum == 2){
                        word = curVar;
                    }
                    curVarNum +=1;
                    curVar = "";
                }      
            }
            nouns.add(new Noun(engWord, word));
        }
    }



    public List<Pronoun> getPronounsList() {
        return pronouns;
    }

    public List<Adjective> getAdjectivesList(){
        return adjectives;
    }

    public List<Verb> getVerbsList(){
        return verbs;
    }

    public List<Preposition> getPrepositionsList(){
        return prepositions;
    }

    public List<Marker> getMarkersList(){
        return markers;
    }

    public List<Noun> getNounsList(){
        return nouns;
    }

    public List<Linking> getLinkingsList(){
        return linkings;
    }
}