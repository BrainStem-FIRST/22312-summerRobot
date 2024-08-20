public class Collector extends Subsystem {

    DcMotorEx collectMotor;

    enum CollectorStates {
        ON, OFF
    };

    CollectorStates collectorState;

    public Lift(HardwareMap hwMap, Telemetry telemetry, Gamepad gamepad1) {
        super(hwMap, telemetry, gamepad1);

        collectMotor = (DcMotorEx) hwMap.dcMotor.get("CollectMotor");
        collectMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        collectorState = CollectorStates.OFF;
    }

    private void spinCollector() { collectMotor.setPower(-gamepad1.right_trigger * 0.5); }
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

    private void checkNewState() {
        if(gamepad1.right_trigger > 0.2) {
            collectorState = CollectorStates.ON;
        } else {
            collectorState = CollectorStates.OFF;
        }
    }

    public void update() {
        checkNewState();
        updateState();
    }
}