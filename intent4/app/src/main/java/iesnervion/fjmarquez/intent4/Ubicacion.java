package iesnervion.fjmarquez.intent4;

public class Ubicacion {

    private String ubicacion;
    private Double longuitud;
    private Double latitud;


    public Ubicacion(String ubicacion, Double latitud, Double longuitud) {
        this.ubicacion = ubicacion;
        this.longuitud = longuitud;
        this.latitud = latitud;
    }

    public Ubicacion() {
        this.ubicacion = "IES Nervion";
        this.longuitud = 37.374213708037715;
        this.latitud = -5.969269215774597;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public Double getLonguitud() {
        return longuitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setLonguitud(Double longuitud) {
        this.longuitud = longuitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }
}
