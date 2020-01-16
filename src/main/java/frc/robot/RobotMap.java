/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

//import edu.wpi.first.wpilibj.AddressableLED;
//import edu.wpi.first.wpilibj.AddressableLEDBuffer;

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

    //--- LED ---//
    //public static AddressableLED m_led;
    //public static AddressableLEDBuffer m_ledBuffer;
    //public static int m_rainbowFirstPixelHue;

    //-- Color Sensor ---//
    //https://github.com/REVrobotics/Color-Sensor-v3-Examples/blob/master/Java/Read%20RGB%20Values/src/main/java/frc/robot/Robot.java
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    public Color detectedColor = m_colorSensor.getColor();

public static void init() {
  //--- Pneumatics ---//
  Valve1 = new DoubleSolenoid(60, 0, 1);
  Valve2 = new DoubleSolenoid(60, 2, 3);
    //--- LEDs ---//
    //m_led = new AddressableLED(1);
    //m_ledBuffer = new AddressableLEDBuffer(12);
    //m_led.setLength(m_ledBuffer.getLength());
    //m_led.setData(m_ledBuffer);
    //m_led.start();
    
}
//--- LED Functions ---//
 /* public static void LEDRainbow(){
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
        final var hue = (m_rainbowFirstPixelHue + (i * 180 / m_ledBuffer.getLength())) % 180;
        m_ledBuffer.setHSV(i, hue, 255, 128);
      }
      m_rainbowFirstPixelHue += 3;
      m_rainbowFirstPixelHue %= 180;
    m_led.setData(m_ledBuffer);
  }
    public static void LEDColor(int Red, int Green, int Blue){
        for (var i = 0; i < m_ledBuffer.getLength(); i++) {
            m_ledBuffer.setRGB(i, Red, Green, Blue);
        }
      m_led.setData(m_ledBuffer);
    }
    public static void LEDMatchSensor(){
        //for (var i = 0; i < m_ledBuffer.getLength(); i++) {
        //    m_ledBuffer.setRGB(i, (int) detectedColor.red, (int) detectedColor.green, (int) detectedColor.blue);
        //}
        //m_led.setData(m_ledBuffer);
    }
    public static void LEDRY(){
      
      for (var i = 0; i < m_ledBuffer.getLength(); i++) {
        if (i % 2 == 0)
          m_ledBuffer.setRGB(i, 255, 240, 0);
        else
          m_ledBuffer.setRGB(i, 255, 0, 0);
        }     
        
      m_rainbowFirstPixelHue += 1;
      m_led.setData(m_ledBuffer);
  }*/
}