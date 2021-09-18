package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;



@Autonomous (name = "Ultimate_goal_basicAuto")
public class Ultimate_goal_basicAuto extends LinearOpMode {

    // Declare OpMode members.
    DcMotor FL;
    DcMotor FR;
    DcMotor BL;
    DcMotor BR;

    DcMotor Flywheel1;
    DcMotor Flywheel2;

    Servo OpenClaw;
    DcMotor wobblegoal_arm;

    DcMotor intake;
    Servo loadingservo;

    int GOOD=0;


    int step = 1;

    int pos = 0;


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

        Flywheel1 = hardwareMap.dcMotor.get("flywhell1");
        Flywheel2 = hardwareMap.dcMotor.get("flywheel2");

        wobblegoal_arm = hardwareMap.dcMotor.get("wobble");
        wobblegoal_arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        wobblegoal_arm.setTargetPosition(0);
        wobblegoal_arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        intake = hardwareMap.dcMotor.get("intake");

        loadingservo = hardwareMap.servo.get("loader");


        OpenClaw = hardwareMap.servo.get("openClaw");
        //  RotateClaw = hardwareMap.servo.get("rotateClaw");


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

                    drive(24);
                    strafe(24);

                    step++;
                    break;
            }
            switch(step) {
                case 2:
                    intake.setPower(1.00);
                    drive(-25);
                    wait(100);
                    intake.setPower(0.00);
            }
            switch(step) {
                case 3:
                    Flywheel1.setPower(1.00);
                    Flywheel2.setPower(1.00);
                    drive(20);
                    wait(100);
                    loadingservo.setPosition(1.00);
                    loadingservo.setPosition(0.00);
                    loadingservo.setPosition(1.00);
                    loadingservo.setPosition(0.00);
                    loadingservo.setPosition(1.00);
                    loadingservo.setPosition(0.00);
                    Flywheel1.setPower(0.00);
                    Flywheel2.setPower(0.00);

            }
            switch(step) {
                case 3:
                    drive(3);
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

