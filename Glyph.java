/**
 * 
 */
package prj5;

import java.util.HashMap;

/**
 * @author Alex Namkung (anamkung)
 * @version 11/15/19
 * @author Kai Kato (kaikato26)
 * @version 11/15/19
 * @author Sam Hita (samhita7)
 * @version 11/15/19
 */
public class Glyph {

    private Song song;
    private HashMap<HobbyEnum, int[]> hobbyMap;
    private HashMap<MajorEnum, int[]> majorMap;
    private HashMap<RegionEnum, int[]> regionMap;


    /**
     * constructor for the glyph class
     * creates hashmaps for hobby major and region
     * 
     * @param song
     *            for the glyph
     */
    public Glyph(Song song) {

        this.song = song;
        hobbyMap = new HashMap<HobbyEnum, int[]>();
        majorMap = new HashMap<MajorEnum, int[]>();
        regionMap = new HashMap<RegionEnum, int[]>();
        hobbyMap.put(HobbyEnum.ART, new int[4]);
        hobbyMap.put(HobbyEnum.READ, new int[4]);
        hobbyMap.put(HobbyEnum.SPORTS, new int[4]);
        hobbyMap.put(HobbyEnum.MUSIC, new int[4]);
        majorMap.put(MajorEnum.COMPUTER_SCIENCE, new int[4]);
        majorMap.put(MajorEnum.MATH_OR_CMDA, new int[4]);
        majorMap.put(MajorEnum.OTHER, new int[4]);
        majorMap.put(MajorEnum.OTHER_ENGINEERING, new int[4]);
        regionMap.put(RegionEnum.NORTHEAST_US, new int[4]);
        regionMap.put(RegionEnum.SOUTHEAST_US, new int[4]);
        regionMap.put(RegionEnum.OUTSIDE_THE_US, new int[4]);
        regionMap.put(RegionEnum.THE_REST_OF_US, new int[4]);

    }


    /**
     * adds the result of the person on to a value in the hash map
     * 
     * @param person
     *            whos results are to be added
     * @param songNum
     *            the number of response
     */
    public void addResult(Person person, int songNum) {

        if (songNum >= person.getResults().length) {
            return;
        }

        String response = person.getResults()[songNum];

        if (songNum % 2 == 1) {

            switch (response) {

                case "Yes":
                    int[] hobbyTempYes = this.hobbyMap.get(person.getHobby());
                    hobbyTempYes[1] += 1;
                    int[] majorTempYes = this.majorMap.get(person.getMajor());
                    majorTempYes[1] += 1;
                    int[] regionTempYes = this.regionMap.get(person
                        .getRegion());
                    regionTempYes[1] += 1;
                    hobbyMap.replace(person.getHobby(), hobbyTempYes);
                    majorMap.replace(person.getMajor(), majorTempYes);
                    regionMap.replace(person.getRegion(), regionTempYes);
                    break;
                case "No":
                    int[] hobbyTempNo = this.hobbyMap.get(person.getHobby());
                    hobbyTempNo[0] += 1;
                    int[] majorTempNo = this.majorMap.get(person.getMajor());
                    majorTempNo[0] += 1;
                    int[] regionTempNo = this.regionMap.get(person.getRegion());
                    regionTempNo[0] += 1;
                    hobbyMap.replace(person.getHobby(), hobbyTempNo);
                    majorMap.replace(person.getMajor(), majorTempNo);
                    regionMap.replace(person.getRegion(), regionTempNo);
                    break;
                default:
                    return;

            }
        }

        if (songNum % 2 == 0) {

            switch (response) {

                case "Yes":
                    int[] hobbyTempYes = this.hobbyMap.get(person.getHobby());
                    hobbyTempYes[3] += 1;
                    int[] majorTempYes = this.majorMap.get(person.getMajor());
                    majorTempYes[3] += 1;
                    int[] regionTempYes = this.regionMap.get(person
                        .getRegion());
                    regionTempYes[3] += 1;
                    hobbyMap.replace(person.getHobby(), hobbyTempYes);
                    majorMap.replace(person.getMajor(), majorTempYes);
                    regionMap.replace(person.getRegion(), regionTempYes);
                    break;
                case "No":
                    int[] hobbyTempNo = this.hobbyMap.get(person.getHobby());
                    hobbyTempNo[2] += 1;
                    int[] majorTempNo = this.majorMap.get(person.getMajor());
                    majorTempNo[2] += 1;
                    int[] regionTempNo = this.regionMap.get(person.getRegion());
                    regionTempNo[2] += 1;
                    hobbyMap.replace(person.getHobby(), hobbyTempNo);
                    majorMap.replace(person.getMajor(), majorTempNo);
                    regionMap.replace(person.getRegion(), regionTempNo);
                    break;
                default:
                    return;

            }

        }

    }


    /**
     * gets the song
     * 
     * @return song
     */
    public Song getSong() {

        return this.song;
    }


    /**
     * gets the hobbyMap
     * 
     * @return hobbyMap
     */
    public HashMap<HobbyEnum, int[]> getHobbyMap() {

        return this.hobbyMap;

    }


    /**
     * gets the majorMap
     * 
     * @return majorMap
     */
    public HashMap<MajorEnum, int[]> getMajorMap() {

        return this.majorMap;

    }


    /**
     * gets the regionMap
     * 
     * @return regionMap
     */
    public HashMap<RegionEnum, int[]> getRegionMap() {

        return this.regionMap;

    }


    /**
     * checks for divide by zero
     * 
     * @param num
     *            numerator
     * @param den
     *            denominator
     * @return double of the ratio
     */
    private Double checkRatio(int num, int den) {

        if (den == 0) {
            return 0.0;

        }
        else {
            return ((double)num / (double)den);
        }

    }


    /**
     * gets the ratio represented by hobby
     * 
     * ReadHeard, ArtHeard, SportHeard, MusicHeard, ReadLike, ArtLike,
     * SportLike, MusicLike
     * 
     * @return Double[] of the ratios
     */
    public Double[] getRatioByHobby() {

        Double[] ret = new Double[8];
        ret[0] = checkRatio(this.hobbyMap.get(HobbyEnum.READ)[3], (this.hobbyMap
            .get(HobbyEnum.READ)[3] + this.hobbyMap.get(HobbyEnum.READ)[2]));

        ret[1] = checkRatio(this.hobbyMap.get(HobbyEnum.ART)[3], (this.hobbyMap
            .get(HobbyEnum.ART)[3] + this.hobbyMap.get(HobbyEnum.ART)[2]));

        ret[2] = checkRatio(this.hobbyMap.get(HobbyEnum.SPORTS)[3],
            (this.hobbyMap.get(HobbyEnum.SPORTS)[3] + this.hobbyMap.get(
                HobbyEnum.SPORTS)[2]));

        ret[3] = checkRatio(this.hobbyMap.get(HobbyEnum.MUSIC)[3],
            (this.hobbyMap.get(HobbyEnum.MUSIC)[3] + this.hobbyMap.get(
                HobbyEnum.MUSIC)[2]));

        ret[4] = checkRatio(this.hobbyMap.get(HobbyEnum.READ)[1], (this.hobbyMap
            .get(HobbyEnum.READ)[1] + this.hobbyMap.get(HobbyEnum.READ)[0]));

        ret[5] = checkRatio(this.hobbyMap.get(HobbyEnum.ART)[1], (this.hobbyMap
            .get(HobbyEnum.ART)[1] + this.hobbyMap.get(HobbyEnum.ART)[0]));

        ret[6] = checkRatio(this.hobbyMap.get(HobbyEnum.SPORTS)[1],
            (this.hobbyMap.get(HobbyEnum.SPORTS)[1] + this.hobbyMap.get(
                HobbyEnum.SPORTS)[0]));

        ret[7] = checkRatio(this.hobbyMap.get(HobbyEnum.MUSIC)[1],
            (this.hobbyMap.get(HobbyEnum.MUSIC)[1] + this.hobbyMap.get(
                HobbyEnum.MUSIC)[0]));

        return ret;

    }


    /**
     * gets the ratio represented by Major
     * 
     * Computer Science Heard, CMDA or Math Heard, Other Heard, Other
     * Engineering Heard, Computer Science Like, CMDA or Math Like,
     * Other Like, Other Engineering Like
     * 
     * @return Double[] of the ratios
     */

    public Double[] getRatioByMajor() {

        Double[] ret = new Double[8];
        ret[0] = checkRatio(this.majorMap.get(MajorEnum.COMPUTER_SCIENCE)[3],
            (this.majorMap.get(MajorEnum.COMPUTER_SCIENCE)[3] + this.majorMap
                .get(MajorEnum.COMPUTER_SCIENCE)[2]));

        ret[2] = checkRatio(this.majorMap.get(MajorEnum.MATH_OR_CMDA)[3],
            (this.majorMap.get(MajorEnum.MATH_OR_CMDA)[3] + this.majorMap.get(
                MajorEnum.MATH_OR_CMDA)[2]));

        ret[3] = checkRatio(this.majorMap.get(MajorEnum.OTHER)[3],
            (this.majorMap.get(MajorEnum.OTHER)[3] + this.majorMap.get(
                MajorEnum.OTHER)[2]));

        ret[1] = checkRatio(this.majorMap.get(MajorEnum.OTHER_ENGINEERING)[3],
            (this.majorMap.get(MajorEnum.OTHER_ENGINEERING)[3] + this.majorMap
                .get(MajorEnum.OTHER_ENGINEERING)[2]));

        ret[4] = checkRatio(this.majorMap.get(MajorEnum.COMPUTER_SCIENCE)[1],
            (this.majorMap.get(MajorEnum.COMPUTER_SCIENCE)[1] + this.majorMap
                .get(MajorEnum.COMPUTER_SCIENCE)[0]));

        ret[6] = checkRatio(this.majorMap.get(MajorEnum.MATH_OR_CMDA)[1],
            (this.majorMap.get(MajorEnum.MATH_OR_CMDA)[1] + this.majorMap.get(
                MajorEnum.MATH_OR_CMDA)[0]));

        ret[7] = checkRatio(this.majorMap.get(MajorEnum.OTHER)[1],
            (this.majorMap.get(MajorEnum.OTHER)[1] + this.majorMap.get(
                MajorEnum.OTHER)[0]));

        ret[5] = checkRatio(this.majorMap.get(MajorEnum.OTHER_ENGINEERING)[1],
            (this.majorMap.get(MajorEnum.OTHER_ENGINEERING)[1] + this.majorMap
                .get(MajorEnum.OTHER_ENGINEERING)[0]));

        return ret;

    }


    /**
     * gets the ratio represented by Region
     * 
     * Northeast US Heard, Southeast US Heard, Outside The US Heard, The Rest Of
     * US Heard, Northeast US Like, Southeast US Like,
     * Outside The US Like, The Rest Of US Like
     * 
     * @return double[] of the ratios
     */

    public Double[] getRatioByRegion() {

        Double[] ret = new Double[8];
        ret[0] = checkRatio(this.regionMap.get(RegionEnum.NORTHEAST_US)[3],
            (this.regionMap.get(RegionEnum.NORTHEAST_US)[3] + this.regionMap
                .get(RegionEnum.NORTHEAST_US)[2]));

        ret[1] = checkRatio(this.regionMap.get(RegionEnum.SOUTHEAST_US)[3],
            (this.regionMap.get(RegionEnum.SOUTHEAST_US)[3] + this.regionMap
                .get(RegionEnum.SOUTHEAST_US)[2]));

        ret[3] = checkRatio(this.regionMap.get(RegionEnum.OUTSIDE_THE_US)[3],
            (this.regionMap.get(RegionEnum.OUTSIDE_THE_US)[3] + this.regionMap
                .get(RegionEnum.OUTSIDE_THE_US)[2]));

        ret[2] = checkRatio(this.regionMap.get(RegionEnum.THE_REST_OF_US)[3],
            (this.regionMap.get(RegionEnum.THE_REST_OF_US)[3] + this.regionMap
                .get(RegionEnum.THE_REST_OF_US)[2]));

        ret[4] = checkRatio(this.regionMap.get(RegionEnum.NORTHEAST_US)[1],
            (this.regionMap.get(RegionEnum.NORTHEAST_US)[1] + this.regionMap
                .get(RegionEnum.NORTHEAST_US)[0]));

        ret[5] = checkRatio(this.regionMap.get(RegionEnum.SOUTHEAST_US)[1],
            (this.regionMap.get(RegionEnum.SOUTHEAST_US)[1] + this.regionMap
                .get(RegionEnum.SOUTHEAST_US)[0]));

        ret[7] = checkRatio(this.regionMap.get(RegionEnum.OUTSIDE_THE_US)[1],
            (this.regionMap.get(RegionEnum.OUTSIDE_THE_US)[1] + this.regionMap
                .get(RegionEnum.OUTSIDE_THE_US)[0]));

        ret[6] = checkRatio(this.regionMap.get(RegionEnum.THE_REST_OF_US)[1],
            (this.regionMap.get(RegionEnum.THE_REST_OF_US)[1] + this.regionMap
                .get(RegionEnum.THE_REST_OF_US)[0]));

        return ret;

    }


    /**
     * returns a double of ratios based on the string given
     * 
     * @param rep
     *            the string of the representation (hobby, major, region)
     * @return double[] of that representation or null
     */
    public Double[] getRatioBy(String rep) {

        if (rep.equals("Hobby")) {
            return this.getRatioByHobby();
        }
        else if (rep.equals("Major")) {
            return this.getRatioByMajor();
        }
        else if (rep.equals("Region")) {

            return this.getRatioByRegion();
        }
        else {
            return null;
        }

    }


    /**
     * 
     * returns the glyph as a string
     * 
     * @return String rep of the glyph
     */
    public String toString() {

        StringBuilder ret = new StringBuilder();
        Double[] byHobby = this.getRatioByHobby();

        ret.append(this.song.toString());

        ret.append("\nheard\n");
        ret.append("reading:" + (int)(byHobby[0] * 100) + " art:"
            + (int)(byHobby[1] * 100) + " sports:" + (int)(byHobby[2] * 100)
            + " music:" + (int)(byHobby[3] * 100) + "\n");

        ret.append("likes\n");
        ret.append("reading:" + (int)(byHobby[4] * 100) + " art:"
            + (int)(byHobby[5] * 100) + " sports:" + (int)(byHobby[6] * 100)
            + " music:" + (int)(byHobby[7] * 100) + "\n");

        return ret.toString();

    }

}
