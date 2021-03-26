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

    //sets variables right wheels and left wheels to the motor controllers
    rightWheels = new DifferentialDrive(new PWMVictorSPX(0), new PWMVictorSPX(2));
    leftWheels = new DifferentialDrive(new PWMVictorSPX (1), new PWMVictorSPX(3));
    //joystick ports
    rightStick = new Joystick(0);
    leftStick = new Joystick(1);
  }

   
  public void joyStickVaratation() {
    stickSpeed = 0.05;
    //measures joystick value with .getRawAxis and sets it to a new double variable
    rightStickYAxisValue = rightStick.getRawAxis(1);
    newRightStickYAxisValue = stickSpeed * rightStickYAxisValue;
    
    leftStickYAxisValue = leftStick.getRawAxis(1);
    newLeftStickYAxisValue = stickSpeed * leftStickYAxisValue;


    //applies the util limmit methods, see Util.java
    limitL = new Util(); 
    limitR = new Util();

  }

  public double turnLock(doubel value)
    //if the left trigger is pulled, both tracks will follow the left joystick
   LeftTriger = getRawButton(1)
     if (leftTriger) {
          lockedRightStickAxisValue.follow(newLeftStickYAxisValue);
          lockedLeftStickAxisValue.follow(newLeftStickYAxisValue);
        
        }
     else {
         lockedRightStickAxisValue.follow(newRightStickYAxisValue);
         lockedLeftStickAxisValue.follow(newLeftStickYAxisValue);
         }
    

   }
 
  
  @Override
  public void teleopPeriodic() {

    //sets each track to the adjusted joystick values
    rightWheels.tankDrive(lockedRightStickAxisValue, lockedLeftStickAxisValue);
    leftWheels.tankDrive(lockedRightStickAxisValue, lockedLeftStickAxisValue);



  }

}
  
