package frc.robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Joystick;

public class drive extends Robot {

 //right wheels are controlled by pwm motor controllers named 0 and 2 
  //left wheels are controlled by pwm motor controllers named 1 and 3 
  @Override
  public void robotInit() {

    //sets variables right wheels and left wheels to the motor controllers
    rightWheels = new DifferentialDrive(new PWMVictorSPX(0), new PWMVictorSPX(2));
    leftWheels = new DifferentialDrive(new PWMVictorSPX (1), new PWMVictorSPX(3));
    //joystick ports
    rightStick = new Joystick(0);
    leftStick = new Joystick(1);
  
    
    //measures joystick value with .getRawAxis and sets it to a new double variable
    rightStickYAxisValue = rightStick.getRawAxis(1);
    newRightStickYAxisValue = stickSpeed * rightStickYAxisValue;
    
    leftStickYAxisValue = leftStick.getRawAxis(1);
    newLeftStickYAxisValue = stickSpeed * leftStickYAxisValue;


   leftTriger = leftStick.getRawButton(1);

     if (leftTriger) {
          almostFinalRightStickAxisValue = newLeftStickYAxisValue;
          almostFinalLeftStickAxisValue = newLeftStickYAxisValue;
          
          finalLeftStickAxisValue = 1 * almostFinalLeftStickAxisValue;

        }
     else {
         finalRightStickAxisValue = newRightStickYAxisValue;
         finalLeftStickAxisValue = newLeftStickYAxisValue;
         }


    limits = new Util(); 




    //sets each track to the adjusted joystick values
    rightWheels.tankDrive(finalRightStickAxisValue, finalLeftStickAxisValue);
    leftWheels.tankDrive(finalRightStickAxisValue, finalLeftStickAxisValue);

  }
}


