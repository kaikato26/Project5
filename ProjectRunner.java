/**
 * 
 */
package prj5;

import java.io.FileNotFoundException;

/**
 * @author anamk
 *
 */
public class ProjectRunner {

    public static void main(String[] args) throws FileNotFoundException {
        
        MusicReader pRunner;
        GUIMusicWindow musicWindow;
        if (args.length == 2) {
            pRunner = new MusicReader(args[0], args[1]);
            musicWindow = new GUIMusicWindow(pRunner);
        }
        else {
            pRunner = new MusicReader("SongList2019F.csv" ,"MusicSurveyData2019F.csv");
            musicWindow = new GUIMusicWindow(pRunner);
        }
        
    }
    
    
}
