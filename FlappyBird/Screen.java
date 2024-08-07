import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

class Screen extends Canvas{
    Main obj;
    Random r = new Random();
    boolean end = false;
    double score = 0;
    public Screen(Main obj) {
        this.obj = obj;
        
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                update(getGraphics());
            }
        }, 1000, 50);
        
        setBackground(Color.CYAN);
        setSize(500, 500);
    }
    
    public void paint(Graphics g) {
        g.setFont(obj.f);
        if (end) {
            g.drawString("Game Over!", 75, 250);
            return;
        }
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 500, 500);
        for (Rect i : obj.rects) {
            g.setColor(i.color);
            g.fillRect(i.rect[0], i.rect[1], i.rect[2], i.rect[3]);
        }
        g.setColor(Color.BLACK);
        g.drawString(Integer.toString((int)score), 230, 38);
    }
    
    public void update(Graphics g) {
        if (end) {
            return;
        }
        for (Rect i : obj.rects) {
            if (i.id == 'b') {
                i.updatePosition(0, obj.gravity-obj.birdSpeed);
            } else if (i.id == 'B' || i.id == 't') {
                if (i.rect[0] < -50) {
                    if (r.nextInt(100)%2 == 0) {
                        obj.topPipe.rect[3] = 85;
                        obj.bottomPipe.rect[1] = 275;
                        obj.bottomPipe.rect[3] = 185;
                    } else {
                        obj.topPipe.rect[3] = 185;
                        obj.bottomPipe.rect[1] = 375;
                        obj.bottomPipe.rect[3] = 85;
                    }
                    i.updatePosition(500, 0);
                    score += 0.5;
                } else {
                    i.updatePosition(-obj.pipeSpeed, 0);
                }
            }
        }
        
        if (obj.birdSpeed > 0) {
            obj.birdSpeed--;
        }
        if (obj.bird.rect[1] + obj.bird.rect[3] >= 460) {
            end = true;
        }
        if (obj.bird.rect[1] <= 40) {
            end = true;
        }
        if (obj.bird.rect[0] + obj.bird.rect[2] >= obj.topPipe.rect[0] &&
            obj.bird.rect[0] <= obj.topPipe.rect[0] + obj.topPipe.rect[2] &&
            obj.bird.rect[1] + obj.bird.rect[3] >= obj.topPipe.rect[1] &&
            obj.bird.rect[1] <= obj.topPipe.rect[1] + obj.topPipe.rect[3]
           ) {
            end = true;
        }
        if (obj.bird.rect[0] + obj.bird.rect[2] >= obj.bottomPipe.rect[0] &&
            obj.bird.rect[0] <= obj.bottomPipe.rect[0] + obj.bottomPipe.rect[2] &&
            obj.bird.rect[1] + obj.bird.rect[3] >= obj.bottomPipe.rect[1] &&
            obj.bird.rect[1] <= obj.bottomPipe.rect[1] + obj.bottomPipe.rect[3]
           ) {
            end = true;
        }

        paint(g);
    }
}
