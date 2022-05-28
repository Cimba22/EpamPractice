package figures;

class Triangle extends Figure{

    private final Point a;
    private final Point b;
    private final Point c;


    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (a == null || b == null || c == null) throw new IllegalArgumentException("Triangle is null.");
        else if ((a.getX()-b.getX())*(c.getY()-b.getY())-(a.getY()-b.getY())*(c.getX()-b.getX())==0)
            throw new IllegalArgumentException("Triangle is degenerative.");

    }

    @Override
    public Point centroid() {
        double sum_x = a.getX() + b.getX() + c.getX();
        double sum_y = a.getY() + b.getY() + c.getY();

        double mean_x = sum_x / 3;
        double mean_y = sum_y / 3;

        return new Point(mean_x,mean_y);

    }

    @Override
    public boolean isTheSame(Figure figure) {
        return figure instanceof Triangle;
    }
}
