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
        double num = Math.sqrt(b*b - 4*a*c);
        double denominator = (2*a);
        results[0] = (-b + num) / denominator;
        results[1] = (-b - num) / denominator;
        return results;
    }
}
