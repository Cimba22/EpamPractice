package figures;
import static java.lang.Math.sqrt;
class Triangle extends Figure{

    private final Point a;
    private final Point b;
    private final Point c;


    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if ((a.getX()-b.getX())*(c.getY()-b.getY())-(a.getY()-b.getY())*(c.getX()-b.getX())==0)
            throw new IllegalArgumentException("Triangle is degenerative.");

    }


    @Override
    public double area() {
        double ab_x = b.getX() - a.getX();
        double ab_y = b.getY() - a.getY();

        double ac_x = c.getX() - a.getX();
        double ac_y = c.getY() - a.getY();

        double bc_x = c.getX() - b.getX();
        double bc_y = c.getY() - b.getY();

        double ab = sqrt(ab_x * ab_x + ab_y * ab_y);
        double ac = sqrt(ac_x * ac_x + ac_y * ac_y);
        double bc = sqrt(bc_x * bc_x + bc_y * bc_y);



        double halfPerimeter = (ab + bc + ac) / 2;

        double areaHeron = sqrt(halfPerimeter * (halfPerimeter - ab) * (halfPerimeter - bc) * (halfPerimeter - ac));

        return areaHeron;

    }

    @Override
    public String pointsToString() {
        return "(" + a.getX() + "," + a.getY() + ")" +
                "(" + b.getX() + "," + b.getY() + ")" +
                "(" + c.getX() + "," + c.getY() + ")";
    }

    @Override
    public String toString() {
        return "Triangle[" + "(" + a.getX() + "," + a.getY() + ")" +
                "(" + b.getX() + "," + b.getY() + ")" +
                "(" + c.getX() + "," + c.getY() + ")" + "]";
    }

    @Override
    public Point leftmostPoint() {
        double min = Math.min(Math.min(a.getX(), b.getX()), c.getX());
        if(min == a.getX()) return a;
        else if(min == b.getX()) return b;
        else return c;
    }
}
