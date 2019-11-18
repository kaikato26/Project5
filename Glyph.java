/**
 * 
 */
package prj5;

import java.util.HashMap;

/**
 * @author anamk
 *
 */
public class Glyph {

    private Song song;
    private HashMap<Hobby, int[]> hobbyMap;
    private HashMap<Major, int[]> majorMap;
    private HashMap<Region, int[]> regionMap;


    public Glyph(Song song) {

        this.song = song;
        hobbyMap = new HashMap<Hobby, int[]>();
        majorMap = new HashMap<Major, int[]>();
        regionMap = new HashMap<Region, int[]>();
        hobbyMap.put(Hobby.ART, new int[4]);
        hobbyMap.put(Hobby.READ, new int[4]);
        hobbyMap.put(Hobby.SPORTS, new int[4]);
        hobbyMap.put(Hobby.MUSIC, new int[4]);
        majorMap.put(Major.COMPUTER_SCIENCE, new int[4]);
        majorMap.put(Major.MATH_OR_CMDA, new int[4]);
        majorMap.put(Major.OTHER, new int[4]);
        majorMap.put(Major.OTHER_ENGINEERING, new int[4]);
        regionMap.put(Region.NORTHEAST_US, new int[4]);
        regionMap.put(Region.SOUTHEAST_US, new int[4]);
        regionMap.put(Region.OUTSIDE_THE_US, new int[4]);
        regionMap.put(Region.THE_REST_OF_US, new int[4]);

    }


    public void addResult(Person person, int songNum) {
        
        if(songNum >= person.getResults().length) {
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


    public Song getSong() {

        return this.song;
    }


    public HashMap<Hobby, int[]> getHobbyMap() {

        return this.hobbyMap;

    }


    public HashMap<Major, int[]> getMajorMap() {

        return this.majorMap;

    }


    public HashMap<Region, int[]> getRegionMap() {

        return this.regionMap;

    }


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
        ret[0] = checkRatio(this.hobbyMap.get(Hobby.READ)[3], (this.hobbyMap
            .get(Hobby.READ)[3] + this.hobbyMap.get(Hobby.READ)[2]));

        ret[1] = checkRatio(this.hobbyMap.get(Hobby.ART)[3], (this.hobbyMap.get(
            Hobby.ART)[3] + this.hobbyMap.get(Hobby.ART)[2]));

        ret[2] = checkRatio(this.hobbyMap.get(Hobby.SPORTS)[3], (this.hobbyMap
            .get(Hobby.SPORTS)[3] + this.hobbyMap.get(Hobby.SPORTS)[2]));

        ret[3] = checkRatio(this.hobbyMap.get(Hobby.MUSIC)[3], (this.hobbyMap
            .get(Hobby.MUSIC)[3] + this.hobbyMap.get(Hobby.MUSIC)[2]));

        ret[4] = checkRatio(this.hobbyMap.get(Hobby.READ)[1], (this.hobbyMap
            .get(Hobby.READ)[1] + this.hobbyMap.get(Hobby.READ)[0]));

        ret[5] = checkRatio(this.hobbyMap.get(Hobby.ART)[1], (this.hobbyMap.get(
            Hobby.ART)[1] + this.hobbyMap.get(Hobby.ART)[0]));

        ret[6] = checkRatio(this.hobbyMap.get(Hobby.SPORTS)[1], (this.hobbyMap
            .get(Hobby.SPORTS)[1] + this.hobbyMap.get(Hobby.SPORTS)[0]));

        ret[7] = checkRatio(this.hobbyMap.get(Hobby.MUSIC)[1], (this.hobbyMap
            .get(Hobby.MUSIC)[1] + this.hobbyMap.get(Hobby.MUSIC)[0]));

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
        ret[0] = checkRatio(this.majorMap.get(Major.COMPUTER_SCIENCE)[3],
            (this.majorMap.get(Major.COMPUTER_SCIENCE)[3] + this.majorMap.get(
                Major.COMPUTER_SCIENCE)[2]));

        ret[1] = checkRatio(this.majorMap.get(Major.MATH_OR_CMDA)[3],
            (this.majorMap.get(Major.MATH_OR_CMDA)[3] + this.majorMap.get(
                Major.MATH_OR_CMDA)[2]));

        ret[2] = checkRatio(this.majorMap.get(Major.OTHER)[3], (this.majorMap
            .get(Major.OTHER)[3] + this.majorMap.get(Major.OTHER)[2]));

        ret[3] = checkRatio(this.majorMap.get(Major.OTHER_ENGINEERING)[3],
            (this.majorMap.get(Major.OTHER_ENGINEERING)[3] + this.majorMap.get(
                Major.OTHER_ENGINEERING)[2]));

        ret[4] = checkRatio(this.majorMap.get(Major.COMPUTER_SCIENCE)[1],
            (this.majorMap.get(Major.COMPUTER_SCIENCE)[1] + this.majorMap.get(
                Major.COMPUTER_SCIENCE)[0]));

        ret[5] = checkRatio(this.majorMap.get(Major.MATH_OR_CMDA)[1],
            (this.majorMap.get(Major.MATH_OR_CMDA)[1] + this.majorMap.get(
                Major.MATH_OR_CMDA)[0]));

        ret[6] = checkRatio(this.majorMap.get(Major.OTHER)[1], (this.majorMap
            .get(Major.OTHER)[1] + this.majorMap.get(Major.OTHER)[0]));

        ret[7] = checkRatio(this.majorMap.get(Major.OTHER_ENGINEERING)[1],
            (this.majorMap.get(Major.OTHER_ENGINEERING)[1] + this.majorMap.get(
                Major.OTHER_ENGINEERING)[0]));

        return ret;

    }


    /**
     * gets the ratio represented by Region
     * 
     * Northeast US Heard, Southeast US Heard, Outside The US Heard, The Rest Of
     * US Heard, Northeast US Like, Southeast US Like,
     * Outside The US Like, The Rest Of US Like
     * 
     * @return int[] of the ratios
     */

    public Double[] getRatioByRegion() {

        Double[] ret = new Double[8];
        ret[0] = checkRatio(this.regionMap.get(Region.NORTHEAST_US)[3],
            (this.regionMap.get(Region.NORTHEAST_US)[3] + this.regionMap.get(
                Region.NORTHEAST_US)[2]));

        ret[1] = checkRatio(this.regionMap.get(Region.SOUTHEAST_US)[3],
            (this.regionMap.get(Region.SOUTHEAST_US)[3] + this.regionMap.get(
                Region.SOUTHEAST_US)[2]));

        ret[2] = checkRatio(this.regionMap.get(Region.OUTSIDE_THE_US)[3],
            (this.regionMap.get(Region.OUTSIDE_THE_US)[3] + this.regionMap.get(
                Region.OUTSIDE_THE_US)[2]));

        ret[3] = checkRatio(this.regionMap.get(Region.THE_REST_OF_US)[3],
            (this.regionMap.get(Region.THE_REST_OF_US)[3] + this.regionMap.get(
                Region.THE_REST_OF_US)[2]));

        ret[4] = checkRatio(this.regionMap.get(Region.NORTHEAST_US)[1],
            (this.regionMap.get(Region.NORTHEAST_US)[1] + this.regionMap.get(
                Region.NORTHEAST_US)[0]));

        ret[5] = checkRatio(this.regionMap.get(Region.SOUTHEAST_US)[1],
            (this.regionMap.get(Region.SOUTHEAST_US)[1] + this.regionMap.get(
                Region.SOUTHEAST_US)[0]));

        ret[6] = checkRatio(this.regionMap.get(Region.OUTSIDE_THE_US)[1],
            (this.regionMap.get(Region.OUTSIDE_THE_US)[1] + this.regionMap.get(
                Region.OUTSIDE_THE_US)[0]));

        ret[7] = checkRatio(this.regionMap.get(Region.THE_REST_OF_US)[1],
            (this.regionMap.get(Region.THE_REST_OF_US)[1] + this.regionMap.get(
                Region.THE_REST_OF_US)[0]));

        return ret;

    }


    public String toString() {

        StringBuilder ret = new StringBuilder();
        Double[] byHobby = this.getRatioByHobby();

        ret.append(this.song.toString());

        ret.append("\nheard\n");
        ret.append("reading:" + (int)(byHobby[0] * 100) + " art:" + (int)(byHobby[1]
            * 100) + " sports:" + (int)(byHobby[2] * 100) + " music:" + (int)(byHobby[3]
                * 100) + "\n");

        ret.append("likes\n");
        ret.append("reading:" + (int)(byHobby[4] * 100) + " art:" + (int)(byHobby[5]
            * 100) + " sports:" + (int)(byHobby[6] * 100) + " music:" + (int)(byHobby[7]
                * 100) + "\n");
/*
 * ret.append(Hobby.ART.toString() + " | Yes: " + this.hobbyMap.get(
 * Hobby.ART)[1] + " | No: " + this.hobbyMap.get(Hobby.ART)[0] + "\n");
 * ret.append(Hobby.MUSIC.toString() + " | Yes: " + this.hobbyMap.get(
 * Hobby.MUSIC)[1] + " | No: " + this.hobbyMap.get(Hobby.MUSIC)[0]
 * + "\n");
 * ret.append(Hobby.SPORTS.toString() + " | Yes: " + this.hobbyMap.get(
 * Hobby.SPORTS)[1] + " | No: " + this.hobbyMap.get(Hobby.SPORTS)[0]
 * + "\n");
 * ret.append(Hobby.READ.toString() + " | Yes: " + this.hobbyMap.get(
 * Hobby.READ)[1] + " | No: " + this.hobbyMap.get(Hobby.READ)[0]
 * + "\n\n");
 * 
 * ret.append("By Major\n\n");
 * ret.append(Major.COMPUTER_SCIENCE.toString() + " | Yes: "
 * + this.majorMap.get(Major.COMPUTER_SCIENCE)[1] + " | No: "
 * + this.majorMap.get(Major.COMPUTER_SCIENCE)[0] + "\n");
 * ret.append(Major.MATH_OR_CMDA.toString() + " | Yes: " + this.majorMap
 * .get(Major.MATH_OR_CMDA)[1] + " | No: " + this.majorMap.get(
 * Major.MATH_OR_CMDA)[0] + "\n");
 * ret.append(Major.OTHER.toString() + " | Yes: " + this.majorMap.get(
 * Major.OTHER)[1] + " | No: " + this.majorMap.get(Major.OTHER)[0]
 * + "\n");
 * ret.append(Major.OTHER_ENGINEERING.toString() + " | Yes: "
 * + this.majorMap.get(Major.OTHER_ENGINEERING)[1] + " | No: "
 * + this.majorMap.get(Major.OTHER_ENGINEERING)[0] + "\n\n");
 * 
 * ret.append("By Region\n\n");
 * ret.append(Region.NORTHEAST_US.toString() + " | Yes: " + this.regionMap
 * .get(Region.NORTHEAST_US)[1] + " | No: " + this.regionMap.get(
 * Region.NORTHEAST_US)[0] + "\n");
 * ret.append(Region.SOUTHEAST_US.toString() + " | Yes: " + this.regionMap
 * .get(Region.SOUTHEAST_US)[1] + " | No: " + this.regionMap.get(
 * Region.SOUTHEAST_US)[0] + "\n");
 * ret.append(Region.THE_REST_OF_US.toString() + " | Yes: "
 * + this.regionMap.get(Region.THE_REST_OF_US)[1] + " | No: "
 * + this.regionMap.get(Region.THE_REST_OF_US)[0] + "\n");
 * ret.append(Region.OUTSIDE_THE_US.toString() + " | Yes: "
 * + this.regionMap.get(Region.OUTSIDE_THE_US)[1] + " | No: "
 * + this.regionMap.get(Region.OUTSIDE_THE_US)[0] + "\n\n");
 */
        return ret.toString();

    }

}
