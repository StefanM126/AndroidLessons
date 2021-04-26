package stefan.marinkov.polovniautomobili;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CarAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Car> mList;

    public void update(Car[] cars) {
        mList.clear();
        if (cars != null) {
            for (Car c : cars) {
                mList.add(c);
            }
        }
        notifyDataSetChanged();
    }

    public void add(Car car) {
        mList.add(car);
        notifyDataSetChanged();
    }

    public CarAdapter(Context mContext) {
        this.mContext = mContext;
        mList = new ArrayList<Car>();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        Object ret = null;
        try {
            ret = mList.get(position);
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
            convertView = inflater.inflate(R.layout.car_row, null);

            ViewHolder holder = new ViewHolder();
            holder.marka = convertView.findViewById(R.id.ListMarka);
            holder.model = convertView.findViewById(R.id.ListModel);
            holder.KM = convertView.findViewById(R.id.ListKilometraza);
            holder.godina = convertView.findViewById(R.id.ListGodina);
            convertView.setTag(holder);
        }

        Car car = (Car) getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.marka.setText(car.getmBrand());
        holder.model.setText(car.getmModel());
        holder.godina.setText(String.format("%d", car.getmYear()));
        holder.KM.setText(String.format("%d", car.getmKM()));

        return  convertView;
    }

    private class ViewHolder{
        TextView marka = null;
        TextView model = null;
        TextView godina = null;
        TextView KM = null;
    }
}
