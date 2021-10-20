talon.changeControlMode(ControlMode.Position); //Change control mode of talon, default is PercentVbus (-1.0 to 1.0)
talon.setFeedbackDevice(FeedbackDevice.QuadEncoder); //Set the feedback device that is hooked up to the talon
talon.setPID(0.5, 0.001, 0.0); //Set the PID constants (p, i, d)
talon.enableControl(); //Enable PID control on the talon

talon.set(5000); //Tells the talon to go to 5000 encoder counts, using the preset PID parameters.

talon.setVoltageRampRate(rampRate); //Sets the max voltage ramp on the talon
//This affects both starting and stopping
