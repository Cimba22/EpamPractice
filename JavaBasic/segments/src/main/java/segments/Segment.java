package segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {

    private final Point start;
    private final Point end;


    public Segment(Point start, Point end) {
        if (start.getX() == end.getX() && start.getY() == end.getY())
            throw new IllegalArgumentException("Exception");


        this.start = start;
        this.end = end;
    }

    double length() {

        double lineLength = sqrt((pow(end.getX() - start.getX(), 2)) +
                pow((end.getY() - start.getY()), 2));

        return lineLength;
    }

    Point middle() {

        double x, y;
        x = (start.getX() + end.getX()) / 2;
        y = (start.getY() + end.getY()) / 2;
        return new Point(x,y);
    }

    Point intersection(Segment another) {
        if(start.getX() / start.getY() == end.getX()/end.getY()) return null;

        double x1 = this.start.getX();
        double y1 = this.start.getY();
        double x2 = this.end.getX();
        double y2 = this.end.getY();
        double x3 = another.start.getX();
        double y3 = another.start.getY();
        double x4 = another.end.getX();
        double y4 = another.end.getY();


        double d = (x1 - x2)*(y3 - y4) - (y1 - y2)*(x3 - x4);

        double t, u;
        if(d != 0) {
            t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / d;
            u = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2)) / d;
        }else return null;

        double x,y;
        if ((t >= 0.0 && t <= 1.0 ) && (u >= 0.0 && u <= 1.0) ){
            x = (x1 + t * (x2 - x1));
            y = (y1 + t * (y2 - y1));
            return new Point(x, y);
        } else return null;

    }

}
