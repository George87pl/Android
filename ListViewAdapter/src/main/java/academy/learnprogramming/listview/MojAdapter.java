package academy.learnprogramming.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MojAdapter extends BaseAdapter {

    private List<Owoc> listaOwocow;
    private LayoutInflater layoutUnflater;

    public MojAdapter(Context context, List<Owoc> listaOwocow) {
        this.listaOwocow = listaOwocow;

        layoutUnflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listaOwocow.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView =  layoutUnflater.inflate(R.layout.wiersz_podstawowy, parent, false);
            viewHolder.nazwa = convertView.findViewById(R.id.textViewNazwa);
            viewHolder.smak = convertView.findViewById(R.id.textViewSmak);
            viewHolder.ilosc = convertView.findViewById(R.id.textViewIlosc);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.nazwa.setText(listaOwocow.get(position).getNazwa());
        viewHolder.smak.setText(listaOwocow.get(position).getSmak());
        viewHolder.ilosc.setText("Ilość: " + listaOwocow.get(position).getIlosc());

        return convertView;
    }

    class ViewHolder {

        TextView nazwa;
        TextView smak;
        TextView ilosc;
    }
}
