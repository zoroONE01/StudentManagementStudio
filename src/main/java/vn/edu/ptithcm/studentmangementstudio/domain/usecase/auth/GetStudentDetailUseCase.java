package vn.edu.ptithcm.studentmangementstudio.domain.usecase.auth;

import vn.edu.ptithcm.studentmangementstudio.domain.entity.Result;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.StudentDetail;
import vn.edu.ptithcm.studentmangementstudio.domain.repository.StudentRepository;
import vn.edu.ptithcm.studentmangementstudio.domain.usecase.base.ResultUseCaseWithParams;

public class GetStudentDetailUseCase extends ResultUseCaseWithParams<StudentDetail, String> {
    private final StudentRepository repository;

    public GetStudentDetailUseCase(StudentRepository repository, String params) {
        super(params);
        this.repository = repository;
    }

    @Override
    public Result<StudentDetail, Exception> call() {
        return repository.get(params);
    }
}
