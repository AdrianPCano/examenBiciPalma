package org.mvpigs.BiciPalma;

public class TarjetaUsuario {
    private String id = null;
    private Boolean activada = false;


    public TarjetaUsuario(String id, Boolean activada) {
        this.id = id;
        this.activada = activada;
    }
    public  String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Boolean getActivada() {
        return activada;
    }
    public void setActivada(Boolean activada){
        this.activada = activada;
    }
    public void setBoolean(Boolean activada) {
        this.activada = activada;
    }
}