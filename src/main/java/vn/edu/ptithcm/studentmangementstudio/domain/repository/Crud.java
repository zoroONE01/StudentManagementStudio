package vn.edu.ptithcm.studentmangementstudio.domain.repository;

public interface Crud<T> extends GetAll<T>, Update<T>, Delete, Add<T> {
}
