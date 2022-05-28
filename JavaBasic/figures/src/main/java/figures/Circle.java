package figures;

class Circle extends Figure{
    private Point o;
    private double radius;

    public Circle(Point o, double radius) {
        this.o = o;
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String pointsToString() {
        return "(" + o.getX() + "," + o.getY() + ")";
    }

    @Override
    public String toString() {
        return "Circle[" + "(" + o.getX() + "," + o.getY() + ")" + radius + ']';
    }

    @Override
    public Point leftmostPoint() {
        return new Point(o.getX() - radius, o.getY());
    }
}
