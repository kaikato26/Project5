/**
 * 
 */
package prj5;

/**
 * @author anamk kaikato26 samhita7
 * @version 11/17/2019
 */
public class Person {

    private Hobby hobby;
    private Major major;
    private Region region;
    private String[] results;


    /**
     * Person class
     * 
     * @param hobby
     *            Person's hobby
     * @param major
     *            person's major
     * @param region
     *            Person's region
     * @param results
     *            Person's survey results
     */
    public Person(String hobby, String major, String region, String[] results) {

        this.results = results;
        this.hobby = stringToHobby(hobby);
        this.region = stringToRegion(region);
        this.major = stringToMajor(major);

    }


    /**
     * Returns the hobby
     * 
     * @return Hobby
     */
    public Hobby getHobby() {

        return this.hobby;

    }


    /**
     * Returns the major
     * 
     * @return Major
     */
    public Major getMajor() {

        return this.major;

    }


    /**
     * Returns the region
     * 
     * @return Region
     */
    public Region getRegion() {

        return this.region;

    }


    /**
     * Returns the results
     * 
     * @return String[]
     */
    public String[] getResults() {

        return this.results;

    }


    /**
     * Converts the string to a hobby
     * 
     * @param hobbyOfPerson
     * @return Hobby
     */
    private Hobby stringToHobby(String hobbyOfPerson) {

        switch (hobbyOfPerson) {
            case "art":
                return Hobby.ART;
            case "sports":
                return Hobby.SPORTS;
            case "music":
                return Hobby.MUSIC;
            case "reading":
                return Hobby.READ;
            default:
                return null;
        }

    }


    /**
     * Converts the string to a major
     * 
     * @param majorOfPerson
     * @return Major
     */
    private Major stringToMajor(String majorOfPerson) {

        switch (majorOfPerson) {
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


    /**
     * Converts the string a region
     * 
     * @param regionOfPerson
     * @return Region
     */
    private Region stringToRegion(String regionOfPerson) {

        switch (regionOfPerson) {
            case "southeast":
                return Region.SOUTHEAST_US;
            case "northeast":
                return Region.NORTHEAST_US;
            case "outside of united states":
                return Region.OUTSIDE_THE_US;
            case "united states (other than southeast or northwest)":
                return Region.THE_REST_OF_US;
            default:
                return null;
        }

    }


    /**
     * Checks if two persons are equal
     * 
     * @return boolean
     * @param obj
     *            Testing object
     */
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (this.getClass() == (obj.getClass())) {

            Person person = (Person)obj;

            return (this.getHobby() == (person.getHobby())) && (this
                .getMajor() == (person.getMajor())) && (this
                    .getRegion() == (person.getRegion())) && (this.getResults()
                        .equals(person.getResults()));
        }

        return false;

    }

}
