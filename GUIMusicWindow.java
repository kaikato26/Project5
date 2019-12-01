/**
 * 
 */
package prj5;

import java.awt.Color;
import CS2114.Button;
import CS2114.Window;
import CS2114.WindowSide;
import CS2114.Shape;
import CS2114.TextShape;

public class GUIMusicWindow {

    public static final int BLACK_BAR_HEIGHT = 125;
    public static final int BLACK_BAR_WIDTH = 20;
    public static final int TOP_GAP = 50;
    public static final int GLYPH_OFFSET_X = 150;
    public static final int GLYPH_OFFSET_Y = 120;
    public static final int GLYPH_GAP_Y = 50;
    public static final int GLYPH_INCREMENT_X = 2;
    public static final int GLYPH_BAR_HEIGHT = BLACK_BAR_HEIGHT / 4;
    public static final int GLYPH_BAR_WIDTH = 15;
    public static final int GLYPH_BAR_EXAMPLE_NUMBER = 15;

    public static final int LEGEND_X_LOC = 1600;
    public static final int LEGEND_Y_LOC = 500;
    public static final int LEGEND_OUTLINE = 3;
    public static final int LEGEND_WIDTH = 250;
    public static final int LEGEND_HEIGHT = 350;
    public static final int LEGEND_TEXT_OFFSET = 20;

    public static final Color EXAMPLE_ATTRIBUTE1 = Color.PINK;
    public static final Color EXAMPLE_ATTRIBUTE2 = Color.BLUE;
    public static final Color EXAMPLE_ATTRIBUTE3 = Color.YELLOW;
    public static final Color EXAMPLE_ATTRIBUTE4 = Color.GREEN;

    private Window window;
    private Button repHobby;
    private Button repRegion;
    private Button repMajor;
    private Button quit;
    private Button prev;
    private Button next;
    private Button byArtist;
    private Button byGenre;
    private Button byYear;
    private Button byTitle;

    private MusicCalculator musicCalc;
    private int counter;

    private int currentPage;
    private String repBy;
    private String attOne;
    private String attTwo;
    private String attThree;
    private String attFour;
    private int numPages;


    public GUIMusicWindow(MusicReader reader) {
        this.currentPage = 0;
        this.musicCalc = reader.getMusicCalc();
        this.numPages = (this.musicCalc.getGlyphList().size() / 9);
        if (this.musicCalc.getGlyphList().size() % 9 == 0) {
            numPages--;
        }

        this.window = new Window("kaikato26 anamkung Samhita7");
        repHobby = new Button("Represent Hobby");
        repRegion = new Button("Represent Region");
        repMajor = new Button("Represent Major");
        quit = new Button("Quit");
        prev = new Button("<= Prev");
        next = new Button("Next =>");
        byArtist = new Button("Sort by Artist Name");
        byGenre = new Button("Sort by Genre");
        byYear = new Button("Sort by Year");
        byTitle = new Button("Sort by Song Title");

        window.addButton(prev, WindowSide.NORTH);
        window.addButton(byArtist, WindowSide.NORTH);
        window.addButton(byTitle, WindowSide.NORTH);
        window.addButton(byYear, WindowSide.NORTH);
        window.addButton(byGenre, WindowSide.NORTH);
        window.addButton(next, WindowSide.NORTH);

        window.addButton(repHobby, WindowSide.SOUTH);
        window.addButton(repMajor, WindowSide.SOUTH);
        window.addButton(repRegion, WindowSide.SOUTH);
        window.addButton(quit, WindowSide.SOUTH);

        // Creates the blackbars, stay constant
        window.setSize(1920, 1040);

        this.quit.onClick(this, "clickedQuit");
        this.next.onClick(this, "clickedNext");
        this.prev.onClick(this, "clickedPrev");
        this.repHobby.onClick(this, "clickedRepHobby");
        this.repMajor.onClick(this, "clickedRepMajor");
        this.repRegion.onClick(this, "clickedRepRegion");

        this.byArtist.onClick(this, "clickedSortByArtist");
        this.byGenre.onClick(this, "clickedSortByGenere");
        this.byTitle.onClick(this, "clickedSortByTitle");
        this.byYear.onClick(this, "clickedSortByYear");

        this.prev.disable();

    }


    private void legendText() {

        Shape legendOutside = new Shape(LEGEND_X_LOC, LEGEND_Y_LOC,
            LEGEND_WIDTH, LEGEND_HEIGHT, Color.black);
        window.addShape(legendOutside);
        Shape legendInside = new Shape(LEGEND_X_LOC + LEGEND_OUTLINE,
            LEGEND_Y_LOC + LEGEND_OUTLINE, LEGEND_WIDTH - 2 * LEGEND_OUTLINE,
            LEGEND_HEIGHT - 2 * LEGEND_OUTLINE, Color.white);
        window.addShape(legendInside);
        window.moveToFront(legendInside);

        // Legend text

        Shape legendBlackBar = new Shape(LEGEND_X_LOC + LEGEND_WIDTH / 2
            - (BLACK_BAR_WIDTH / 2), LEGEND_Y_LOC + 180, BLACK_BAR_WIDTH,
            BLACK_BAR_HEIGHT, Color.black);
        window.addShape(legendBlackBar);
        window.moveToFront(legendBlackBar);

        TextShape songTitleText = new TextShape(LEGEND_X_LOC + LEGEND_WIDTH / 2
            - (BLACK_BAR_WIDTH * 2) + 5, LEGEND_Y_LOC + 170, "Song title");
        TextShape heardText = new TextShape(LEGEND_X_LOC + LEGEND_WIDTH / 2
            - (BLACK_BAR_WIDTH * 3), LEGEND_Y_LOC + 230, "Heard");
        TextShape likesText = new TextShape(LEGEND_X_LOC + LEGEND_WIDTH / 2
            + (BLACK_BAR_WIDTH), LEGEND_Y_LOC + 230, "Likes");

        songTitleText.setBackgroundColor(Color.white);
        heardText.setBackgroundColor(Color.white);
        likesText.setBackgroundColor(Color.white);

        window.addShape(songTitleText);
        window.addShape(heardText);
        window.addShape(likesText);

        window.moveToFront(songTitleText);
        window.moveToFront(heardText);
        window.moveToFront(likesText);

        TextShape attribute1Text = new TextShape(LEGEND_X_LOC
            + LEGEND_TEXT_OFFSET, LEGEND_Y_LOC + LEGEND_TEXT_OFFSET * 2,
            this.attOne);
        TextShape attribute2Text = new TextShape(LEGEND_X_LOC
            + LEGEND_TEXT_OFFSET, LEGEND_Y_LOC + LEGEND_TEXT_OFFSET * 3,
            this.attTwo);
        TextShape attribute3Text = new TextShape(LEGEND_X_LOC
            + LEGEND_TEXT_OFFSET, LEGEND_Y_LOC + LEGEND_TEXT_OFFSET * 4,
            this.attThree);
        TextShape attribute4Text = new TextShape(LEGEND_X_LOC
            + LEGEND_TEXT_OFFSET, LEGEND_Y_LOC + LEGEND_TEXT_OFFSET * 5,
            this.attFour);

        TextShape legendText = new TextShape(LEGEND_X_LOC +

            LEGEND_TEXT_OFFSET, LEGEND_Y_LOC + LEGEND_TEXT_OFFSET, this.repBy
                + " Legend");

        attribute1Text.setBackgroundColor(Color.white);
        attribute2Text.setBackgroundColor(Color.white);
        attribute3Text.setBackgroundColor(Color.white);
        attribute4Text.setBackgroundColor(Color.white);
        legendText.setBackgroundColor(Color.white);

        attribute1Text.setForegroundColor(EXAMPLE_ATTRIBUTE1);
        attribute2Text.setForegroundColor(EXAMPLE_ATTRIBUTE2);
        attribute3Text.setForegroundColor(EXAMPLE_ATTRIBUTE3);
        attribute4Text.setForegroundColor(EXAMPLE_ATTRIBUTE4);

        window.addShape(attribute1Text);
        window.addShape(attribute2Text);
        window.addShape(attribute3Text);
        window.addShape(attribute4Text);
        window.addShape(legendText);

        window.moveToFront(attribute1Text);
        window.moveToFront(attribute2Text);
        window.moveToFront(attribute3Text);
        window.moveToFront(attribute4Text);
        window.moveToFront(legendText);
    }


    private void glyphBars() {

        for (int row = 1; row < 4; row++) {
            for (int column = 1; column < 4; column++) {

                if (counter == this.musicCalc.getGlyphList().size()) {
                    break;
                }

                Double[] ratios = this.musicCalc.getGlyphList().get(counter)
                    .getRatioBy(repBy);
                // creates black bars
                Shape blackBar = new Shape(window.getGraphPanelWidth() / 4
                    * column - GLYPH_OFFSET_X, row * window
                        .getGraphPanelHeight() / 4 + (row * GLYPH_GAP_Y)
                        - GLYPH_OFFSET_Y, BLACK_BAR_WIDTH, BLACK_BAR_HEIGHT,
                    Color.black);
                window.addShape(blackBar);

                // creates data bars
                Shape glyphBar1R = new Shape(window.getGraphPanelWidth() / 4
                    * column - GLYPH_OFFSET_X + BLACK_BAR_WIDTH, row * window
                        .getGraphPanelHeight() / 4 + (row * GLYPH_GAP_Y)
                        - GLYPH_OFFSET_Y + (GLYPH_BAR_HEIGHT * 0),
                    (GLYPH_INCREMENT_X * ((int)(ratios[4] * 100))),
                    GLYPH_BAR_HEIGHT, EXAMPLE_ATTRIBUTE1);
                Shape glyphBar2R = new Shape(window.getGraphPanelWidth() / 4
                    * column - GLYPH_OFFSET_X + BLACK_BAR_WIDTH, row * window
                        .getGraphPanelHeight() / 4 + (row * GLYPH_GAP_Y)
                        - GLYPH_OFFSET_Y + (GLYPH_BAR_HEIGHT * 1),
                    (GLYPH_INCREMENT_X * ((int)(ratios[5] * 100))),
                    GLYPH_BAR_HEIGHT, EXAMPLE_ATTRIBUTE2);
                Shape glyphBar3R = new Shape(window.getGraphPanelWidth() / 4
                    * column - GLYPH_OFFSET_X + BLACK_BAR_WIDTH, row * window
                        .getGraphPanelHeight() / 4 + (row * GLYPH_GAP_Y)
                        - GLYPH_OFFSET_Y + (GLYPH_BAR_HEIGHT * 2),
                    (GLYPH_INCREMENT_X * ((int)(ratios[6] * 100))),
                    GLYPH_BAR_HEIGHT, EXAMPLE_ATTRIBUTE3);
                Shape glyphBar4R = new Shape(window.getGraphPanelWidth() / 4
                    * column - GLYPH_OFFSET_X + BLACK_BAR_WIDTH, row * window
                        .getGraphPanelHeight() / 4 + (row * GLYPH_GAP_Y)
                        - GLYPH_OFFSET_Y + (GLYPH_BAR_HEIGHT * 3),
                    (GLYPH_INCREMENT_X * ((int)(ratios[7] * 100))),
                    GLYPH_BAR_HEIGHT, EXAMPLE_ATTRIBUTE4);

                Shape glyphBar1L = new Shape(window.getGraphPanelWidth() / 4
                    * column - GLYPH_OFFSET_X - (GLYPH_INCREMENT_X
                        * ((int)(ratios[0] * 100))), row * window
                            .getGraphPanelHeight() / 4 + (row * GLYPH_GAP_Y)
                            - GLYPH_OFFSET_Y + (GLYPH_BAR_HEIGHT * 0),
                    (GLYPH_INCREMENT_X * ((int)(ratios[0] * 100))),
                    GLYPH_BAR_HEIGHT, EXAMPLE_ATTRIBUTE1);

                Shape glyphBar2L = new Shape(window.getGraphPanelWidth() / 4
                    * column - GLYPH_OFFSET_X - (GLYPH_INCREMENT_X
                        * ((int)(ratios[1] * 100))), row * window
                            .getGraphPanelHeight() / 4 + (row * GLYPH_GAP_Y)
                            - GLYPH_OFFSET_Y + (GLYPH_BAR_HEIGHT * 1),
                    (GLYPH_INCREMENT_X * ((int)(ratios[1] * 100))),
                    GLYPH_BAR_HEIGHT, EXAMPLE_ATTRIBUTE2);

                Shape glyphBar3L = new Shape(window.getGraphPanelWidth() / 4
                    * column - GLYPH_OFFSET_X - (GLYPH_INCREMENT_X
                        * ((int)(ratios[2] * 100))), row * window
                            .getGraphPanelHeight() / 4 + (row * GLYPH_GAP_Y)
                            - GLYPH_OFFSET_Y + (GLYPH_BAR_HEIGHT * 2),
                    (GLYPH_INCREMENT_X * ((int)(ratios[2] * 100))),
                    GLYPH_BAR_HEIGHT, EXAMPLE_ATTRIBUTE3);

                Shape glyphBar4L = new Shape(window.getGraphPanelWidth() / 4
                    * column - GLYPH_OFFSET_X - (GLYPH_INCREMENT_X
                        * ((int)(ratios[3] * 100))), row * window
                            .getGraphPanelHeight() / 4 + (row * GLYPH_GAP_Y)
                            - GLYPH_OFFSET_Y + (GLYPH_BAR_HEIGHT * 3),
                    (GLYPH_INCREMENT_X * ((int)(ratios[3] * 100))),
                    GLYPH_BAR_HEIGHT, EXAMPLE_ATTRIBUTE4);

                TextShape exampleSong = new TextShape(window
                    .getGraphPanelWidth() / 4 * column - GLYPH_OFFSET_X - 30,
                    (row * window.getGraphPanelHeight() / 4 + (row
                        * GLYPH_GAP_Y) - GLYPH_OFFSET_Y) - 60, this.musicCalc
                            .getGlyphList().get(counter).getSong().getTitle());
                TextShape exampleArtist = new TextShape(window
                    .getGraphPanelWidth() / 4 * column - GLYPH_OFFSET_X - 16,
                    (row * window.getGraphPanelHeight() / 4 + (row
                        * GLYPH_GAP_Y) - GLYPH_OFFSET_Y) - 40, this.musicCalc
                            .getGlyphList().get(counter).getSong().getArtist());

                exampleSong.setBackgroundColor(Color.white);
                exampleArtist.setBackgroundColor(Color.white);

                window.addShape(exampleSong);
                window.addShape(exampleArtist);

                window.addShape(glyphBar1R);
                window.addShape(glyphBar2R);
                window.addShape(glyphBar3R);
                window.addShape(glyphBar4R);
                window.addShape(glyphBar1L);
                window.addShape(glyphBar2L);
                window.addShape(glyphBar3L);
                window.addShape(glyphBar4L);

                counter++;
            }
        }

    }


    public void clickedRepHobby(Button button) {
        this.repBy = "Hobby";

        this.attOne = "Read";
        this.attTwo = "Art";
        this.attThree = "Sports";
        this.attFour = "Music";
        this.window.removeAllShapes();
        this.glyphBars();
        this.legendText();
        this.counter = this.currentPage * 9;
    }


    public void clickedRepRegion(Button button) {
        this.repBy = "Region";
        this.attOne = "Northeast US";
        this.attTwo = "Southeast US";
        this.attFour = "Outside the US";
        this.attThree = "The Rest Of US";
        this.window.removeAllShapes();
        this.glyphBars();
        this.legendText();
        this.counter = this.currentPage * 9;
    }


    public void clickedRepMajor(Button button) {
        this.repBy = "Major";
        this.attOne = "Computer Science";
        this.attThree = "CMDA or Math";
        this.attFour = "Other";
        this.attTwo = "Other Engineering";
        this.window.removeAllShapes();
        this.glyphBars();
        this.legendText();
        this.counter = this.currentPage * 9;
    }


    public void clickedQuit(Button button) {
        System.exit(0);
    }


    public void clickedPrev(Button button) {
        if (this.currentPage == 0) {
            this.prev.disable();
            return;
        }
        this.currentPage--;
        if (0 == this.currentPage) {
            this.prev.disable();
        }
        this.next.enable();

        this.counter = this.currentPage * 9;
        this.window.removeAllShapes();
        this.legendText();
        this.glyphBars();
        this.counter = this.currentPage * 9;

    }


    public void clickedNext(Button button) {

        if (this.numPages == this.currentPage) {
            this.next.disable();
            return;
        }
        this.currentPage++;
        if (this.numPages == this.currentPage) {
            this.next.disable();
        }
        this.counter = this.currentPage * 9;
        this.prev.enable();
        this.window.removeAllShapes();
        this.legendText();
        this.glyphBars();
        this.counter = this.currentPage * 9;

    }


    public void clickedSortByArtist(Button button) {

        this.musicCalc.sortGlyphs("artist");
        this.window.removeAllShapes();
        this.legendText();
        this.glyphBars();
        this.counter = this.currentPage * 9;
    }


    public void clickedSortByGenere(Button button) {

        this.musicCalc.sortGlyphs("genre");
        this.window.removeAllShapes();
        this.legendText();
        this.glyphBars();
        this.counter = this.currentPage * 9;
    }


    public void clickedSortByYear(Button button) {

        this.musicCalc.sortGlyphs("date");
        this.window.removeAllShapes();
        this.legendText();
        this.glyphBars();
        this.counter = this.currentPage * 9;
    }


    public void clickedSortByTitle(Button button) {

        this.musicCalc.sortGlyphs("title");
        this.window.removeAllShapes();
        this.legendText();
        this.glyphBars();
        this.counter = this.currentPage * 9;
    }
}
