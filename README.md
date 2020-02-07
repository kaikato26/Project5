
MUSIC VISUALIZATION PROJECT
Takes in survey data from a spreadsheet presents it visually.

How to run:
- make sure you have spread sheet of songs and spreadsheet of consumer data in the same folder
- input file names into the commandline arguments of the file ProjectRunner (songfile, surveydatafile)
- make sure you have the provided libraries in the buildpath of the project (CarranoDataStructureLib, CS2114-Support, and GraphWindowLib)
- run the ProjectRunner file to show data visualization

Song file format:

SongName-----|Artist-----|Year-----|Genre-----|
exSong        exArtist    exYear    exGenre

Song data must be formated into columns as shown above

Survey data file format:

Submisson# | Time Taken | Major | Region | Hobby | Heard1 | Liked1 | Heard2 | Liked2 | ... HeardN | LikedN

Survey data must be formated into columns shown above.
-Each row on the survey data should represent one persons data
-Different Majors include Math or CMDA, Computer Science, Other, and Other Engineering
-Different Regions include Northeast, Outside of United States, United States (other than Southeast or Northwest), and Southeast
-Different Hobbies include music, reading, sports, and art
