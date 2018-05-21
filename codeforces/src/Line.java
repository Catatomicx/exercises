
public class Line {
    Point p1;
    Point p2;
    
    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    
    public Line(int x1, int y1, int x2, int y2) {
        p1 = new Point();
        p2 = new Point();
        p1.setLocation(x1, y1);
        p2.setLocation(x2, y2);
    }
    
    public boolean isCollinear(Point p) {
        if(p1.getX() == p2.getX())
            return p.getX() == p1.getX();
            
        double m1 = ((double) (p.getY() - p1.getY())) / (p.getX() - p1.getX());
        double m2 = ((double) (p.getY() - p2.getY())) / (p.getX() - p2.getX());
        
        return m1 == m2;
    }
    
    public Point getP1() {
        return p1;
    }
    
    public Point getP2() {
        return p2;
    }
    
    public String toString() {
        return "[" + p1.toString() + ", " + p2.toString() + "]";
    }
    
    public double getSlope() {
        return Point.slope(p1, p2);
    }
}