package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.*;

public class BookmarkList {

    public ArrayList<Bookmark> _bookmarklist;
    private Bookmark bookmark;

    public BookmarkList(){
        _bookmarklist = new ArrayList<Bookmark>();
    }

    public BookmarkList(ArrayList<Bookmark> bookmarks){
        _bookmarklist = new ArrayList<Bookmark>();
        for (Bookmark bookmark : bookmarks) {
            _bookmarklist.add(bookmark);
        }
    }

    public void addBookMark(Bookmark bm){
        if(!_bookmarklist.contains(bm)) _bookmarklist.add(bm);
        for (Bookmark bookmark : _bookmarklist) {
            if(bookmark.equals(bm)) bookmark.increaseRating();
        }
    }

    @Override
    public boolean equals(Object object) {
        BookmarkList anotherBookmarkList= (BookmarkList) object;
        if(Arrays.equals(this._bookmarklist.toArray(),anotherBookmarkList._bookmarklist.toArray())) return true;
        return false;
    }

    public int countSecureUrls() {
        return (int) _bookmarklist.stream().filter(bookmark -> bookmark.getURL().substring(0, 5).contains("https")).count();
    }

    /*
    public List<Bookmark> sortBookmarksByRating() {
        List<Bookmark> sortedBookmarks = new ArrayList<>(_bookmarklist);
        sortedBookmarks.sort(Comparator.comparing(Bookmark::getRating).reversed());
        return sortedBookmarks;
    }

     */
}
