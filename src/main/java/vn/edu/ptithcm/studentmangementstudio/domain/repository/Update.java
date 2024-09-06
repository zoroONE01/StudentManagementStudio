package vn.edu.ptithcm.studentmangementstudio.domain.repository;

public interface Update<T> {
    Exception update(Object id, T t);
}
