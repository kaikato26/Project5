package project5;


import student.TestCase;

public class SongTest extends TestCase {

   
        
        private Song song1;
        private Song song2;
        private Song song3;
        
        
        public void setUp()
        {
            song1 = new Song("Travis Scott", "Butterfly Effect", "Pop", 2018);
            song2 = new Song("Travis Scott", "Sicko Mode", "Pop", 2018);
            song3 = new Song("Travis Scott", "Butterfly Effect", "Pop", 2018);
        }
        
        public void testGetArtist()
        {
            assertEquals("Travis Scott", song1.getArtist());
        }
        
        public void testGetTitle()
        {
            assertEquals("Butterfly Effect", song1.getTitle()); 
        }
        
        public void testGetGenre()
        {
            assertEquals("Pop", song1.getGenre()); 
        }
        
        public void testGetDate()
        {
            assertEquals(2018, song1.getDate()); 
        }
        
        public void testToString()
        {
            String str = "Song Title: Butterfly Effect\n" + "Artist: Travis Scott\n"
                + "Genre: Pop\n" + "Year: 2018";
            
            assertEquals(str, song1.toString());
            
        }
        
        public void testEquals()
        {
            Object obj = null;
            assertFalse(song1.equals(obj));

            obj = new Object();
            assertFalse(song1.equals(obj)); 

            assertTrue(song1.equals(song3));
            assertFalse(song1.equals(song2));
            
        }
        
    }

