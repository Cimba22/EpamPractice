public class Line {

    private final int k, b;



    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {
        int x, y;

        if (other.k == this.k) return null;
        else {
            x = (other.b - this.b) / (this.k - other.k);
            y = this.k * x + this.b;
        }

         return new Point(x,y);
    }

}
