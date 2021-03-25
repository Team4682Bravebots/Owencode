/*
.______   .______          ___   ____    ____  _______ .______     ______   .___________.    _______.
|   _  \  |   _  \        /   \  \   \  /   / |   ____||   _  \   /  __  \  |           |   /       |
|  |_)  | |  |_)  |      /  ^  \  \   \/   /  |  |__   |  |_)  | |  |  |  | `---|  |----`  |   (----`
|   _  <  |      /      /  /_\  \  \      /   |   __|  |   _  <  |  |  |  |     |  |        \   \    
|  |_)  | |  |\  \----./  _____  \  \    /    |  |____ |  |_)  | |  `--'  |     |  |    .----)   |   
|______/  | _| `._____/__/     \__\  \__/     |_______||______/   \______/      |__|    |_______/    

                                        The Team Strikes Back! 
                                            -frosty :D
*/

package frc.robot;

//imports stuff 
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


//declares!
public class Robot extends TimedRobot {
  protected DifferentialDrive rightWheels;
  protected DifferentialDrive leftWheels;
  protected Joystick rightStick;
  protected Joystick leftStick;
  
  
  private Util limitL;
  private Util limitR;

  double rightStickYAxisValue;
  double newRightStickYAxisValue;
  double leftStickYAxisValue;
  double newLeftStickYAxisValue;
  double stickSpeed;
  double lockedRightStickAxisValue;
  double lockedLeftStickAxisValue; 


  boolean leftTriger; 
  //boolean isPressed; 

  double limitL(){
    return newLeftStickYAxisValue;
  }
  
  double limitR(){
    return newRightStickYAxisValue;
  }

 

  //right wheels are controlled by pwm motor controllers named 0 and 2 
  //left wheels are controlled by pwm motor controllers named 1 and 3 
  @Override
  public void robotInit() {
   
    rightWheels = new DifferentialDrive(new PWMVictorSPX(0), new PWMVictorSPX(2));
    leftWheels = new DifferentialDrive(new PWMVictorSPX (1), new PWMVictorSPX(3));
    //switches each track direction (0=foward 1=reverse) (drive train is mirrored therfore 0,1)
    rightStick = new Joystick(0);
    leftStick = new Joystick(1);
  }

   
  public void joyStickVaratation() {
    //gets joysitck value, set value percentage to left trigger state. Pushed = 75% throttle unpushed = 50% throttle
    /*boolean isPressed = rightStick.getRawButton(1);
      if(isPressed) {
        stickSpeed = 0.75;
      }
      else {
        stickSpeed = 0.05; 
      }

      //stickSpeed = 0.05;
      */
       
      //sets the value 
    rightStickYAxisValue = rightStick.getRawAxis(1);
    newRightStickYAxisValue = stickSpeed * rightStickYAxisValue;
    
    leftStickYAxisValue = leftStick.getRawAxis(1);
    newLeftStickYAxisValue = stickSpeed * leftStickYAxisValue;

    limitL = new Util(); 
    limitR = new Util();
    

   }
 
   // sets wheel speed to adjusted joystick Y value. 
  @Override
  public void teleopPeriodic() {

    //rightWheels.tankDrive(newRightStickYAxisValue, newLeftStickYAxisValue);
    //leftWheels.tankDrive(newRightStickYAxisValue, newLeftStickYAxisValue);

    rightWheels.tankDrive(lockedRightStickAxisValue, lockedLeftStickAxisValue);
    leftWheels.tankDrive(lockedRightStickAxisValue, lockedLeftStickAxisValue);



  }

}
  




