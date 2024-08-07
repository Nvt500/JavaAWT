import java.awt.*; 
import java.awt.event.*;
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 
import java.util.HashMap;

public class Main extends Frame { 
    Color penColor = Color.BLACK;
    Color backgroundColor = Color.WHITE;
    int radius = 20;
    String shape = "Circle";
    Draw d = new Draw(this);
    Main() 
    { 
        add(d);
        
        HashMap<String, Color> colors = new HashMap<String, Color>();
        colors.put("Black", Color.BLACK);
        colors.put("White", Color.WHITE);
        colors.put("Gray", Color.GRAY);
        colors.put("Red", Color.RED);
        colors.put("Orange", Color.ORANGE);
        colors.put("Yellow", Color.YELLOW);
        colors.put("Green", Color.GREEN);
        colors.put("Blue", Color.BLUE);
        colors.put("Magenta", Color.MAGENTA);
        colors.put("Pink", Color.PINK);
        
        Choice c = new Choice();
        c.setBounds(200, 30, 75, 50);
        
        Choice c2 = new Choice();
        c2.setBounds(120, 30, 75, 50);
        
        Choice c3 = new Choice();
        c3.setBounds(20, 30, 95, 50);
        c3.add("Circle");
        c3.add("Square");
        c3.add("Triangle");
        
        for (String col : colors.keySet()) {
            c.add(col);
            c2.add(col);
        }
        c.select("Black");
        c2.select("White");
        
        c.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                for (String col : colors.keySet()) {
                    if (c.getSelectedItem().equals(col)) {
                        penColor = colors.get(col);
                    }
                }
            }
        });
        
        c2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                for (String col : colors.keySet()) {
                    if (c2.getSelectedItem().equals(col)) {
                        d.changeBackgroundColor(colors.get(col));
                    }
                }
            }
        });
        
        c3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (c3.getSelectedItem().equals("Circle")) {
                    shape = "Circle";
                } else if (c3.getSelectedItem().equals("Square")) {
                    shape = "Square";
                } else if (c3.getSelectedItem().equals("Triangle")) {
                    shape = "Triangle";
                } 
            }
        });
        
        Scrollbar s = new Scrollbar();
        s.setMaximum(100);
        s.setMinimum(10);
        s.setValue(20);
        s.setOrientation(0);
        s.setBounds(280, 30, 200, 50);
        
        s.addAdjustmentListener(new AdjustmentListener() {
           public void adjustmentValueChanged(AdjustmentEvent e) {
               radius = s.getValue();
           } 
        });
        
        Label l = new Label("Shape of Pen", 2);
        l.setBounds(15, 0, 95, 30);
        
        Label l2 = new Label("Background", 2);
        l2.setBounds(120, 0, 80, 30);
        
        Label l3 = new Label("Pen Color", 2);
        l3.setBounds(195, 0, 75, 30);
        
        Label l4 = new Label("Pen Size", 2);
        l4.setBounds(275, 0, 125, 30);
        
        add(s);
        add(c); 
        add(c2);
        add(c3);
        add(l);
        add(l2);
        add(l3);
        add(l4);
        
        setSize(500, 500);
        setBackground(Color.WHITE);
        setTitle("Main");
        setLayout(null);
        setVisible(true);
        
        addWindowListener(new WindowAdapter() { 
            @Override
            public void windowClosing(WindowEvent e) 
            { 
                System.exit(0); 
            } 
        }); 
    } 

    public static void main(String[] args) 
    { 
        Main frame = new Main(); 
    } 
}
