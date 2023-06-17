package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

public class BookmarkTest {


    @Test
    public void ensureURLIsSet(){

        // Arrange
        String expectedResult = "https://www.google.com/";
        String result = "a";
        //Act
        result = new Bookmark("https://www.google.com/").getURL() ;

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void onlyAllowValidURL(){
        
        // Arrange
        String invalidURL = "asdasdaljdas";

        //Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,() -> {new Bookmark(invalidURL);});
    }

    @Test
    public void createBookmarkList(){

        // Arrange
        ArrayList<Bookmark> expectedResult = new BookmarkList()._bookmarklist;
        ArrayList<Bookmark> result = null;

        // Act
        result = new BookmarkList()._bookmarklist;

        // Assert
        assertEquals(expectedResult,result);
    }

    @Test
    public void addBookmarkToList(){

        //Arrange
        ArrayList<Bookmark> expectedResultList = new ArrayList<Bookmark>();
        expectedResultList.add(new Bookmark("https://www.youtube.com"));
        BookmarkList expectedResult = new BookmarkList(expectedResultList);
        
        BookmarkList bookmarkList = new BookmarkList();
        
        //Act
        bookmarkList.addBookMark(new Bookmark("https://www.youtube.com"));
        //result = bookmarkList._bookmarklist;

        //Assert
        assertEquals(expectedResult,bookmarkList);

    }

    @Test
    public void assertEqualsReturnsFalseOnDifferentLists(){

        //Arrange
        boolean expectedResult = false;
        boolean result = true;

        
        BookmarkList bookmarkList = new BookmarkList();
        BookmarkList bookmarkList2 = new BookmarkList();
        bookmarkList.addBookMark(new Bookmark("https://www.youtube.com"));
        bookmarkList2.addBookMark(new Bookmark("https://www.google.com"));
        
        //Act
        result = bookmarkList.equals(bookmarkList2);

        //result = bookmarkList._bookmarklist;

        //Assert
        assertEquals(expectedResult,result);

    }

    @Test
    public void assertBookmarkEqualsFalseOnDifferentURLs(){
        
        //Arrange
        boolean expectedResult = false;
        boolean result = true;

        Bookmark bookmark1 = new Bookmark("https://www.youtube.com");
        Bookmark bookmark2 = new Bookmark("https://www.google.com");

        //Act
        result = bookmark1.equals(bookmark2);


        //Assert
        assertEquals(expectedResult,result);
    }

    @Test
    public void assertRatingIncreases(){
        
        //Arrange
        int expectedResult = 1;
        int result = 0;

        Bookmark bookmark = new Bookmark("https://www.youtube.com");
        
        //Act
        bookmark.increaseRating();
        result = bookmark.rating;

        //Assert
        assertEquals(expectedResult,result);
    }

    @Test
    public void assertNoDuplicateIsAddedToBookMarkList(){
        
        //Arrange
        int expectedResult = 1;
        int result = 0;

        ArrayList<Bookmark> bookmarkArray = new ArrayList<Bookmark>();
        bookmarkArray.add(new Bookmark("https://www.youtube.com"));
        BookmarkList bookmarkList = new BookmarkList(bookmarkArray);
        
        //Act
        bookmarkList.addBookMark(new Bookmark("https://www.youtube.com"));
        result = bookmarkList._bookmarklist.size();

        //Assert
        assertEquals(expectedResult,result);
    }

    @Test
    public void assertRatingOfDuplicateInListIncreases(){
        //Arrange
        int expectedResult = 1;
        int result = 0;
        ArrayList<Bookmark> bookmarkArray = new ArrayList<Bookmark>();
        bookmarkArray.add(new Bookmark("https://www.youtube.com"));
        BookmarkList bookmarkList = new BookmarkList(bookmarkArray);
        
        //Act
        bookmarkList.addBookMark(new Bookmark("https://www.youtube.com"));
        Bookmark bm = bookmarkList._bookmarklist.get(0);
        result = bm.rating;

        //Assert
        assertEquals(expectedResult,result);

    }

    @Test
    public void assertNonDuplicateIsAdded(){
        //Arrange
        int expectedResult = 2;
        int result = 0;
        ArrayList<Bookmark> bookmarkArray = new ArrayList<Bookmark>();
        bookmarkArray.add(new Bookmark("https://www.youtube.com"));
        BookmarkList bookmarkList = new BookmarkList(bookmarkArray);
        
        //Act
        bookmarkList.addBookMark(new Bookmark("https://www.goole.com"));
        result = bookmarkList._bookmarklist.size();

        //Assert
        assertEquals(expectedResult,result);
    }
/*    @Test
    public void ensureValidURL() throws MalformedURLException {

        String validURL = new Bookmark("https://www.youtube.at/").getURL();
        Boolean expectedResult = true;
        boolean result;
        try {
            new URL(validURL).toURI();
            result = true;
        }

        // If there was an Exception
        // while creating URL object
        catch (Exception e) {
            result = false;
        }

        assertEquals(expectedResult, result);

    }*/

    @Test
    public void keywordShorterThan3Char(){
        boolean expectedResult = false;
        //Act
        boolean result = new Bookmark("https://www.google.com/").checkIfKeywordLongerThan3Char("a");

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void keywordEqualTo3Char(){
        boolean expectedResult = false;
        //Act
        boolean result = new Bookmark("https://www.google.com/").checkIfKeywordLongerThan3Char("a2-");

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void keywordLongerThan3Char(){
        boolean expectedResult = true;
        //Act
        boolean result = new Bookmark("https://www.google.com/").checkIfKeywordLongerThan3Char("2-po7d");

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void keywordIsEmpty(){
        boolean expectedResult = false;
        //Act
        boolean result = new Bookmark("https://www.google.com/").checkIfKeywordLongerThan3Char("");

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void removeWantedKeywordFromBookmark(){
        boolean expectedResult = false;
        Bookmark bookmark = new Bookmark("https://www.google.com/");
        bookmark.addKeyword("tag1");
        bookmark.addKeyword("tag2");

        bookmark.removeKeyword("tag1");
        boolean result = bookmark.getKeywords().contains("tag1");
        assertEquals(expectedResult, result);
    }

    public void removeUnwantedKeywordFromBookmark(){
        boolean expectedResult = true;
        Bookmark bookmark = new Bookmark("https://www.google.com/");
        bookmark.addKeyword("tag1");

        bookmark.removeKeyword("tag2");
        boolean result = bookmark.getKeywords().contains("tag1");
        assertEquals(expectedResult, result);
    }

    public void removeNotExistingKeywordFromBookmark(){
        boolean expectedResult = false;
        Bookmark bookmark = new Bookmark("https://www.google.com/");
        bookmark.addKeyword("tag1");

        bookmark.removeKeyword("tag2");
        boolean result = bookmark.getKeywords().contains("tag2");
        assertEquals(expectedResult, result);
    }

    public void removeMultipleIdenticalKeywords(){
        boolean expectedResult = false;
        Bookmark bookmark = new Bookmark("https://www.google.com/");
        bookmark.addKeyword("tag1");
        bookmark.addKeyword("tag2");
        bookmark.addKeyword("tag1");
        bookmark.addKeyword("tag1");
        bookmark.addKeyword("tag3");

        bookmark.removeKeyword("tag1");
        boolean result = bookmark.getKeywords().contains("tag1");
        assertEquals(expectedResult, result);
    }


    @Test
    public void detectHowManySecureUrlsAreStored() {//Arrange
        BookmarkList list = new BookmarkList();
        int expected = 2;

        //Act
        list.addBookMark(new Bookmark("https://www.youtube.com"));
        list.addBookMark(new Bookmark("https://www.a1.net"));
        list.addBookMark(new Bookmark("http://www.a1.net"));
        list.addBookMark(new Bookmark("http://www.a1.net"));
        int result = list.countSecureUrls();

        //Assert
        assertEquals(expected, result);
    }

    /*
    @Test
    public void ensureBookmarkWithHighestRatingIsAtIndexZero() {
        // Arrange
        BookmarkList list = new BookmarkList();
        list.addBookMark(new Bookmark("https://www.fh-campuswien.ac.at/"));
        list.addBookMark(new Bookmark("https://www.orf.at/"));
        list.addBookMark(new Bookmark("https://www.google.com/"));
        list.addBookMark(new Bookmark("https://www.fh-campuswien.ac.at/"));
        list.addBookMark(new Bookmark("https://www.fh-campuswien.ac.at/"));
        list.addBookMark(new Bookmark("https://www.orf.at/"));

        //Act
        List<Bookmark> sortedBookmarks = list.sortBookmarksByRating();
        String firstPlaceUrl = sortedBookmarks.get(0).getURL();
        String secondPlaceUrl = sortedBookmarks.get(1).getURL();
        String thirdPlaceUrl = sortedBookmarks.get(2).getURL();

        //Assert
        assertEquals(firstPlaceUrl, "https://www.fh-campuswien.ac.at/");
        assertEquals(secondPlaceUrl, "https://www.orf.at/");
        assertEquals(thirdPlaceUrl, "https://www.google.com/");
    }

     */

}
