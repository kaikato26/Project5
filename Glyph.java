/**
 * 
 */
package project5;

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
        hobbyMap.put(Hobby.ART, new int[2]);
        hobbyMap.put(Hobby.READ, new int[2]);
        hobbyMap.put(Hobby.SPORTS, new int[2]);
        hobbyMap.put(Hobby.MUSIC, new int[2]);
        majorMap.put(Major.COMPUTER_SCIENCE, new int[2]);
        majorMap.put(Major.MATH_OR_CMDA, new int[2]);
        majorMap.put(Major.OTHER, new int[2]);
        majorMap.put(Major.OTHER_ENGINEERING, new int[2]);
        regionMap.put(Region.NORTHEAST_US, new int[2]);
        regionMap.put(Region.SOUTHEAST_US, new int[2]);
        regionMap.put(Region.OUTSIDE_THE_US, new int[2]);
        regionMap.put(Region.THE_REST_OF_US, new int[2]);

    }


    public void addResult(Person person, int songNum) {

        String response = person.getResults()[songNum];

        switch (response) {

            case "Yes":
                int[] hobbyTempYes = this.hobbyMap.get(person.getHobby());
                hobbyTempYes[1] += 1;
                int[] majorTempYes = this.majorMap.get(person.getMajor());
                majorTempYes[1] += 1;
                int[] regionTempYes = this.regionMap.get(person.getRegion());
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


    public String toString() {

        StringBuilder ret = new StringBuilder();
        ret.append("Song Name: " + this.song.getTitle() + " Artist Name: "
            + this.song.getArtist() + " Genre: " + this.song.getGenre()
            + " Date: " + this.song.getDate() + "\n\n");

        ret.append("By Hobby\n\n");
        ret.append(Hobby.ART.toString() + " | Yes: " + this.hobbyMap.get(
            Hobby.ART)[1] + " | No: " + this.hobbyMap.get(Hobby.ART)[0] + "\n");
        ret.append(Hobby.MUSIC.toString() + " | Yes: " + this.hobbyMap.get(
            Hobby.MUSIC)[1] + " | No: " + this.hobbyMap.get(Hobby.MUSIC)[0]
            + "\n");
        ret.append(Hobby.SPORTS.toString() + " | Yes: " + this.hobbyMap.get(
            Hobby.SPORTS)[1] + " | No: " + this.hobbyMap.get(Hobby.SPORTS)[0]
            + "\n");
        ret.append(Hobby.READ.toString() + " | Yes: " + this.hobbyMap.get(
            Hobby.READ)[1] + " | No: " + this.hobbyMap.get(Hobby.READ)[0]
            + "\n\n");

        ret.append("By Major\n\n");
        ret.append(Major.COMPUTER_SCIENCE.toString() + " | Yes: "
            + this.majorMap.get(Major.COMPUTER_SCIENCE)[1] + " | No: "
            + this.majorMap.get(Major.COMPUTER_SCIENCE)[0] + "\n");
        ret.append(Major.MATH_OR_CMDA.toString() + " | Yes: " + this.majorMap
            .get(Major.MATH_OR_CMDA)[1] + " | No: " + this.majorMap.get(
                Major.MATH_OR_CMDA)[0] + "\n");
        ret.append(Major.OTHER.toString() + " | Yes: " + this.majorMap.get(
            Major.OTHER)[1] + " | No: " + this.majorMap.get(Major.OTHER)[0]
            + "\n");
        ret.append(Major.OTHER_ENGINEERING.toString() + " | Yes: "
            + this.majorMap.get(Major.OTHER_ENGINEERING)[1] + " | No: "
            + this.majorMap.get(Major.OTHER_ENGINEERING)[0] + "\n\n");

        ret.append("By Region\n\n");
        ret.append(Region.NORTHEAST_US.toString() + " | Yes: " + this.regionMap
            .get(Region.NORTHEAST_US)[1] + " | No: " + this.regionMap.get(
                Region.NORTHEAST_US)[0] + "\n");
        ret.append(Region.SOUTHEAST_US.toString() + " | Yes: " + this.regionMap
            .get(Region.SOUTHEAST_US)[1] + " | No: " + this.regionMap.get(
                Region.SOUTHEAST_US)[0] + "\n");
        ret.append(Region.THE_REST_OF_US.toString() + " | Yes: "
            + this.regionMap.get(Region.THE_REST_OF_US)[1] + " | No: "
            + this.regionMap.get(Region.THE_REST_OF_US)[0] + "\n");
        ret.append(Region.OUTSIDE_THE_US.toString() + " | Yes: "
            + this.regionMap.get(Region.OUTSIDE_THE_US)[1] + " | No: "
            + this.regionMap.get(Region.OUTSIDE_THE_US)[0] + "\n\n");

        return ret.toString();

    }

}
