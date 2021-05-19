package frc.robot;
import edu.wpi.first.wpilibj.PWMVictorSPX;

    public class armShoot {

        private PWMVictorSPX inTake; 
       // public PWMVictorSPX intakePort
       // private int intakePort;

        public void eatforward(int intakePort2) {
            inTake = new PWMVictorSPX(intakePort2);
            inTake.set(0.5);

        }

    
    
}
