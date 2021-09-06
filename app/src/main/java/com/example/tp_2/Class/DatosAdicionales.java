package com.example.tp_2.Class;

import com.example.tp_2.Enum.NivelEstudio;

import java.io.Serializable;

public class DatosAdicionales implements Serializable {

    public DatosAdicionales(NivelEstudio nivelEstudio, boolean interesesDeporte, boolean interesesMusica,
                            boolean interesesArte, boolean interesesTecnologia, boolean recibirInformacion)
    {
        this.NivelEstudio = nivelEstudio;
        this.InteresDeporte = interesesDeporte;
        this.InteresMusica = interesesMusica;
        this.InteresArte = interesesArte;
        this.InteresTecnología = interesesTecnologia;
        this.RecibirInformacion = recibirInformacion;
    }

    public DatosAdicionales()
    {

    }

    private NivelEstudio NivelEstudio;

    private boolean InteresDeporte;
    private boolean InteresMusica;
    private boolean InteresArte;
    private boolean InteresTecnología;

    private boolean RecibirInformacion;

    public com.example.tp_2.Enum.NivelEstudio getNivelEstudio() {
        return NivelEstudio;
    }

    public void setNivelEstudio(com.example.tp_2.Enum.NivelEstudio nivelEstudio) {
        NivelEstudio = nivelEstudio;
    }

    public boolean isInteresDeporte() {
        return InteresDeporte;
    }

    public void setInteresDeporte(boolean interesDeporte) {
        InteresDeporte = interesDeporte;
    }

    public boolean isInteresMusica() {
        return InteresMusica;
    }

    public void setInteresMusica(boolean interesMusica) {
        InteresMusica = interesMusica;
    }

    public boolean isInteresArte() {
        return InteresArte;
    }

    public void setInteresArte(boolean interesArte) {
        InteresArte = interesArte;
    }

    public boolean isInteresTecnología() {
        return InteresTecnología;
    }

    public void setInteresTecnología(boolean interesTecnología) {
        InteresTecnología = interesTecnología;
    }

    public boolean isRecibirInformacion() {
        return RecibirInformacion;
    }

    public void setRecibirInformacion(boolean recibirInformacion) {
        RecibirInformacion = recibirInformacion;
    }

    public String toCSV(){
        return NivelEstudio + ";" +
        InteresDeporte + ";" +
        InteresMusica + ";" +
        InteresArte + ";" +
        InteresTecnología + ";" +
        RecibirInformacion;
    }

    public String getHeaderCSV(){
        return "NivelEstudio;InteresDeporte;InteresMusica;InteresArte;InteresTecnología;RecibirInformacion";
    }
}
