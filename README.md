# Mock Voding App made in Java Swing
To add voting options to the UI using Intellij:
1) Click and drag JRadioButton next to the other buttons.
2) Change the "Button Group" property on your new Radio Button to candidate.
3) Set the "text" property to whatever you want to show on the UI as a voting option. This string will be sent to the flask server.
4) To change the window label text, App.java line 89 has the following line, change it to change the text:
  JFrame frame = new JFrame("Pretend this is a phone");
5) To create an exicutable .jar file, click the "Build" menu, and click "Build Artifacts".  
(steps 1, 2, and 3 visualized in readme.jpg)
