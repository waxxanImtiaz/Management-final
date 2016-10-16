/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

public class LibraryBooks {

    private int id;
    private String bookName;
    private String author;
    private String state;

    /**
     * @return the bookId
     */
    public int getId() {
        return id;
    }

    /**
     * @param bookId the bookId to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the bookName
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * @param bookName the bookName to set
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * @return the bookAuthor
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param bookAuthor the bookAuthor to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

}
