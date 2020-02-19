/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
//import edu.wpi.first.wpilibj.util.Color8Bit;
import com.revrobotics.ColorSensorV3;

public class ColorSensor extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  private Lighting m_Lighting;
 // private Color8Bit displayColor;

public ColorSensor() {
  m_Lighting= new Lighting();
}

@Override
public void periodic() {
  // This method will be called once per scheduler run
  Color detectedColor = m_colorSensor.getColor();
  

    double IR = m_colorSensor.getIR();
        /**
     * Open Smart Dashboard or Shuffleboard to see the color detected by the 
     * sensor.
     */
  // Color8Bit displayColor =  Color8Bit((int) detectedColor.red*255, (int) detectedColor.green * 255, (int) detectedColor.blue * 255);

  double redCorrection = -0.31;
  double blueCorrection = -0.19;
  double greenCorrection = -0.48;
  double currentRed = detectedColor.red + redCorrection;
  double currentGreen = detectedColor.green + greenCorrection;
  double currentBlue = detectedColor.blue + blueCorrection;
  double myRed = currentRed * 255;
  double myGreen = currentGreen * 255;
  double myBlue = currentBlue * 255;
    int proximity = m_colorSensor.getProximity();

    SmartDashboard.putNumber("raw Red", detectedColor.red);
    SmartDashboard.putNumber("raw Green", detectedColor.green);
    SmartDashboard.putNumber("raw Blue", detectedColor.blue);
    
    SmartDashboard.putNumber("Red", myRed);
    SmartDashboard.putNumber("Green", myGreen);
    SmartDashboard.putNumber("Blue", myBlue);

    SmartDashboard.putNumber("Proximity", proximity);
    SmartDashboard.putNumber("IR", IR);

    if (proximity>100){

      if((myRed > 30)&& (myBlue < 0) && (myGreen < 0)){
        //Detected Red
        m_Lighting.LEDColor(255, 0, 0);
      }
      if((myRed < 0)&& (myBlue > 10) && (myGreen > 20)){
        //Detected Green
        m_Lighting.LEDColor(0, 255, 0);
      }
      if((myRed < 0)&& (myBlue > 40) && (myGreen < 0)){
        //Detected Blue
        m_Lighting.LEDColor(0, 0, 255);
      }
      if((myRed > 3)&& (myBlue < 3) && (myGreen > 15)){
        //Detected Yellow
          m_Lighting.LEDColor(255, 255, 0);
      }
      if((myRed < 5)&& (myBlue < 20) && (myGreen < 5)){
        //Detected NA
          m_Lighting.LEDColor(255, 255, 255);
      }
/*
        if(detectedColor.green*255 > 100){
          m_Lighting.LEDColor(255, 255, 0);
        } else {
        m_Lighting.LEDColor(255, 0, 0);
        }
      }
      if(myBlue > 30){
        m_Lighting.LEDColor(0, 0, 255);
      }
      if(myGreen > 80){
        m_Lighting.LEDColor(0, 255, 0);
      }
      //m_Lighting.LEDColor(displayColor.red, displayColor.green, displayColor.blue);*/

    }else{
      m_Lighting.LEDRainbow();

    }
        /**
     * In addition to RGB IR values, the color sensor can also return an 
     * infrared proximity value. The chip contains an IR led which will emit
     * IR pulses and measure the intensity of the return. When an object is 
     * close the value of the proximity will be large (max 2047 with default
     * settings) and will approach zero when the object is far away.
     * 
     * Proximity can be used to roughly approximate the distance of an object
     * or provide a threshold for when an object is close enough to provide
     * accurate color values.
     */
}
}
