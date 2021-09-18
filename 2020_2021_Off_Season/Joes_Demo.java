/*
FTC Team 4991 GearFreaks
Author(s):  Alex Pereira and Charles Burometto
Date: 15 Feb 2019
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp(name="Joes_Demo")
public class Joes_Demo extends LinearOpMode {

    // Declare OpMode members.
    DcMotor dcmotor1;

    Servo servo1;   // 180 servo
    Servo servo2;   // continuous servo

    float Yvalue1;
    float Xvalue1;
    float Yvalue2;
    float Xvalue2;

    boolean buttonA;
    boolean buttonB;
    boolean buttonX;
    boolean buttonY;

    boolean rbumper;

    ColorSensor color1; // color sensor
    TouchSensor touch1; // touch sensor
    ModernRoboticsI2cRangeSensor range1;
    double range_value;

    OpticalDistanceSensor ods1;
    double odsValueRaw;
    double odsValue;

    DistanceSensor distance1;

    double DCMotorSpeed =0.0;

    double RegularServoPosition = 0.0;
    double SmartServoPosition = 0.0;

    //Servo Positions
    double START = 0.5;
    double SPEED = 0.5;

    boolean LEDState = false;     //Tracks the mode of the color sensor; Active = true, Passive = false
    boolean colorDetected = false;

    private ElapsedTime     runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        dcmotor1 = hardwareMap.dcMotor.get("dcmotor1");

        servo1 = hardwareMap.servo.get("servo1");
        servo2 = hardwareMap.servo.get("servo2");

        color1 = hardwareMap.colorSensor.get("color1");
        color1.enableLed(true);
        touch1 = hardwareMap.touchSensor.get("touch1");

        color1.setI2cAddress(I2cAddr.create8bit(0x3a));

        range1 = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "range1");
        ods1 = hardwareMap.opticalDistanceSensor.get("ods1");

        //Servo Positions
        servo2.setPosition(START);
        servo1.setPosition(START);

        telemetry.addData("SERVO POS", START);
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            //getJoystickSettings(joystick);
            Yvalue1 = -gamepad1.left_stick_y;
            Xvalue1 = -gamepad1.left_stick_x;
            Yvalue2 = -gamepad1.right_stick_y;
            Xvalue2 = -gamepad1.right_stick_x;

            buttonA = gamepad1.a;
            buttonB = gamepad1.b;
            buttonX = gamepad1.x;
            buttonY = gamepad1.y;

            rbumper = gamepad1.right_bumper;

            DCMotorSpeed = (Yvalue1 + Xvalue1);
            DCMotorSpeed = Range.clip(DCMotorSpeed, -1, 1);

            dcmotor1.setPower(DCMotorSpeed);
            range_value = range1.getDistance(DistanceUnit.INCH);

            odsValueRaw = ods1.getRawLightDetected();
            odsValue = Math.pow(odsValueRaw, -0.5);

            //COLOR_READ = (color1.blue() < color1.red());
            telemetry.addData("Red", color1.red());
            telemetry.addData("Blue", color1.blue());
            telemetry.addData("Range", range_value);
            telemetry.addData("ODS Value", odsValue);
            telemetry.update();

            if(Yvalue2 > 0.25) { SPEED = 1.0; }
            if(Yvalue2 < -0.25) { SPEED = 0.0; }
            if(Yvalue2 > -0.25 && Yvalue2 < 0.25) { SPEED = 0.5; }
            servo2.setPosition(SPEED);

            // is button pressed?
            if (touch1.isPressed()) {
                // button is pressed.
                telemetry.addData("Button", "PRESSED");
                telemetry.update();
            }

            if(rbumper) {
                servo2.setPosition(0.5);
                sleep(1000);
                telemetry.addData("Continuous:", "STOPPED");    //
                telemetry.update();
            }

            if(buttonA) {
                SmartServoPosition+=0.10;
                servo1.setPosition(SmartServoPosition);
                sleep(1000);
                telemetry.addData("Smart Servo is now at:", SmartServoPosition);    //
                telemetry.update();
            }

            if(buttonB) {
                SmartServoPosition-=0.10;
                servo1.setPosition(SmartServoPosition);
                sleep(1000);
                telemetry.addData("Smart Servo is now at:", SmartServoPosition);    //
                telemetry.update();
            }

            if(buttonX) {
                RegularServoPosition = 1.00;
                servo2.setPosition(RegularServoPosition);
                sleep(1000);
                telemetry.addData("Regular Servo is now at:", RegularServoPosition);    //
                telemetry.update();
            }

            if(buttonY) {
                RegularServoPosition = -1.00;
                servo2.setPosition(RegularServoPosition);
                sleep(1000);
                telemetry.addData("Regular Servo is now at:", RegularServoPosition);    //
                telemetry.update();
            }
        }

        //Prepares To End Match
        dcmotor1.setPower(0.00);
        color1.enableLed(false);

        telemetry.addData("Path", "Complete");
        telemetry.update();
        idle();
    }

}