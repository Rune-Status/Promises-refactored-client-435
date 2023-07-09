package org.runejs.client.scene;

import org.runejs.client.media.renderable.Model;

/**
 * Temporary holding ground for camera code
 *
 * JKM will refactor this soon
 */
public class SceneCamera {
    public static CutsceneCamera cutscene = new CutsceneCamera();
    public static int cameraYaw = 0;
    public static int cameraPitch = 128;
    public static int cameraZoom = 600;
    public static int cameraX;
    public static int cameraY;
    public static int cameraZ;

    /**
     * The minimum pitch for the camera, based on the surrounding terrain. Scaled up and must be
     * divided before comparing to pitches directly.
     *
     * Lifts the camera up when there are mountains around, etc.
     */
    public static int cameraTerrainMinScaledPitch = 0;

    // movement velocity of camera

    public static int cameraVelocityYaw = 0;
    public static int cameraVelocityPitch = 0;
    public static int cameraVelocityZoom = 0;

    /**
     * The camera's current origin X coordinate.
     *
     * This is generally the player's position in the Scene, but it is dampened slightly
     * and not attached directly to the player.
     */
    public static int cameraOriginX;

    /**
     * The camera's current origin Y coordinate.
     *
     * This is generally the player's position in the Scene, but it is dampened slightly
     * and not attached directly to the player.
     */
    public static int cameraOriginY;

    // camera effects, jitter etc

    public static boolean[] customCameraActive = new boolean[5];

    public static int[] customCameraJitter = new int[5];
    public static int[] customCameraTimer = new int[5];
    public static int[] customCameraFrequency = new int[5];
    public static int[] customCameraAmplitude = new int[5];

    public static void setCameraPosition(int originX, int originY, int originZ, int yaw, int pitch, int zoom) {
        cameraYaw = yaw;
        cameraPitch = pitch;

        int xOffset = 0;
        int yawDifference = 0x7ff & -yaw + 2048;
        int zOffset = 0;
        int pitchDifference = 2048 - pitch & 0x7ff;
        int yOffset = zoom + pitch * 3;
        if(pitchDifference != 0) {
            int cosine = Model.COSINE[pitchDifference];
            int sine = Model.SINE[pitchDifference];
            int temp = zOffset * cosine + -(sine * yOffset) >> 16;
            yOffset = cosine * yOffset + sine * zOffset >> 16;
            zOffset = temp;
        }
        if(yawDifference != 0) {
            int cosine = Model.COSINE[yawDifference];
            int sine = Model.SINE[yawDifference];
            int temp = cosine * xOffset + yOffset * sine >> 16;
            yOffset = -(xOffset * sine) + yOffset * cosine >> 16;
            xOffset = temp;
        }

        cameraX = -xOffset + originX;
        cameraY = originY + -yOffset;
        cameraZ = -zOffset + originZ;
    }

    /**
     * Set the maximum height of the player's surrounding terrain.
     *
     * Used to control the minimum allowed pitch. Higher number = camera forced higher up
     */
    public static void setMaxSurroundingTerrainHeight(int i_3_) {
        int i_9_ = i_3_ * 192;
        if (i_9_ > 98048)
            i_9_ = 98048;
        if (i_9_ < 32768)
            i_9_ = 32768;
        if (cameraTerrainMinScaledPitch < i_9_) {
            cameraTerrainMinScaledPitch += (-cameraTerrainMinScaledPitch + i_9_) / 24;
        } else if (cameraTerrainMinScaledPitch > i_9_)
            cameraTerrainMinScaledPitch += (-cameraTerrainMinScaledPitch + i_9_) / 80;
    }

    public static int getClampedPitch(int pitch) {
        if (pitch < 128)
            return 128;
        if (pitch > 383)
            return 383;
        return pitch;
    }

    public static void clampPitch() {
        cameraPitch = getClampedPitch(cameraPitch);
    }
}