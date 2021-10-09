package frc.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.CANCoder;



public class Robot extends TimedRobot {
  // config \\
  public static int portArcadeJoystick = 1;

   //can network
    public static final int canNumFrontLeftMotor = 1;
    public static final int canNumFrontRightMotor = 2;
    public static final int canNumBackLeftMotor = 3; 
    public static final int canNumBackRightMotor = 4;
     /*This number (1),(2),(3),(4) is what identifies the controller on the CAN network.
     You can set this in the RoboRIO webpage by connecting to the robot
     through the radio and typing 10.56.38.2 into INTERNET EXPLORER, 
     or through USB using the IP 172.22.11.2 into the same browser.
     You may need adminstrative privilages, so the login is admin/no password
     DO NOT CHANGE THE PASSWORD WITHOUT TELLING SOMEONE FIRST. LEAVE BLANK.*/


  // motors \\
  public static WPI_TalonSRX frontLeftMotor;
  public static WPI_TalonSRX frontRightMotor;
  public static WPI_TalonSRX backLeftMotor; 
  public static WPI_TalonSRX backRightMotor; 
  /*
  need to reverse the direction of the right drive motors 
  so that they spin toward the same direction as the left drive 
  motors when supplied with a positive power
  */


  // hids \\  
  public Joystick arcadeJoystick; 
}

  @Override
  public void robotInit() {
    // motors \\
    frontLeftMotor = new WPI_TalonSRX(canNumFrontLeftMotor);  //sets all motor varibles to talons 
    frontRightMotor = new WPI_TalonSRX(canNumFrontRightMotor);
    backLeftMotor = new WPI_TalonSRX(canNumBackLeftMotor); 
    backRightMotor = new WPI_TalonSRX(canNumBackRightMotor); 


    // hids \\
    arcadeJoystick = new Joystick(portArcadeJoystick); //sets joystick varibles to joysticks 
    otherJoystick = new Joystick(portOtherJoystick);
  }

  @Override
  public void teleopPeriodic() {

    double y = -arcadeJoystick.getY(); //this is reversed
    double x = arcadeJoystick.getZ() * 1.1; // Counteract imperfect strafing
    double rx = arcadeJoystick.getX();

    // Denominator is the largest motor power (absolute value) or 1
    // This ensures all the powers maintain the same ratio, but only when
    // at least one is out of the range [-1, 1]
    double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
    double frontLeftPower = (y + x + rx) / denominator;
    double backLeftPower = (y - x + rx) / denominator;
    double frontRightPower = (y - x - rx) / denominator;
    double backRightPower = (y + x - rx) / denominator;

    frontLeftMotor.set(frontLeftPower);
    backLeftMotor.set(backLeftPower);
    frontRightMotor.set(frontRightPower);
    frontLeftMotor.set(backRightPower);


    }

