package vn.edu.ptithcm.studentmangementstudio.domain.usecase.base;

import vn.edu.ptithcm.studentmangementstudio.domain.entity.Result;

public abstract class ResultUseCaseWithParams<T, P> extends ResultUseCase<T> {
    protected final P params;

    protected ResultUseCaseWithParams(P params) {
        this.params = params;
    }

}
