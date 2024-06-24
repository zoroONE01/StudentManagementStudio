package vn.edu.ptithcm.studentmangementstudio.domain.usecase.auth;

import vn.edu.ptithcm.studentmangementstudio.domain.repository.AuthRepository;
import vn.edu.ptithcm.studentmangementstudio.domain.usecase.base.VoidUseCase;

public class DisconnectDbUseCase extends VoidUseCase {
    private final AuthRepository repository;

    public DisconnectDbUseCase(AuthRepository repository) {
        this.repository = repository;
    }

    @Override
    public Exception call() {
        return repository.disconnect();
    }

}