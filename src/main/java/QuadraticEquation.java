import java.util.Queue;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] getX(){
        double[] results = new double[2];
        double x1 = (-b + Math.sqrt(b*b - 4*a*c))/(2*a);
        double x2 = (-b - Math.sqrt(b*b - 4*a*c))/(2*a);
        results[0] = x1;
        results[1] = x2;
        return results;
    }
}
