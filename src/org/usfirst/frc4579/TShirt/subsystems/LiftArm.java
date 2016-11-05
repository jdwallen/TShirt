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
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4579.TShirt.Robot;

/**
 *
 */
public class LiftArm extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final AnalogPotentiometer liftArmAnalogPotentiometer = RobotMap.liftArmLiftArmAnalogPotentiometer;
    private final SpeedController liftArmSpeedController = RobotMap.liftArmLiftArmSpeedController;
    private final PIDController liftArmPIDController = RobotMap.liftArmLiftArmPIDController;
    private final DigitalInput raisedLimitSwitch = RobotMap.liftArmRaisedLimitSwitch;
    private final DigitalInput loweredLimitSwitch = RobotMap.liftArmLoweredLimitSwitch;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private final int TOPHAT = 6;  // Axis identifier for joystick tophat used to lift and lower arm.
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public int getTophatState () {
    	return (int)Robot.oi.getJoystick1().getRawAxis(TOPHAT);
    }
    
    public double getLiftArmAngle() {
    	return 0.0; // Fix
    }

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new DefaultAim());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

