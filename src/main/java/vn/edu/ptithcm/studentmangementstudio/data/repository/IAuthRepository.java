package vn.edu.ptithcm.studentmangementstudio.data.repository;

import vn.edu.ptithcm.studentmangementstudio.core.K;
import vn.edu.ptithcm.studentmangementstudio.data.datasource.SqlServerDataSource;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.*;
import vn.edu.ptithcm.studentmangementstudio.domain.repository.AuthRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IAuthRepository extends AuthRepository {

    @Override
    public Result<List<Department>, Exception> getDepartments() {
        var query = "SELECT * FROM Get_Subscribes";
        try (var resultSet = getSqlServerDataSource().executeQuery(query)) {
            var departments = new ArrayList<Department>();
            while (resultSet.next()) {
                var departmentName = resultSet.getString(K.DbFields.DEPARTMENT_NAME);
                var serverName = resultSet.getString(K.DbFields.SERVER_NAME);
                var department = new Department(departmentName, serverName);
                departments.add(department);
            }
            return Result.success(departments);
        } catch (SQLException e) {
            return Result.error(e);
        }
    }

    @Override
    public Result<LoginInfo, Exception> getTeacherInfo(String username) {
        // Query to get user info
        try (var resultSet = getSqlServerDataSource().executeQuery("EXEC SP_Lay_Thong_Tin_GV_Tu_Login ?", username)) {
            if (resultSet.first()) {
                var id = resultSet.getString(K.DbFields.TEACHER_ID);
                var fullName = resultSet.getString(K.DbFields.FULL_NAME);
                var groupName = resultSet.getString(K.DbFields.GROUP_NAME);
                return Result.success(LoginInfo.of(id, fullName, groupName));
            }
            return Result.error(new RuntimeException(K.Strings.NOT_FOUND_USER));
        } catch (SQLException e) {
            return Result.error(e);
        }
    }

    @Override
    public Result<LoginInfo, Exception> getStudentInfo(String username, String password) {
        // Query to get user info
        try (var resultSet = getSqlServerDataSource().executeQuery("EXEC SP_Lay_Thong_Tin_SV_Tu_Login ?, ?", username, password)) {
            if (resultSet.first()) {
                var id = resultSet.getString(K.DbFields.STUDENT_ID);
                var fullName = resultSet.getString(K.DbFields.FULL_NAME);
                var groupName = resultSet.getString(K.DbFields.GROUP_NAME);
                return Result.success(LoginInfo.of(id, fullName, groupName));
            }
            return Result.error(new RuntimeException(K.Strings.NOT_FOUND_USER));
        } catch (SQLException e) {
            return Result.error(e);
        }
    }

    @Override
    public Exception connectToServer(LoginInput params) {
        try {
            var serverAddress = SqlServerDataSource.getServer(params.department().serverName());
            getSqlServerDataSource().connect(serverAddress, params.username(), params.password());
            return null;
        } catch (SQLException e) {
            return e;
        }
    }

    @Override
    public Exception connectToServerAsStudent(String serverName) {
        try {
            getSqlServerDataSource().connectToServerAsStudent(serverName);
            return null;
        } catch (SQLException e) {
            return e;
        }
    }

    @Override
    public Exception ConnectToServerAsRoot() {
        try {
            getSqlServerDataSource().connectToServerAsRoot();
            return null;
        } catch (SQLException e) {
            return e;
        }
    }

    @Override
    public Exception disconnect() {
        try {
            getSqlServerDataSource().close();
            return null;
        } catch (SQLException e) {
            return e;
        }
    }
}
