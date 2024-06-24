package vn.edu.ptithcm.studentmangementstudio.domain.usecase.auth;

import vn.edu.ptithcm.studentmangementstudio.data.repository.IAuthRepository;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.LoginInfo;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.LoginInput;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Result;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Student;
import vn.edu.ptithcm.studentmangementstudio.domain.usecase.base.ResultUseCaseWithParams;

public class GetStudentInfoUseCase extends ResultUseCaseWithParams<LoginInfo, LoginInput> {
    final IAuthRepository repository;

    public GetStudentInfoUseCase(IAuthRepository repository, LoginInput input) {
        super(input);
        this.repository = repository;
    }

    @Override
    public Result<LoginInfo, Exception> call() {
        return repository.getStudentInfo(params.username(), params.password());
    }

}
