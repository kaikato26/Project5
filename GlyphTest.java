/**
 * 
 */
package project5;

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
    private Song song3;
    private Song song4;
    private Glyph glyph1;
    private Glyph glyph2;
    private Glyph glyph3;
    private Glyph glyph4;


    public void setUp() {
        
        test5 = new Person("art", "computer science", "southeast us", test1);
        test6 = new Person("read", "math or cmda", "northeast us", test2);
        test7 = new Person("music", "other",
            "united states (other than southeast or northwest)", test3);
        test8 = new Person("sports", "other engineering", "outside the us",
            test4);
        song1 = new Song("Kid Cudi", "Reborn", "Rap", 2018);
        song2 = new Song("J.Cole", "Middle Child", "HipHop", 2019);
        song3 = new Song("Juice WRLD", "All Girls Are The Same", "R&B", 2017);
        song4 = new Song("Kanye West", "Heartless", "R&B", 2009);
        glyph1 = new Glyph(song1);
        glyph2 = new Glyph(song2);
        glyph3 = new Glyph(song3);
        glyph4 = new Glyph(song4);
        
    }
    
    public void testAddResult() {
        
        
            
            glyph1.addResult(test5, 0);
            glyph1.addResult(test6, 0);
            glyph1.addResult(test7, 0);
            glyph1.addResult(test8, 0);
            
            glyph2.addResult(test5, 1);
            glyph2.addResult(test6, 1);
            glyph2.addResult(test7, 1);
            glyph2.addResult(test8, 1);
            
            glyph3.addResult(test5, 2);
            glyph3.addResult(test6, 2);
            glyph3.addResult(test7, 2);
            glyph3.addResult(test8, 2);
            
            glyph4.addResult(test5, 3);
            glyph4.addResult(test6, 3);
            glyph4.addResult(test7, 3);
            glyph4.addResult(test8, 3);
            
            
            
            
            
            System.out.println(glyph1);
            System.out.println(glyph2);
            System.out.println(glyph3);
            System.out.println(glyph4);
        
    }
    
}
