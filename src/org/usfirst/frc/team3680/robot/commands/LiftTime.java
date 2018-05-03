package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftTime extends Command {
	
	public double commandSpeed;
	public double commandTimeout;

	public LiftTime(double speed, double timeout) {
        requires(Robot.liftSubsystem);
        commandSpeed = speed;
        commandTimeout = timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		setTimeout(commandTimeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.liftSubsystem.runLiftMotor(commandSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
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
