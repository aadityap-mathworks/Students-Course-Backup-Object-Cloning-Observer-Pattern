# CSX42: Assignment 2
## Name: Aaditya Sakharam Patil
-----------------------------------------------------------------------
-----------------------------------------------------------------------
###Assuming you are in the directory containing this README
-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on project.
#### Note: build.xml is present in studentCoursesBackup/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile studentCoursesBackup/src/build.xml clean

Description: It cleans up all the .class files that were generated when 
you compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentCoursesBackup/src/build.xml all

Description: Compiles code and generates .class files inside the BUILD 
folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile studentCoursesBackup/src/build.xml run -Darg0=src/input.txt -Darg1=src/delete.txt -Darg2=src/output1.txt -Darg3=src/output2.txt -Darg4=src/output3.txt
Note: For this command to work correctly place all the files in src directory. 
else, Arguments accept the absolute path of the files.

-----------------------------------------------------------------------
## Description:

Data Structure used: Binary Search Tree

Time Complexity:
Search node :O(log(n))
insert node: O(log(n))
BST: O(h) h--height

References:
BST and Node : 
https://www.sanfoundry.com/java-program-implement-binary-search-tree/
https://www.geeksforgeeks.org/

Clone:
https://programmingmitra.blogspot.com/2016/11/Java-Cloning-Types-of-Cloning-Shallow-Deep-in-Details-with-Example.html

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 10/06/2018

