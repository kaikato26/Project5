/**
 * 
 */
package prj5;

/**
 * @author Alex Namkung (anamkung)
 * @version 11/15/19
 * @author Kai Kato (kaikato26)
 * @version 11/15/19
 * @author Sam
 * @version 11/15/19
 *
 */
public class Song {

    private String artist;
    private String title;
    private String genre;
    private int date;


    /**
     * the constructor for the song class
     * 
     * @param artist
     *            name
     * @param title
     *            song title
     * @param genre
     *            type of music
     * @param date
     *            year made
     */
    public Song(String artist, String title, String genre, int date) {

        this.artist = artist;
        this.title = title;
        this.genre = genre;
        this.date = date;

    }


    /**
     * returns the artist field
     * 
     * @return String artist
     */
    public String getArtist() {

        return this.artist;

    }


    /**
     * returns the title field
     * 
     * @return String title
     */
    public String getTitle() {

        return this.title;

    }


    /**
     * return the genre field
     * 
     * @return String genre
     */
    public String getGenre() {

        return this.genre;

    }


    /**
     * returns the date field
     * 
     * @return int date
     */
    public int getDate() {

        return this.date;

    }


    /**
     * returns a string representation of the song class
     * 
     * @return String toString
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("song title: " + title);
        str.append("\nsong artist: " + artist);
        str.append("\nsong genre: " + genre);
        str.append("\nsong year: " + date);

        return str.toString();
    }


    /**
     * returns true all fields of the 2 classes are the same
     * else return false
     * 
     * @return boolean T or F
     */
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
