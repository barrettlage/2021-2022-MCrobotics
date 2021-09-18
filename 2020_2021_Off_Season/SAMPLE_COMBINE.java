package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp(name="SAMPLE_COMBINE")
public class SAMPLE_COMBINE extends LinearOpMode {

    //Variable Name Declarations
    DcMotor motor;
    Servo servo1;
    ColorSensor color;
    CRServo servo2;
    boolean ButtonA;
    boolean ButtonB;
    boolean ButtonX;
    boolean ButtonY;
    boolean DpadUp;
    boolean DpadDown;
    boolean DpadLeft;
    boolean DpadRight;
    @Override

    public void runOpMode() throws InterruptedException {
        motor = hardwareMap.dcMotor.get("motor");
        servo1 = hardwareMap.servo.get("servo1");
        servo2 = hardwareMap.crservo.get("servo2");
        color = hardwareMap.colorSensor.get("color");
        waitForStart();
        while (opModeIsActive()) {
            ButtonA = gamepad1.a;
            ButtonB = gamepad1.b;
            ButtonX = gamepad1.x;
            ButtonY = gamepad1.y;
            DpadUp = gamepad1.dpad_up;
            DpadDown = gamepad1.dpad_down;
            DpadLeft = gamepad1.dpad_left;
            DpadRight = gamepad1.dpad_right;

            if (color.red()>50) {
                motor.setPower(1.00);
                sleep(1000);
                motor.setPower(0.00);
            }
            if (color.blue()>50) {
                servo2.setPower(1.00);
                sleep(1000);
                servo2.setPower(0.00);
            }
        }
    }
}