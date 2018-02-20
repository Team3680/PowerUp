package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDrive extends Command {
	
	public double commandLinear;
	public double commandRotation;
	public double commandTimeout;

    public AutoDrive(double speed, double rotation, double timeout) {
        requires(Robot.driveSubsystem);
        commandLinear = speed;
        commandRotation = rotation;
        commandTimeout = timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		setTimeout(commandTimeout);
    		
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveSubsystem.arcadeDrive(commandLinear, commandRotation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.driveSubsystem.arcadeDrive(0,0);
    		System.out.println("Driven Distance");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
