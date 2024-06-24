package vn.edu.ptithcm.studentmangementstudio.domain.entity;

public record LoginInput(String username, String password, Department department) {
    public static LoginInput student(String username, String password) {
        return new LoginInput(username, password, null);
    }

    public boolean isStudent() {
        return department == null;
    }
}
