if (xBox.getRawButton(buttonB)) {
      colorWheelMotor.set(0.50); 
    }else{
         if (xBox.getRawButton(rightStickDown)){
          colorWheelMotor.set(-0.25); 
    }else{
           colorWheelMotor.set(0);
          } //dead lmfao 
        }
