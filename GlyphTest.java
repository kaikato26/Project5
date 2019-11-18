/**
 * 
 */
package prj5;

import java.util.HashMap;

/**
 * 
 * @author Alex Namkung (anamkung)
 * @version 11/15/19
 * @author Kai Kato (kaikato26)
 * @version 11/15/19
 * @author Sam Hita (samhita7)
 * @version 11/15/19
 *
 */
public class GlyphTest extends student.TestCase {

    private String[] test1 = { "Yes", "No", "", "No" };
    private String[] test2 = { "No", "Yes", "Yes", "" };
    private String[] test3 = { "", "No", "Yes", "Yes" };
    private String[] test4 = { "Yes", "", "No", "No" };
    private Person test5;
    private Person test6;
    private Person test7;
    private Person test8;
    private Song song1;

    private Glyph glyph1;
    private Glyph glyph2;


    /**
     * sets up the glyphs to be tested
     */
    public void setUp() {

        test5 = new Person("art", "computer science", "southeast", test1);
        test6 = new Person("reading", "math or cmda", "northeast", test2);
        test7 = new Person("music", "other",
            "united states (other than southeast or northwest)", test3);
        test8 = new Person("sports", "other engineering",
            "outside of united states", test4);
        song1 = new Song("Kid Cudi", "Reborn", "Rap", 2018);
        Song song2 = new Song("J.Cole", "Middle Child", "HipHop", 2019);

        glyph1 = new Glyph(song1);
        glyph2 = new Glyph(song2);

    }


    /**
     * tests the add results method
     */
    public void testAddResult() {

        glyph1.addResult(test5, 0);
        glyph1.addResult(test6, 0);
        glyph1.addResult(test7, 0);
        glyph1.addResult(test8, 0);

        glyph1.addResult(test5, 1);
        glyph1.addResult(test6, 1);
        glyph1.addResult(test7, 1);
        glyph1.addResult(test8, 1);

        glyph2.addResult(test5, 2);
        glyph2.addResult(test6, 2);
        glyph2.addResult(test7, 2);
        glyph2.addResult(test8, 2);

        glyph2.addResult(test5, 3);
        glyph2.addResult(test6, 3);
        glyph2.addResult(test7, 3);
        glyph2.addResult(test8, 3);
        glyph2.addResult(test8, 1000);
        glyph2.getRatioByRegion();
        // System.out.println(glyph2);

        assertEquals(glyph2.getHobbyMap().get(Hobby.ART)[0], 1);

    }


    /**
     * tests the getSong method
     */
    public void testGetSong() {

        assertEquals(glyph1.getSong(), song1);

    }


    /**
     * tests the get hobby map method
     */
    public void testGetHobbyMap() {

        HashMap<Hobby, int[]> hobbyMap = new HashMap<Hobby, int[]>();
        hobbyMap.put(Hobby.ART, new int[4]);
        hobbyMap.put(Hobby.READ, new int[4]);
        hobbyMap.put(Hobby.SPORTS, new int[4]);
        hobbyMap.put(Hobby.MUSIC, new int[4]);

        Glyph test = new Glyph(song1);
        assertEquals(test.getHobbyMap().keySet(), hobbyMap.keySet());

    }


    /**
     * tests the get major map method
     */
    public void testGetMajorMap() {

        HashMap<Major, int[]> majorMap = new HashMap<Major, int[]>();
        majorMap.put(Major.COMPUTER_SCIENCE, new int[4]);
        majorMap.put(Major.MATH_OR_CMDA, new int[4]);
        majorMap.put(Major.OTHER, new int[4]);
        majorMap.put(Major.OTHER_ENGINEERING, new int[4]);

        Glyph test = new Glyph(song1);
        assertEquals(test.getMajorMap().keySet(), majorMap.keySet());

    }


    /**
     * tests the get region map method
     */
    public void testGetRegionMap() {

        HashMap<Region, int[]> regionMap = new HashMap<Region, int[]>();
        regionMap.put(Region.NORTHEAST_US, new int[4]);
        regionMap.put(Region.SOUTHEAST_US, new int[4]);
        regionMap.put(Region.OUTSIDE_THE_US, new int[4]);
        regionMap.put(Region.THE_REST_OF_US, new int[4]);

        Glyph test = new Glyph(song1);
        assertEquals(test.getRegionMap().keySet(), regionMap.keySet());

    }


    /**
     * tests the get ratio methods for hobby, major, and region
     */
    public void testGetRatio() {

        glyph1 = new Glyph(song1);
        Double[] hob = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
        assertEquals(glyph1.getRatioByHobby()[1], hob[1], 2);
        Double[] maj = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
        assertEquals(glyph1.getRatioByMajor()[1], maj[1], 2);
        Double[] reg = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
        assertEquals(glyph1.getRatioByRegion()[1], reg[1], 2);
    }


    /**
     * tests the to string method for the glyph
     */
    public void testToString() {

        glyph1 = new Glyph(song1);
        assertEquals(glyph1.toString(),
            "song title: Reborn\nsong artist: Kid Cudi\nsong genre: Rap\n"
                + "song year: 2018\nheard"
                + "\nreading:0 art:0 sports:0 music:0\nlikes\n"
                + "reading:0 art:0 sports:0 music:0\n");

    }

}
