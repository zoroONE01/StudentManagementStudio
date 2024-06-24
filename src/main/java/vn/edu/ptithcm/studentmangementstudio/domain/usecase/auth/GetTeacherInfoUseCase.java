package vn.edu.ptithcm.studentmangementstudio.domain.usecase.auth;

import vn.edu.ptithcm.studentmangementstudio.data.repository.IAuthRepository;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.LoginInfo;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Result;
import vn.edu.ptithcm.studentmangementstudio.domain.usecase.base.ResultUseCaseWithParams;

public class GetTeacherInfoUseCase extends ResultUseCaseWithParams<LoginInfo, String> {
    final IAuthRepository repository;

    public GetTeacherInfoUseCase(IAuthRepository repository, String username) {
        super(username);
        this.repository = repository;
    }

    @Override
    public Result<LoginInfo, Exception> call() {
        return repository.getTeacherInfo(params);
    }

}
