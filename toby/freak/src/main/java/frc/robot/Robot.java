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
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.GenericHID;

import edu.wpi.first.wpilibj.Timer;


//declares!
public class Robot extends TimedRobot {
  protected SpeedControllerGroup rightWheels;
  protected SpeedControllerGroup leftWheels;
  

  
  
  //config
  public static final int intakePortLeft = 7;
  public static final int intakePortRight = 8;

  public static final int liftMotorPort = 5; 

  public static final int climberMotorPort = 6; 

  public static final int colorWheelMotorPort = 0;

  //xbox buttons
  public static final int buttonA = 1;
  public static final int buttonB = 2;
  public static final int buttonX = 3; 
  public static final int buttonY = 4;

  public static final int buttonO1 = -1;
  public static final int buttonO2 = 8;
  public static final int leftStickDown = 9;
  public static final int rightStickDown = 10;

  public static final int bumperLeft = 5;
  public static final int bumperRight = 6;

  //morots 
  private PWMVictorSPX inTakeLeft;
  private PWMVictorSPX inTakeRight; 
  private PWMVictorSPX liftMotor;
  private PWMVictorSPX climbMotor;
  private PWMVictorSPX colorWheelMotor;
 

  //human interface devices
  private GenericHID xBox;
  protected Joystick leftJoystick;
  protected Joystick rightJoystick;
  protected Joystick arcadeJoystick;

  //drieve stuff
  public DifferentialDrive robotDrive;
  
  public double rawArcadeJoystickY;
  public double rawArcadeJoysitckZ;

  public double arcadeJoystickY;
  public double arcadeJoystickZ; 
 
  public double leftWheelTune;

  public double arcadeJoyStickYTune;
  public double arcadeJoystickZTune;

  public double leftJoystickTune;
  public double rightJoystickTune;


  //percesion mode
  public double percesion;
  public double zTuneNumber;

  public Timer matchTime;
 
  
  

  @Override
  public void robotInit() {
    
    //human inferface devies
    leftJoystick = new Joystick(0);
    rightJoystick = new Joystick(1);
    xBox = new XboxController(2);

    arcadeJoystick = new Joystick(3);

    //left and right motor sets
    rightWheels = new SpeedControllerGroup(new PWMVictorSPX(4), new PWMVictorSPX(2));
    leftWheels = new SpeedControllerGroup(new PWMVictorSPX (1), new PWMVictorSPX(3));
    
  
    

    robotDrive = new DifferentialDrive(leftWheels, rightWheels);
    

    rawArcadeJoystickY = arcadeJoystick.getY();
    rawArcadeJoysitckZ = arcadeJoystick.getZ();

    arcadeJoystickZ = rawArcadeJoysitckZ * -1;
    arcadeJoystickY = rawArcadeJoystickY * 1;


    //doot 
    inTakeLeft = new PWMVictorSPX(intakePortLeft);
    inTakeRight = new PWMVictorSPX(intakePortRight); 

    liftMotor = new PWMVictorSPX(liftMotorPort);
    climbMotor = new PWMVictorSPX(climberMotorPort);
    colorWheelMotor = new PWMVictorSPX(colorWheelMotorPort);

   // zTuneNumber = arcadeJoystick.getThrottleChannel();

  }
  long l;
@Override
  public void autonomousInit() {
    
   //robotDrive.tankDrive(-0.6, -0.5);
    
      l = System.currentTimeMillis();
    
    


  }
  
  @Override
  public void autonomousPeriodic() {
 
  robotDrive.tankDrive(-0.6, -0.5);
   //Timer.delay(7000);
   if((System.currentTimeMillis()-l) > 7000){
    inTakeLeft.set(-1);
    inTakeRight.set(1);
    robotDrive.tankDrive(0, 0);
   }
   
 
  }
   
  @Override
  public void teleopPeriodic() {

    arcadeJoyStickYTune = 1;
    arcadeJoystickZTune = -0.5;

    leftJoystickTune = 1;
    rightJoystickTune = 0.9;

    if (arcadeJoystick.getRawButton(1) || leftJoystick.getRawButton(1)){
      arcadeJoyStickYTune = 1 * 0.5;
      arcadeJoystickZTune = -0.5 * 0.5;

      leftJoystickTune = 1 * 0.5;
      rightJoystickTune = 0.9 * 0.5;

    } else {
      arcadeJoyStickYTune = 1;
      arcadeJoystickZTune = -0.5;

      leftJoystickTune = 1;
      rightJoystickTune = 0.9;
 
    }




    if (arcadeJoystick.getZ() > 0){
      zTuneNumber = -0.6;
    } else {
          if (arcadeJoystick.getZ() < 0){
      zTuneNumber = 0.5;
    } else {
      zTuneNumber = 0;

    }
    }





    robotDrive.arcadeDrive(arcadeJoystick.getY() * arcadeJoyStickYTune, arcadeJoystick.getX() * -0.9 + -0.05);
    
   // robotDrive.tankDrive(leftJoystick.getY() * leftJoystickTune, rightJoystick.getY() * rightJoystickTune);
    //robotDrive.tankDrive(leftJoystick.getX() * leftJoystickTune, rightJoystick.getX() * rightJoystickTune);


 
  

   //climber
    if (xBox.getRawButton(buttonX)) {
      climbMotor.set(-1); 
    }else{
         if (xBox.getRawButton(leftStickDown)){
          climbMotor.set(0.5); 
    }else{
           climbMotor.set(0);
          }

    //color wheel
    if (xBox.getRawButton(buttonB)) {
      colorWheelMotor.set(0.50); 
    }else{
         if (xBox.getRawButton(rightStickDown)){
          colorWheelMotor.set(-0.25); 
    }else{
           colorWheelMotor.set(0);
          }


    //intake
    if (xBox.getRawButton(bumperLeft)){
      inTakeLeft.set(-1);
      inTakeRight.set(1);
    }else{
      if (xBox.getRawButton(bumperRight)){
      inTakeLeft.set(1); 
      inTakeRight.set(-1); 
    }else{
      inTakeLeft.set(0);
      inTakeRight.set(0);
    }
  }
    

  

    //armLifter
    if (xBox.getRawButton(buttonY)){
      liftMotor.set(0.20); 
    }else{
     if (xBox.getRawButton(buttonA)){
      liftMotor.set(-0.20);
    }else{
     if (xBox.getRawButton(buttonO2)){
     liftMotor.set(0);
    }
    }


 }}}}}