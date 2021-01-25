package iesnervion.fjmarquez.fragments;

import androidx.lifecycle.MutableLiveData;

public class MyViewModel extends androidx.lifecycle.ViewModel {

    private MutableLiveData<Integer> btnSelecionado = new MutableLiveData<Integer>();;


    public MutableLiveData<Integer> getBtnSelecionado() {
        return btnSelecionado;
    }

    public void setBtnSelecionado(Integer btnSelecionado) {
        this.btnSelecionado.setValue(btnSelecionado);
    }

    public MyViewModel(){
        this.btnSelecionado.setValue(0);
    }
}
