/**
 * 
 */
package prj5;

import java.io.FileNotFoundException;
import bsh.ParseException;

/**
 * @author anamk
 *
 */
public class Input {

    /**
     * @param args
     * @throws ParseException 
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        MusicReader pRunner;
        if (args.length == 2) {
            pRunner = new MusicReader(args[1], args[0]);
            pRunner.getMusicCalc().sortGlyphs("genre");
            System.out.println(pRunner.getMusicCalc().getGlyphList().toString());
            pRunner.getMusicCalc().sortGlyphs("title");
            System.out.println(pRunner.getMusicCalc().getGlyphList().toString());
        }
        else {
            pRunner = new MusicReader("SongList2018Intro.csv", "MusicSurveyData2018Intro.csv");
            pRunner.getMusicCalc().sortGlyphs("genre");
            System.out.println(pRunner.getMusicCalc().getGlyphList().toString());
            pRunner.getMusicCalc().sortGlyphs("title");
            System.out.println(pRunner.getMusicCalc().getGlyphList().toString());
        }
        
        
        
    }

}
