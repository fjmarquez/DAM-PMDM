package iesnervion.fjmarquez.fragments;

import androidx.lifecycle.MutableLiveData;

public class ViewModel extends androidx.lifecycle.ViewModel {

    private MutableLiveData<Integer> btnSelecionado = new MutableLiveData<Integer>();;


    public MutableLiveData<Integer> getBtnSelecionado() {
        return btnSelecionado;
    }

    public void setBtnSelecionado(Integer btnSelecionado) {
        this.btnSelecionado.setValue(btnSelecionado);
    }

    public ViewModel(){
        this.btnSelecionado.setValue(0);
    }
}
