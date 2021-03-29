package stefan.marinkov.customadapter;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

public class Character {
    private Drawable mImage;
    private String mText;

    Character(Drawable mImage, String mText) {
       this.mImage = mImage;
       this.mText = mText;
    }

    public void setmImage(Drawable mImage) {
        this.mImage = mImage;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public Drawable getmImage() {
        return mImage;
    }

    public String getmText() {
        return mText;
    }
}
