import java.awt.*;
import java.awt.event.*;  
import java.lang.Math; 

class Draw extends Canvas implements MouseMotionListener{
    Main obj;
    Draw(Main obj) {
        this.obj = obj;
        addMouseMotionListener(this);
        
        setBackground(Color.WHITE);
        setBounds(0, 100, 500, 400);
        setSize(500, 400);
    }
    
    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        g.setColor(obj.penColor);
        if (obj.shape.equals("Circle")) {
            g.fillOval(e.getX()-(int)(obj.radius/2), e.getY()-(int)(obj.radius/2), obj.radius, obj.radius);
        } else if (obj.shape.equals("Square")) {
            g.fillRect(e.getX()-(int)(obj.radius/2), e.getY()-(int)(obj.radius/2), obj.radius, obj.radius);
        } else if (obj.shape.equals("Triangle")) {
            int a = obj.radius * (int)Math.sqrt(3);
            double A = Math.pow(obj.radius, 2) - Math.pow((a/2), 2);
            A = (int)Math.sqrt(A);
            int[] xValues = {e.getX(), e.getX()+(int)(a/2), e.getX()-(int)(a/2)};
            int[] yValues = {e.getY()-obj.radius, e.getY()+(int)A, e.getY()+(int)A};
            g.fillPolygon(xValues, yValues, 3);
        }
    }
    
    public void mouseMoved(MouseEvent e){}
    
    public void changeBackgroundColor(Color c) {
        setBackground(c);
    }
}
