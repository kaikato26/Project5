/**
 * 
 */
package prj5;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author anamk
 *
 */
public class MusicCalculator {

    private LinkedList<Glyph> glyphList;
    private ArrayList<Song> songList;


    public MusicCalculator(ArrayList<Song> songs, ArrayList<Person> persons) {
        this.songList = songs;
        this.glyphList = fillGlyphList(songs, persons);

    }


    private LinkedList<Glyph> fillGlyphList(
        ArrayList<Song> songs,
        ArrayList<Person> persons) {

        LinkedList<Glyph> glyphList = new LinkedList<Glyph>();
        
        int len = songs.size();
        

        for (int i = 0; i <len; i++) {

            glyphList.add(new Glyph(songs.get(i)));

            for (int j = 0; j < persons.size(); j++) {

                glyphList.get(i).addResult(persons.get(j), 2 * i);
                glyphList.get(i).addResult(persons.get(j), 2 * i + 1);
                
            }

        }
        return glyphList;
    }


    public LinkedList<Glyph> sortGlyphs(String sortCriteria) {

        LinkedList<Glyph> copyGlyph = new LinkedList<Glyph>();
        LinkedList<String> sortList = new LinkedList<String>();

        if (sortCriteria.equals("date")) {
            LinkedList<Integer> songDates = new LinkedList<Integer>();
            for (int i = 0; i < songList.size(); i++) {
                songDates.add(glyphList.get(i).getSong().getDate());
            }
            songDates = songDates.sort();
            for (int i = 0; i < songDates.size(); i++) {
                Iterator<Glyph> it = this.glyphList.iterator();
                while (it.hasNext()) {
                    Glyph glyph = it.next();
                    if (songDates.get(i).equals(glyph.getSong().getDate())) {
                        copyGlyph.add(glyph);
                        it.remove();
                        break;
                    }

                }
            }
            this.setGlyphList(copyGlyph);
            return this.glyphList;

        }

        switch (sortCriteria) {
            case "title":
                for (int i = 0; i < songList.size(); i++) {
                    sortList.add(glyphList.get(i).getSong().getTitle());
                }
                sortList = sortList.sort();
                for (int i = 0; i < sortList.size(); i++) {
                    Iterator<Glyph> it = this.glyphList.iterator();
                    while (it.hasNext()) {
                        Glyph glyph = it.next();
                        if (sortList.get(i).equals(glyph.getSong()
                            .getTitle())) {
                            copyGlyph.add(glyph);
                            it.remove();
                            break;
                        }

                    }
                }
                this.setGlyphList(copyGlyph);
                return this.glyphList;

            case "genre":
                for (int i = 0; i < songList.size(); i++) {
                    sortList.add(glyphList.get(i).getSong().getGenre());
                }
                sortList = sortList.sort();
                for (int i = 0; i < sortList.size(); i++) {
                    Iterator<Glyph> it = this.glyphList.iterator();
                    while (it.hasNext()) {
                        Glyph glyph = it.next();
                        if (sortList.get(i).equals(glyph.getSong()
                            .getGenre())) {
                            copyGlyph.add(glyph);
                            it.remove();
                            break;
                        }

                    }
                }
                this.setGlyphList(copyGlyph);
                return this.glyphList;

            case "artist":
                for (int i = 0; i < songList.size(); i++) {
                    sortList.add(glyphList.get(i).getSong().getArtist());
                }
                sortList = sortList.sort();
                for (int i = 0; i < sortList.size(); i++) {
                    Iterator<Glyph> it = this.glyphList.iterator();
                    while (it.hasNext()) {
                        Glyph glyph = it.next();
                        if (sortList.get(i).equals(glyph.getSong()
                            .getArtist())) {
                            copyGlyph.add(glyph);
                            it.remove();
                            break;
                        }

                    }
                }
                this.setGlyphList(copyGlyph);
                return this.glyphList;

            default:
                return null;
        }

    }


    public LinkedList<Glyph> getGlyphList() {

        return this.glyphList;

    }


    public void setGlyphList(LinkedList<Glyph> glyphList) {

        this.glyphList = glyphList;
    }

}
