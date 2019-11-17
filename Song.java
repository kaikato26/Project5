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


    public Song(String artist, String title, String genre, int date) {

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
    
    public String toString()
    {
       StringBuilder str = new StringBuilder();
       str.append("Song Title: " + title);
       str.append("\nArtist: " + artist);
       str.append("\nGenre: " + genre);
       str.append("\nYear: " + date);
    
       return str.toString();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (this.getClass().equals(obj.getClass())) {

            Song other = (Song)obj;
            if (this.artist.equals(other.artist) && this.genre.equals(
                other.genre) && this.title.equals(other.title)
                && this.date == other.date) {

                return true;

            }

        }

        return false;

    }

}
