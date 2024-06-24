package vn.edu.ptithcm.studentmangementstudio.domain.usecase.auth;

import vn.edu.ptithcm.studentmangementstudio.domain.repository.AuthRepository;
import vn.edu.ptithcm.studentmangementstudio.domain.usecase.base.VoidUseCaseWithParams;

public class ConnectToServerAsStudentUseCase extends VoidUseCaseWithParams<String> {

    private final AuthRepository repository;

    public ConnectToServerAsStudentUseCase(AuthRepository repository, String serverName) {
        super(serverName);
        this.repository = repository;
    }

    @Override
    public Exception call() {
        return repository.connectToServerAsStudent(params);
    }
}
