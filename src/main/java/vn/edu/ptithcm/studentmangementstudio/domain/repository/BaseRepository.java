package vn.edu.ptithcm.studentmangementstudio.domain.repository;

import vn.edu.ptithcm.studentmangementstudio.data.datasource.SqlServerDataSource;

public abstract class BaseRepository {

    protected SqlServerDataSource getSqlServerDataSource() {
        return SqlServerDataSource.getInstance();
    }


}
