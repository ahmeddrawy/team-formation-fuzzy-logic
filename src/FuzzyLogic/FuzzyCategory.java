package FuzzyLogic;

public class FuzzyCategory {
    int numberOfPoints = 0 ;
    Point points[] = null;
    Line lines[] = null ;
    double centroid = 0 ;
    FuzzyCategory(int numberOfPoints, double [] points ){
        this.numberOfPoints = numberOfPoints;
        setPoints(points);
        ConstructLines();
        calcCentroid();
    }
    /// we're given Xs only we put Ys depending on shape
    /// the start and end are zeros and middles are 1s
    /// we only deal with 3 points or 4 points diagrams
    private void setPoints(double[] points) {
        this.points = new Point[numberOfPoints];
        for (int i = 0; i <numberOfPoints ; i++) {
            if( i == 0 || i == numberOfPoints -1){

                this.points[i]= new Point(points[i], 0);
            }
            else{

                this.points[i]= new Point(points[i], 1);

            }
        }
    }
    private void ConstructLines(){
        lines = new Line[numberOfPoints-1];
        for (int i = 1; i < numberOfPoints; i++) {
            lines[i-1] = new Line(points[i-1] , points[i]);
        }
    }
    double inRange(double x){
        for (int i = 0; i < numberOfPoints -1; i++) {
            if(lines[i].inRange(x)){
                return lines[i].solveY(x);
//                return true;
            }
        }
        return 0;
    }

    public double getCentroid() {
        return centroid;
    }
    void calcCentroid(){
        for (Point p :points) {
            centroid +=p.getX();
        }
        centroid /=numberOfPoints;
    }
    void print(){
        for (Point p:points) {
            p.print();
        }
    }
}
