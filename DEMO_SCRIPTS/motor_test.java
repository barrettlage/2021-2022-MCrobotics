package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="motor_est")
public class motor_test extends LinearOpMode {

    DcMotor Motor;
    //Gamepad1 Variables
    float left_y_value; //The right Joystick
    float right_y_value; //The left Joystick
    double MotorPower; //Left wheel's motor
    boolean ButtonA1; //Launch button

    @Override

    public void runOpMode() throws InterruptedException {
        Motor = hardwareMap.dcMotor.get("catapult");

        waitForStart();

        while (opModeIsActive()) {
            left_y_value = gamepad1.left_stick_y;
            MotorPower = left_y_value;
            MotorPower = Range.clip(MotorPower, -1, 1);
            Motor.setPower(MotorPower);

            ButtonA1 = gamepad1.a;
        }
    }
}