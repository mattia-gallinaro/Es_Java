public class Numeric{
    public static boolean approxEqual(double x, double y) {
        final double epsilon = 1e-14;
        double max = Math.max(Math.abs(x), Math.abs(y));
        return Math.abs(x - y) <= epsilon *max;
        //return true;
    }
}