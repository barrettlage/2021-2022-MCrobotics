package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

public abstract class Ticks_Autonomous_Base_One_Wheel extends LinearOpMode {

    DcMotor FLMotor;


    public void init_motors () {
        FLMotor = hardwareMap.dcMotor.get("flmotor");
        FLMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FLMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
    public void move (double speed, int ticks) {
        speed = Range.clip(speed, -1, 1);

        FLMotor.setTargetPosition(ticks);
        FLMotor.setPower(speed);
        while(FLMotor.isBusy()) { sleep(500);}


    }


}


