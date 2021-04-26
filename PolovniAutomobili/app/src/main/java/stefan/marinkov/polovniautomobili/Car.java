package stefan.marinkov.polovniautomobili;

public class Car {
    private String mBrand;
    private String mModel;
    private int mYear;
    private int mKM;
    private int mID;

    public Car(String mBrand, String mModel, int mYear, int mKM, int mID) {
        this.mBrand = mBrand;
        this.mModel = mModel;
        this.mYear = mYear;
        this.mKM = mKM;
        this.mID = mID;
    }

    public String getmBrand() {
        return mBrand;
    }

    public String getmModel() {
        return mModel;
    }

    public int getmYear() {
        return mYear;
    }

    public int getmKM() {
        return mKM;
    }

    public int getmID() {
        return mID;
    }

    public void setmBrand(String mBrand) {
        this.mBrand = mBrand;
    }

    public void setmModel(String mModel) {
        this.mModel = mModel;
    }

    public void setmYear(int mYear) {
        this.mYear = mYear;
    }

    public void setmKM(int mKM) {
        this.mKM = mKM;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }
}
