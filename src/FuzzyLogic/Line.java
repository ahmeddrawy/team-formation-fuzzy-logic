package FuzzyLogic;

public class Line {
    Point first;
    Point second ;
    double C = 0.0 ;
    double slope = 0.0 ;
    Line(Point first , Point second ){
        this.first = first;
        this.second = second ;
        calculateSlope();
        calculateC();
    }
    public double solveY(double x ){
        return slope*x + C ;
    }
    private void calculateSlope(){
        slope = (1.0*second.getY() -first.getY())/(second.getX()-first.getX() );
        return;
    }
    void calculateC(){
        C = first.getY() - slope * first.getX();
    }
    public double getSlope() {
        return slope;
    }
    public boolean inRange(double x ){
        return  first.getX()<= x && second.getX()<=x;
    }

}
