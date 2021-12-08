package org.firstinspires.ftc.teamcode;

import android.widget.Button;
import android.widget.RadioButton;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.Range;

import org.checkerframework.checker.units.qual.A;

@TeleOp(name="COMP21_TankTread_TeleOp")
public class COMP21_TankTread_TeleOp extends LinearOpMode {
    // Defining the Motors, Servos, and other Devices.
    DcMotor LMotor;
    DcMotor RMotor;
    DcMotor Lift;
    Servo Bucket;

    // Defining the Variables
    boolean ButtonA;
    boolean LB;
    boolean RB;
    int destination = 0;
    float LS;
    float RS;

    @Override
    public void runOpMode() throws InterruptedException {

        // -- Hardwaremapping Section -- \\
        /* Hardwaremapping tells the program what the motors, servos, and other technical parts should be called
        in the Configuration. We also use this section the motors' directions, so that the robot drives the correct
        way, and set the mode of them, as well. */

        LMotor = hardwareMap.dcMotor.get("lmotor");
        RMotor = hardwareMap.dcMotor.get("rmotor");
        Lift = hardwareMap.dcMotor.get("lift");
        Lift.setTargetPosition(0);
        Lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Bucket = hardwareMap.servo.get("bucket");


       waitForStart();


       while (opModeIsActive()) {
            /*
                This is the COMP21_TankTread_TeleOp program, the COMP21 stands for Competition 2021, which
                shows that this program was made for and primarily used in the 2021 Competition Season, the second
                part of it, the TankTread part, signifies that it was coded for the Tank Tread robot specifically.
                The Tank Tread robot we made is used for Scrimmages and smaller events, meanwhile we use our
                Mecanum Wheel Robot for the main competitions and qualifiers.

                Finally, the TeleOp means that a person, or persons, control the robot via 1 or more gamepad
                controllers.

             */
           // Assigning the Variables to the buttons on the Gamepads.
           LS = gamepad1.left_stick_y;
           RS = gamepad1.right_stick_y;
           ButtonA = gamepad1.a;
           LB = gamepad1.left_bumper;
           RB = gamepad1.right_bumper;

           LMotor.setPower(-LS);
           RMotor.setPower(-RS);

            // Here, button A will set the position to 0.75, and tilt to where it is needed, to be able to deliver
           // the scoring elements.
           if (ButtonA) {
               Bucket.setPosition(0.25);
           }
           // Else, it will make sure the Bucket's position is set to 0, or  the starting/loading position.
           else {
               Bucket.setPosition(1.00);
           }

           //
           if (RB) {
               Lift.setPower(1.00); // Sets the power of the Lift to 100% in Forward
               destination=Lift.getCurrentPosition(); // Finds and Stores the current position of the Lift.
               destination+=50; // This adds the number of Ticks to the stored current position of the lift.
               sleep (200); // Sleep to ensure that it has time to complete the action.
               telemetry.addData("destination", destination); /* Telemetry statements so that we can see the
                current position of the Lift. */
               Lift.setTargetPosition(destination); // The Position of the Lift is Updated to the newer Position.
               telemetry.addData("destination", Lift.getCurrentPosition());
               telemetry.update();
               Lift.setPower(0.00);
           }

           if(LB) {
               destination = Lift.getCurrentPosition();
               destination -= 100; // plus and equal sign adds 100 and stores 100 as its new base value
               Lift.setPower(-1.00);
               sleep(200);
               telemetry.addData("destination", destination);
               Lift.setTargetPosition(destination); // the target is the new value that is equated
               telemetry.addData("destination", Lift.getCurrentPosition());
               telemetry.update();
               Lift.setPower(0.00);
           }
           


    }
}
}

