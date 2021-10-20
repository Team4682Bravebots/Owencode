
//ngl there is a way better way to do this just saving it 
package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class pnuematics {
  
  Robot r = new Robot();

    // pnuematics \\ 
  Compressor comp = new Compressor(); 
  DoubleSolenoid solenoid1 = new DoubleSolenoid(0, 1);

   // toggle booleans \\
   boolean toggleSol1On = false;
   boolean toggleSol1Pressed = false;

   boolean toggleCompOn = false;
   boolean toggleCompPressed = false;

  public void updateSol1Toggle(){
    if(r.xBox.getRawButton(r.buttonA)){
      if(!toggleSol1Pressed){
          toggleSol1On = !toggleSol1On;
          toggleSol1Pressed = true;
      }
  }else{
      toggleSol1Pressed = false;
  }
}

  public void updateCompToggle(){
    if(r.xBox.getRawButton(r.buttonO2)){
      if(!toggleCompPressed){
          toggleCompOn = !toggleCompOn;
          toggleCompPressed = true;
      }
  }else{
      toggleCompPressed = false;
  }
}
