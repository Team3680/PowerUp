package org.usfirst.frc.team3680.robot.subsystems;

import org.usfirst.frc.team3680.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftSubsystem extends Subsystem {

    private Spark liftMotor;
    public Encoder encoder;
    public DigitalInput liftSwitch;
    
    public LiftSubsystem() {
    		liftMotor = new Spark(RobotMap.liftController);
    		encoder = new Encoder(RobotMap.liftEncoder1, RobotMap.liftEncoder2);
    		liftSwitch = new DigitalInput(RobotMap.liftSwitch);
    }
    
    public void runLiftMotor(double speed) { 
    		liftMotor.set(speed);
    }
    
    public void resetEncoder() {
    		encoder.reset();
    }
    
    public boolean getLimitSwitch() {
    		return liftSwitch.get();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

