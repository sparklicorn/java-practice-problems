package sparklicorn.geometry;

public class Rectangle {

	final Point[] points;
	
	Rectangle(Point p1, Point p2, Point p3, Point p4) {
		this.points = new Point[] { p1, p2, p3, p4 };
	}
}
