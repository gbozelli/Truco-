import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class frame extends JFrame{
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,
    bp,bm,bv,bd,
    be,bb,bs;
    frame(){
        b1 = new JButton();b2 = new JButton();b3 = new JButton();b4 = new JButton();
        b5 = new JButton();b6 = new JButton();b7 = new JButton();b8 = new JButton();
        b9 = new JButton();b0 = new JButton();
        bp = new JButton();bm = new JButton();bv = new JButton();bd = new JButton();
        be = new JButton();bb = new JButton();
        this.b1.setBounds(0, 0, 20, 40);
        this.add(b1);
        ImageIcon image = new ImageIcon("newaa.jpg");
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(400,400);
        this.setVisible(true);
        this.setIconImage(image.getImage());
    }
}


