package org.usfirst.frc.team3680.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3680.robot.commands.DriveLiftMotor;
import org.usfirst.frc.team3680.robot.commands.DriveTeleop;
import org.usfirst.frc.team3680.robot.commands.ExtendArm;
import org.usfirst.frc.team3680.robot.commands.GripGrabber;
import org.usfirst.frc.team3680.robot.commands.LiftDriveToValue;
import org.usfirst.frc.team3680.robot.commands.ReleaseGrabber;
import org.usfirst.frc.team3680.robot.commands.RetractArm;

public class OI {
	public Joystick rightStick;
	
	public OI() { 
		rightStick = new Joystick(RobotMap.rightStickUSB);
		buttonWhileHeld(rightStick, 11, new DriveLiftMotor(1));
		buttonWhileHeld(rightStick, 10, new DriveLiftMotor(-1));
		buttonWhenPressed(rightStick, 4, new ReleaseGrabber());
		buttonWhenPressed(rightStick, 5, new GripGrabber());
		buttonWhenPressed(rightStick, 6, new ExtendArm());
		buttonWhenPressed(rightStick, 7, new RetractArm());
		buttonWhenPressed(rightStick, 3, new LiftDriveToValue(200,1));
		buttonWhenPressed(rightStick, 2, new LiftDriveToValue(100,1));
		buttonWhenPressed(rightStick, 1, new LiftDriveToValue(0,1));
	}
	
	private void buttonWhileHeld(Joystick joystick, int button, Command command) { 
		new JoystickButton(joystick, button).whileHeld(command);
	}
	
	private void buttonWhenPressed(Joystick joystick, int button, Command command) { 
		new JoystickButton(joystick, button).whenPressed(command);
	}
	
	public double getRightX() { 
		if(!(rightStick == null)) {
			return rightStick.getX();
		} else { 
			return 0;
		}
	}
	
	public double getRightY() { 
		if(!(rightStick == null)) { 
			return rightStick.getY();
		} else {
			return 0;
		}
	}

}
