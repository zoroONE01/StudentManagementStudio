package vn.edu.ptithcm.studentmangementstudio.core;

public class K {

    public static class Column {
        public static final String ID = "id";
        public static final String LASTNAME = "lastname";
        public static final String FIRSTNAME = "firstname";
        public static final String ADDRESS = "address";
        public static final String BIRTH = "birth";
        public static final String GENDER = "gender";
        public static final String CLASS_ID = "classId";
        public static final String IS_OFF = "isOff";
    }

    public static class Routes {
        static private final String ADMIN = "fxml/admin";
        static private final String USER = "fxml/user";
        static public final String LOGIN = USER + "/login-view.fxml";
        static public final String DASHBOARD = USER + "/dashboard-view.fxml";
        static public final String LOGIN_ADMIN = ADMIN + "/login-view.fxml";
        static public final String DASHBOARD_ADMIN = ADMIN + "/dashboard-view.fxml";
        static public final String CLASSROOM_FORM = ADMIN + "/classroom-form-view.fxml";
        static public final String STUDENT_FORM = ADMIN + "/student-form-view.fxml";
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
    }

    public static class Pattern {
        public static final String DATE = "MM/dd/yyyy";
    }
}
