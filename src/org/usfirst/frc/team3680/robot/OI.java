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
		buttonWhileHeld(rightStick, 3, new DriveLiftMotor(1));
		buttonWhileHeld(rightStick, 2, new DriveLiftMotor(-0.5));
		buttonWhenPressed(rightStick, 6, new ReleaseGrabber());
		buttonWhenPressed(rightStick, 7, new GripGrabber());
		buttonWhenPressed(rightStick, 4, new ExtendArm());
		buttonWhenPressed(rightStick, 5, new RetractArm());
		//buttonWhenPressed(rightStick, 3, new LiftDriveToValue(8000,-0.5));
		//buttonWhenPressed(rightStick, 2, new LiftDriveToValue(10000,-0.5));
		//buttonWhenPressed(rightStick, 1, new LiftDriveToValue(0,0.5));
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
