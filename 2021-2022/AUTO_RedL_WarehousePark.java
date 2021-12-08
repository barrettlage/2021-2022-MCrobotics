package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="AUTO_RedL_WarehousePark")
public class AUTO_RedL_WarehousePark extends COMP21_Auto_Mecanum_Base {

    @Override
    public void runOpMode() throws InterruptedException {


        // Defining the Motors, Servos, and Color Sensor.
        DcMotor Lift;
        Servo Intake;
        ColorSensor Color;

        // Defining the Variables used in the program.
        int destination=0;
        double FL_power = 0.0;
        double FR_power = 0.0;
        double BL_power = 0.0;
        double BR_power = 0.0;


        init_motors();

        // Hardwaremapping the various devices.
        Intake = hardwareMap.servo.get("intake");
        Color = hardwareMap.colorSensor.get("color");
        Lift = hardwareMap.dcMotor.get("lift");
        Lift.setTargetPosition(0);
        Lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();
        /*
            The goal of this program is to drive up to one of the 3 squares and check for the Duck/Team
            Shipping Element. If it does not detect one of the game elements, it will strafe to the next square.
            It does this with the first two, if it doesn't detect the game elements there, it automatically assumes
            that it is located in the 3rd square, and will drop the cube off in the 3rd level.

            After this, it will make a turn, which roughly lines up the robot in a straight line to the Warehouse.
            After making the turn, it will drive forward enough to go over the bars and park fully in the Warehouse.


        The Drive Motors are 312 RPM with 537.7 Pulses per Rotation
        */

        drive(0.50, 650);

        sleep(750);

        if(Color.red() > 100) {

            telemetry.addData("Object 1 detected, Red =", Color.red());
            telemetry.update();
            strafe(0.50,-1500);
            drive(0.50,-75);
            Lift.setPower(0.50);
            Lift.setTargetPosition(750);
            sleep(1000);
            drive(0.50, 75);
            Intake.setPosition(0.00);
            sleep(2000);
            Intake.setPosition(0.50);
            drive(0.50,-150);
            Lift.setPower(0.50);
            Lift.setTargetPosition(0);


        }
        else {

            strafe(0.50,-425);

            if(Color.red() > 100) {

                telemetry.addData("Object 2 detected, Red =", Color.red());
                telemetry.update();
                strafe(0.50, -1000);
                drive(0.50, -75);
                Lift.setPower(0.50);
                Lift.setTargetPosition(1250);
                sleep(2000);
                drive(0.50, 75);
                Intake.setPosition(0.00);
                sleep(2000);
                Intake.setPosition(0.50);
                drive(0.50, -150);
                Lift.setPower(0.50);
                Lift.setTargetPosition(0);

            }
            else {
                telemetry.addData("Object 3 detected, Red =", Color.red());
                telemetry.update();
                strafe(0.50, -1000);
                drive(0.50, -75);
                Lift.setPower(0.50);
                Lift.setTargetPosition(1750);
                sleep(2000);
                drive(0.50, 175);
                Intake.setPosition(0.00);
                sleep(2000);
                Intake.setPosition(0.50);
                drive(0.50, -250);
                Lift.setPower(0.50);
                Lift.setTargetPosition(0);
            }
        }

        Lift.setPower(0.50);
        Lift.setTargetPosition(500);

        turn(0.50,-1110);

        strafe(0.50, 150);

        drive(0.80,3000);

        Lift.setPower(0.50);
        Lift.setTargetPosition(0);


    }


}