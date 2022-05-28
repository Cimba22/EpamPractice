package figures;

import static java.lang.Double.NaN;
import static java.lang.Double.isNaN;
class Quadrilateral extends Figure {

    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;
    double ab;
    double bc;
    double cd;
    double da;
    double ac;
    double bd;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        if (a == null || b == null || c == null || d == null) throw new IllegalArgumentException("Point is null.");
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

        double x1 = a.getX(), y1 = a.getY();
        double x2 = b.getX(), y2 = b.getY();
        double x3 = c.getX(), y3 = c.getY();
        double x4 = d.getX(), y4 = d.getY();
        double d1 = ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
        if (d1 != 0) {

            double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / d1;
            double u = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2)) / d1;
            if ((t >= 0.0 && t <= 1.0 && u >= 0.0 && u <= 1.0)) throw new IllegalArgumentException("Exception.");

        }

        x1 = a.getX();
        y1 = a.getY();
        x2 = d.getX();
        y2 = d.getY();
        x3 = c.getX();
        y3 = c.getY();
        x4 = b.getX();
        y4 = b.getY();
        d1 = ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
        if (d1 != 0) {

            double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / d1;
            double u = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2)) / d1;
            if ((t >= 0.0 && t <= 1.0 && u >= 0.0 && u <= 1.0)) throw new IllegalArgumentException("Exception");
        }


        ab = Math.sqrt((a.getX() - b.getX()) * (a.getX() - b.getX()) + (a.getY() - b.getY()) * (a.getY() - b.getY()));
        bc = Math.sqrt((c.getX() - b.getX()) * (c.getX() - b.getX()) + (c.getY() - b.getY()) * (c.getY() - b.getY()));
        cd = Math.sqrt((d.getX() - c.getX()) * (d.getX() - c.getX()) + (d.getY() - c.getY()) * (d.getY() - c.getY()));
        da = Math.sqrt((a.getX() - d.getX()) * (a.getX() - d.getX()) + (a.getY() - d.getY()) * (a.getY() - d.getY()));

        ac = Math.sqrt((a.getX() - c.getX()) * (a.getX() - c.getX()) + (a.getY() - c.getY()) * (a.getY() - c.getY()));
        bd = Math.sqrt((b.getX() - d.getX()) * (b.getX() - d.getX()) + (b.getY() - d.getY()) * (b.getY() - d.getY()));

        double s1 = (ab + bc + ac) / 2;
        double s2 = (ac + cd + da) / 2;

        double temp1 = Math.sqrt(s1 * (s1 - ab) * (s1 - bc) * (s1 - ac)) + Math.sqrt(s2 * (s2 - ac) * (s2 - cd) * (s2 - da));

        double s3 = (ab + bd + da) / 2;
        double s4 = (bc + cd + bd) / 2;
        double temp2 = Math.sqrt(s3 * (s3 - ab) * (s3 - bd) * (s3 - da)) + Math.sqrt(s4 * (s4 - bc) * (s4 - cd) * (s4 - bd));
        if (Math.abs(s1 - ab) <= 0.00001 || Math.abs(s1 - bc) <= 0.00001 || Math.abs(s1 - ac) <= 0.00001 || Math.abs(s2 - ac) <= 0.00001 || Math.abs(s2 - cd) <= 0.00001 || Math.abs(s2 - da) <= 0.00001)
            throw new IllegalArgumentException("Exception 3");
        if (Math.abs(s3 - ab) <= 0.00001 || Math.abs(s3 - bd) <= 0.00001 || Math.abs(s3 - da) <= 0.00001 || Math.abs(s4 - bc) <= 0.00001 || Math.abs(s4 - cd) <= 0.00001 || Math.abs(s4 - bd) <= 0.00001)
            throw new IllegalArgumentException("Exception 4");

        if (temp2 - temp1 >= 0.00001 || isNaN(temp2) || isNaN(temp1))
            throw new IllegalArgumentException("Exception 5");

    }

    @Override
    public Point centroid() {
        double x_abc = (((a.getX() + b.getX() + c.getX()) / 3));
        double y_abc = (((a.getY() + b.getY() + c.getY()) / 3));

        double x_adc = (((a.getX() + d.getX() + c.getX()) / 3));
        double y_adc = (((a.getY() + d.getY() + c.getY()) / 3));

        double x_abd = (((a.getX() + b.getX() + d.getX()) / 3));
        double y_abd = (((a.getY() + b.getY() + d.getY()) / 3));

        double x_dbc = (((d.getX() + b.getX() + c.getX()) / 3));
        double y_dbc = (((d.getY() + b.getY() + c.getY()) / 3));

        double d = (y_dbc - y_abd) * (x_adc - x_abc) - (x_dbc - x_abd) * (y_adc - y_abc);
        if(d == 0) return null;

        double ua = ((x_dbc - x_abd) * (y_abc - y_abd) - (y_dbc - y_abd) * (x_abc - x_abd))/ d;

        double x = x_abc + ua * (x_adc - x_abc);
        double y = y_abc + ua * (y_adc - y_abc);

        return new Point(x,y);
    }



    @Override
    public boolean isTheSame(Figure figure) {
        if (figure == null) return false;
        if (figure == this) return true;
        if (figure instanceof Quadrilateral) {
            if (a.isTheSame(((Quadrilateral)figure).a) || a.isTheSame(((Quadrilateral)figure).b) ||
                    a.isTheSame(((Quadrilateral)figure).c) || a.isTheSame(((Quadrilateral)figure).d)){
                if (b.isTheSame(((Quadrilateral)figure).a) || b.isTheSame(((Quadrilateral)figure).b) ||
                        b.isTheSame(((Quadrilateral)figure).c) || b.isTheSame(((Quadrilateral)figure).d)){
                    if (c.isTheSame(((Quadrilateral)figure).a) || c.isTheSame(((Quadrilateral)figure).b) ||
                            c.isTheSame(((Quadrilateral)figure).c) || c.isTheSame(((Quadrilateral)figure).d)){
                        return d.isTheSame(((Quadrilateral) figure).a) || d.isTheSame(((Quadrilateral) figure).b) ||
                                d.isTheSame(((Quadrilateral) figure).c) || d.isTheSame(((Quadrilateral) figure).d);
                    }
                }
            }
        }
        return false;
    }
}
