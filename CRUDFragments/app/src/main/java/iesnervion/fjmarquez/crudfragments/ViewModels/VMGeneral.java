package iesnervion.fjmarquez.crudfragments.ViewModels;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import iesnervion.fjmarquez.crudfragments.Entities.Equipo;
import iesnervion.fjmarquez.crudfragments.R;

public class VMGeneral extends androidx.lifecycle.ViewModel{

    //Atributos
    private MutableLiveData<ArrayList<Equipo>> listaEquipos = new MutableLiveData<ArrayList<Equipo>>();

    //Getters y Setters
    public MutableLiveData<ArrayList<Equipo>> getListaEquipos() {
        return listaEquipos;
    }

    //TODO -> Recibir un arraylist en lugar de un mutablelivedata y hacer un set value dentro del setter
    public void setListaEquipos(MutableLiveData<ArrayList<Equipo>> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    //Constructor
    public VMGeneral(){
        ArrayList<Equipo> equiposVM = new ArrayList<Equipo>();
        equiposVM.add(new Equipo("Atlanta Hawks", R.drawable.atlanta));
        equiposVM.add(new Equipo("Boston Celtics", R.drawable.boston));
        equiposVM.add(new Equipo("Milwaukee Bucks", R.drawable.bucks));
        equiposVM.add(new Equipo("Chicago Bulls", R.drawable.bulls));
        equiposVM.add(new Equipo("Cleveland Cavaliers", R.drawable.cavs));
        equiposVM.add(new Equipo("Los Angeles Clippers", R.drawable.clippers));
        equiposVM.add(new Equipo("Dallas Mavericks", R.drawable.dallas));
        equiposVM.add(new Equipo("Denver Nuggets", R.drawable.denver));
        equiposVM.add(new Equipo("Detroit Pistons", R.drawable.detroit));
        equiposVM.add(new Equipo("Memphis Grizzlies", R.drawable.grizzlies));
        equiposVM.add(new Equipo("Charlotte Hornets", R.drawable.hornets));
        equiposVM.add(new Equipo("Houston Rockets", R.drawable.houston));
        equiposVM.add(new Equipo("Indiana Pacers", R.drawable.indiana));
        equiposVM.add(new Equipo("Los Angeles Lakers", R.drawable.lakers));
        equiposVM.add(new Equipo("Miami Heat", R.drawable.miami));
        equiposVM.add(new Equipo("Minesota Timberwolves", R.drawable.minesota));
        equiposVM.add(new Equipo("Brooklyn Nets", R.drawable.nets));
        equiposVM.add(new Equipo("New York Nicks", R.drawable.nicks));
        equiposVM.add(new Equipo("Orlando Magic", R.drawable.orlando));
        equiposVM.add(new Equipo("New Orleans Pelicans", R.drawable.orleans));
        equiposVM.add(new Equipo("Philadelphia Sixers", R.drawable.philadelphia));
        equiposVM.add(new Equipo("Portland Trail Blazers", R.drawable.portland));
        equiposVM.add(new Equipo("Sacramento Kings", R.drawable.sacramento));
        equiposVM.add(new Equipo("Seatle SuperSonics", R.drawable.seatle));
        equiposVM.add(new Equipo("San Antonio Spurs", R.drawable.spurs));
        equiposVM.add(new Equipo("Phoenix Suns", R.drawable.suns));
        equiposVM.add(new Equipo("Oklahoma Thunder", R.drawable.thunder));
        equiposVM.add(new Equipo("Toronto Raptors", R.drawable.toronto));
        equiposVM.add(new Equipo("Utah Jazz", R.drawable.utah));
        equiposVM.add(new Equipo("Golden State Warriors", R.drawable.warriors));
        equiposVM.add(new Equipo("Washington Wizards", R.drawable.wizards));

        listaEquipos.setValue(equiposVM);
    }

}
