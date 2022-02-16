package classes.content.enums;

public enum PieceType {
    FIXED, CARRE, I, L_DROITE, L_GAUCHE, S_DROITE, S_GAUCHE, T;

    public static PieceType getType(int i) {
        return values()[i];
    }

    public static int toString(String type) {
        return PieceType.valueOf(type).ordinal();
    }
}