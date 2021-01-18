package iesnervion.fjmarquez.viewmodelnba.VM;

import android.text.style.AlignmentSpan;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VMEquiposNBA extends ViewModel {

    /* Atributos */

    public MutableLiveData<List<String>> mldListaEquiposNBA;
    public List<String> listaEquiposNBA;

    /* Getters y Setters*/

    public MutableLiveData<List<String>> getListaEquiposNBA() {
        return mldListaEquiposNBA;
    }

    public void setListaEquiposNBA(MutableLiveData<List<String>> listaEquiposNBA) {
        this.mldListaEquiposNBA = listaEquiposNBA;
    }

    /* Constructor */

    public VMEquiposNBA(){

        mldListaEquiposNBA  = new MutableLiveData<List<String>>();
        listaEquiposNBA = new ArrayList<String>();

        mldListaEquiposNBA.postValue(listaEquiposNBA);

        listaEquiposNBA.add("Atlanta Hawks");
        listaEquiposNBA.add("Boston Celtics");
        listaEquiposNBA.add("Brooklyn Nets");
    }



}
