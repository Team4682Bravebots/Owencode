package frc.robot;

public class Util extends Robot{



  
   //Sets limits for controller imputs (so the values cant go above 1 or below -1). 
 

    public double limitL(double value) {
        if (newLeftStickYAxisValue > 1.0) {
          return 1.0;
          }
      
        if (newLeftStickYAxisValue < -1.0) {
          return -1.0;
          }
    
          return newLeftStickYAxisValue;
          }
          
  

    public double limitR(double value) {
        if (newRightStickYAxisValue > 1.0) {
          return 1.0;
          }
      
        if (newRightStickYAxisValue < -1.0) {
          return -1.0;
          }
      
          return newRightStickYAxisValue;
        }
      

    public double turnLock(doubel value)
        leftTriger = getRawButton(1)
        if (leftTriger) {
          

        }
}
