/**
 * 
 */
package project5;

/**
 * @author anamk
 *
 */
public class PersonTest extends student.TestCase {

    private String[] test1 = { "Yes", "No", "Yes", "No" };
    private String[] test2 = { "No", "No", "Yes", "No" };
    private String[] test3 = { "", "No", "Yes", "Yes" };
    private String[] test4 = { "Yes", "", "", "No" };
    private Person test5;
    private Person test6;
    private Person test7;
    private Person test8;
    private Person test9;


    public void setUp() {
        
        test5 = new Person("art", "computer science", "southeast us", test1);
        test6 = new Person("read", "math or cmda", "northeast us", test2);
        test7 = new Person("music", "other",
            "united states (other than southeast or northwest)", test3);
        test8 = new Person("sports", "other engineering", "outside the us",
            test4);
        test9 = new Person("art", "computer science", "southeast us", test1);

    }


    public void testGetHobby() {

        assertEquals(test5.getHobby(), Hobby.ART);
        assertEquals(test6.getHobby(), Hobby.READ);
        assertEquals(test7.getHobby(), Hobby.MUSIC);
        assertEquals(test8.getHobby(), Hobby.SPORTS);

    }


    public void testGetMajor() {

        assertEquals(test5.getMajor(), Major.COMPUTER_SCIENCE);
        assertEquals(test6.getMajor(), Major.MATH_OR_CMDA);
        assertEquals(test7.getMajor(), Major.OTHER);
        assertEquals(test8.getMajor(), Major.OTHER_ENGINEERING);

    }


    public void testGetRegion() {

        assertEquals(test5.getRegion(), Region.SOUTHEAST_US);
        assertEquals(test6.getRegion(), Region.NORTHEAST_US);
        assertEquals(test7.getRegion(), Region.THE_REST_OF_US);
        assertEquals(test8.getRegion(), Region.OUTSIDE_THE_US);

    }


    public void testResults() {
        
        assertEquals(test5.getResults(), test1);
        assertEquals(test6.getResults(), test2);
        assertEquals(test7.getResults(), test3);
        assertEquals(test8.getResults(), test4);

    }
    
     public void testEquals() {
    
        Object obj = null;
        assertFalse(test5.equals(obj));

        obj = new Object();
        assertFalse(test5.equals(obj)); 

        assertTrue(test5.equals(test9));
        assertFalse(test5.equals(test6));
    }

}
