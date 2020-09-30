Instructions:

The project is a stardard maven project and is under the jobsity folder.

Building the project:
From the command line, enter the jobsity folder and run:
mvn package

Running:
After building the project, enter the target/classes folder and run:
java com.jobsity.bowling.Bowling <path to the file with the game entries>

Four files with examples can be found under jobsity/src/main/resources (they will also be available in the target/classes folder after building the project):
- faults.txt - Example in which all moves are faults;
- jobsity.txt - Example provided by Jobsity;
- strikes.txt - Example in which all moves are strikes;
- zeroes.txt - Example in which all moves are zeroes;
