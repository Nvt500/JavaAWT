import java.awt.*; 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent;

public class Main extends Frame implements KeyListener{
    int[] r1 = {50, 240, 20, 20};
    Rect bird = new Rect(r1, Color.BLACK, 'b');
    int[] r2 = {0, 460, 500, 40};
    Rect ground = new Rect(r2, Color.DARK_GRAY, 'g');
    int[] r3 = {0, 0, 500, 40};
    Rect clouds = new Rect(r3, Color.WHITE, 'c');
    int[] r4 = {450, 40, 50, 135};
    Rect topPipe = new Rect(r4, Color.GREEN, 't');
    int[] r5 = {450, 325, 50, 135};
    Rect bottomPipe = new Rect(r5, Color.GREEN, 'B');
   
    Rect[] rects = {bird, ground, clouds, topPipe, bottomPipe};
    
    int pipeSpeed = 5;
    int birdSpeed = 0;
    int gravity = 10;
    
    Font f = new Font("Serif", Font.BOLD, 50);
    
    public Main() {
        addKeyListener(this);
        add(new Screen(this));
        
        setSize(500, 500);
        setBackground(Color.WHITE);
        setTitle("Main");
        setLayout(null);
        setVisible(true);
        
        addWindowListener(new WindowAdapter() { 
            @Override
            public void windowClosing(WindowEvent e) { 
                System.exit(0); 
            } 
        }); 
    } 

    public static void main(String[] args) { 
        Main frame = new Main(); 
    } 

    public void keyPressed(KeyEvent e) {}    
    
    public void keyReleased (KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            birdSpeed = 20;
        }
    }    
    
    public void keyTyped(KeyEvent e) {}    
}

class Rect {
    int[] rect;
    Color color;
    char id;
    public Rect(int[] rect, Color color, char id) {
        this.rect = rect;
        this.color = color;
        this.id = id;
    }
    
    public boolean checkCollision(int[] r) {
        return true;
    }
    
    public void updatePosition(int x, int y) {
        this.rect[0] += x;
        this.rect[1] += y;
    }
}
