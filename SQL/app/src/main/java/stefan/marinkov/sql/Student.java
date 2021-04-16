package stefan.marinkov.sql;

public class Student {
    private String mIme;
    private String mPrezime;
    private String mIndex;

    public Student(String ime, String prezime, String index) {
        this.mIme = ime;
        this.mPrezime = prezime;
        this.mIndex = index;
    }

    public void setIme(String ime) {
        this.mIme = ime;
    }

    public void setPrezime(String prezime) {
        this.mPrezime = prezime;
    }

    public void setIndex(String index) {
        this.mIndex = index;
    }

    public String getIme() {
        return mIme;
    }

    public String getPrezime() {
        return mPrezime;
    }

    public String getIndex() {
        return mIndex;
    }
}
