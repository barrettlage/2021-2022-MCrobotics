package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="SAMPLE_BUTTONS_SERVO")
public class SAMPLE_BUTTONS_SERVO extends LinearOpMode {

    //Variable Name Declarations
    Servo servo1;
    boolean ButtonA;
    boolean ButtonB;
    boolean ButtonX;
    @Override

    public void runOpMode() throws InterruptedException {
        servo1 = hardwareMap.servo.get("servo1");
        servo1.setPosition(0.00);
        waitForStart();
        while (opModeIsActive()) {
            ButtonA = gamepad1.a;
            ButtonB = gamepad1.b;
            ButtonX = gamepad1.x;

            if (ButtonA) {
                servo1.setPosition(0.00);
            }
            if (ButtonB) {
                servo1.setPosition(1.00);
            }
            if (ButtonX) {
                servo1.setPosition(0.50);
            }
        }
    }
}