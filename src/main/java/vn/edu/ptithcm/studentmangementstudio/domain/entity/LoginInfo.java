package vn.edu.ptithcm.studentmangementstudio.domain.entity;

public record LoginInfo(String id, String fullName, Group group) {

    public static LoginInfo of(String id, String fullName, String groupName) {
        return new LoginInfo(id, fullName, Group.fromName(groupName));
    }

}
