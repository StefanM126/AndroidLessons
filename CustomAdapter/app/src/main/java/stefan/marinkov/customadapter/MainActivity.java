package stefan.marinkov.customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView mLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLista = findViewById(R.id.lista);
        CharacterAdapter adapter = new CharacterAdapter(this);
        adapter.addCharacter(new Character(getDrawable(R.drawable.slika1), getString(R.string.tekst1)));
        adapter.addCharacter(new Character(getDrawable(R.drawable.slika2), getString(R.string.tekst2)));
        adapter.addCharacter(new Character(getDrawable(R.drawable.slika3), getString(R.string.tekst3)));
        adapter.addCharacter(new Character(getDrawable(R.drawable.slika4), getString(R.string.tekst4)));
        adapter.addCharacter(new Character(getDrawable(R.drawable.slika5), getString(R.string.tekst5)));
       // adapter.addCharacter(new Character(getDrawable(R.drawable.slika6), getString(R.string.tekst6)));
       // adapter.addCharacter(new Character(getDrawable(R.drawable.slika7), getString(R.string.tekst7)));
       // adapter.addCharacter(new Character(getDrawable(R.drawable.slika8), getString(R.string.tekst8)));
       // adapter.addCharacter(new Character(getDrawable(R.drawable.slika9), getString(R.string.tekst9)));
       // adapter.addCharacter(new Character(getDrawable(R.drawable.slika10), getString(R.string.tekst10)));
        mLista.setAdapter(adapter);
    }
}
