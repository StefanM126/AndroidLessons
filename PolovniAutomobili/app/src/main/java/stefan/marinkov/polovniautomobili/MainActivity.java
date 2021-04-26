package stefan.marinkov.polovniautomobili;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.security.InvalidParameterException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView mList;
    private DBHelper mDBHelper;
    private CarAdapter mCarAdapter;

    private Button mDodaj;
    private Button mPrikaziKM;
    private Button mPrikaziMladje;

    private int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCarAdapter = new CarAdapter(this);
        mList = findViewById(R.id.lista);
        mList.setAdapter(mCarAdapter);

        mList.setOnItemClickListener(this);

        mDBHelper = new DBHelper(this);

        mDodaj = findViewById(R.id.dodaj);
        mDodaj.setOnClickListener(this);

        mPrikaziKM = findViewById(R.id.prikaziKM);
        mPrikaziKM.setOnClickListener(this);

        mPrikaziMladje = findViewById(R.id.prikaziMladje);
        mPrikaziMladje.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Car[] cars;
        String marka = getTextFromET(R.id.marka);
        String model = getTextFromET(R.id.model);
        int km;
        int godina;

        switch (v.getId()) {
            case R.id.dodaj:
                if(marka.isEmpty() || model.isEmpty() || getTextFromET(R.id.kilometraza).isEmpty() || getTextFromET(R.id.godina).isEmpty()) {
                    Toast.makeText(v.getContext(), "Nevalidan unos! Potrebno popuniti sva polja.", Toast.LENGTH_SHORT).show();
                    break;
                }

                try {
                    km = Integer.parseInt(getTextFromET(R.id.kilometraza));
                } catch (IllegalArgumentException  e) {
                    Toast.makeText(v.getContext(), "Nevalidan unos! Potrebno uneti broj za polje KILOMETRAŽA.", Toast.LENGTH_SHORT).show();
                    break;
                }

                try {
                    godina = Integer.parseInt(getTextFromET(R.id.godina));
                } catch (IllegalArgumentException  e) {
                    Toast.makeText(v.getContext(), "Nevalidan unos! Potrebno uneti broj za polje GODINA.", Toast.LENGTH_SHORT).show();
                    break;
                }

                Car car = new Car(model, marka, godina, km, id++);
                mDBHelper.insertCar(car);
                mCarAdapter.update(mDBHelper.readAllCars());
                break;

            case R.id.prikaziKM:
                if(getTextFromET(R.id.kilometraza).toString().isEmpty()) {
                    cars = mDBHelper.readAllCars();
                }
                else {
                    try {
                        km = Integer.parseInt(getTextFromET(R.id.kilometraza));
                    } catch (IllegalArgumentException  e) {
                        Toast.makeText(v.getContext(), "Nevalidan unos! Potrebno uneti broj za polje KILOMETRAŽA.", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    cars = mDBHelper.readCarsLKM(km);
                }
                mCarAdapter.update(cars);
                break;

            case R.id.prikaziMladje:
                if(getTextFromET(R.id.godina).toString().isEmpty()) {
                    cars = mDBHelper.readAllCars();
                }
                else {
                    try {
                        godina = Integer.parseInt(getTextFromET(R.id.godina));
                    } catch (IllegalArgumentException  e) {
                        Toast.makeText(v.getContext(), "Nevalidan unos! Potrebno uneti broj za polje GODINA.", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    cars = mDBHelper.readCarsGYear(godina);
                }
                mCarAdapter.update(cars);
                break;
        }
    }

    private String getTextFromET(int id) {
        return ((EditText)findViewById(id)).getText().toString();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mCarAdapter.update(mDBHelper.readAllCars());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Car car = (Car) mCarAdapter.getItem(position);
        mDBHelper.deleteCar(car.getmID());
        mCarAdapter.update(mDBHelper.readAllCars());
    }
}
