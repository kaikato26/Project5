/**
 * 
 */
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import bsh.ParseException;

/**
 * @author anamk
 *
 */
public class MusicReader {

    private ArrayList<Song> songList;
    private ArrayList<Person> personList;
    private MusicCalculator glyphList;


    public MusicReader(String songFileName, String personFileName)
        throws FileNotFoundException {

        this.songList = this.readSongs(songFileName);
        this.personList = this.readPersons(personFileName);
        this.glyphList = new MusicCalculator(songList, personList);
        
    }


    public ArrayList<Song> readSongs(String songFileName)
        throws FileNotFoundException {

        ArrayList<Song> songs = new ArrayList<Song>();
        Scanner scan = new Scanner(new File(songFileName));
        scan.nextLine();
        while (scan.hasNext()) {

            String line = scan.nextLine();
            String[] vals = line.split(", *", -1);
            if (vals.length != 4) {
                continue;
            }

            songs.add(new Song(vals[1], vals[0], vals[3], Integer.valueOf(
                vals[2])));

        }
        scan.close();
        return songs;

    }


    public ArrayList<Person> readPersons(String personFileName)
        throws FileNotFoundException {

        ArrayList<Person> persons = new ArrayList<Person>();
        Scanner scan = new Scanner(new File(personFileName));
        String[] temp = scan.nextLine().split(", *", -1);
        int len = temp.length;
        while (scan.hasNext()) {

            String line = scan.nextLine();
            String[] vals = line.split(", *", -1);
            if (vals.length != len) {
                continue;
            }
            String[] attributes = Arrays.copyOfRange(vals, 2, 5);
            String[] responses = Arrays.copyOfRange(vals, 5, len);
            if (checkForEmptyVals(attributes)) {
                continue;
            }
            persons.add(new Person(attributes[2].toLowerCase(), attributes[0]
                .toLowerCase(), attributes[1].toLowerCase(), responses));

        }
        scan.close();
        return persons;

    }


    private boolean checkForEmptyVals(String[] vals) {

        for (int i = 0; i < vals.length; i++) {

            if (vals[i].equals("")) {
                return true;
            }
        }
        return false;

    }
    
    public MusicCalculator getMusicCalc() {
        
        return this.glyphList;
    }

}
