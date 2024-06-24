package vn.edu.ptithcm.studentmangementstudio.domain.usecase.auth;

import vn.edu.ptithcm.studentmangementstudio.domain.entity.LoginInput;
import vn.edu.ptithcm.studentmangementstudio.domain.repository.AuthRepository;
import vn.edu.ptithcm.studentmangementstudio.domain.usecase.base.VoidUseCaseWithParams;

public class ConnectToServerUseCase extends VoidUseCaseWithParams<LoginInput> {
    private final AuthRepository repository;

    public ConnectToServerUseCase(AuthRepository repository, LoginInput input) {
        super(input);
        this.repository = repository;
    }

    @Override
    public Exception call() {
        return repository.connectToServer(params);
    }
}
