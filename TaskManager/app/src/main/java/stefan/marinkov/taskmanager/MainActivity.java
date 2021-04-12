package stefan.marinkov.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lista_m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista_m = findViewById(R.id.lista);
        final TaskAdapter taskAdapter = new TaskAdapter(this);
        taskAdapter.addTask(new Task("Zadatak", getDrawable(R.drawable.slika1)));
        taskAdapter.addTask(new Task("Zadatak", getDrawable(R.drawable.slika1)));
        taskAdapter.addTask(new Task("Zadatak", getDrawable(R.drawable.slika1)));
        taskAdapter.addTask(new Task("Zadatak", getDrawable(R.drawable.slika1)));
        taskAdapter.addTask(new Task("Zadatak", getDrawable(R.drawable.slika1)));
        taskAdapter.addTask(new Task("Zadatak", getDrawable(R.drawable.slika1)));
        taskAdapter.addTask(new Task("Zadatak", getDrawable(R.drawable.slika1)));
        taskAdapter.addTask(new Task("Zadatak", getDrawable(R.drawable.slika1)));
        taskAdapter.addTask(new Task("Zadatak", getDrawable(R.drawable.slika1)));

        lista_m.setAdapter(taskAdapter);

        lista_m.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Task task = (Task) taskAdapter.getItem(position);
                Toast.makeText(MainActivity.this, task.getTaskName_m(), Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }
}
