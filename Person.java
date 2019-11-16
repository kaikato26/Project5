/**
 * 
 */
package project5;

/**
 * @author anamk
 *
 */
public class Person {

    private Hobby hobby;
    private Major major;
    private Region region;
    private String[] results;


    public Person(String hobby, String major, String region, String[] results) {

        this.results = results;
        this.hobby = stringToHobby(hobby);
        this.region = stringToRegion(region);
        this.major = stringToMajor(major);

    }


    public Hobby getHobby() {

        return this.hobby;

    }


    public Major getMajor() {

        return this.major;

    }


    public Region getRegion() {

        return this.region;

    }


    public String[] getResults() {

        return this.results;

    }


    private Hobby stringToHobby(String hobby) {

        switch (hobby) {
            case "art":
                return Hobby.ART;
            case "sports":
                return Hobby.SPORTS;
            case "music":
                return Hobby.MUSIC;
            case "read":
                return Hobby.READ;
            default:
                return null;
        }

    }


    private Major stringToMajor(String major) {

        switch (major) {
            case "computer science":
                return Major.COMPUTER_SCIENCE;
            case "math or cmda":
                return Major.MATH_OR_CMDA;
            case "other":
                return Major.OTHER;
            case "other engineering":
                return Major.OTHER_ENGINEERING;
            default:
                return null;
        }

    }


    private Region stringToRegion(String region) {

        switch (region) {
            case "southeast us":
                return Region.SOUTHEAST_US;
            case "northeast us":
                return Region.NORTHEAST_US;
            case "outside the us":
                return Region.OUTSIDE_THE_US;
            case "united states (other than southeast or northwest)":
                return Region.THE_REST_OF_US;
            default:
                return null;
        }

    }

}
