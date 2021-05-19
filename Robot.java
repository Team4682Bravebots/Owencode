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
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.GenericHID;



//declares!
public class Robot extends TimedRobot {
  protected DifferentialDrive rightWheels;
  protected DifferentialDrive leftWheels;
  

  //TODO make these actualy wok 
  //config
  public static final int intakePort = 7;
  public static final int armLift = 6; 
  public static final int climberPort = 5; 


  //human interface devices
  private GenericHID xBox;
  protected Joystick joyStick;

  //classes
  private climber climb1;
  private intake arm1;
  private armLift arm2;
  
 

  @Override
  public void robotInit() {
    
    //human inferface devies
    joyStick = new Joystick(0);
    xBox = new XboxController(1);

    //left and right motor sets
    rightWheels = new DifferentialDrive(new PWMVictorSPX(0), new PWMVictorSPX(2));
    leftWheels = new DifferentialDrive(new PWMVictorSPX (1), new PWMVictorSPX(3));

  }

   

   //sets wheel speed to adjusted joystick Y value. 
  @Override
  public void teleopPeriodic() {


    //arcade drive 
    rightWheels.arcadeDrive(joyStick.getX(), joyStick.getY());
    leftWheels.arcadeDrive(joyStick.getX(), joyStick.getY());
    

    //climber
    while (xBox.getRawButton(1)) {
      climb1.climby();
    }
    while (xBox.getRawButton(3)){
      climb1.climbyneg();
    }
    while (xBox.getRawButton(2)){
      climb1.climbdebug();
    }

    //intake
    while (xBox.getRawButton(0)){
      arm1.inTakeSpin();
    }
    while (xBox.getRawButton(6)){
      arm1.inTakeStop();
    }
    while (xBox.getRawButton(9)) {
      arm1.intakeUnSpin();
    }
    
    //armLifter
    while (xBox.getRawButton(5)){
      arm2.armUp();
    }
    while (xBox.getRawButton(7)){
      arm2.armDown();
    }


    //emergency stop
    if (xBox.getRawButton(8)){
      climb1.climberStop();
      arm2.armLiftStop();
      arm1.inTakeStop(); 
    }

  }


}
  
