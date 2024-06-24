package vn.edu.ptithcm.studentmangementstudio.domain.usecase.base;

import vn.edu.ptithcm.studentmangementstudio.domain.entity.Result;

public abstract class ResultUseCase<T> implements UseCase<Result<T, Exception>> {
    abstract public Result<T, Exception> call();
}
