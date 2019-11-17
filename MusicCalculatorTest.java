/**
 * 
 */
package project5;

import java.util.ArrayList;

/**
 * @author anamk
 *
 */
public class MusicCalculatorTest extends student.TestCase {
    
    private MusicCalculator test;
    private ArrayList<Person> persons;
    private ArrayList<Song> songs;
   
    private Person test5;
    private Person test6;
    private Person test7;
    private Person test8;
    private Song song1;
    private Song song2;
    private Song song3;
    private Song song4;
    
    public void setUp() {
        
        persons = new ArrayList<Person>();
        songs = new ArrayList<Song>();
        String[] test1 = { "Yes", "No", "", "No" };
        String[] test2 = { "No", "No", "Yes", "" };
        String[] test3 = { "", "No", "Yes", "Yes" };
        String[] test4 = { "Yes", "", "No", "No" };
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
        
        persons.add(test5);
        persons.add(test6);
        persons.add(test7);
        persons.add(test8);
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        
        
    }
    
    public void testSort() {
        test = new MusicCalculator(songs, persons);
        
        System.out.println(test.sortGlyphs("title").toString());
        
    }
    
    

}
