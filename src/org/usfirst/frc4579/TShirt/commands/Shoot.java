// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4579.TShirt.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4579.TShirt.Robot;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class Shoot extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
	
	private double m_valveOpenTime = 0.0;
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public Shoot() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.compressedAirTank);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	// Set the timeout for how long to leave the valve open.
    	m_valveOpenTime = (double)Robot.compressedAirTank.getValveOpenTime() / 1000.0;
    	setTimeout(m_valveOpenTime);
    
    	// Open the valve.
    	Robot.compressedAirTank.openTankValve();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (timeSinceInitialized() >= m_valveOpenTime);
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	// Close the valve.
    	Robot.compressedAirTank.closeTankValve();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
