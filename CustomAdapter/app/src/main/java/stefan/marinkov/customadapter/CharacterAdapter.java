package stefan.marinkov.customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CharacterAdapter extends BaseAdapter {

    private ArrayList<Character> mCharacterList;
    private Context mContext;

    public CharacterAdapter(Context mContext) {
        this.mContext = mContext;
        this.mCharacterList = new ArrayList<Character>();

    }

    public void addCharacter(Character character) {
        mCharacterList.add(character);
        notifyDataSetChanged(); // dogadjaj koji javlja da treba sinhronizovati listu sa adapterom
    }

    @Override
    public int getCount() {
        return mCharacterList.size();
    }

    @Override
    public Object getItem(int position) {
        Object rv = null;
        try {
            rv = mCharacterList.get(position);
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return rv;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_row, null);

            ViewHolder holder = new ViewHolder();
            holder.image = convertView.findViewById(R.id.image);
            holder.text = convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        }

        Character character = (Character) getItem(position);

        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.text.setText(character.getmText());
        holder.image.setImageDrawable(character.getmImage());

        return convertView;
    }

    private class ViewHolder {
        public ImageView image = null;
        public TextView text = null;
    }
}
