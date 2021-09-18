/*
FTC Team 4991 GearFreaks
Author(s):  Alex Pereira and Charles Burometto
Date: 15 Feb 2019
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Catch")
public class Catch extends LinearOpMode {

    // Declare OpMode members.
    DcMotor Left;
    DcMotor Right;
    DcMotor Catapult;  // need to use encoder with this motor - neverest 60  1680 ticks

    Float DCMotorSpeed;
    float Yvalue1;
    float Xvalue1;
    float Yvalue2;
    float Xvalue2;

    boolean buttonA;
    boolean buttonB;
    boolean buttonX;
    boolean buttonY;
    boolean dpad_up;
    boolean dpad_down;
    boolean dpad_left;
    boolean dpad_right;

    int Launch;

    boolean start_game = false;
    int launch_position = 0;

    ColorSensor color1; // color sensor

    boolean LEDState = true;
    //Tracks the mode of the color sensor; Active = true, Passive = false
    boolean colorDetected = false;

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        Left = hardwareMap.dcMotor.get("left");
        Right = hardwareMap.dcMotor.get("right");
        Left.setDirection(DcMotor.Direction.REVERSE);

        Catapult = hardwareMap.dcMotor.get("catapult");
        //Catapult.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Catapult.setTargetPosition(0);
        Catapult.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        color1 = hardwareMap.colorSensor.get("color1");
        color1.enableLed(true);
        //color1.setI2cAddress(I2cAddr.create8bit(0x3a));

        telemetry.addData("Robot Initiatized:", "Ready to Start");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {


            //getJoystickSettings(joystick);
            Yvalue1 = gamepad1.left_stick_y;
            Yvalue2 = gamepad1.right_stick_y;

            Yvalue1 = Range.clip(Yvalue1, -1, 1);
            Yvalue2 = Range.clip(Yvalue2, -1, 1);

            Left.setPower(Yvalue1);
            Right.setPower(Yvalue2);

            buttonA = gamepad1.a;
            buttonB = gamepad1.b;
            buttonX = gamepad1.x;
            dpad_up = gamepad1.dpad_up;
            dpad_down = gamepad1.dpad_down;
            dpad_left = gamepad1.dpad_left;
            dpad_right = gamepad1.dpad_right;

            if (buttonA){
                telemetry.addData("Current Position", Catapult.getCurrentPosition());
                Launch = Catapult.getCurrentPosition();
                Catapult.setTargetPosition(Launch + 500);
                Catapult.setPower(0.50);
                telemetry.addData("New Position", Catapult.getCurrentPosition());
                telemetry.update();
            }
            if (buttonB){
                Catapult.setPower(0.00);
            }
            if (buttonX){
                telemetry.addData("Current Position", Catapult.getCurrentPosition());
                Launch = Catapult.getCurrentPosition();
                Catapult.setTargetPosition(Launch + 1680);
                Catapult.setPower(0.50);
                while (Catapult.isBusy()){
                    telemetry.addData("New Position", Catapult.getCurrentPosition());
                    telemetry.update();
                }
                sleep(1000);
            }
            if (dpad_up){
                telemetry.addData("Current Position", Catapult.getCurrentPosition());
                Launch = Catapult.getCurrentPosition();
                Catapult.setTargetPosition(Launch + 105);
                Catapult.setPower(0.50);
                telemetry.addData("New Position", Catapult.getCurrentPosition());
                telemetry.update();
            }
            if (dpad_down){
                telemetry.addData("Current Position", Catapult.getCurrentPosition());
                Launch = Catapult.getCurrentPosition();
                Catapult.setTargetPosition(Launch - 105);
                Catapult.setPower(0.50);
                telemetry.addData("New Position", Catapult.getCurrentPosition());
                telemetry.update();
            }
            if (dpad_left){
                telemetry.addData("Current Position", Catapult.getCurrentPosition());
                Launch = Catapult.getCurrentPosition();
                Catapult.setTargetPosition(Launch - 52);
                Catapult.setPower(0.50);
                telemetry.addData("New Position", Catapult.getCurrentPosition());
                telemetry.update();
            }
            if (dpad_right){
                telemetry.addData("Current Position", Catapult.getCurrentPosition());
                Launch = Catapult.getCurrentPosition();
                Catapult.setTargetPosition(Launch + 52);
                Catapult.setPower(0.50);
                telemetry.addData("New Position", Catapult.getCurrentPosition());
                telemetry.update();
            }
        }
    }
}