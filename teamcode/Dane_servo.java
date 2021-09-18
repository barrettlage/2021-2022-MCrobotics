package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name="Dane_servo")
public class Dane_servo extends Motor1_TeleOp_Base {

    @Override
    public void runOpMode() throws InterruptedException {

        init_motors2();

        waitForStart();

        while (opModeIsActive()) {

            init_booleans();

            if(RT > 0.1) {
                FRMotor.setPower(-1.00);
            }



            if(LT > 0.1) {
                FLMotor.setPower(-1.00);

            }

            if(RB) {
                FRMotor.setPower(1.00);
            }

            else {
                FRMotor.setPower(0.00);
            }

            if(LB) {
                FLMotor.setPower(1.00);

            }
            else {
                FLMotor.setPower(0.00);
            }

            if (A) {
                ContinuousServo.setPosition(1.00);
            }

            if (B) {
                ContinuousServo.setPosition(0.00);
            }
             else {
                 ContinuousServo.setPosition(0.50);
            }
             if (Y) {
                 HalfServo.setPosition(1.00);
             }
             if (X) {
                 HalfServo.setPosition(0.00);
             }
             else {
                 HalfServo.setPosition(0.50);
             }




        }
    }
}
