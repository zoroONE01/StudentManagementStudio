package vn.edu.ptithcm.studentmangementstudio.domain.usecase.auth;

import vn.edu.ptithcm.studentmangementstudio.domain.entity.Department;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Result;
import vn.edu.ptithcm.studentmangementstudio.domain.repository.AuthRepository;
import vn.edu.ptithcm.studentmangementstudio.domain.usecase.base.ResultUseCase;

import java.util.List;

public class GetDepartmentUseCase extends ResultUseCase<List<Department>> {
    private final AuthRepository repository;

    public GetDepartmentUseCase(AuthRepository repository) {
        this.repository = repository;
    }

    @Override
    public Result<List<Department>, Exception> call() {
        return repository.getDepartments();
    }

}
