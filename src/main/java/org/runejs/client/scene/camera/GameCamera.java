package org.runejs.client.scene.camera;

import org.runejs.client.scene.Point3d;

public abstract class GameCamera implements Camera {
    /**
     * The camera's current rotation.
     */
    protected CameraRotation rotation = new CameraRotation(0, 128);

    /**
     * The camera's current position.
     */
    protected Point3d position = new Point3d(0, 0, 0);

    /**
     * Called when the camera's rotation is updated.
     */
    protected abstract void onRotationUpdate(CameraRotation newRotation, CameraRotation oldRotation);

    @Override
    public CameraRotation getRotation() {
        return this.rotation;
    }

    public void setYaw(int yaw) {
        this.rotate(yaw, this.rotation.pitch);
    }

    public void setPitch(int pitch) {
        this.rotate(this.rotation.yaw, pitch);
    }

    public void rotate(int yaw, int pitch) {
        CameraRotation oldRotation = this.rotation;
        this.rotation = new CameraRotation(yaw, this.getClampedPitch(pitch));

        this.onRotationUpdate(this.rotation, oldRotation);
    }

    /**
     * Clamps the pitch to a valid value.
     */
    private int getClampedPitch(int pitch) {
        return Math.max(128, Math.min(pitch, 383));
    }

    @Override
    public Point3d getPosition() {
        return this.position;
    }

    public void setPosition(Point3d position) {
        this.position = position;
    }
}
