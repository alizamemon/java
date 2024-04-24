
package coachingcenter;

import javax.swing.JFrame;


public class Coachingcenter {


    public static void main(String[] args) {
        JFrame frame=new JFrame();
 frame.setBounds(50, 50, 800,600);
frame.setTitle("LOGIN PAGE");
gui1 g=new gui1();
frame.add(g);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    
}
