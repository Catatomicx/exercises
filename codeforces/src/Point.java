
public class Point {
	private int x;
	private int y;
	
	public Point() {
		this (0, 0);
	}
	
	public static void main(String[] args) {
		Point point = new Point(0, 0);
		Point point2 = new Point(2, 3);
		System.out.println(slope(point, point2));
	}
	
	public Point(int x, int y) {
		setLocation(x, y);
	}
	
	public double distanceFromOrigin() {
		return Math.sqrt(x * x + y * y);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public void translate(int dx, int dy) {
		setLocation(x + dx, y + dy);
	}
	
	public int quadrant() {
		if(x > 0 && y > 0)
			return 1;
		else if(x > 0 && y < 0)
			return 4;
		else if(x < 0 && y < 0)
			return 3;
		else return 2;
					
	}
	
	public void flip() {
		this.setLocation(-getY(), -getX());
	}
	
	public int manhatDist(Point that) {
		return Math.abs(this.getX() - that.getX()) + Math.abs(this.getY() - that.getY());
	}
	
	public boolean isVertical(Point that) {
		if(this.getX() == that.getX())
			return true;
		else
			return false;
	}
	
	public static double slope(Point p1, Point p2) {
		if(p1.getX() == p2.getX())
			throw new IllegalArgumentException("undefined slope");
		
		return (p2.getY() * 1.0 - p1.getY()) / (p2.getX() - p1.getX());
	}
	
	public boolean isCollinear(Point p1, Point p2) {
		double slope1 = slope(p1, p2);
		double slope2 = slope(this, p2);
		double slope3 = slope(p1, this);
		
		if(this.getX() == p1.getX() && p1.getX() == p2.getX())
			return true;
		
		if(slope1 != slope2 && slope1 != slope3 && slope2 != slope3)
			return false;

		return true;
	}
	
}
