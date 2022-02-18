public class PhysicsObjectsInMotion {
    public static void main(String[] args) {
        double v, theta, t, g;
        v = 43.0;
        theta = 52.0;
        t = 6.0;
        g = 9.8;
        double x, y;
        x = x(v, t, theta);
        y = y(v, t, theta, g);
        System.out.println("x = " + x);
        System.out.println("y = " + y);


    }
    public static double x(double v, double t, double theta) {

        return v * t * Math.cos(Math.toRadians(theta));
    }

    public static double y(double v, double t, double theta, double g) {

        return v * t * Math.sin(Math.toRadians(theta)) - .5 * g * t * t;
    }
}
