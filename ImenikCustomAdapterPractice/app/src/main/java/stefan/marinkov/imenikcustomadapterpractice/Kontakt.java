package stefan.marinkov.imenikcustomadapterpractice;

import android.graphics.drawable.Drawable;

public class Kontakt {
    private String name_m;
    private String surname_m;
    private String number_m;
    private Drawable image_m;

    public Kontakt(String name_m, String surname_m, String number_m, Drawable image_m) {
        this.name_m = name_m;
        this.surname_m = surname_m;
        this.number_m = number_m;
        this.image_m = image_m;
    }


    public String getName_m() {
        return name_m;
    }

    public String getSurname_m() {
        return surname_m;
    }

    public String getNumber_m() {
        return number_m;
    }

    public Drawable getImage_m() {
        return image_m;
    }

    public void setName_m(String name_m) {
        this.name_m = name_m;
    }

    public void setSurname_m(String surname_m) {
        this.surname_m = surname_m;
    }

    public void setNumber_m(String number_m) {
        this.number_m = number_m;
    }

    public void setImage_m(Drawable image_m) {
        this.image_m = image_m;
    }
}
