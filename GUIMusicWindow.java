package Proj5;

import java.awt.Color;
import java.util.HashMap;
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
    public static final int GLYPH_INCREMENT_X = 5;
    public static final int GLYPH_BAR_HEIGHT = BLACK_BAR_HEIGHT / 4;
    public static final int GLYPH_BAR_WIDTH = 15;
    public static final int GLYPH_BAR_EXAMPLE_NUMBER = 15;
    
    public static final int LEGEND_X_LOC = 1600;
    public static final int LEGEND_Y_LOC = 500;
    public static final int LEGEND_OUTLINE = 3;
    public static final int LEGEND_WIDTH = 250;
    public static final int LEGEND_HEIGHT = 350;
    public static final int LEGEND_TEXT_OFFSET = 20;
    
    public static final Color EXAMPLE_ATTRIBUTE1 = Color.blue;
    public static final Color EXAMPLE_ATTRIBUTE2 = Color.orange;
    public static final Color EXAMPLE_ATTRIBUTE3 = Color.green;
    public static final Color EXAMPLE_ATTRIBUTE4 = Color.red;

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


    public GUIMusicWindow() {
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
        for (int row = 1; row < 4; row++) {
            for (int column = 1; column < 4; column++) {
                Shape blackBar = new Shape(window.getGraphPanelWidth() / 4
                    * column - GLYPH_OFFSET_X, row * window
                        .getGraphPanelHeight() / 4 + (row * GLYPH_GAP_Y)
                        - GLYPH_OFFSET_Y, BLACK_BAR_WIDTH, BLACK_BAR_HEIGHT,
                    Color.black);
                window.addShape(blackBar);
            }
        }
        

        this.glyphBars();
        
        //Legend box
        Shape legendOutside = new Shape(LEGEND_X_LOC,LEGEND_Y_LOC,LEGEND_WIDTH,LEGEND_HEIGHT,Color.black);
        window.addShape(legendOutside);
        Shape legendInside = new Shape(LEGEND_X_LOC+LEGEND_OUTLINE,LEGEND_Y_LOC+LEGEND_OUTLINE,LEGEND_WIDTH-2*LEGEND_OUTLINE,LEGEND_HEIGHT-2*LEGEND_OUTLINE,Color.white);
        window.addShape(legendInside);
        window.moveToFront(legendInside);
        
        
        
        
        //Legend text
        this.legendText();
        
        Shape legendBlackBar = new Shape(LEGEND_X_LOC +LEGEND_WIDTH/2-(BLACK_BAR_WIDTH/2),LEGEND_Y_LOC+180, BLACK_BAR_WIDTH, BLACK_BAR_HEIGHT, Color.black);
        window.addShape(legendBlackBar);
        window.moveToFront(legendBlackBar);
        
        TextShape songTitleText = new TextShape(LEGEND_X_LOC+LEGEND_WIDTH/2-(BLACK_BAR_WIDTH*2)+5,LEGEND_Y_LOC+170,"Song title");
        TextShape heardText = new TextShape(LEGEND_X_LOC+LEGEND_WIDTH/2-(BLACK_BAR_WIDTH*3),LEGEND_Y_LOC+230,"Heard");
        TextShape likesText = new TextShape(LEGEND_X_LOC+LEGEND_WIDTH/2+(BLACK_BAR_WIDTH),LEGEND_Y_LOC+230,"Likes");
        
        songTitleText.setBackgroundColor(Color.white);
        heardText.setBackgroundColor(Color.white);
        likesText.setBackgroundColor(Color.white);
        
        window.addShape(songTitleText);
        window.addShape(heardText);
        window.addShape(likesText);
        
        window.moveToFront(songTitleText);
        window.moveToFront(heardText);
        window.moveToFront(likesText);
    }


    private void update() {
        
    }

    private void legendText() {
        TextShape attribute1Text = new TextShape(LEGEND_X_LOC+LEGEND_TEXT_OFFSET,LEGEND_Y_LOC+LEGEND_TEXT_OFFSET*2,"ATTRIBUTE 1");
        TextShape attribute2Text = new TextShape(LEGEND_X_LOC+LEGEND_TEXT_OFFSET,LEGEND_Y_LOC+LEGEND_TEXT_OFFSET*3,"ATTRIBUTE 2");
        TextShape attribute3Text = new TextShape(LEGEND_X_LOC+LEGEND_TEXT_OFFSET,LEGEND_Y_LOC+LEGEND_TEXT_OFFSET*4,"ATTRIBUTE 3");
        TextShape attribute4Text = new TextShape(LEGEND_X_LOC+LEGEND_TEXT_OFFSET,LEGEND_Y_LOC+LEGEND_TEXT_OFFSET*5,"ATTRIBUTE 4");
        
        TextShape legendText = new TextShape(LEGEND_X_LOC+LEGEND_TEXT_OFFSET,LEGEND_Y_LOC+LEGEND_TEXT_OFFSET," Legend");
        
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
        Shape glyphBar1R = new Shape(window.getGraphPanelWidth() / 4 * column
            - GLYPH_OFFSET_X + BLACK_BAR_WIDTH, row*window.getGraphPanelHeight() / 4
                + (row*GLYPH_GAP_Y) - GLYPH_OFFSET_Y + (GLYPH_BAR_HEIGHT * 0),
            GLYPH_INCREMENT_X * GLYPH_BAR_EXAMPLE_NUMBER, GLYPH_BAR_HEIGHT,
            EXAMPLE_ATTRIBUTE1);
        Shape glyphBar2R = new Shape(window.getGraphPanelWidth() / 4 * column
            - GLYPH_OFFSET_X + BLACK_BAR_WIDTH, row*window.getGraphPanelHeight() / 4
                + (row*GLYPH_GAP_Y) - GLYPH_OFFSET_Y + (GLYPH_BAR_HEIGHT * 1),
            GLYPH_INCREMENT_X * GLYPH_BAR_EXAMPLE_NUMBER, GLYPH_BAR_HEIGHT,
            EXAMPLE_ATTRIBUTE2);
        Shape glyphBar3R = new Shape(window.getGraphPanelWidth() / 4 * column
            - GLYPH_OFFSET_X + BLACK_BAR_WIDTH, row*window.getGraphPanelHeight() / 4
                + (row*GLYPH_GAP_Y) - GLYPH_OFFSET_Y + (GLYPH_BAR_HEIGHT * 2),
            GLYPH_INCREMENT_X * GLYPH_BAR_EXAMPLE_NUMBER, GLYPH_BAR_HEIGHT,
            EXAMPLE_ATTRIBUTE3);
        Shape glyphBar4R = new Shape(window.getGraphPanelWidth() / 4 * column
            - GLYPH_OFFSET_X + BLACK_BAR_WIDTH, row*window.getGraphPanelHeight() / 4
                + (row*GLYPH_GAP_Y) - GLYPH_OFFSET_Y + (GLYPH_BAR_HEIGHT * 3),
            GLYPH_INCREMENT_X * GLYPH_BAR_EXAMPLE_NUMBER, GLYPH_BAR_HEIGHT,
            EXAMPLE_ATTRIBUTE4);

        Shape glyphBar1L = new Shape(window.getGraphPanelWidth() / 4 * column
            - GLYPH_OFFSET_X  - GLYPH_INCREMENT_X * GLYPH_BAR_EXAMPLE_NUMBER, row*window.getGraphPanelHeight() / 4
                + (row*GLYPH_GAP_Y) - GLYPH_OFFSET_Y + (GLYPH_BAR_HEIGHT * 0),
            GLYPH_INCREMENT_X * GLYPH_BAR_EXAMPLE_NUMBER, GLYPH_BAR_HEIGHT,
            EXAMPLE_ATTRIBUTE1);
        
        Shape glyphBar2L = new Shape(window.getGraphPanelWidth() / 4 * column
            - GLYPH_OFFSET_X  - GLYPH_INCREMENT_X * GLYPH_BAR_EXAMPLE_NUMBER, row*window.getGraphPanelHeight() / 4
                + (row*GLYPH_GAP_Y) - GLYPH_OFFSET_Y + (GLYPH_BAR_HEIGHT * 1),
            GLYPH_INCREMENT_X * GLYPH_BAR_EXAMPLE_NUMBER, GLYPH_BAR_HEIGHT,
            EXAMPLE_ATTRIBUTE2);
        
        Shape glyphBar3L = new Shape(window.getGraphPanelWidth() / 4 * column
            - GLYPH_OFFSET_X  - GLYPH_INCREMENT_X * GLYPH_BAR_EXAMPLE_NUMBER, row*window.getGraphPanelHeight() / 4
                + (row*GLYPH_GAP_Y) - GLYPH_OFFSET_Y + (GLYPH_BAR_HEIGHT * 2),
            GLYPH_INCREMENT_X * GLYPH_BAR_EXAMPLE_NUMBER, GLYPH_BAR_HEIGHT,
            EXAMPLE_ATTRIBUTE3);
        
        Shape glyphBar4L = new Shape(window.getGraphPanelWidth() / 4 * column
            - GLYPH_OFFSET_X  - GLYPH_INCREMENT_X * GLYPH_BAR_EXAMPLE_NUMBER, row*window.getGraphPanelHeight() / 4
                + (row*GLYPH_GAP_Y) - GLYPH_OFFSET_Y + (GLYPH_BAR_HEIGHT * 3),
            GLYPH_INCREMENT_X * GLYPH_BAR_EXAMPLE_NUMBER, GLYPH_BAR_HEIGHT,
            EXAMPLE_ATTRIBUTE4);
        
        window.addShape(glyphBar1R);
        window.addShape(glyphBar2R);
        window.addShape(glyphBar3R);
        window.addShape(glyphBar4R);
        window.addShape(glyphBar1L);
        window.addShape(glyphBar2L);
        window.addShape(glyphBar3L);
        window.addShape(glyphBar4L);
            }
        }
        
        TextShape exampleSong = new TextShape(window.getGraphPanelWidth() / 4 - GLYPH_OFFSET_X - BLACK_BAR_WIDTH,115,"Kid Cudi");
        TextShape exampleArtist = new TextShape(window.getGraphPanelWidth() / 4 - GLYPH_OFFSET_X - BLACK_BAR_WIDTH - 20,130,"by Playboi Carti");
        
        exampleSong.setBackgroundColor(Color.white);
        exampleArtist.setBackgroundColor(Color.white);
        
        window.addShape(exampleSong);
        window.addShape(exampleArtist);


    }


    public void clickedRepHobby(Button button) {

    }


    public void clickedRepRegion(Button button) {

    }


    public void clickedRepMajor(Button button) {

    }


    public void clickedQuit(Button button) {

    }


    public void clickedPrev(Button button) {

    }


    public void clickedNext(Button button) {

    }


    public void clickedbyArtist(Button button) {

    }


    public void clickedbyGenere(Button button) {

    }


    public void clickedbyYear(Button button) {

    }


    public void clickedByTitle(Button button) {

    }
}
