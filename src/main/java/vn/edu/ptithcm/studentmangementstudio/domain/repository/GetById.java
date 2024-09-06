package vn.edu.ptithcm.studentmangementstudio.domain.repository;

import vn.edu.ptithcm.studentmangementstudio.domain.entity.Result;

public interface GetById<T> {
    Result<T, Exception> get(Object id);
}
