/*
FTC Team 4991 GearFreaks
Author(s):  Alex Pereira and Charles Burometto
Date: 15 Feb 2019
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="MR_SENSOR_DEMO")
public class MR_SENSOR_DEMO extends LinearOpMode {

    // Declare OpMode members.
    DcMotor dcmotor3;

    Servo servo0;
    Servo servo3;

    ColorSensor color1;  //REV color sensor
    TouchSensor touch1;

    float Yvalue1;
    float Xvalue1;
    float Yvalue2;
    float Xvalue2;

    boolean buttonA;
    boolean buttonB;
    boolean buttonX;
    boolean buttonY;

    boolean rbumper;


    double DCMotorSpeed =0.0;

    double SmartServoPosition = 0.0;
    double RegularServoPosition = 0.0;

    //Servo Positions
    double START = 0.5;   // servo start position
    double STOP = 0.5;    // servo stop position

    int STEP=1;           // keep track of which step we are in - used for automomous

    boolean LEDState = true;     //Tracks the mode of the color sensor; Active = true, Passive = false
    boolean colorDetected = false;

    private ElapsedTime     runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        dcmotor3 = hardwareMap.dcMotor.get("dcmotor3");

        servo0 = hardwareMap.servo.get("servo0");  // 180 degree servo
        servo3 = hardwareMap.servo.get("servo3");  // continuous servo

        touch1 = hardwareMap.touchSensor.get("touch1");
        color1 = hardwareMap.colorSensor.get("color1");
        color1.enableLed(true);

        color1.setI2cAddress(I2cAddr.create8bit(0x3a));

        //Servo Positions
        servo0.setPosition(START);
        servo3.setPosition(STOP);

        telemetry.addData("SERVO POS", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            //getJoystickSettings(joystick);
            Yvalue1 = -gamepad1.left_stick_y;
            Xvalue1 = -gamepad1.left_stick_x;

            buttonA = gamepad1.a;
            buttonB = gamepad1.b;
            buttonX = gamepad1.x;
            buttonY = gamepad1.y;

            rbumper = gamepad1.right_bumper;

            DCMotorSpeed = (Yvalue1 + Xvalue1);
            DCMotorSpeed = Range.clip(DCMotorSpeed, -1, 1);


            dcmotor3.setPower(DCMotorSpeed);


            //COLOR_READ = (color1.blue() < color1.red());
            telemetry.addData("Red", color1.red());
            telemetry.addData("Blue", color1.blue());
            telemetry.update();

            // is button pressed?
            if (touch1.isPressed()) {
                // button is pressed.
                telemetry.addData("Button", "PRESSED");
                telemetry.update();
            }
//            else {
//                // button is not pressed.
//                telemetry.addData("Button", "NOT PRESSED");
//            }

            if(rbumper) {
                servo3.setPosition(0.5);
                sleep(1000);
                telemetry.addData("Continuous:", "STOPPED");    //
                telemetry.update();
            }

            if(buttonA) {
                SmartServoPosition+=0.10;
                servo0.setPosition(SmartServoPosition);
                sleep(1000);
                telemetry.addData("Smart Servo is now at:", SmartServoPosition);    //
                telemetry.update();
            }
            if(buttonB) {
                SmartServoPosition-=0.10;
                servo0.setPosition(SmartServoPosition);
                sleep(1000);
                telemetry.addData("Smart Servo is now at:", SmartServoPosition);    //
                telemetry.update();
            }
            if(buttonX) {
                RegularServoPosition = 1.00;
                servo3.setPosition(RegularServoPosition);
                sleep(1000);
                telemetry.addData("Regular Servo is now at:", RegularServoPosition);    //
                telemetry.update();
            }
            if(buttonY) {
                RegularServoPosition = -1.00;
                servo3.setPosition(RegularServoPosition);
                sleep(1000);
                telemetry.addData("Regular Servo is now at:", RegularServoPosition);    //
                telemetry.update();
            }




        }

        //Prepares To End Match
        dcmotor3.setPower(0.00);

        telemetry.addData("Path", "Complete");
        telemetry.update();
        idle();
    }

}

