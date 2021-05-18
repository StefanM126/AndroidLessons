package stefan.marinkov.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static String API_KEY = "eb96a121cf4ec4a1a2bd36267b16356f";
    private static String API_CALL = "https://api.openweathermap.org/data/2.5/weather?q=";

    private EditText enteredCity;
    private Button confirm;
    TextView showTemp, showHum, showPress, showDesc;
    HttpHelper httpHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredCity = findViewById(R.id.city);
        confirm = findViewById(R.id.confirm_button);
        showTemp = findViewById(R.id.temperture);
        showHum = findViewById(R.id.humidity);
        showPress = findViewById(R.id.pressure);
        showDesc = findViewById(R.id.weather);

        httpHelper = new HttpHelper();
        confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String location = String.valueOf(enteredCity.getText()); //uneti grad
        final String FILENAME = API_CALL + location + "&appid=" + API_KEY + "&units=metric";

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("string", FILENAME);
                    JSONObject object = httpHelper.getJSONObjectFromURL(FILENAME);
                    JSONObject main = object.getJSONObject("main");


                    final double temp = main.getDouble("temp");
                    final double pressure = main.getDouble("pressure");
                    final double humidity = main.getDouble("humidity");

                    final JSONObject weather = object.getJSONArray("weather").getJSONObject(0);
                    final String desc = weather.getString("description");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showTemp.setText(String.valueOf(temp));
                            showPress.setText(String.valueOf(pressure));
                            showHum.setText(String.valueOf(humidity));
                            showDesc.setText(desc);
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
