package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.Range;

public abstract class Motor1_TeleOp_Base extends LinearOpMode {

    DcMotor FLMotor;
    DcMotor FRMotor;
    Servo HalfServo;
    Servo ContinuousServo;
    ColorSensor Color1;
    TouchSensor Touch1;
    int target=0;
    int target2=0;
    boolean RB;
    boolean LB;
    boolean Y;
    boolean A;
    boolean B;
    boolean X;
    float RT;
    float LT;
    float RS;
    float LS;
    float rvalue = gamepad1.right_stick_y;
    double rightspeed = 0.0;
    double leftspeed = 0.0;
    public void init_motors2 () {
        FLMotor = hardwareMap.dcMotor.get("motor1");
        FRMotor = hardwareMap.dcMotor.get("motor2");
        HalfServo = hardwareMap.servo.get("servo1");
        ContinuousServo = hardwareMap.servo.get("servo2");
        /*Color1 = hardwareMap.colorSensor.get("color1");
        Touch1 = hardwareMap.touchSensor.get("touch1");
        */


    }

    public void init_booleans () {
        RB = gamepad1.right_bumper;
        LB = gamepad1.left_bumper;
        RT = gamepad1.right_trigger;
        LT = gamepad1.left_trigger;
        RS = gamepad1.right_stick_y;
        LS = gamepad1.left_stick_y;
        A = gamepad1.a;
        B = gamepad1.b;
        Y = gamepad1.y;
        X = gamepad1.x;
    }

}