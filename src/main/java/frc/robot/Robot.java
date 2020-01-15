/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot; 

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    RobotMap.init();
    // Instantiate our RobotContainer.  This will perform all our button bindings,.
    m_robotContainer = new RobotContainer();
   
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    
   // Color detectedColor = m_colorSensor.getColor();
   //detectedColor = m_colorSensor.getColor();

    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    RobotMap.LEDRainbow();
    //Set a variable to allow our drive station to know what color we are.
    //We might want to set this to a RobotMap setting.
    //DriverStation.Alliance color;
    //color = DriverStation.getInstance().getAlliance();
    //if(color == DriverStation.Alliance.Blue){
        //We were sending this to smartdashboard in 2018 SmartDashboard.putBoolean("Alliance", true);
    //}else {
        //We were sending this to smartdashboard in 2018 SmartDashboard.putBoolean("Alliance", false);
    //}
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
   RobotMap.LEDColor(255, 0, 0);
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.

    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    RobotMap.LEDColor(255, 255, 0);
    /* -- How we read the data from the FMS in 2018
    gameData = DriverStation.getInstance().getGameSpecificMessage();
    if(gameData.length() > 0) {RobotMap.FieldLayout = gameData;}
    */ 
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    RobotMap.LEDRY();
  }


}




// What can we read from the driver station? https://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/DriverStation.html
// https://frc-docs.readthedocs.io/en/latest/docs/software/wpilib-overview/2020-Game-Data.html