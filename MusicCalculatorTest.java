/**
 * 
 */
package prj5;

import java.util.ArrayList;

/**
 * @author Alex Namkung (anamkung)
 * @version 11/15/19
 * @author Kai Kato (kaikato26)
 * @version 11/15/19
 * @author Sam Hita (samhita7)
 * @version 11/15/19
 */
public class MusicCalculatorTest extends student.TestCase {

    private MusicCalculator test;


    /**
     * sets up the music calculator to be tested
     */
    public void setUp() {

        ArrayList<Person> persons = new ArrayList<Person>();
        ArrayList<Song> songs = new ArrayList<Song>();
        String[] test1 = { "Yes", "No", "", "No" };
        String[] test2 = { "No", "No", "Yes", "" };
        String[] test3 = { "", "No", "Yes", "Yes" };
        String[] test4 = { "Yes", "", "No", "No" };
        Person test5 = new Person("art", "computer science", "southeast",
            test1);
        Person test6 = new Person("reading", "math or cmda", "northeast",
            test2);
        Person test7 = new Person("music", "other",
            "united states (other than southeast or northwest)", test3);
        Person test8 = new Person("sports", "other engineering",
            "outside of united states", test4);
        Song song1 = new Song("Kid Cudi", "Reborn", "Rap", 2018);
        Song song2 = new Song("J.Cole", "Middle Child", "HipHop", 2019);
        Song song3 = new Song("Juice WRLD", "All Girls Are The Same", "R&B",
            2017);
        Song song4 = new Song("Kanye West", "Heartless", "R&B", 2009);

        persons.add(test5);
        persons.add(test6);
        persons.add(test7);
        persons.add(test8);
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);

        test = new MusicCalculator(songs, persons);
    }


    /**
     * tests the sort method for the music calculator
     */
    public void testSort() {

        test.sortGlyphs("date");
        assertEquals(test.getGlyphList().get(0).getSong().getDate(), 2009);
        assertEquals(test.getGlyphList().get(1).getSong().getDate(), 2017);
        assertEquals(test.getGlyphList().get(2).getSong().getDate(), 2018);
        assertEquals(test.getGlyphList().get(3).getSong().getDate(), 2019);

        test.sortGlyphs("genre");
        assertEquals(test.getGlyphList().get(0).getSong().getGenre(), "HipHop");
        assertEquals(test.getGlyphList().get(1).getSong().getGenre(), "R&B");
        assertEquals(test.getGlyphList().get(2).getSong().getGenre(), "R&B");
        assertEquals(test.getGlyphList().get(3).getSong().getGenre(), "Rap");

        test.sortGlyphs("title");
        assertEquals(test.getGlyphList().get(0).getSong().getTitle(),
            "All Girls Are The Same");
        assertEquals(test.getGlyphList().get(1).getSong().getTitle(),
            "Heartless");
        assertEquals(test.getGlyphList().get(2).getSong().getTitle(),
            "Middle Child");
        assertEquals(test.getGlyphList().get(3).getSong().getTitle(), "Reborn");

        test.sortGlyphs("artist");
        assertEquals(test.getGlyphList().get(0).getSong().getArtist(),
            "J.Cole");
        assertEquals(test.getGlyphList().get(1).getSong().getArtist(),
            "Juice WRLD");
        assertEquals(test.getGlyphList().get(2).getSong().getArtist(),
            "Kanye West");
        assertEquals(test.getGlyphList().get(3).getSong().getArtist(),
            "Kid Cudi");

    }

}
