// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.ArcadeDrive;

public class RobotDriveSystem extends SubsystemBase {
 //Determines drive type
 private boolean isDriveStraight = true;

 //Drive

//instantiate left and right side drive and create drive groups
     Spark leftF = new Spark(1);
     //Spark leftR = new Spark(1);
//named "M" for motor
    SpeedControllerGroup m_left = new SpeedControllerGroup(leftF);
  
     Spark rightF = new Spark(2);
     //Spark rightR = new Spark(2);
     SpeedControllerGroup m_right = new SpeedControllerGroup(rightF);
//differential drive, aka west coast is the type of drive base we have 
     DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);

 //Encoders for drive
 //encoders count motor rotations
 Encoder lEncoder = new Encoder(Constants.lEncoder1, Constants.lEncoder2, false, Encoder.EncodingType.k4X);
 Encoder rEncoder = new Encoder(Constants.rEncoder1, Constants.rEncoder2, false, Encoder.EncodingType.k4X);
//gyro tells us what dirictions we are facing
 AnalogGyro gyro = new AnalogGyro(Constants.gyro);
//gyros can be sensitive, so we set sensitivity to offset any issues with that
 public void DriveTrain() {
   gyro.setSensitivity(0.0065);
 }

 //Standard driving
 //drives with joystick
 public void drive(double y, double x){
   m_drive.arcadeDrive(-y, -x);
 }
//sets motor speeds to 0 to stop
 public void stop(){
  m_drive.arcadeDrive(0, 0);
 }
//tells us our gyro angle
 public double getGyro() {
   return gyro.getAngle() % 360.0;
 }
//resets gyro
 public void resetGyro() {
   gyro.reset();
 }
 //gets encoder value (rotations)
 public double getEncoderLeft(){
   System.out.println(lEncoder.getDistance());
   return lEncoder.getDistance();
 }
 
 public double getEncoderRight(){
   return rEncoder.getDistance();
 }
 //reset encoder numbers to 0 rotations
 public void resetBothEncoders(){
   lEncoder.reset();
   rEncoder.reset();
 }
 
 //Returns a given encoder value as inches
 public double encoderInches(double encoderValue){
   return encoderValue / 12.9;
 }
 
 //Returns the left encoder distance as inches
 public double leftEncoderInches(){
   return encoderInches(getEncoderLeft());
 }
 
 public double rightEncoderInches(){
   return encoderInches(getEncoderRight());
 }
 
 public double setDegrees(double degrees){
   return degrees * -0.26;
 }
 
 //Changes the autonomous driving type
 public void setIsDriveStraight(boolean state){
   isDriveStraight = state;
 }
 
 //Drives straight in autonomous with PID control
 public void driveStraight(double speed){
   double correction = 0.0;
   //Checks to see if the difference between the left and right is within a margin of error
   if(Math.abs(leftEncoderInches() - rightEncoderInches()) > Constants.driveForwardOffset){	
     //Left distance is less than right distance
     if(leftEncoderInches() < rightEncoderInches()){
       correction = -Constants.driveCorrection;
     }else{	//Right distance is less than left distance
       correction = Constants.driveCorrection;
     }
   }
   drive(-speed, correction);	//Drives with the correction value
 }
 
 //Turns in autonomous with PID control
 public void driveTurn(double speed){
   double correctionL = 0.0;
   double correctionR = 0.0;
   //Checks to see if the difference between the left and right is within a margin of error
   if(Math.abs(leftEncoderInches() + rightEncoderInches()) > Constants.driveForwardOffset){
     if(leftEncoderInches() > rightEncoderInches())	//Left distance is greater than right distance
       correctionR = -Constants.driveCorrection;
     }else{
       correctionL = -Constants.driveCorrection;
     }
   m_drive.tankDrive(-speed - correctionL, speed - correctionR);	//Drives as a tank drive to correct turning drift
 }
 
 
 //Drives off of a controller by default
   public void initDefaultCommand() {
     setDefaultCommand(new ArcadeDrive());
   }

}
