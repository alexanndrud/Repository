public class Hollow  {
    int  balls;
   public  Hollow()  {
        this.balls  =  0;
    }


    public  int  getBalls()  {return  balls;}
    public  void  addBalls(int balls) {this.balls += balls;}
    public  boolean  isEmpty() {return balls == 0;}
    public  int  removeBalls() {
        int  balls  =  this.balls;
        this.balls  =  0;
        return  balls;
    }

}
