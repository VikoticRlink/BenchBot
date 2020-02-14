/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Pneumatics extends SubsystemBase {
  
  // --- Pneumatics ---//
  public static Compressor airSupply;
  public static DoubleSolenoid Valve1;
  public static DoubleSolenoid Valve2; 

  public  Pneumatics() {
    //--- Pneumatics ---//
    airSupply = new Compressor(60);
    Valve1 = new DoubleSolenoid(60, 0, 1);
    //Valve2 = new DoubleSolenoid(60, 2, 3);

  }


  @Override
  public void periodic() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    if(RobotContainer.DriverController.getAButton()){
      Valve1.set(DoubleSolenoid.Value.kForward);
    }else{
      Valve1.set(DoubleSolenoid.Value.kReverse);

    }

  }
}
