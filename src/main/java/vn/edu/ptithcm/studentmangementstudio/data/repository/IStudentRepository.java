package vn.edu.ptithcm.studentmangementstudio.data.repository;

import vn.edu.ptithcm.studentmangementstudio.core.K;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Result;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Student;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.StudentDetail;
import vn.edu.ptithcm.studentmangementstudio.domain.repository.StudentRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IStudentRepository extends StudentRepository {

    @Override
    public Exception add(Student student) {
        return null;
    }

    @Override
    public Exception delete(Object id) {
        return null;
    }

    @Override
    public Exception update(Object id, Student student) {
        return null;
    }

    @Override
    public Result<List<Student>, Exception> get() {
        try (var resultSet = getSqlServerDataSource().executeQuery("EXEC GetStudentList")) {
            var students = new ArrayList<Student>();
            while (resultSet.next()) {
                var id = resultSet.getString(K.DbFields.STUDENT_ID);
                var lastName = resultSet.getString(K.DbFields.LASTNAME);
                var firstName = resultSet.getString(K.DbFields.FIRSTNAME);
                var gender = resultSet.getInt(K.DbFields.GENDER);
                var birth = resultSet.getDate(K.DbFields.BIRTH);
                var address = resultSet.getString(K.DbFields.ADDRESS);
                var isOFf = resultSet.getBoolean(K.DbFields.IS_OFF);
                var classId = resultSet.getString(K.DbFields.CLASS_ID);
                var student = new Student(id, lastName, firstName, address, birth.toLocalDate(), classId, gender, isOFf);
                students.add(student);
            }
            if (students.isEmpty()) throw new SQLException(K.Strings.NOT_FOUND_DATA);
            return Result.success(students);
        } catch (SQLException e) {
            return Result.error(e);
        }
    }

    @Override
    public Result<StudentDetail, Exception> get(Object input) {
        try (var resultSet = getSqlServerDataSource().executeQuery("EXEC GetStudentDetails ?", input)) {
            if (!resultSet.first()) {
                return Result.error(new SQLException(K.Strings.NOT_FOUND_DATA));
            }
            var id = resultSet.getString(K.DbFields.STUDENT_ID);
            var lastName = resultSet.getString(K.DbFields.LASTNAME);
            var firstName = resultSet.getString(K.DbFields.FIRSTNAME);
            var gender = resultSet.getInt(K.DbFields.GENDER);
            var birth = resultSet.getDate(K.DbFields.BIRTH);
            var address = resultSet.getString(K.DbFields.ADDRESS);
            var isOFf = resultSet.getBoolean(K.DbFields.IS_OFF);
            var classId = resultSet.getString(K.DbFields.CLASS_ID);
            var password = resultSet.getString(K.DbFields.PASSWORD);
            var studentDetail = new StudentDetail(id, lastName, firstName, address, birth.toLocalDate(), classId, gender, isOFf, password);
            return Result.success(studentDetail);
        } catch (SQLException e) {
            return Result.error(e);
        }
    }
}
