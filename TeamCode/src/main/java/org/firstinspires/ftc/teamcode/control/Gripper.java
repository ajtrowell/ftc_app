package org.firstinspires.ftc.teamcode.control;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Gripper for grabbing stones and skystones.
 */
public class Gripper {
    /**
     * @param leftFinger The left finger servo.
     * @param rightFinger The right finger servo.
     * @param wrist The twisting wrist servo.
     */
    public Gripper(Servo leftFinger, Servo rightFinger, Servo wrist) {
        this.leftFinger = leftFinger;
        this.rightFinger = rightFinger;
        this.wrist = wrist;
    }

    // The possible finger positions.
    public enum FingerPosition {
        OPEN_LEFT,
        OPEN,
        CLOSED,
    }

    /**
     * Sets the finger position.
     * @param position The position to set.
     */
    public void setFingerPosition(FingerPosition position) {
        if (position == FingerPosition.OPEN_LEFT) {
            openLeft();
        } else if (position == FingerPosition.OPEN) {
            open();
        } else if (position == FingerPosition.CLOSED) {
            close();
        }
    }

    /**
     * Closes the fingers to grip a stone.
     */
    public void close() {
        leftFinger.setPosition(LEFT_CLOSED);
        rightFinger.setPosition(RIGHT_CLOSED);
    }

    /**
     * Opens both fingers to drop a stone, or to get ready to pick one up.
     */
    public void open() {
        leftFinger.setPosition(LEFT_OPEN);
        rightFinger.setPosition(RIGHT_OPEN);
    }

    /**
     * Opens just the left finger to next to another stone.
     */
    public void openLeft() {
        leftFinger.setPosition(LEFT_OPEN);
    }

    // The possible wrist positions.
    public enum WristPosition {
        FRONT_BACK,
        LEFT_RIGHT,
    }

    /**
     * Sets the wrist position.
     * @param position The position to set.
     */
    public void setWristPosition(WristPosition position) {
        if (position == WristPosition.FRONT_BACK) {
            rotateToFrontBack();
        } else if (position == WristPosition.LEFT_RIGHT) {
            rotateToLeftRight();
        }
    }

    /**
     * Rotates so it's front to back.
     */
    public void rotateToFrontBack() {
        wrist.setPosition(WRIST_FRONT_BACK);
    }

    /**
     * Rotates so it's left to right.
     */
    public void rotateToLeftRight() {
        wrist.setPosition(WRIST_LEFT_RIGHT);
    }

    // Servos for actuating the Gripper.
    private Servo leftFinger;
    private Servo rightFinger;
    private Servo wrist;

    // The calibration values.
    private double LEFT_CLOSED = 0.0;
    private double LEFT_OPEN = 1.0;
    private double RIGHT_OPEN = 0.0;
    private double RIGHT_CLOSED = 1.0;
    private double WRIST_FRONT_BACK = 0.0;
    private double WRIST_LEFT_RIGHT = 1.0;
}
