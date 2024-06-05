package vn.edu.ptithcm.studentmangementstudio.presentation.admin;

import vn.edu.ptithcm.studentmangementstudio.core.K;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Classroom;
import vn.edu.ptithcm.studentmangementstudio.presentation.BaseFormPresenter;


public class ClassroomFormPresenter extends BaseFormPresenter<Classroom> {

    @Override
    protected String getPath() {
        return K.Routes.CLASSROOM_FORM;
    }

    @Override
    protected Classroom onSave() {
        return new Classroom("", 0, "");
    }
}