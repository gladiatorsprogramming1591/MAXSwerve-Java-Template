package frc.robot.commands.PathPlanner.Column9;

import java.util.List;

import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.commands.FollowPathWithEvents;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem.DriveSubsystem;
import frc.robot.subsystems.MainIntakeSubsystem.ArmSubsystem;
import frc.robot.subsystems.MainIntakeSubsystem.IntakeSubsystem;

public class NewOnePieceAuto9 extends SequentialCommandGroup {

    public NewOnePieceAuto9(DriveSubsystem driveSubsystem, 
                        ArmSubsystem armSubsystem,
                        IntakeSubsystem intakeSubsystem
                        ){

        List<PathPlannerTrajectory> m_path = PathPlanner.loadPathGroup("One Piece Auto 9",
            Constants.AutoConstants.kMaxSpeedMetersPerSecond,
            Constants.AutoConstants.kMaxAccelerationMetersPerSecondSquared);


        addCommands(
                new FollowPathWithEvents(
                    driveSubsystem.followTrajectoryCommand(m_path.get(0), true),
                    m_path.get(0).getMarkers(),
                    Constants.AutoConstants.AUTO_EVENT_MAP),
                new FollowPathWithEvents(
                    driveSubsystem.followTrajectoryCommand(m_path.get(1), false),
                    m_path.get(1).getMarkers(),
                    Constants.AutoConstants.AUTO_EVENT_MAP),
                new FollowPathWithEvents(
                    driveSubsystem.followTrajectoryCommand(m_path.get(2), false),
                    m_path.get(2).getMarkers(),
                    Constants.AutoConstants.AUTO_EVENT_MAP)
                // new FollowPathWithEvents(
                //     driveSubsystem.followTrajectoryCommand(m_path.get(3), false),
                //     m_path.get(3).getMarkers(),
                //     Constants.AutoConstants.AUTO_EVENT_MAP)
            );
    }
}