package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="Motor1_Position_Auto_Base")
public class Motor1_Position_Auto_Base extends Motor1_Autonomous_Base {

    @Override
    public void runOpMode() throws InterruptedException {

        init_motors();

        waitForStart();

            color();
            sleep(3000);

            drive(0.50, 2000);
            sleep(1000);

            //drive(0.50, 3500);

            //drive2(0.50, 2000);
            //sleep(1000);

            servo(0.00);
            sleep(1000);

            servo(1.00);
            sleep(1000);

            servo2(0.00);
            sleep(1000);

            servo2(1.00);
            sleep(1000);
            //sleep(10000);


    }
}
