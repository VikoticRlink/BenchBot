/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.RobotContainer;

public class DriveBase extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  TalonSRX LeftMaster= new TalonSRX(1);
  TalonSRX LeftSlave= new TalonSRX(11);
  TalonSRX RightMaster= new TalonSRX(2);
  TalonSRX RigthSlave= new TalonSRX(22);
  TalonSRX ArmMaster= new TalonSRX(3);
  TalonSRX ArmSlave= new TalonSRX(33);
  
  TalonSRX IntakeMaster= new TalonSRX(4);
  VictorSPX IntakeSlave= new VictorSPX(44);
  TalonSRX CPI= new TalonSRX(5);
  

public DriveBase() {
  
}

@Override
public void periodic() {
  // This method will be called once per scheduler run
CPI.set(ControlMode.PercentOutput, RobotContainer.DriverController.getY(edu.wpi.first.wpilibj.GenericHID.Hand.kRight));
}
}
