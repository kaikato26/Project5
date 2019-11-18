/**
 * 
 */
package prj5;

/**
 * @author anamk
 *
 */
public class GlyphTest extends student.TestCase {

    private String[] test1 = { "Yes", "No", "", "No" };
    private String[] test2 = { "No", "No", "Yes", "" };
    private String[] test3 = { "", "No", "Yes", "Yes" };
    private String[] test4 = { "Yes", "", "No", "No" };
    private Person test5;
    private Person test6;
    private Person test7;
    private Person test8;
    private Song song1;
    private Song song2;
    
    private Glyph glyph1;
    private Glyph glyph2;
    


    public void setUp() {

        test5 = new Person("art", "computer science", "southeast", test1);
        test6 = new Person("reading", "math or cmda", "northeast", test2);
        test7 = new Person("music", "other",
            "united states (other than southeast or northwest)", test3);
        test8 = new Person("sports", "other engineering", "outside of united states",
            test4);
        song1 = new Song("Kid Cudi", "Reborn", "Rap", 2018);
        song2 = new Song("J.Cole", "Middle Child", "HipHop", 2019);
        
        glyph1 = new Glyph(song1);
        glyph2 = new Glyph(song2);
        

    }


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
        

        // System.out.println(glyph2);

        assertEquals(glyph2.getHobbyMap().get(Hobby.ART)[0], 1);

    }


    public void testGetSong() {

        assertEquals(glyph1.getSong(), song1);

    }

}
