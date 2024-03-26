

public class CircleCalculator implements ShapeCalculator
    {
    @Override
    public double calculateArea(double... params)
        {
        double radius = params[0];
        return Math.PI * Math.pow(radius, 2);
        }

    @Override
    public double calculatePerimeter(double... params)
        {
        double width = params[0];
        double height = params[1];
        return 2 * (width + height);
        }
    }
