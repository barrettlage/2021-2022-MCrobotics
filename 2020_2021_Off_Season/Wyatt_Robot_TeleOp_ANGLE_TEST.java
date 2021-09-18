package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Wyatt_Robot_TeleOp_ANGLE_TEST")
public class Wyatt_Robot_TeleOp_ANGLE_TEST extends LinearOpMode {

    DcMotor leftmotor;
    DcMotor rightmotor;
    DcMotor lift;
    DcMotor conveyor;

    float left_y_value;
    float right_y_value;
    boolean dpadUp;
    boolean dpadDown;
    boolean ButtonA;
    boolean ButtonB;
    float RightTrigger;
    double RPower;
    double LPower;
    double speed;

    int Start = 0;

    @Override
    public void runOpMode() throws InterruptedException {

        //leftmotor = hardwareMap.dcMotor.get("left");
        //rightmotor = hardwareMap.dcMotor.get("right");
        lift = hardwareMap.dcMotor.get("lift");
        //conveyor = hardwareMap.dcMotor.get("conveyor");

        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lift.setTargetPosition(0);
        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        //leftmotor.setDirection(DcMotor.Direction.REVERSE);


        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        waitForStart();


        while (opModeIsActive()) {

            /*left_y_value = gamepad1.left_stick_y;
            right_y_value = gamepad1.right_stick_y;
            LPower = left_y_value;
            RPower = right_y_value;
            LPower = Range.clip(LPower, -1, 1);
            RPower = Range.clip(RPower, -1, 1);
            leftmotor.setPower(LPower);
            rightmotor.setPower(RPower);

             */

            dpadUp = gamepad1.dpad_up;
            dpadDown = gamepad1.dpad_down;
            ButtonA = gamepad1.a;
            ButtonB = gamepad1.b;




            if(dpadUp){
                Start = lift.getCurrentPosition();


                lift.setTargetPosition(Start += 10);
                lift.setPower(1.00);
                while(lift.isBusy()) {
                }
                lift.setPower(0.00);
                telemetry.addData("CurrentPos UP:", lift.getCurrentPosition());
                telemetry.update();
            }

            if(dpadDown){
                Start = lift.getCurrentPosition();
                Start -= 10;
                lift.setTargetPosition(Start);
                lift.setPower(1.00);
                while(lift.isBusy()) {
                }
                lift.setPower(0.00);
                telemetry.addData("CurrentPos:", lift.getCurrentPosition());
                telemetry.update();
            }
        }

    }
}
