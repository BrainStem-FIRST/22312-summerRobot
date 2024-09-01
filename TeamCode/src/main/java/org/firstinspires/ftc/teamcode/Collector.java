package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Collector extends Subsystem {

    DcMotorEx collectMotor;
    public double amp = 0;

    enum CollectorStates {
        ON, OFF
    };

    CollectorStates collectorState;

    public Collector(HardwareMap hwMap, Telemetry telemetry) {
        super(hwMap, telemetry);

        collectMotor = (DcMotorEx) hwMap.dcMotor.get("CollectMotor");
        collectMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        collectorState = CollectorStates.OFF;
    }

    public void setAmp(double amp) {
        this.amp = amp;
    }

    private void spinCollector() { collectMotor.setPower(-amp* 0.5); }
    private void stopCollector() { collectMotor.setPower(0); }

    private void updateState() {
        switch(collectorState) {
            case ON:
                spinCollector();
                break;
            case OFF:
                stopCollector();
                break;
        }
    }

    public void update() {
        updateState();
    }
}