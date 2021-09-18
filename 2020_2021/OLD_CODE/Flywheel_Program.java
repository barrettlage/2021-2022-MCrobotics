package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;


@TeleOp(name="Flywheel_Program")
public class Flywheel_Program extends LinearOpMode {


    /* Declaring the Flywheel's Motor(s).
    Can be configured to only use 1 motor, too.
*/
    DcMotor Flywheel1;
    DcMotor Flywheel2;


        /*
    To convert this into a program for 1 DcMotor only, comment out any line of code with 'Flywheel2' in it.
    This way it will only run the first Flywheel Motor, and not both.
    */


    // Declaring the Controller's buttons to activate and de-activate the Flywheel Motor(s).
    boolean buttonY;
    boolean buttonB;
    boolean buttonA;


    @Override
    public void runOpMode() throws InterruptedException {

        // Hardware Mapping the 2 DcMotors.
        Flywheel1 = hardwareMap.dcMotor.get("Left");
        Flywheel2 = hardwareMap.dcMotor.get("Right");


        // Reversing the Right Flywheel DcMotor. (This line can be commented out if you are using only 1 Motor.)
        Flywheel2.setDirection(DcMotor.Direction.REVERSE);


        // Below, the Telemetry is stating that the Flywheel Program is ready to run.
        telemetry.addData("Status", "Ready to run");
        telemetry.update();


        waitForStart();

        while (opModeIsActive()) {

            // Getting the values of the buttons needed to start and stop the Flywheel Motor(s).
            buttonY = gamepad1.y;
            buttonB = gamepad1.b;
            buttonA = gamepad1.a;



            // The code below is used to start the Flywheel Motor(s) at 100% Throttle when the 'Y' button is pushed on the Controller.
            if (buttonY) {
                telemetry.addData("Flywheel Motors Engaged.", " ");
                telemetry.update();
                Flywheel1.setPower(1.00);
                Flywheel2.setPower(1.00);
            }



            // The code below is used to stop the Flywheel Motor(s) when the 'B' button is pushed on the Controller.
            if (buttonB) {
                telemetry.addData("Flywheel Motors Disengaged. ", " ");
                telemetry.update();
                Flywheel1.setPower(0.00);
                Flywheel2.setPower(0.00);
            }



            // The code below is used to put the Flywheel Motor(s) at 100% Throttle IN REVERSE when the 'A' button is pushed on the Controller.
            if (buttonA) {
                telemetry.addData("Flywheel Motors Engaged in Reverse. ", " ");
                telemetry.update();
                Flywheel1.setPower(-1.00);
                Flywheel2.setPower(-1.00);
            }


        }
    }
}