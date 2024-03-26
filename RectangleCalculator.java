

public class RectangleCalculator implements ShapeCalculator
    {
    @Override
    public double calculateArea(double... params)
        {
        double width = params[0];
        double height = params[1];
        return width * height;
        }
    
    @Override
    public double calculatePerimeter(double... params)
        {
        double width = params[0];
        double height = params[1];
        return 2 * (width + height);
        }
    }
