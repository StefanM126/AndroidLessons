package stefan.marinkov.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startS;
    private Button stopS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startS = findViewById(R.id.startServiceBT);
        stopS = findViewById(R.id.stopServiceBT);

        startS.setOnClickListener(this);
        stopS.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, LogingService.class);
        if (v.getId() == R.id.startServiceBT) {
            startService(intent);
        }
        else if (v.getId() == R.id.stopServiceBT) {
            stopService(intent);
        }
    }
}
