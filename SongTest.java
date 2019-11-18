/**
 * 
 */
package prj5;

/**
 * @author Alex Namkung (anamkung)
 * @version 11/15/19
 * @author Kai Kato (kaikato26)
 * @version 11/15/19
 * @author Sam Hita (samhita7)
 * @version 11/15/19
 *
 */
public class SongTest extends student.TestCase {

    private Song song1;
    private Song song2;


    /**
     * sets up the songs to be tested
     */
    public void setUp() {

        song1 = new Song("Kid Cudi", "Reborn", "Rap", 2018);
        song2 = new Song("J.Cole", "Middle Child", "HipHop", 2019);

    }


    /**
     * tests the get artist method
     */
    public void testGetArtist() {

        assertEquals(song1.getArtist(), "Kid Cudi");
        assertEquals(song2.getArtist(), "J.Cole");
    }


    /**
     * tests the gettitle method
     */
    public void testGetTitle() {

        assertEquals(song1.getTitle(), "Reborn");
        assertEquals(song2.getTitle(), "Middle Child");

    }


    /**
     * tests the get genre method
     */
    public void testGetGenre() {

        assertEquals(song1.getGenre(), "Rap");
        assertEquals(song2.getGenre(), "HipHop");

    }


    /**
     * tests the getdate method
     */
    public void testGetDate() {

        assertEquals(song1.getDate(), 2018);
        assertEquals(song2.getDate(), 2019);

    }


    /**
     * tests the tostring method
     */
    public void testToString() {

        assertEquals(song1.toString(),
            "song title: Reborn\nsong artist: Kid Cudi\n"
                + "song genre: Rap\nsong year: 2018");

    }


    /**
     * tests the equals method
     * checks for null, type and more
     */
    public void testEquals() {

        Song test20 = new Song("Kid Cudi", "Reborn", "Rap", 2018);
        Song song5 = new Song("Kid Cudi", "F", "Rap", 2018);
        Song song6 = new Song("F", "Reborn", "Rap", 2018);
        Song song7 = new Song("Kid Cudi", "Reborn", "F", 2018);
        Song song8 = new Song("Kid Cudi", "Reborn", "Rap", 1000);
        Person nullType = null;
        String stringType = "hello";
        assertFalse(song1.equals(nullType));
        assertTrue(song1.equals(song1));
        assertFalse(song1.equals(stringType));
        assertTrue(song1.equals(test20));
        assertFalse(song1.equals(song2));
        assertFalse(song1.equals(song5));
        assertFalse(song1.equals(song6));
        assertFalse(song1.equals(song7));
        assertFalse(song1.equals(song8));

    }

}
