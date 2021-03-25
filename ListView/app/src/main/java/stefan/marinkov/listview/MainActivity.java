package stefan.marinkov.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ListView lista;
    TextView tekst;
    ArrayAdapter<String> adapter;
    Button button1;
    EditText et1;
    boolean onLongClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tekst = findViewById(R.id.tekst1);
        onLongClick = false;

        lista = findViewById(R.id.lista);
        lista.setEmptyView(tekst);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        lista.setAdapter(adapter);

        adapter.add("Pera");
        adapter.add("Žika");
        adapter.add("Sima");

        button1 = findViewById(R.id.b1);
        et1 = findViewById(R.id.et1);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // akcija na klik elementa
                if(!onLongClick)
                    adapter.remove(adapter.getItem(position));
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                onLongClick = true;
                Toast.makeText(getApplicationContext(), adapter.getItem(position), Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        button1.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        String txt = et1.getText().toString();
        et1.getText().clear();

        if(txt.isEmpty())
            return;
        adapter.add(txt);
    }
}
