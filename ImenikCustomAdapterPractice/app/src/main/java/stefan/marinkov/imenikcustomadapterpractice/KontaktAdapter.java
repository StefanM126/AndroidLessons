package stefan.marinkov.imenikcustomadapterpractice;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TabWidget;
import android.widget.TextView;

import java.util.ArrayList;

public class KontaktAdapter extends BaseAdapter {
    private ArrayList<Kontakt> lista_m;
    Context context_m;

    public KontaktAdapter(Context context_m) {
        lista_m = new ArrayList<Kontakt>();
        this.context_m = context_m;
    }

    public void addItem(Kontakt kontakt) {
        lista_m.add(kontakt);
        notifyDataSetChanged();
    }

    public void removeItem(int index) {
        lista_m.remove(index);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return lista_m.size();
    }

    @Override
    public Object getItem(int position) {
        Object tmp = null;
        try {
            tmp = lista_m.get(position);
        }
        catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context_m.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_element, null);

            ViewHolder holder = new ViewHolder();
            holder.image_m = convertView.findViewById(R.id.image);
            holder.name_m = convertView.findViewById(R.id.nameTV);
            holder.surname_m =  convertView.findViewById(R.id.surnameTV);
            holder.number_m = convertView.findViewById(R.id.numberTV);
            convertView.setTag(holder);
        }

        Kontakt kontakt = (Kontakt) getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.image_m.setImageDrawable(kontakt.getImage_m());
        holder.name_m.setText(kontakt.getName_m());
        holder.surname_m.setText(kontakt.getSurname_m());
        holder.number_m.setText(kontakt.getNumber_m());

        return convertView;
    }

    private class ViewHolder{
        public TextView name_m = null;
        public TextView surname_m = null;
        public TextView number_m = null;
        public ImageView image_m = null;
    }
}
