// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj.motorcontrol.MockMotorController;

import java.util.Map;
import java.util.HashMap;

public class DriveSubsystem extends SubsystemBase {
  /** This subsystem will represent a two motor differential drive base to showcase example
   * Shuffleboard widgets for controlling.
   * 
   * In addition there will be a third motor within the subsystem for using WPIlib pid control.
  **/

  private ShuffleboardTab debugTab; // Will use the same tab as another subsystem
  private ShuffleboardTab driveTab; // Examples on how to arrange a tab for competition use
  
  private NetworkTableEntry sbLeftSpeed;
 
  private MockMotorController leftMotor;
  private MockMotorController rightMotor;

  public DriveSubsystem() {
    // getTab will create a new tab, or return an existing one.
    // Multiple subsystems can call getTab and send widgets to the same tab.
    debugTab = Shuffleboard.getTab("Random Layout");
    // The following widgets are very simple. Automatic placement, default widgets.
    sbExampleDouble = exTab.add("Example Double",exampleDouble).getEntry();
    sbExampleTruth = exTab.add("Example Truth", exampleTruth).getEntry();

    // We will add widgets to a tab with layout.
    driveTab = Shuffleboard.getTab("Competition")

    // Possible Widgets are all here:  
    // https://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/shuffleboard/BuiltInWidgets.html
    // This is a read only number bar.
    sbExampleChange = exTab
    .add("Example Changes", 0.0)
    .withWidget(BuiltInWidgets.kNumberBar)
    .withProperties(Map.of("min",0,"max",60))
    .getEntry();

  }

  
  @Override
  public void periodic() {
    

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
