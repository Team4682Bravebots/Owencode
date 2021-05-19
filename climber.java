package frc.robot;
import edu.wpi.first.wpilibj.PWMVictorSPX;


public class climber{

    private PWMVictorSPX climbMotor;
    
    
    
    public void climby() { 
        climbMotor = new PWMVictorSPX(5);
        climbMotor.set(0.5); 
    }

    public void climbyneg() {
        climbMotor = new PWMVictorSPX(5);
        climbMotor.set(-0.3); 
    }


    public void climbdebug(){
        climbMotor = new PWMVictorSPX(5);
        climbMotor.set(0.3);
        
    }
    public void climberStop(){
        climbMotor = new PWMVictorSPX(5);
        climbMotor.set(0);
    }
}
