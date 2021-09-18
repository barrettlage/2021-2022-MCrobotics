package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;

@TeleOp(name="SAMPLE_BUTTONS_SERVO_360")
public class SAMPLE_BUTTONS_SERVO_360 extends LinearOpMode {

    //Variable Name Declarations
    CRServo servo2;
    boolean ButtonA;
    boolean ButtonB;
    boolean ButtonX;
    @Override

    public void runOpMode() throws InterruptedException {
        servo2 = hardwareMap.crservo.get("servo2");
        waitForStart();
        while (opModeIsActive()) {
            ButtonA = gamepad1.a;
            ButtonB = gamepad1.b;
            ButtonX = gamepad1.x;

            if (ButtonA) {
                servo2.setPower(0.00);
            }
            if (ButtonB) {
                servo2.setPower(1.00);
            }
            if (ButtonX) {
                servo2.setPower(-1.00);
            }
        }
        servo2.setPower(0.00);
    }
}