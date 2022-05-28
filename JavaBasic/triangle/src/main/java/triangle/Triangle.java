package triangle;

import static java.lang.Math.*;

class Triangle {

    private final Point a, b, c;

    public Triangle(Point a, Point b, Point c) {

        this.a = a;
        this.b = b;
        this.c = c;
        if ((a.getX()-b.getX())*(c.getY()-b.getY())-(a.getY()-b.getY())*(c.getX()-b.getX())==0)
            throw new IllegalArgumentException("Triangle is degenerative.");

    }

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

    public Point centroid(){

        double sum_x = a.getX() + b.getX() + c.getX();
        double sum_y = a.getY() + b.getY() + c.getY();

        double mean_x = sum_x / 3;
        double mean_y = sum_y / 3;

        return new Point(mean_x,mean_y);
    }

}
