package stefan.marinkov.sql;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Student> lista;

    public StudentAdapter(Context mContext) {
        this.mContext = mContext;
        this.lista = new ArrayList<Student>();
    }

    public void update(Student[] students) {
       lista.clear();
       if (students != null) {
           for (Student s : students) {
               lista.add(s);
           }
       }
       notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        Object ret = null;
        try {
            ret = lista.get(position);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.student_row, null);

            ViewHolder holder = new ViewHolder();
            holder.name = convertView.findViewById(R.id.list_name);
            holder.surname = convertView.findViewById(R.id.list_surname);
            holder.index = convertView.findViewById(R.id.list_index);
            convertView.setTag(holder);
        }

            Student student = (Student) getItem(position);

            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.name.setText(student.getIme());
            holder.surname.setText(student.getPrezime());
            holder.index.setText(student.getIndex());

        return  convertView;
    }

    private class ViewHolder{
       TextView name = null;
       TextView surname = null;
       TextView index = null;
    }
}
