/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;

/**
 * Add your docs here.
 */
public class RobotMap {
  // --- Pneumatics ---//
  public static DoubleSolenoid Valve1;
  public static DoubleSolenoid Valve2; 

    //-- Color Sensor ---//
    //https://github.com/REVrobotics/Color-Sensor-v3-Examples/blob/master/Java/Read%20RGB%20Values/src/main/java/frc/robot/Robot.java
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    public Color detectedColor = m_colorSensor.getColor();

public static void init() {
  //--- Pneumatics ---//
  Valve1 = new DoubleSolenoid(60, 0, 1);
  Valve2 = new DoubleSolenoid(60, 2, 3);
    
}
}