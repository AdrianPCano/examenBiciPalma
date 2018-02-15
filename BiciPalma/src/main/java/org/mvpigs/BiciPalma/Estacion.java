package org.mvpigs.BiciPalma;

import org.mvpigs.BiciPalma.Bicicleta;
import org.mvpigs.BiciPalma.TarjetaUsuario;

import java.util.concurrent.ThreadLocalRandom;


public class Estacion {
    private int id = 0;
    private String direccion = null;
    private int numeroAnclajes = 0;
    private Bicicleta[] anclajes = null;

    public Estacion(int id, String direccion, int anclajes) {
        this.id = id;
        this.direccion = direccion;
        this.numeroAnclajes = numeroAnclajes;
        this.anclajes = new Bicicleta[anclajes];
    }
    public int getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getNumeroAnclajes() {
        return numeroAnclajes;
    }

    public void consultarEstacion() {
        System.out.println("La ID es: " + getId());
        System.out.println("La direccion es: " + getDireccion());
        System.out.println("El numero de anclajes es: " + getNumeroAnclajes());
    }
    public int anclajesLibres() {
        int anclajesLibres = 0;
        for(Bicicleta anclaje : this.anclajes) {
            if (anclaje == null) {
                anclajesLibres++;
            }
        }
        return anclajesLibres;
    }
    public void consultarAnclajes() {
        int posicion  = 0;
        int numeroAnclaje = 0;

        for (Bicicleta bicicleta : this.anclajes) {
            numeroAnclaje = posicion + 1;
            if (bicicleta == null) {
                System.out.println("El anclaje " +numeroAnclaje+ " está libre");
            } else {
                System.out.println("El anclaje " +numeroAnclaje+ " está ocupado por la bicicleta con Id: " +this.anclajes[posicion].getId());
            }
            posicion++;
        }
    }
    public void anclarBicicleta(Bicicleta bicicleta) {
        int posicion = 0;
        int numeroAnclaje = posicion + 1;
        for (Bicicleta anclaje : this.anclajes) {
            if (anclaje == null) { 
                this.anclajes[posicion] = bicicleta;
                mostrarAnclaje(bicicleta, numeroAnclaje);
                break;
            } else {
                posicion++;
                numeroAnclaje++;
            }
        }
    }
    public void mostrarAnclaje(Bicicleta bicicleta, int numeroAnclaje){
        System.out.println("La bicicleta " +bicicleta.getId()+ " acnclada en el anclaje " +numeroAnclaje);
    }
    public boolean leerTarjetaUsuario(TarjetaUsuario tarjetaUsuario) {
        return tarjetaUsuario.getActivada();
    }
    public void mostrarBicicleta (Bicicleta bicicleta, int numeroAnclaje) {
        System.out.println("bicicleta retirada: " + bicicleta.getId() + " del anclaje: " +numeroAnclaje);
    }
    public void retirarBicicleta(TarjetaUsuario tarjetaUsuario) {
        if (leerTarjetaUsuario(tarjetaUsuario)) {
            boolean biciRetirada = false;
            while (!biciRetirada) {
                int posicion = generarAnclaje();
                int numeroAnclaje = posicion +1;
                if (this.anclajes[posicion] != null) {
                    mostrarBicicleta(this.anclajes[posicion], numeroAnclaje);
                    this.anclajes[posicion] = null;
                    biciRetirada = true;
                }
            }
        } else {
            System.out.println("La tarjeta de usuario no está activada");
        }
    }
    public int generarAnclaje() {
            Integer numeroEntero = ThreadLocalRandom.current().nextInt(0, this.anclajes.length); 
            return numeroEntero;
    }
}