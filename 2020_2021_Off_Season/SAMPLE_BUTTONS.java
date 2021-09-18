package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="SAMPLE_BUTTONS")
public class SAMPLE_BUTTONS extends LinearOpMode {

    //Variable Name Declarations
    DcMotor motor;
    boolean ButtonA;
    boolean ButtonB;
    @Override

    public void runOpMode() throws InterruptedException {
        motor = hardwareMap.dcMotor.get("motor");
        waitForStart();
        while (opModeIsActive()) {
            ButtonA = gamepad1.a;
            ButtonB = gamepad1.b;

            if (ButtonA) {
                motor.setPower(1.00);
            }
            if (ButtonB) {
                motor.setPower(0.00);
            }
        }
        motor.setPower(0.00);
    }
}