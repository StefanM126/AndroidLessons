package stefan.marinkov.imenikcustomadapterpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lista_m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista_m = findViewById(R.id.lista);
        final KontaktAdapter adapter = new KontaktAdapter(this);

        adapter.addItem(new Kontakt("Petar", "Peric", "0631254129", getDrawable(R.drawable.slika1)));
        adapter.addItem(new Kontakt("Petar", "Peric", "0631254129", getDrawable(R.drawable.slika2)));
        adapter.addItem(new Kontakt("Petar", "Peric", "0631254129", getDrawable(R.drawable.slika3)));
        adapter.addItem(new Kontakt("Petar", "Peric", "0631254129", getDrawable(R.drawable.slika4)));
        adapter.addItem(new Kontakt("Petar", "Peric", "0631254129", getDrawable(R.drawable.slika5)));
        adapter.addItem(new Kontakt("Petar", "Peric", "0631254129", getDrawable(R.drawable.slika6)));
        adapter.addItem(new Kontakt("Petar", "Peric", "0631254129", getDrawable(R.drawable.slika7)));
        adapter.addItem(new Kontakt("Petar", "Peric", "0631254129", getDrawable(R.drawable.slika8)));
        adapter.addItem(new Kontakt("Petar", "Peric", "0631254129", getDrawable(R.drawable.slika9)));
        adapter.addItem(new Kontakt("Petar", "Peric", "0631254129", getDrawable(R.drawable.slika10)));
        adapter.addItem(new Kontakt("Petar", "Peric", "0631254129", getDrawable(R.drawable.slika11)));
        adapter.addItem(new Kontakt("Petar", "Peric", "0631254129", getDrawable(R.drawable.slika12)));
        lista_m.setAdapter(adapter);

        lista_m.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.removeItem(position);
                return false;
            }
        });
    }
}
