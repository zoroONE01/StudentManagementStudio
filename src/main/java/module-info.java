module vn.edu.ptithcm.studentmangementstudio {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires static lombok;
//    requires mssql.jdbc;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;

    exports vn.edu.ptithcm.studentmangementstudio;
    exports vn.edu.ptithcm.studentmangementstudio.presentation;
    exports vn.edu.ptithcm.studentmangementstudio.domain.entity;

    opens vn.edu.ptithcm.studentmangementstudio to javafx.fxml;
    opens vn.edu.ptithcm.studentmangementstudio.presentation to javafx.fxml;
    exports vn.edu.ptithcm.studentmangementstudio.presentation.user;
    opens vn.edu.ptithcm.studentmangementstudio.presentation.user to javafx.fxml;
    exports vn.edu.ptithcm.studentmangementstudio.presentation.admin;
    opens vn.edu.ptithcm.studentmangementstudio.presentation.admin to javafx.fxml;
}