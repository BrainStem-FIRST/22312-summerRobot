package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class BrainSTEMRobot {
    // Don't touch these
    public Telemetry telemetry;
    public OpMode opMode;

    public DriveTrain driveTrain;
    public Lift lift;
    public Collector collector;

    public BrainSTEMRobot(HardwareMap hwMap, Telemetry telemetry, OpMode opMode) {

        this.telemetry = telemetry;
        this.opMode = opMode;

        driveTrain = new DriveTrain(hwMap, telemetry);
        lift = new Lift(hwMap, telemetry);
        collector = new Collector(hwMap, telemetry);
    }

    public void update() {
        lift.update();
        collector.update();
    }
}