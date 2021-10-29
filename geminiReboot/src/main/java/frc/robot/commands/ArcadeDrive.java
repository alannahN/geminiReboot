package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
//import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

/** An example command that uses an example subsystem. */
public class ArcadeDrive extends CommandBase {
	//sets states from auto
  static boolean flip = false;
	static boolean buttonState = false;
	//requires use of arcade drive subsystem in order to use command
    public ArcadeDrive() {
    	addRequirements(Robot.RobotDriveSystem);
    }

	//what happens when command is first used
    public void initialize() {}

    //Sets if the drive orientation is reversed
    public static void setFlip(){
    	flip = !flip;
    }
    //drives robot using joystick input
    public void execute() {
    	//Drives the robot in different orientations based on a driver button input
    	if(flip){
    		//High speed gear in front
    		if(RobotContainer.driveController.getRawAxis(2) > 0.6){
	        	Robot.RobotDriveSystem.drive(-RobotContainer.driveController.getY(Hand.kLeft) * 1.1, RobotContainer.driveController.getX(Hand.kLeft) * 0.8);
	    	}else{
	    	//Low speed gear in front
	    		Robot.RobotDriveSystem.drive(-RobotContainer.driveController.getY(Hand.kLeft) * 0.6, RobotContainer.driveController.getX(Hand.kLeft) * 0.8);
	    	}
    	}
    	else{
    		//Overdrive
	    	if(RobotContainer.driveController.getRawAxis(3) > 0.6){
	    		Robot.RobotDriveSystem.drive(RobotContainer.driveController.getY(Hand.kLeft) * 1.1, RobotContainer.driveController.getX(Hand.kLeft) * 1.1);
	    	//Fast Speed
	    	}else if(RobotContainer.driveController.getRawAxis(2) > 0.6){
	        	Robot.RobotDriveSystem.drive(RobotContainer.driveController.getY(Hand.kLeft) * 1.1, RobotContainer.driveController.getX(Hand.kLeft) * 0.8);
	    	}else{
    		//Low speed
	    		Robot.RobotDriveSystem.drive(RobotContainer.driveController.getY(Hand.kLeft) * 0.6, RobotContainer.driveController.getX(Hand.kLeft) * 0.8);
	    	}
    	}
    	//Low speed turning is faster because the turning was awful. High speed turning is slower because it was too sensitive
        //#TokyoDrift
    }

    @Override
  public boolean isFinished() {
    return false;
  }

    protected void end() {}

    protected void interrupted() {}
}

