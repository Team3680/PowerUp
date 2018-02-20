package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveLiftMotor extends Command {
	
	public double liftMotorSpeed;

    public DriveLiftMotor(double speed) {
        requires(Robot.liftSubsystem);
        liftMotorSpeed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		Robot.liftSubsystem.runLiftMotor(liftMotorSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.liftSubsystem.runLiftMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
