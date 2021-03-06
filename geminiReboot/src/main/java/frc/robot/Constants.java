// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

//PWM
	//RobotDrive
	public static int left = 0;
	public static int right = 1;
	//Shooter
	public static int flywheel = 4;
	public static int shooterControl = 5;
	public static int shooterRotate = 6;   
	//Other
	public static int intake = 9;
	public static int gearEjector = 3;
	public static int hood = 7;
	public static int gearIntake = 2;
	public static int gearIntakeRotate = 8;

//Analog
	public static int gearUltra = 3;
	public static int turretPot = 4;
	public static int gearIntakePot = 2;
	public static int gearPot = 1;
	public static int gyro = 0;

	//Relay
	
// USB
	//Cameras
	public static int cameraBoiler = 0;
	public static int cameraGear = 1;
	public static int cameraFront = 2;
	
//DIO
	//Encoders
	public static int lEncoder1 = 0;
	public static int lEncoder2 = 1;
	public static int rEncoder1 = 2;
	public static int rEncoder2 = 3;
	//Other
	public static int gearLimit = 4;

	
//PID
	//Drive
	public static double driveStraightP = 0.05;
	public static double driveStraightI = 0.0;
	public static double driveStraightD = 0.001;
	public static double driveTurnP = 0.15;
	public static double driveTurnI = 0.0;
	public static double driveTurnD = 0.0005;
	public static double driveGTurnP = 0.02;
	public static double driveGTurnI = 0.0;
	public static double driveGTurnD = 0.005;
	
	//Turret
	public static double turretP = 0.025;
	public static double turretI = 0.0;
	public static double turretD = 0.0002;
	//Gear
	public static double gearP = 0.1;
	public static double gearI = 0.0;
	public static double gearD = 0.0;
	//Gear Pickup
	public static double gearFloorP = 10.0;
	public static double gearFloorI = 0.0;
	public static double gearFloorD = 0.0;
	

//Variables
	//Drive
	public static double driveForwardOffset = 0.25;
	public static double driveTurnOffset = 0.25;
	public static double driveGTurnOffset = 2.0;
	public static double driveCorrection = -0.2;
	public static double drivePegForward = 0.6;
	public static double drivePegCorrection = 0.6;
	public static double drivePegDefault = 0.6;
	public static double drivePegOffset = 8;
	public static double pegDistance = 10;
	
	//Gear
	public static double gearTwoRev = 100;
	public static double gearOffset = 0.1;
	public static double gearTimeout = 1.0;
	public static double gearRest = 0.5;

	//Image resoulution constants
	public static final int IMG_WIDTH = 320;
	public static final int IMG_HEIGHT = 240;
	//Turret Potentiometer Limits
	public static double turretLower = 0.367;
	public static double turretUpper = 0.552;
	//GearFloor Setpoints
	public static double ground = 0.630;
	public static double hold = 0.33; 	//0.35; Old Setpoint
	public static double gearFloorAdjust = 1.0;
	

}
