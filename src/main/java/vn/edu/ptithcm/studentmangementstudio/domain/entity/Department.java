package vn.edu.ptithcm.studentmangementstudio.domain.entity;

public record Department(String departmentName, String serverName) {
    @Override
    public String toString() {
        return departmentName;
    }


}
