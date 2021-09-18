/*
FTC Team 4991 GearFreaks
Author:  Charles Burometto
Date: 7 Nov 2019
Modified by:
Modified Date:
*/
/*
FTC Team 4991 GearFreaks
Author:  Charles Burometto
Date: 7 Nov 2019
Modified by:
Modified Date:02/10/20
working
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="Auto_Park_Move_Left_Forward")
public class Auto_Park_Move_Left_Forward extends LinearOpMode {

    // Declare OpMode members.
    DcMotor FL;
    DcMotor FR;
    DcMotor BL;
    DcMotor BR;
    DcMotor XRail;

    Servo OpenClaw;
    Servo RotateClaw;
    Servo GrabPlatform1;
    Servo GrabPlatform2;
    Servo ExtendActuator;

    int GOOD=0;
    int xRailPosition = 0;
    //double clawRotation = 0.5;

    int step = 1;

    int pos = 0;

    double ActuatorPower = 0;
    double RELEASE = 0.3;
    double GRAB = 0.8;


    //DcMotorController.DeviceMode DevMode;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        FL = hardwareMap.dcMotor.get("FL");
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FL.setTargetPosition(0);
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        FR = hardwareMap.dcMotor.get("FR");
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setTargetPosition(0);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        BL = hardwareMap.dcMotor.get("BL");
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setTargetPosition(0);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        BR = hardwareMap.dcMotor.get("BR");
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setTargetPosition(0);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        ExtendActuator = hardwareMap.servo.get("extendXRail");

        XRail = hardwareMap.dcMotor.get("raiseXRail");
        XRail.setTargetPosition(0);
        XRail.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        XRail.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        OpenClaw = hardwareMap.servo.get("openClaw");
      //  RotateClaw = hardwareMap.servo.get("rotateClaw");
        GrabPlatform1 = hardwareMap.servo.get("grabPlatform1");
        GrabPlatform2 = hardwareMap.servo.get("grabPlatform2");

        FL.setDirection(DcMotor.Direction.REVERSE);
        BL.setDirection(DcMotor.Direction.REVERSE);

        //RotateClaw.setPosition(clawRotation);

        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        while (opModeIsActive()) {
            switch(step) {
                case 1:
                    /*ExtendActuator.setPosition(1);
                    sleep(4000);
                    ExtendActuator.setPosition(0.5);*/

                    GrabPlatform1.setPosition(1);
                    GrabPlatform2.setPosition(0);
                    //OpenClaw.setPosition(RELEASE);

                    strafe(24);
                    drive(24);

                    step++;
                    break;
            }

        }

    }
    public void drive(int inches) {

        BL.setPower(1);
        BR.setPower(1);
        FL.setPower(1);
        FR.setPower(1);

        FL.setTargetPosition(FL.getCurrentPosition()+inches*60);
        FR.setTargetPosition(FR.getCurrentPosition()+inches*60);
        BL.setTargetPosition(BL.getCurrentPosition()+inches*60);
        BR.setTargetPosition(BR.getCurrentPosition()+inches*60);

        while (FR.isBusy()) {}

        FL.setPower(0.00);
        FR.setPower(0.00);
        BL.setPower(0.00);
        BR.setPower(0.00);

    }
    public void strafe(int inches) {

        BL.setPower(1);
        BR.setPower(1);
        FL.setPower(1);
        FR.setPower(1);

        FL.setTargetPosition(FL.getCurrentPosition()-inches*60);
        FR.setTargetPosition(FR.getCurrentPosition()+inches*60);
        BL.setTargetPosition(BL.getCurrentPosition()+inches*60);
        BR.setTargetPosition(BR.getCurrentPosition()-inches*60);

        while (FR.isBusy()) {}

        FL.setPower(0.00);
        FR.setPower(0.00);
        BL.setPower(0.00);
        BR.setPower(0.00);

    }

}



//  ColorSensor color;                //for reading color on beacon


//  boolean LEDState = false;//mode of the color sensor;
//Active = true, Passive = false
// Send telemetry message to signify robot waiting;

//     telemetry.addData("Status", "Ready to run");    //
//              telemetry.update();
