package stefan.marinkov.httpconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayAdapter<String> mListAdapter;
    private HttpHelper httpHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        httpHelper = new HttpHelper();

        mListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        ListView list = findViewById(R.id.lista);
        list.setAdapter(mListAdapter);

        Button getOne = findViewById(R.id.get_one);
        Button getAll = findViewById(R.id.get_all);

        getOne.setOnClickListener(this);
        getAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // GUI NE SMES DA MENJAS IZ DRUGOG THREADA!!!
        switch (v.getId()) {
            case R.id.get_all:
                if (!mListAdapter.isEmpty()) {
                    mListAdapter.clear();
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = httpHelper.getJSONObjectFromURL("https://dog.ceo/api/breeds/list/all");
                            JSONObject message = jsonObject.getJSONObject("message");

                            Iterator<String> iter = message.keys();

                            //mListAdapter.clear();
                            while (iter.hasNext()) {
                                final String key = iter.next();
                                JSONArray values = message.getJSONArray(key);

                                for (int i = 0; i < values.length(); i++) {
                                    final String value = values.getString(i);
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            mListAdapter.add(key.toUpperCase() + ":" + value);
                                        }
                                    });
                                }
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;

            case R.id.get_one:
                if (!mListAdapter.isEmpty()) {
                    mListAdapter.clear();
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = httpHelper.getJSONObjectFromURL("https://dog.ceo/api/breed/hound/list");
                            JSONArray values = jsonObject.getJSONArray("message");

                            for (int i = 0; i < values.length(); i++) {
                                final String value = values.getString(i);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        mListAdapter.add(value.toUpperCase());
                                    }
                                });
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
        }

    }
}
