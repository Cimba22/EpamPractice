package figures;

class Quadrilateral extends Figure{

    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        double ac_x = c.getX() - a.getX();
        double ac_y = c.getY() - a.getY();

        double bd_x = d.getX() - b.getX();
        double bd_y = d.getY() - b.getY();

        return Math.abs(ac_x * bd_y - bd_x * ac_y) / 2;
    }

    @Override
    public String pointsToString() {
        return "(" + a.getX() + "," + a.getY() + ")" +
                "(" + b.getX() + "," + b.getY() + ")" +
                "(" + c.getX() + "," + c.getY() + ")" +
                "(" + d.getX() + "," + d.getY() + ")";
    }

    @Override
    public String toString() {
        return "Quadrilateral[" + "(" + a.getX() + "," + a.getY() + ")" +
                "(" + b.getX() + "," + b.getY() + ")" +
                "(" + c.getX() + "," + c.getY() + ")" +
                "(" + d.getX() + "," + d.getY() + ")" + "]";
    }

    @Override
    public Point leftmostPoint() {
        if(a.getX() < b.getX() && a.getX() < c.getX() && a.getX() < d.getX())
            return a;
        else if(b.getX() < a.getX() && b.getX() < c.getX() && b.getX() < d.getX())
            return b;
        else if (c.getX() < a.getX() && c.getX() < b.getX() && c.getX() < d.getX())
            return c;
        else return d;
    }
}
