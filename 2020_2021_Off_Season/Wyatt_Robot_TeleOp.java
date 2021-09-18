package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.robotcore.internal.camera.delegating.DelegatingCaptureSequence;

@TeleOp(name="Wyatt_Robot_TeleOp")
public class Wyatt_Robot_TeleOp extends LinearOpMode {

    DcMotor leftmotor;
    DcMotor rightmotor;
    DcMotor lift;
    DcMotor conveyor;

    float left_y_value;
    float right_y_value;
    boolean ButtonX;
    boolean ButtonA;
    boolean ButtonB;
    boolean ButtonY;
    boolean dpadUp;
    boolean dpadDown;
    float RightTrigger;
    double RPower;
    double LPower;
    double speed;

    int Start = 0;
    boolean Moving = false;
    boolean NotMoving = false;

    @Override
    public void runOpMode() throws InterruptedException {

            leftmotor = hardwareMap.dcMotor.get("left");
            rightmotor = hardwareMap.dcMotor.get("right");
            lift = hardwareMap.dcMotor.get("lift");
            conveyor = hardwareMap.dcMotor.get("conveyor");

            lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            lift.setTargetPosition(0);
            lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


            rightmotor.setDirection(DcMotor.Direction.REVERSE);
            conveyor.setDirection(DcMotor.Direction.REVERSE);


            telemetry.addData("Status", "Ready to run");
            telemetry.update();

            waitForStart();


            while (opModeIsActive()) {

                        //Drivetrain
                left_y_value = gamepad1.left_stick_y;
                right_y_value = gamepad1.right_stick_y;
                LPower = left_y_value;
                RPower = right_y_value;
                LPower = Range.clip(LPower, -1, 1);
                RPower = Range.clip(RPower, -1, 1);
                leftmotor.setPower(LPower);
                rightmotor.setPower(RPower);


                dpadDown = gamepad1.dpad_down;
                dpadUp = gamepad1.dpad_up;
                ButtonY = gamepad1.y;
                ButtonA = gamepad1.a;
                ButtonB = gamepad1.b;
                ButtonX = gamepad1.x;




                        //Conveyor
                if (ButtonA && !Moving) {
                    conveyor.setPower(0.10);
                    Moving = true;
                }
                else if (ButtonA && Moving) {
                    conveyor.setPower(0.00);
                    Moving = false;
                }

                if (ButtonB && !Moving) {
                    conveyor.setPower(-0.10);
                    Moving = true;
                }
                else if (ButtonB && Moving) {
                    conveyor.setPower(0.00);
                    Moving = false;
                }


                if (ButtonX) {
                    lift.setTargetPosition(527); //527 should work
                    lift.setPower(0.50);
                    while(lift.isBusy()) {
                        telemetry.addData("Position:",lift.getCurrentPosition());
                        telemetry.update();
                    }
                    lift.setPower(0.00);
                }

                if (ButtonY) {
                    lift.setTargetPosition(0);
                    lift.setPower(-0.50);
                    while(lift.isBusy()) {
                        telemetry.addData("Position:",lift.getCurrentPosition());
                        telemetry.update();
                    }
                    lift.setPower(0.00);
                }


                if(dpadUp){
                    Start = lift.getCurrentPosition();


                    lift.setTargetPosition(Start += 10);
                    lift.setPower(0.75);
                    while(lift.isBusy()) {
                    }
                    lift.setPower(0.00);
                    telemetry.addData("Current Pos UP:", lift.getCurrentPosition());
                    telemetry.update();
                }

                if(dpadDown){
                    Start = lift.getCurrentPosition();
                    Start -= 10;
                    lift.setTargetPosition(Start);
                    lift.setPower(0.75);
                    while(lift.isBusy()) {
                    }
                    lift.setPower(0.00);
                    telemetry.addData("Current Pos:", lift.getCurrentPosition());
                    telemetry.update();
                }





            }
    }
}
