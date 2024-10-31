public class LinearEquation {
    private int x1, y1, x2, y2;


    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }


    public double yIntercept() {
        return roundedToHundredth(y1 - (slope() * x1));
    }


    public double slope() {
        return roundedToHundredth((double) (y2 - y1) / (x2 - x1));
    }


    public String equation() {
        double m = slope();
        double b = yIntercept();
        String slopeStr = formatSlope(m);
        String interceptStr = formatIntercept(b);
        return String.format("y = %sx%s", slopeStr, interceptStr);
    }


    private String formatSlope(double slope) {
        if (slope == 1.0) return "";
        if (slope == -1.0) return "-";
        if (slope == (int) slope) return String.format("%d", (int) slope);
        return String.format("%.2f", slope);
    }


    private String formatIntercept(double intercept) {
        if (intercept == 0.0) return "";
        if (intercept < 0.0) return String.format(" - %.2f", Math.abs(intercept));
        return String.format(" + %.2f", intercept);
    }


    public String coordinateForX(double x) {
        double y = slope() * x + yIntercept();
        return String.format("(%.2f, %.2f)", x, y);
    }


    public String lineInfo() {
        return String.format("The two points are: (%d, %d) and (%d, %d)\n" +
                        "The equation of the line between these points is: %s\n" +
                        "The y-intercept of this line is: %.2f\n" +
                        "The slope of this line is: %.2f\n" +
                        "The distance between these points is: %.2f",
                x1, y1, x2, y2, equation(), yIntercept(), slope(), distance());
    }


    private double roundedToHundredth(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
