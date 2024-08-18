package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp")
public class Tele extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    private BrainSTEMRobot robot;
    private double leftStickX, leftStickY, rightStickX;
    private static final double threshold = 0.1;


    @Override
    public void runOpMode() throws InterruptedException {

        robot = new BrainSTEMRobot(this.hardwareMap, this.telemetry, this);

        double leftStick;
        telemetry.addData("Opmode Status :", "Init");
        telemetry.update();
        waitForStart();


        while (opModeIsActive()) {

            leftStickX = gamepad1.left_stick_x;
            leftStickY = gamepad1.left_stick_y * -1;

            if (Math.abs(gamepad1.right_stick_x) > threshold) {
                if (gamepad1.right_stick_x < 0)
                    rightStickX = gamepad1.right_stick_x * gamepad1.right_stick_x * -1 * (4.0 / 5.0) - (1.0 / 5.0);
                else
                    rightStickX = gamepad1.right_stick_x * gamepad1.right_stick_x * (4.0 / 5.0) + (1.0 / 5.0);
            } else {
                rightStickX = 0;

                if ((Math.abs(gamepad1.left_stick_y) > threshold) || (Math.abs(gamepad1.left_stick_x) > threshold) || Math.abs(gamepad1.right_stick_x) > threshold) {
                    //Calculate formula for mecanum drive function
                    double addValue = (double) (Math.round((100 * (leftStickY * Math.abs(leftStickY) + leftStickX * Math.abs(leftStickX))))) / 100;
                    double subtractValue = (double) (Math.round((100 * (leftStickY * Math.abs(leftStickY) - leftStickX * Math.abs(leftStickX))))) / 100;


                    //Set motor speed variables
                    robot.setDTMotorPowers((addValue + rightStickX), (subtractValue - rightStickX), (subtractValue + rightStickX), (addValue - rightStickX));
                } else {
                    robot.stop();
                }
            }
        }
    }
}