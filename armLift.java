package frc.robot;
import edu.wpi.first.wpilibj.PWMVictorSPX;

public class armLift {
    private PWMVictorSPX liftMotor;
    
    
    public void armUp() { 
        liftMotor = new PWMVictorSPX(6);
        liftMotor.set(0.5); 
    }
    public void armDown() { 
        liftMotor = new PWMVictorSPX(6);
        liftMotor.set(-0.5); 
    }
    public void armLiftStop() {
        liftMotor = new PWMVictorSPX(6);
        liftMotor.set(0);
    }

}

