package iesnervion.fjmarquez.repasoexamenpmdm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context contexto;
    ArrayList<cancion> listCancion;
    int pos;

    public RVAdapter(Context contexto, ArrayList<cancion> listCancion)
    {
        this.contexto = contexto;
        this.listCancion = listCancion;

        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listCancion.size();
    }

    @Override
    public String getItem(int position) {
        return listCancion.get(position).getNombre();
    }

    @Override
    public long getItemId(int position) {
        return listCancion.get(position).getId();
    }

    @Override
    public int getItemViewType(int position) {

        if (position % 2 == 0) {
            return 0;
        }
        else {
            return 1;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        int type = getItemViewType(i);
        if (type == 0) {
            if (convertView == null) {
                LayoutInflater mInflater = (LayoutInflater) contexto.
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = mInflater.inflate(R.layout.rvrow, parent, false);

                mViewHolder.nombre = (TextView) convertView.findViewById(R.id.nombre);
                mViewHolder.autor = (TextView) convertView.findViewById(R.id.autor);
                mViewHolder.genero = (TextView) convertView.findViewById(R.id.genero);

                convertView.setTag(mViewHolder);
            } else {
                mViewHolder = (ViewHolder) convertView.getTag();
            }
        }else {
            if (convertView == null) {
                LayoutInflater mInflater = (LayoutInflater) contexto.
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = mInflater.inflate(R.layout.rvrow2, parent, false);

                mViewHolder.nombre = (TextView) convertView.findViewById(R.id.nombre);
                mViewHolder.autor = (TextView) convertView.findViewById(R.id.autor);
                mViewHolder.genero = (TextView) convertView.findViewById(R.id.genero);

                convertView.setTag(mViewHolder);
            } else {
                mViewHolder = (ViewHolder) convertView.getTag();
            }
        }

        mViewHolder.nombre.setText(listCancion.get(i).getNombre());
        mViewHolder.autor.setText(listCancion.get(i).getAutor());
        mViewHolder.genero.setText(listCancion.get(i).getGenero());


        return convertView;
    }

    static class ViewHolder {
        TextView nombre;
        TextView autor;
        TextView genero;

        public TextView getNombre() {
            return nombre;
        }

        public TextView getAutor() {
            return autor;
        }

        public TextView getGenero() {
            return genero;
        }
    }
}