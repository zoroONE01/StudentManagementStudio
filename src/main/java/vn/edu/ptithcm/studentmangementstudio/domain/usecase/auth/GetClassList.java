package vn.edu.ptithcm.studentmangementstudio.domain.usecase.auth;

import vn.edu.ptithcm.studentmangementstudio.domain.entity.Classroom;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Result;
import vn.edu.ptithcm.studentmangementstudio.domain.repository.ClassRepository;
import vn.edu.ptithcm.studentmangementstudio.domain.usecase.base.ResultUseCase;

import java.util.List;

public class GetClassList extends ResultUseCase<List<Classroom>> {

    private final ClassRepository repository;

    public GetClassList(ClassRepository repository) {
        this.repository = repository;
    }

    @Override
    public Result<List<Classroom>, Exception> call() {
        return repository.get();
    }
}
