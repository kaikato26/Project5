/**
 * 
 */
package prj5;

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

        test5 = new Person("art", "computer science", "southeast", test1);
        test6 = new Person("reading", "math or cmda", "northeast", test2);
        test7 = new Person("music", "other",
            "united states (other than southeast or northwest)", test3);
        test8 = new Person("sports", "other engineering",
            "outside of united states", test4);
        test9 = new Person("", "", "", test1);

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
        Person test20 = new Person("art", "computer science", "southeast",
            test1);
        Person diffHobby = new Person("", "computer science", "southeast",
            test1);

        Person diffMajor = new Person("art", "", "southeast", test1);
        Person diffRegion = new Person("art", "computer science", "", test1);
        Person diffResponse = new Person("art", "computer science", "southeast",
            test2);

        assertFalse(test5.equals(diffHobby));
        assertFalse(test5.equals(diffMajor));
        assertFalse(test5.equals(diffRegion));
        assertFalse(test5.equals(diffResponse));

        Person nullType = null;
        String stringType = "hello";
        assertFalse(test5.equals(nullType));
        assertTrue(test5.equals(test5));
        assertFalse(test5.equals(stringType));
        assertTrue(test5.equals(test20));
        assertFalse(test5.equals(test6));

        Object obj = null;
        assertFalse(test5.equals(obj));

        obj = new Object();
        assertFalse(test5.equals(obj));

        assertFalse(test5.equals(test9));
        assertFalse(test5.equals(test6));

    }

}
