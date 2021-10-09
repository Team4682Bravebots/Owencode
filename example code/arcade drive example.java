
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
//note this is with gear driven dc motors 

package frc.robot;

//imports stuff 
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

//declares!
public class Robot extends TimedRobot {

  // config \\

  // human interface devices \\
  // joysticks
  protected Joystick arcadeJoystick;


  // motor controllers \\
  // speed controllers
  private PWMVictorSPX inTakeLeft;
  private PWMVictorSPX inTakeRight;
  private PWMVictorSPX liftMotor;
  private PWMVictorSPX climbMotor;
  private PWMVictorSPX colorWheelMotor;

  // speed controller groups
  protected SpeedControllerGroup rightWheels;
  protected SpeedControllerGroup leftWheels;

  // drives
  public DifferentialDrive robotDrive;

  // drive vars \\
  public double rawArcadeJoystickY;
  public double rawArcadeJoysitckX;
  public double arcadeJoystickY;
  public double arcadeJoystickX;
  
  public double arcadeJoyStickYTune;
  public double arcadeJoystickXTune;

  public double leftJoystickTune;
  public double rightJoystickTune;

  // percesion mode
  public double percesion;
  public double xTuneNumber;

  @Override
  public void robotInit() {

    // hids \\
    arcadeJoystick = new Joystick(1);
    

    // left and right motor sets
    rightWheels = new SpeedControllerGroup(new PWMVictorSPX(4), new PWMVictorSPX(2));
    leftWheels = new SpeedControllerGroup(new PWMVictorSPX(1), new PWMVictorSPX(3));

    // initalizes difff drive
    robotDrive = new DifferentialDrive(leftWheels, rightWheels);

    rawArcadeJoystickY = arcadeJoystick.getY();
    rawArcadeJoysitckX = arcadeJoystick.getX();
    
    //accounts for when the joystick is moved and the robot goes the oppsite way its sposto 
    arcadeJoystickX = rawArcadeJoysitckX * -1;
    arcadeJoystickY = rawArcadeJoystickY * 1;
  }

   
  @Override
  public void teleopPeriodic() {

    //is multiplied by the joystick value to tune joystick imputs 
    arcadeJoyStickYTune = 1;
    arcadeJoystickXTune = -0.5;


    //if the trigger on the joystick is press it multiplies all the controlls by half for more percise movement
    if (arcadeJoystick.getRawButton(1)){
      arcadeJoyStickYTune = 1 * 0.5;
      arcadeJoystickXTune = arcadeJoystickXTune * 0.5; //might change to -0.5 if this breakts it 

    } else {
      arcadeJoyStickYTune = 1;
      arcadeJoystickXTune = -0.5;
 
    }

    //if the joystick value difrent then zero the var xTuneNumber tunes the X to account for weird turning
    if (arcadeJoystick.getX() > 0){
      xTuneNumber = 0;
    } else {
          if (arcadeJoystick.getX() < 0){
      xTuneNumber = -1 * 0;
    } else {
      xTuneNumber = 0;

    }
    }


      //sets values to the command arcade drive
    robotDrive.arcadeDrive(arcadeJoystick.getY() * arcadeJoyStickYTune, arcadeJoystick.getX() * arcadeJoystickXTune + xTuneNumber );


  }
  }

  }








}
