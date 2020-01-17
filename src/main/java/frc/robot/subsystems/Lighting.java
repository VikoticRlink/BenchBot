/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;

public class Lighting extends SubsystemBase {
  /**
   * Creates a new Lighting Subsystem.
   */
  private static AddressableLED m_led;
  private static AddressableLEDBuffer m_ledBuffer;
  private static int m_rainbowFirstPixelHue;

  public  Lighting() {
    m_led = new AddressableLED(1);
    m_ledBuffer = new AddressableLEDBuffer(12);
    m_led.setLength(m_ledBuffer.getLength());
    m_led.setData(m_ledBuffer);
    m_led.start();

  }


  @Override
  public void periodic() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }


  public void LEDRY(){
      
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
      if (i % 2 == 0)
        m_ledBuffer.setRGB(i, 255, 240, 0);
      else
        m_ledBuffer.setRGB(i, 255, 0, 0);
      }     
      
    m_rainbowFirstPixelHue += 1;
    m_led.setData(m_ledBuffer);
  }
  
  public void LEDRainbow(){
    //--- make a rainbow pattern on LEDs ---//
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
        final var hue = (m_rainbowFirstPixelHue + (i * 180 / m_ledBuffer.getLength())) % 180;
        m_ledBuffer.setHSV(i, hue, 255, 128);
      }
      m_rainbowFirstPixelHue += 3;
      m_rainbowFirstPixelHue %= 180;
    m_led.setData(m_ledBuffer);
  }

  public void LEDColor(int Red, int Green, int Blue){
    //--- Set a specific color to the whole string of LEDs ---//
      for (var i = 0; i < m_ledBuffer.getLength(); i++) {
          m_ledBuffer.setRGB(i, Red, Green, Blue);
      }
    m_led.setData(m_ledBuffer);
  }
  public void LEDMatchSensor(){
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
        //m_ledBuffer.setRGB(i, (int) RobotMap.detectedColor.red, (int) detectedColor.green, (int) detectedColor.blue);
    }
    m_led.setData(m_ledBuffer);
  }

// More ideas https://www.tweaking4all.com/hardware/arduino/adruino-led-strip-effects/#LEDStripEffectSparkle
}
