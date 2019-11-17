package Proj5;

import java.util.ArrayList;
import java.util.Iterator;

public class MusicCalculator {

    private LinkedList<Glyph> glyphList;
    private ArrayList<Song> songList;


    public MusicCalculator(
        ArrayList<Song> songList,
        ArrayList<Person> personList) {
        this.songList = songList;
        for (int i = 0; i < songList.size(); i++) {
            glyphList.add(new Glyph(songList.get(i)));
        }
    }


    public LinkedList<Glyph> sortGlyphs(String sortCriteria) {
        LinkedList<Glyph> copyGlyph = new LinkedList<Glyph>();
        LinkedList<String> sortList = new LinkedList<String>();
        Iterator<Glyph> it = glyphList.iterator();

        if (sortCriteria.equals("date")) {
            LinkedList<Integer> songDates = new LinkedList<Integer>();
            for (int i = 0; i < songList.size(); i++) {
                songDates.add(glyphList.get(i).getSong().getDate());
            }
            songDates.sort();
            for (int i = 0; i < sortList.size(); i++) {
                while (it.hasNext()) {
                    Glyph glyph = it.next();
                    if (songDates.get(i).equals(glyph.getSong().getDate())) {
                        copyGlyph.add(glyph);
                        it.remove();
                        break;
                    }

                }
            }
            glyphList = copyGlyph;
            return glyphList;
        }

        switch (sortCriteria) {
            case "title":
                for (int i = 0; i < songList.size(); i++) {
                    sortList.add(glyphList.get(i).getSong().getTitle());
                }
                sortList.sort();
                for (int i = 0; i < sortList.size(); i++) {
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
                glyphList = copyGlyph;
                return glyphList;

            case "genre":
                for (int i = 0; i < songList.size(); i++) {
                    sortList.add(glyphList.get(i).getSong().getGenre());
                }
                sortList.sort();
                for (int i = 0; i < sortList.size(); i++) {
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
                glyphList = copyGlyph;
                return glyphList;

            case "artist":
                for (int i = 0; i < songList.size(); i++) {
                    sortList.add(glyphList.get(i).getSong().getArtist());
                }
                sortList.sort();
                for (int i = 0; i < sortList.size(); i++) {
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
                glyphList = copyGlyph;
                return glyphList;

            default:
                return null;
        }

    }
}
