package stefan.marinkov.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    private ListView mLista;
    private Button mSubmit;
    private StudentDBHelper DBHelper;
    private StudentAdapter mStudentAdapter;

    private EditText mNameET;
    private EditText mSurnameET;
    private EditText mIndexET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLista = findViewById(R.id.lista);
        mStudentAdapter = new StudentAdapter(this);
        mLista.setAdapter(mStudentAdapter);
        mLista.setOnItemClickListener(this);

        DBHelper = new StudentDBHelper(this);

        mNameET = findViewById(R.id.name);
        mSurnameET = findViewById(R.id.surname);
        mIndexET = findViewById(R.id.index);

        mSubmit = findViewById(R.id.submit);
        mSubmit.setOnClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Student student = (Student)mStudentAdapter.getItem(position);
        DBHelper.deleteStudent(student.getIndex());
        mStudentAdapter.update(DBHelper.readAllStudents());
    }

    @Override
    public void onClick(View v) {
        DBHelper.insert(new Student(mNameET.getText().toString(), mSurnameET.getText().toString(), mIndexET.getText().toString()));
        mStudentAdapter.update(DBHelper.readAllStudents());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mStudentAdapter.update(DBHelper.readAllStudents());
    }
}

