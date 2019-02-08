# CsvToDb
Practice Scenario: This projects goal is to take a .csv file of specific data, 
read in and then parse that data into either a sqlite in-memory database or 
back out into a new .csv file based of if the data entry has any missing elements.

Built with:
  - Maven -https://maven.apache.org/
  - Maven Assembly Plugin -http://maven.apache.org/plugins/maven-assembly-plugin/
  - SQLite JDBC -https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc
  - Hibernate ORM -http://hibernate.org/orm/
  - SQLite Dialect -https://github.com/gwenn/sqlite-dialect
  - Opencsv -http://opencsv.sourceforge.net/
  
To run the the project open the target subfolder and doubleclick the csvtodb-1.0.0-jar-with-dependencies.jar file
Once opened select the .csv file you wish to upload and a appropriate path for bad csv files to be placed and then click
load file. Press the view database contents to view the good data that was just uploaded into the db and check your output 
filepath for the the bad entries csv files. log file are placed in the home directory, usually C:\Users\"yourname"


Approach:
  My initial approach was to breakdown the project into smaller usecases, which was already essentially done within the requirements
  I then took some time and tried to research some opensource tools that could help with this project and how to use them.
  I decided to try to use maven, hibernate, and opencsv to try and make the project a little easier to construct. I had never used 
  these tools before this project but maven and hibernate seem like they are often used in professional settings so I went ahead 
  and tried learning by doing. During the construction phase I tried to adhere to a MVC design as much as possible and this is more 
  obvious in some areas than others.
  
