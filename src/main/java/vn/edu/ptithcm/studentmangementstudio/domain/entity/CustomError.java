package vn.edu.ptithcm.studentmangementstudio.domain.entity;

public record CustomError(String message, String details) {
    public static CustomError fromMessage(String message) {
        return new CustomError(message, null);
    }
}
