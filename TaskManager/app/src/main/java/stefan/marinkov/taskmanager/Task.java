package stefan.marinkov.taskmanager;

import android.graphics.drawable.Drawable;
import android.widget.CheckBox;

public class Task {
    private String taskName_m;
    private Drawable picture_m;
    private Boolean checkBox_m;

    public Task(String taskName_m, Drawable picture_m) {
        this.taskName_m = taskName_m;
        this.picture_m = picture_m;
        this.checkBox_m = false;
    }

    public void setTaskName_m(String taskName_m) {
        this.taskName_m = taskName_m;
    }

    public void setPicture_m(Drawable picture_m) {
        this.picture_m = picture_m;
    }

    public void setCheckBox_m(Boolean checkBox_m) {
        this.checkBox_m = checkBox_m;
    }

    public String getTaskName_m() {
        return taskName_m;
    }

    public Drawable getPicture_m() {
        return picture_m;
    }

    public Boolean getCheckBox_m() {
        return checkBox_m;
    }
}
