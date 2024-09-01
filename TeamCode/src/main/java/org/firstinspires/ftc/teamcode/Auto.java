package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class Auto extends LinearOpMode {
    private BrainSTEMRobot robot;
    @Override
    public void runOpMode() throws InterruptedException {
        robot = new BrainSTEMRobot(hardwareMap, telemetry, this);
        waitForStart();

        int ticks = 0;
        double pos = 0.99;
        double neg = -0.99;
        double off = 0;

        // try to make robot move motors within tick interval


    }

}
