package iesnervion.fjmarquez.listanba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context contexto;
    String[] datos;
    int[] datosImg;
    int pos;

    public Adaptador(Context contexto, String[] datos, int[] imagenes)
    {
        this.contexto = contexto;
        this.datos = datos;
        this.datosImg = imagenes;


        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return datosImg.length;
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
                convertView = mInflater.inflate(R.layout.row, parent, false);


                mViewHolder.imgEquipo = (ImageView) convertView.findViewById(R.id.imgEquipo);
                mViewHolder.txtEquipo = (TextView) convertView.findViewById(R.id.txtEquipo);
                convertView.setTag(mViewHolder);
            } else {
                mViewHolder = (ViewHolder) convertView.getTag();
            }
        }else {
            if (convertView == null) {
                LayoutInflater mInflater = (LayoutInflater) contexto.
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = mInflater.inflate(R.layout.row2, parent, false);


                mViewHolder.imgEquipo = (ImageView) convertView.findViewById(R.id.imgEquipo);
                mViewHolder.txtEquipo = (TextView) convertView.findViewById(R.id.txtEquipo);
                convertView.setTag(mViewHolder);
            } else {
                mViewHolder = (ViewHolder) convertView.getTag();
            }
        }
        mViewHolder.imgEquipo.setImageResource(datosImg[i]);
        mViewHolder.txtEquipo.setText(datos[i]);


        return convertView;
    }

    static class ViewHolder {
        ImageView imgEquipo;
        TextView txtEquipo;
        int pos;

        public ImageView getImgEquipo() {
            return imgEquipo;
        }

        public TextView getTxtEquipo() {
            return txtEquipo;
        }
    }
}
