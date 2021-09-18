package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@Autonomous(name="Wheel_Tick_Test")
public class Wheel_Tick_Test extends Ticks_Autonomous_Base_One_Wheel {
    @Override
    public void runOpMode() throws InterruptedException {
        init_motors();

        waitForStart();


       move(0.50, 2000);
       sleep(10000);
    }
}
