package figures;

class Circle extends Figure{
    private final Point o;
    private final double radius;

    public Circle(Point o, double radius) {
        this.o = o;
        this.radius = radius;
        if((Math.PI * this.radius * this.radius) == 0 || this.radius < 0 || o == null)
            throw new IllegalArgumentException("Quadrilateral has zero area.");
    }

    @Override
    public Point centroid() {
        return o;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure == null) return false;
        if (figure == this) return true;
        if (figure instanceof Circle) {
            return this.o.isTheSame(((Circle) figure).o) && this.o.isTheSame(((Circle) figure).o) &&
                    Math.abs(((Circle) figure).radius - this.radius) <= 0.0001;
        }
        return false;
    }
}
