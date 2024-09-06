package vn.edu.ptithcm.studentmangementstudio.domain.usecase.auth;

import vn.edu.ptithcm.studentmangementstudio.domain.entity.Result;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Student;
import vn.edu.ptithcm.studentmangementstudio.domain.repository.StudentRepository;
import vn.edu.ptithcm.studentmangementstudio.domain.usecase.base.ResultUseCase;

import java.util.List;

public class GetStudentListUseCase extends ResultUseCase<List<Student>> {
    private final StudentRepository repository;

    public GetStudentListUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Result<List<Student>, Exception> call() {
        return repository.get();
    }
}
