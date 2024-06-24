package vn.edu.ptithcm.studentmangementstudio.domain.usecase.base;

public abstract class VoidUseCaseWithParams<P> extends VoidUseCase {
    protected final P params;

    protected VoidUseCaseWithParams(P params) {
        this.params = params;
    }
}
