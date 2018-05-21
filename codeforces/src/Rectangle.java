
public class Rectangle {

	Point topLeft;
	int x;
	int y;
	int width;
	int height;
	
	public Rectangle(Point p, int width, int height) {
		topLeft.setLocation(p.getX(), p.getY());
		this.width = width;
		this.height = height;
	}
	
    public Rectangle(int x, int y, int width, int height) {
        if (width > 0 && height > 0) {
            this.width = width;
            this.height = height;
        } else {
            throw new IllegalArgumentException();
        }
        this.x = x;
        this.y = y;
    }

	public boolean contains(Point p) {
		return contains(p.getX(), p.getY());
	}
	
	public boolean contains(int x, int y) {
	    return (x <= this.getX() + width && x >= this.getX()) &&
	    		(y <= this.getY() + height && y >= this.getY());
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public Rectangle union(Rectangle rect) {
	    int newX = Math.min(this.getX(), rect.getX());
	    int newY = Math.min(this.getY(), rect.getY());
	    
	    int newWidth = Math.max(rect.getX() + rect.getWidth() - newX,
	        this.getX() + this.getWidth() - newX);
	    
	    int newHeight = Math.max(rect.getY() + rect.getHeight() - newY,
	        this.getY() + this.getHeight() - newY);
	    
	    return new Rectangle(newX, newY, newWidth, newHeight);
	}	
	
	public Rectangle intersection(Rectangle rect) {
	    if(this.getX() + this.getWidth() < rect.getX() ||
	        rect.getX() + rect.getWidth() < this.getX() ||
	        this.getY() + this.getHeight() < rect.getY() ||
	        rect.getY() + rect.getHeight() < this.getY())
	        return new Rectangle(0, 0, 0, 0);
	        
	    int startX = Math.max(this.getX(), rect.getX());
	    
	    int endX = Math.min(this.getX() + this.getWidth(),
	        rect.getX() + rect.getWidth());
	    
	    int startY = Math.max(this.getY(), rect.getY());
	    
	    int endY = Math.min(this.getY() + this.getHeight(),
	        rect.getY() + rect.getHeight());
	        
	    return new Rectangle(startX, startY, endX - startX, endY - startY);
	}

}
