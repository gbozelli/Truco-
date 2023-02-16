import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class frame extends JFrame{
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,
    bp,bm,bv,bd,
    be,bb = new JButton();
    frame frame;
    frame(){
        ImageIcon image = new ImageIcon("newaa.jpg");
        this.frame.setTitle("Calculator");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setSize(400,400);
        this.frame.setVisible(true);
        this.frame.setIconImage(image.getImage());
    }
}


