package vn.edu.ptithcm.studentmangementstudio.domain.repository;

import vn.edu.ptithcm.studentmangementstudio.domain.entity.Student;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.StudentDetail;

public abstract class StudentRepository extends BaseRepository implements Crud<Student>, GetById<StudentDetail> {

}
