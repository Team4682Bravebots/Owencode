package frc.robot;
import edu.wpi.first.wpilibj.PWMVictorSPX;

    public class intake {

        private PWMVictorSPX inTake; 

        public void inTakeSpin() {
            inTake = new PWMVictorSPX(7);
            inTake.set(0.5);

        }
        public void inTakeStop() {
            inTake = new PWMVictorSPX(7);
            inTake.set(0);
        }
}
