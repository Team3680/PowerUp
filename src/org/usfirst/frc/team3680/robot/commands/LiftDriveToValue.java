package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftDriveToValue extends Command {

	public double liftValue;
	public double liftSpeed;
	public int liftDirection;
	
    public LiftDriveToValue(double value, double speed) {
        requires(Robot.liftSubsystem);
        liftValue = value;
        liftSpeed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		setTimeout(10);
    		if(Robot.liftSubsystem.encoder.getDistance() > liftValue) {
    			liftDirection = -1;
    		} else if (Robot.liftSubsystem.encoder.getDistance() < liftValue) {
    			liftDirection = 1;
    		}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(Robot.liftSubsystem.encoder.getDistance() > liftValue*1.05 || Robot.liftSubsystem.encoder.getDistance() < liftValue*0.95) {
    		Robot.liftSubsystem.runLiftMotor(liftSpeed*liftDirection);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.liftSubsystem.encoder.getDistance() > liftValue*1.05 || Robot.liftSubsystem.encoder.getDistance() < liftValue*0.95) {
    		return false;
    } else {
    		return true;
    }
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.liftSubsystem.runLiftMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
