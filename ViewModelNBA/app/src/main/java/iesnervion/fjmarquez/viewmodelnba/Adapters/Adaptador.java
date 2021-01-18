package iesnervion.fjmarquez.viewmodelnba.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import iesnervion.fjmarquez.viewmodelnba.R;

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context contexto;
    List<String> datos;
    int pos;

    public Adaptador(Context contexto, List<String> datos)
    {
        this.contexto = contexto;
        this.datos = datos;


        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public String getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) contexto.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.row, parent, false);


            mViewHolder.txtEquipo = (TextView) convertView.findViewById(R.id.txtEquipo);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.txtEquipo.setText(datos.get(i));


        return convertView;
    }

    static class ViewHolder {
        TextView txtEquipo;

        public TextView getTxtEquipo() {
            return txtEquipo;
        }

        public void setTxtEquipo(String txtEquipo){
            this.txtEquipo.setText(txtEquipo);
        }

    }
}

