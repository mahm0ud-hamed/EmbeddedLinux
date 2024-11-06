# introduction to JAVAFX 8 

## JAVA AWT 
- Java AWT (Abstract Window Toolkit) is an API to develop Graphical User Interface (GUI) or windows-based applications in Java.

- **Why AWT is platform independent?**
Java AWT calls the native platform calls the native platform (operating systems) subroutine for creating API components like TextField, ChechBox, button, etc.

For example, an AWT GUI with components like TextField, label and button will have different look and feel for the different platforms like Windows, MAC OS, and Unix. The reason for this is the platforms have different view for their native components and AWT directly calls the native subroutine that creates those components.

In simple words, an AWT application will look like a windows application in Windows OS whereas it will look like a Mac application in the MAC OS.

- AWT is usede resource of operating system it heavy weight because it use native resources and this will be a compiler in betwwen 

## JAVA SWING 
- is a part of Java Foundation Classes (JFC) that is used to create window-based applications. It is built on the top of AWT (Abstract Windowing Toolkit) API and entirely written in java.

- Unlike AWT, Java Swing provides platform-independent and lightweight components.

- java.swing -> light weight than awt , and GUI is not  displayed in OS view . 
- plugagable look and feel -> like launcher which is change ui only which is used by MVC design pattern model view controller 


## JAVAFX 

- **What is JavaFX?**
- JavaFX is a Java library used to develop Desktop applications as well as Rich Internet Applications (RIA). The applications built in JavaFX, can run on multiple platforms including Web, Mobile and Desktops

- model -> bussiness logic -> any thing related to data 
- view -> how to view data how you will display data 
- contoller -> the middle were between data and view  read data from data and hnadle it to view it usibg view 

- maintinabilty 
- extendability 

- frame - TOP  level continer like window has maxmize and miinimize 

- itermidiate contaier will be  *pane like Stackpane

- satage show one secene at a time 
- fx ui component are not thread safe 

- launch method will not return after it finish its work until user close program or u kill it using paltform.stop 

- its not allowed to make any stage or any scene in launcher thread only you can make this only  in application thread 

- javafx runtime what will create two thread launcher  thread and application thread 

- if you have a custom thread that need to do lenghty operation and it also need to make an edit in ui and it not allowed to make ui in another than application thread so make lenghty operation on thread and make ui edit in application thread 

- so make it as callback using paltform.runlater(runabble object );

