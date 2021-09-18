/*
FTC Team 4991 GearFreaks
Author:  Joe Walton
Date: 29 Oct 2017
Modified by:
Modified Date:
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="RevDemoRobot")
public class RevDemoRobot extends LinearOpMode {

    // Declare OpMode members.
    DcMotor driveLeft;
    DcMotor driveRight;

    DcMotor throwBall;

    Servo Reload;

    boolean buttonA;
    boolean buttonB;


    int GOOD = 0;
    int launchPos = 0;
    int target = -1680;

    // target is negative so + goes up and - goes down


    //DcMotorController.DeviceMode DevMode;
    private ElapsedTime     runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        driveRight = hardwareMap.dcMotor.get("right");
        driveRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        driveLeft = hardwareMap.dcMotor.get("left");
        driveLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        throwBall = hardwareMap.dcMotor.get("throwBall");
        throwBall.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        throwBall.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        throwBall.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        Reload = hardwareMap.servo.get("LoadBall");

        driveLeft.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        Reload.setPosition(0.82);
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        while (opModeIsActive() ) {
            //getJoystickSettings(joystick);

            //left joystick controls the robot for:
            //     forward
            //     reverse
            //     straf left (sideways)
            //     straf right (sideways)
            //     and all diagonals
            float Yvalue1 = gamepad1.left_stick_y;
            float Xvalue2 = gamepad1.right_stick_x;

            float LF = (Yvalue1 - Xvalue2);
            float RF = (Yvalue1 + Xvalue2);

            LF = Range.clip(LF, -1, 1);
            RF = Range.clip(RF, -1, 1);

            // only use if turning robot --- MAY HAVE TO REVERSE THE VALYES
            /*if(Xvalue2 != 0){
                RF -= Xvalue2;
                LF += Xvalue2;
            }
*/
            driveLeft.setPower(LF);
            driveRight.setPower(RF);

//            float BYvalue1 = -gamepad2.left_stick_y;
//            float BXvalue1 = -gamepad2.left_stick_x;
//            float linear_power = (BYvalue1 + BXvalue1);
//
//            linear_power = Range.clip(linear_power, -1, 1);
//            //linearLift.setPower(linear_power);

            // get current button values
            buttonA = gamepad1.a;

            // target is negative so + goes up and - goes down
            // need to fine tune the target distance from 3000 ticks to ???
            if(buttonA && GOOD == 0) {
                GOOD=1;
                launchPos = (throwBall.getCurrentPosition());
                launchPos -= target;
                if(launchPos < 0){
                    launchPos=0;
                }
                throwBall.setTargetPosition(launchPos);
                throwBall.setPower(0.4);
                telemetry.addData("GOING TO A", launchPos);    //
                telemetry.update();
            }

            buttonB = gamepad1.b;

            if(buttonB && GOOD == 0 ) {
                GOOD=1;
                Reload.setPosition(0.0);

            }
            else if(!buttonB){
                sleep(50);
                Reload.setPosition(0.82);
                GOOD=0;
            }


            if(Math.abs(throwBall.getCurrentPosition() - throwBall.getTargetPosition()) <= 20){
                GOOD = 0;
            }


            telemetry.addData("CurrPos", throwBall.getCurrentPosition());
            telemetry.addData("Good", GOOD);
            telemetry.update();
        }
        // end of OpMode = Game over/stop pushed

        driveLeft.setPower(0.00);
        driveRight.setPower(0.00);
        telemetry.addData("Path", "Complete");
        telemetry.update();
        //sleep(1000);
        idle();
    }

}
