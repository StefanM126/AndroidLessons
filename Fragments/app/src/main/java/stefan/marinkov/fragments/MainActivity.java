package stefan.marinkov.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BlankFragment blankFragment = new BlankFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.KontejnerFR1, blankFragment).commit();
        BlankFragment2 blankFragment2 = new BlankFragment2();
        getSupportFragmentManager().beginTransaction().add(R.id.KontejnerFR2, blankFragment2).commit();

        Button changeFragment_bt = findViewById(R.id.fragment_bt);
        changeFragment_bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        BlankFragment3 blankFragment3 = new BlankFragment3();
        getSupportFragmentManager().beginTransaction().replace(R.id.KontejnerFR2, blankFragment3).addToBackStack(null).commit();
    }
}
