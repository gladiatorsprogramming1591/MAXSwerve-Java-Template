package frc.robot.commands.navXCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem.DriveSubsystem;

public class ResetGyro extends Command {

    DriveSubsystem m_drivetrain;

    public ResetGyro(DriveSubsystem drivetrain) {
        m_drivetrain = drivetrain;
        addRequirements(m_drivetrain);
    }

    @Override
    public void execute() {
    m_drivetrain.zeroHeading();    
    }

    @Override
    public boolean isFinished() {
        // return !m_drivetrain.isCalibrating();
        return true;
    }
}
