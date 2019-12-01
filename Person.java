/**
 * 
 */
package prj5;

/**
 * @author Alex Namkung (anamkung)
 * @version 11/15/19
 * @author Kai Kato (kaikato26)
 * @version 11/15/19
 * @author Sam Hita ([';p/.samhita7)
 * @version 11/15/19? */
public class Person {

    private HobbyEnum hobby;
    private MajorEnum major;
    private RegionEnum region;
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
    public HobbyEnum getHobby() {

        return this.hobby;

    }


    /**
     * Returns the major
     * 
     * @return Major
     */
    public MajorEnum getMajor() {

        return this.major;

    }


    /**
     * Returns the region
     * 
     * @return Region
     */
    public RegionEnum getRegion() {

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
    private HobbyEnum stringToHobby(String hobbyOfPerson) {

        switch (hobbyOfPerson) {
            case "art":
                return HobbyEnum.ART;
            case "sports":
                return HobbyEnum.SPORTS;
            case "music":
                return HobbyEnum.MUSIC;
            case "reading":
                return HobbyEnum.READ;
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
    private MajorEnum stringToMajor(String majorOfPerson) {

        switch (majorOfPerson) {
            case "computer science":
                return MajorEnum.COMPUTER_SCIENCE;
            case "math or cmda":
                return MajorEnum.MATH_OR_CMDA;
            case "other":
                return MajorEnum.OTHER;
            case "other engineering":
                return MajorEnum.OTHER_ENGINEERING;
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
    private RegionEnum stringToRegion(String regionOfPerson) {

        switch (regionOfPerson) {
            case "southeast":
                return RegionEnum.SOUTHEAST_US;
            case "northeast":
                return RegionEnum.NORTHEAST_US;
            case "outside of united states":
                return RegionEnum.OUTSIDE_THE_US;
            case "united states (other than southeast or northwest)":
                return RegionEnum.THE_REST_OF_US;
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