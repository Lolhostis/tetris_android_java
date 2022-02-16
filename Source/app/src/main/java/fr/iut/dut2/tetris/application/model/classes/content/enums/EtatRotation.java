package classes.content.enums;

public enum EtatRotation {
    ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270;

    public static EtatRotation getType(int i) {
        return values()[i];
    }
}
