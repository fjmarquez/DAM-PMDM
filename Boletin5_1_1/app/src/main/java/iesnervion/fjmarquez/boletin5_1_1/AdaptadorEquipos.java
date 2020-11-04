package iesnervion.fjmarquez.boletin5_1_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorEquipos extends BaseAdapter {

    private static LayoutInflater inflater = null;
    private Context contexto;
    private String[] equipos;
    private int[] imgsEquipos;

    public AdaptadorEquipos(Context contexto, String[] equipos, int[] imgs) {
        this.contexto = contexto;
        this.equipos = equipos;
        this.imgsEquipos = imgs;
        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.fila, null);
        TextView nombreEquipo = (TextView)vista.findViewById(R.id.nombreEquipo);
        ImageView imgEquipo = (ImageView) vista.findViewById(R.id.imgEquipo);
        nombreEquipo.setText(equipos[i]);
        imgEquipo.setImageResource(imgsEquipos[i]);
        return null;
    }

    @Override
    public int getCount() {
        return imgsEquipos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
