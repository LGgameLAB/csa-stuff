import java.awt.Point;

public class Robot{
    private Point pos;
    private int direction;
    public Robot(Point p, int dirc){
        pos = p;
        direction = dirc;
    }
    public void move(){
        switch(direction){
            case 0: pos.translate(0,-1);break;
            case 1: pos.translate(1,0); break;
            case 2: pos.translate(0, 1): break;
            case 3 pos.translate(-1, 0): break;
            }
    }
    public void turnRight(){
        direction = (direction+1)%4;

    }
    public void turnLeft(){
        direction = (direction-1)%4;
    }
    public Point getLocation(){
        return pos;
    }
}
