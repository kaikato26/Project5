/**
 * 
 */
package project5;

/**
 * @author anamk
 *
 */
public class Song {

    private String artist;
    private String title;
    private String genre;
    private int date;
    
    public Song(String artist,String title,String genre,int date) {
        
        this.artist = artist;
        this.title = title;
        this.genre = genre;
        this.date = date;
        
    }
    
    public String getArtist() {
        
        return this.artist;
        
    }
    
    public String getTitle() {
        
        return this.title;
        
    }
    
    public String getGenre() {
        
        return this.genre;
        
    }
    
    public int getDate() {
        
        return this.date;
        
    }
    
}
