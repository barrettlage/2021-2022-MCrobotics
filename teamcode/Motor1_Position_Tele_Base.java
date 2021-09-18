package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name="Motor1_Position_Tele_Base")
public class Motor1_Position_Tele_Base extends Motor1_TeleOp_Base {

    @Override
    public void runOpMode() throws InterruptedException {

        init_motors2();

        waitForStart();

        while (opModeIsActive()) {

            init_booleans();

            if (RS > .5) {

            }
        }
    }
}
