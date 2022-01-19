// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.shuffleboard.*;

import java.util.Map;

public class ExampleSubsystem extends SubsystemBase {
  /** Using this example subsystem to explore some ShuffleBoard Code examples.
   * 
   *  Shuffleboard can display Doubles, Boolean values as well as strings.
   *  In addition, if there are objects that implement Sendable, those can also be used
   *  ( Commands are all sendable. )
  **/

  // Double will change periodically
  private double exampleDouble = 0.0;
  // ExampleTruth will be true if example Double is even, or if explicitly set.
  private boolean exampleTruth = true;
  // exampleChange will change without the driver's control based on current time.
  private double exampleChange = 0;
  private long startMillis = System.currentTimeMillis();

  private ShuffleboardTab exTab;
  private NetworkTableEntry sbExampleDouble;
  private NetworkTableEntry sbExampleTruth;
  private NetworkTableEntry sbExampleChange;

  public ExampleSubsystem() {
    // Shuffleboard can have multiple tabs.  
    // getTab will create a new tab, or return an existing one.
    // Multiple subsystems can call getTab and send widgets to the same tab.
    exTab = Shuffleboard.getTab("Random Layout");
    // The following widgets are very simple. Automatic placement, default widgets.
    sbExampleDouble = exTab.add("Example Double",exampleDouble).getEntry();
    sbExampleTruth = exTab.add("Example Truth", exampleTruth).getEntry();

    // Possible Widgets are all here:  
    // https://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/shuffleboard/BuiltInWidgets.html
    // This is a read only number bar.
    sbExampleChange = exTab
    .add("Example Changes", 0.0)
    .withWidget(BuiltInWidgets.kNumberBar)
    .withProperties(Map.of("min",0,"max",60))
    .getEntry();

  }

  public double getExampleDouble(){
    return exampleDouble;
  }

  public void setExampleDouble(double d){
    // If we know when the data in the variable changes, we can update the widget at the same time.
    exampleDouble=d;
    sbExampleDouble.setDouble(exampleDouble);

  }

  public boolean getExampleTruth(){
    return exampleTruth;
  }
  public void setExampleTruth(boolean t){
    // If we know when the data in the variable changes, we can update the widget at the same time.
    exampleTruth=t;
    sbExampleTruth.setBoolean(t);
  }
 
  @Override
  public void periodic() {
    // Count from 0-60 and back over again for each minute the code has been running.
    exampleChange=((System.currentTimeMillis()-startMillis)/1000) % 60;
    // If we don't control when the data might change, we can poll and add those changes to the dashboard.
    sbExampleChange.setDouble(exampleChange);

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
