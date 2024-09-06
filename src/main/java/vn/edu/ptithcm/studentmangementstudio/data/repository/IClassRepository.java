package vn.edu.ptithcm.studentmangementstudio.data.repository;

import vn.edu.ptithcm.studentmangementstudio.core.K;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Classroom;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Result;
import vn.edu.ptithcm.studentmangementstudio.domain.repository.ClassRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IClassRepository extends ClassRepository {
    @Override
    public Exception add(Classroom aClass) {
        return null;
    }

    @Override
    public Exception delete(Object id) {
        return null;
    }

    @Override
    public Result<List<Classroom>, Exception> get() {
        try (var resultSet = getSqlServerDataSource().executeQuery("EXEC GetClassList")) {
            var classList = new ArrayList<Classroom>();
            while (resultSet.next()) {
                var id = resultSet.getString(K.DbFields.CLASS_ID);
                var className = resultSet.getString(K.DbFields.CLASS_NAME);
                var classYear = resultSet.getString(K.DbFields.CLASS_YEAR);
                var departmentId = resultSet.getString(K.DbFields.DEPARTMENT_ID);
                var classroom = new Classroom(id, className, classYear, departmentId);
                classList.add(classroom);
            }
            if (classList.isEmpty()) throw new SQLException(K.Strings.NOT_FOUND_DATA);
            return Result.success(classList);
        } catch (SQLException e) {
            return Result.error(e);
        }
    }

    @Override
    public Exception update(Object id, Classroom aClass) {
        return null;
    }
}
