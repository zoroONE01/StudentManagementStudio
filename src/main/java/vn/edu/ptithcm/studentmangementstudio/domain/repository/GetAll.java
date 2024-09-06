package vn.edu.ptithcm.studentmangementstudio.domain.repository;

import vn.edu.ptithcm.studentmangementstudio.domain.entity.Result;

import java.util.List;

public interface GetAll<T> {
    Result<List<T>, Exception> get();
}
