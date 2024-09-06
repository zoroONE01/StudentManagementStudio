package vn.edu.ptithcm.studentmangementstudio.core;

public class K {


    public static class DbFields {
        public static final String LASTNAME = "HO";
        public static final String FIRSTNAME = "TEN";
        public static final String ADDRESS = "DIACHI";
        public static final String BIRTH = "NGAYSINH";
        public static final String GENDER = "PHAI";
        public static final String CLASS_ID = "MALOP";
        public static final String IS_OFF = "DANGHIHOC";
        public static final String PASSWORD = "PASSWORD";
        public static final String DEPARTMENT_NAME = "TENKHOA";
        public static final String SERVER_NAME = "TENSERVER";
        public static final String STUDENT_ID = "MASV";
        public static final String TEACHER_ID = "MAGV";
        public static final String FULL_NAME = "HOTEN";
        public static final String GROUP_NAME = "TENNHOM";
        public static final String CLASS_NAME = "TENLOP";
        public static final String CLASS_YEAR = "KHOAHOC";
        public static final String DEPARTMENT_ID = "MAKHOA";

    }

    public static class Routes {
        static public final String LOGIN = "fxml/login-view.fxml";
        static public final String DASHBOARD = "fxml/dashboard-view.fxml";
        static public final String CLASSROOM_FORM = "fxml/classroom-form-view.fxml";
        static public final String STUDENT_FORM = "fxml/student-form-view.fxml";
    }

    public static class Strings {
        public static final String APP_NAME = "Student Management Studio";
        static public final String CONFIRM = "CONFIRM";
        public static final String CONFIRM_DELETE = "Are you sure you want to delete?";
        public static final String CONFIRM_LOGOUT = "Are you sure you want to logout?";
        public static final String CONFIRM_EXIT = "Are you sure you want to exit?";
        public static final String MALE = "Nam";
        public static final String FEMALE = "Nữ";
        public static final String BLANK = "";
        public static final String ACTIVE = "Đang hoạt động";
        public static final String INACTIVE = "Ngừng hoạt động (Đã nghỉ học)";
        public static final String ALL = "All";
        public static final String ID = "ID";
        public static final String NOT_FOUND_SQL_SERVER_DRIVER = "Không tìm thấy driver JDBC cho SQL Server.";
        public static final String NOT_FOUND_USER = "Không tìm thấy người dùng.";
        public static final String DO_NOT_LEAVE_BLANK = " không được để trống.";
        public static final String ACCOUNT_OR_PASSWORD_INCORRECT = "Tài Khoản hoặc Mật Khẩu không chính xác.";
        public static final String NOT_FOUND_DATA = "Không tìm thấy dữ liệu.";
    }

    public static class Pattern {
        public static final String DATE = "MM/dd/yyyy";
    }
}
