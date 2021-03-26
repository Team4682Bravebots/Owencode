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
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;



public class Robot extends TimedRobot {

  // Joysticks\\
   protected Joystick rightStick;
   protected Joystick leftStick;

  //drive systems \\
   protected DifferentialDrive rightWheels;
   protected DifferentialDrive leftWheels;

   double stickSpeed;

  // joystick variables \\
   double leftStickYAxisValue;
   double rightStickYAxisValue;

   double newRightStickYAxisValue;
   double newLeftStickYAxisValue;

   double almostFinalLeftStickAxisValue;
   double almostFinalRightStickAxisValue;

   double finalRightStickAxisValue;
   double finalLeftStickAxisValue; 



  // button booleans \\   
   boolean leftTriger; 
   boolean rightTrigger; 

  // components \\
   public drive drive_; 
   public powerCellRack rack_; 
   public climber climber_; 
   public Util limits; 


   public void config() {

    // Stick sensivity multiplyer, raise or lower this from 0 - 1 to adjust controll sensivity. (math: this * joystick imput = output)
    stickSpeed = 0.05;

   }

   


  @Override
  public void robotInit() {
    drive_ = new drive();
    rack_ = new powerCellRack(); 
    climber_ = new climber(); 
    

  }

}
