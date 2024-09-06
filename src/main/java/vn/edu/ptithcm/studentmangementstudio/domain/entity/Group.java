package vn.edu.ptithcm.studentmangementstudio.domain.entity;

public enum Group {
    PGV, KHOA, PKT, SV;

    public static Group fromName(String name) {
        return switch (name) {
            case "PGV" -> PGV;
            case "KHOA" -> KHOA;
            case "PKT" -> PKT;
            case "SV" -> SV;
            default -> null;
        };
    }

    public String getName() {
        return switch (this) {
            case PGV -> "PGV";
            case KHOA -> "KHOA";
            case PKT -> "PKT";
            case SV -> "SV";
        };
    }

    boolean isSV() {
        return this == SV;
    }

    boolean isPGV() {
        return this == PGV;
    }

    boolean isKHOA() {
        return this == KHOA;
    }

    boolean isPKT() {
        return this == PKT;
    }
}
