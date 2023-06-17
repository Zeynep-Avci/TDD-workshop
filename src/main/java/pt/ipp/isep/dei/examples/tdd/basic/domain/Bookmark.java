package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.net.URL;
import java.util.ArrayList;

public class Bookmark {
    
    private String URLString;
    //ArrayList<String> keywords stores the keywords
    private ArrayList<String> keywords;

    public int rating;

    public Bookmark(String url) throws IllegalArgumentException{
        try{
            new URL(url).toURI();
        }
        catch(Exception e){
            throw new IllegalArgumentException();
        }

        rating = 0;

        URLString = url;
        this.keywords = new ArrayList<String>();
    }

    public String getURL() {
        return URLString;
    }

    //add keyoword
    public void addKeyword(String keyword){

        if (checkIfKeywordLongerThan3Char(keyword)){
            keywords.add(keyword);
        }
    }

/*    //check if keyword already exists
    public boolean hasKeyword(String keyword){
        return keywords.contains(keyword);
    }
    }*/

    //retrieve all the keywords associated with the bookmark
    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public boolean checkIfKeywordLongerThan3Char(String keyword){

        if (keyword.length() > 3) {
            return true;
        } else {
            return false;
        }
    }

    public void removeKeyword(String keyword){
        keywords.remove(keyword);
    }

    public void increaseRating(){
        this.rating++;
    }

    @Override
    public boolean equals(Object object) {
    Bookmark anotherBookmark= (Bookmark) object;
    if(this.URLString.equals(anotherBookmark.URLString)) return true;
    return false;
    }
}
