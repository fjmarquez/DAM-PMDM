package iesnervion.fjmarquez.fragments;

import androidx.lifecycle.MutableLiveData;

public class ViewModel extends androidx.lifecycle.ViewModel {

    private MutableLiveData<String> textoFragmentDetalle = new MutableLiveData<String>();;


    public MutableLiveData<String> getTextoFragmentDetalle() {
        return textoFragmentDetalle;
    }

    public void setTextoFragmentDetalle(String textoFragmentDetalle) {
        this.textoFragmentDetalle.setValue(textoFragmentDetalle);
    }
}
