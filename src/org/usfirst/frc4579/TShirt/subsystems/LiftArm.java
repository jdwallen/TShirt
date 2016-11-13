// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4579.TShirt.subsystems;

import org.usfirst.frc4579.TShirt.RobotMap;
import org.usfirst.frc4579.TShirt.commands.*;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4579.TShirt.Robot;
import org.usfirst.frc4579.TShirt.OI.TOPHATSTATE;

/**
 *
 */
public class LiftArm extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    private final double slewStepSize  = 20.0/50.0;  // degrees/sec divided by 50 executions/sec  Add to smartdashboard?

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final AnalogPotentiometer liftArmAnalogPotentiometer = RobotMap.liftArmLiftArmAnalogPotentiometer;
    private final SpeedController liftArmSpeedController = RobotMap.liftArmLiftArmSpeedController;
    private final PIDController liftArmPIDController = RobotMap.liftArmLiftArmPIDController;
    private final DigitalInput raisedLimitSwitch = RobotMap.liftArmRaisedLimitSwitch;
    private final DigitalInput loweredLimitSwitch = RobotMap.liftArmLoweredLimitSwitch;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private double m_commandedArmAngle = 0.0;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void initialize() {
    	// Initialize PID controller
    	// Initialize potentiometer.
    	// Initialize limit switches.
    }
    
    public void stop() {
    	// Stow the lift arm and disable.
    }
    
    //private double getLiftArmAngle() {
    //	return liftArmAnalogPotentiometer.get();
    //}
    
    private void setLiftArmAngle(double degrees) {
    	liftArmPIDController.setSetpoint(degrees);
    }

    private boolean atUpperArmLimit () {
    	return raisedLimitSwitch.get();
    }
    
    private boolean atLowerArmLimit () {
    	return loweredLimitSwitch.get();
    }
    
    public void manageLiftArm () {
    	
    	switch (Robot.oi.getTophatState()) {
    	
    	case FORWARD: // Lowering the arm
    		
    	    // if we arn't already at the lower limit
    		if (!atLowerArmLimit()) {
    			// Lower the arm angle a step.
    			m_commandedArmAngle -= slewStepSize;
        		setLiftArmAngle(m_commandedArmAngle);
    		}
    		
    		break;
    		
    	case BACKWARD: // Raising the arm
    	
    	    // if we arn't already at the upper limit
    		if (!atUpperArmLimit()) {
    			// Raise the arm angle a step.
    			m_commandedArmAngle += slewStepSize;
        		setLiftArmAngle(m_commandedArmAngle);
    		}
    		
    		break;
    		
    	case NEUTRAL: // Nothing to do
    		break;
    		
    	case ERROR:  // Unexpected value returned from the tophat
    		
    		// Print out error message?
    		// Throw an exception?    		
    		break;
    	}
    }
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new DefaultAim());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

