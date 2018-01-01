package org.usfirst.frc.team3680.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3680.robot.commands.DriveTeleop;

public class OI {
	public Joystick rightStick;
	
	public OI() { 
		rightStick = new Joystick(RobotMap.rightStickUSB);
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
