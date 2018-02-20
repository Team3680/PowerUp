package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GripGrabber extends Command {

    public GripGrabber() {
        requires(Robot.grabberSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		Robot.grabberSubsystem.clampGrabber("true");
    		setTimeout(0.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.grabberSubsystem.clampGrabber("off");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
