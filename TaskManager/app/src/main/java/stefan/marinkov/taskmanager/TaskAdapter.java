package stefan.marinkov.taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends BaseAdapter {
    private ArrayList<Task> lista_m;
    private Context context_m;

    public TaskAdapter(Context context_m) {
        this.lista_m = new ArrayList<Task>();
        this.context_m = context_m;
    }

    public void addTask(Task task) {
       lista_m.add(task);
        notifyDataSetChanged();
    }

    public void removeTask(int position) {
        lista_m.remove(position);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return lista_m.size();
    }

    @Override
    public Object getItem(int position) {
        Object tmp = null;
        try{
           tmp = lista_m.get(position);
        }
        catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return tmp;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context_m.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_element, null);

            ViewHolder holder = new ViewHolder();
            holder.taskName_m = convertView.findViewById(R.id.task_name);
            holder.image_m = convertView.findViewById(R.id.image);
            holder.checkBox_m = convertView.findViewById(R.id.checkbox);
            holder.checkBox_m.setTag(position);
            convertView.setTag(holder);
        }

        final Task task = (Task) getItem(position);

        final ViewHolder holder = (ViewHolder)convertView.getTag();
        holder.taskName_m.setText(task.getTaskName_m());
        holder.image_m.setImageDrawable(task.getPicture_m());
        holder.checkBox_m.setChecked(task.getCheckBox_m());

        holder.checkBox_m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    int position = (int) buttonView.getTag();
                    removeTask(position);
                }
            }
        });
        return convertView;
    }

    private class ViewHolder{
        public TextView taskName_m;
        public ImageView image_m;
        public CheckBox checkBox_m;
    }
}
