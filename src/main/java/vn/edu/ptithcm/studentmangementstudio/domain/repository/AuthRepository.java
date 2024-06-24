package vn.edu.ptithcm.studentmangementstudio.domain.repository;

import vn.edu.ptithcm.studentmangementstudio.domain.entity.*;

import java.util.List;

public abstract class AuthRepository extends BaseRepository {
    abstract public Result<List<Department>, Exception> getDepartments();

    abstract public Result<LoginInfo, Exception> getTeacherInfo(String username);

    abstract public Result<LoginInfo, Exception> getStudentInfo(String username, String password);

    abstract public Exception disconnect();

    abstract public Exception connectToServer(LoginInput params);

    abstract public Exception connectToServerAsStudent(String serverName);

    abstract public Exception ConnectToServerAsRoot();

}
