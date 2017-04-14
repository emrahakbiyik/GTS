package com.emrahakbiyik.gts.Objects;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by emrahakbiyik on 12.04.2017.
 */

public class Arac {
    public int AracID;
    public String Rumuz;
    public String Marka;
    public String Model;
    public String Plaka;
    public int[] photoID;
    public BigDecimal Tramer;
    public String BoyaDurumu;
    public BigDecimal AlisFiyati;
    public BigDecimal SatisFiyati;
    public String[] Masraflar;
    public HashMap MasrafTutari;
    public BigDecimal FaturaFiyati;





    public Arac(){}

    public Arac (String rumuz, String plaka, int[] photoID){
        this.Rumuz= rumuz;
        this.Plaka=plaka;
        this.photoID=photoID;

    }

    public String getRumuz() {
        return Rumuz;
    }

    public void setRumuz(String rumuz) {
        Rumuz = rumuz;
    }

    public String getMarka() {
        return Marka;
    }

    public void setMarka(String marka) {
        Marka = marka;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getPlaka() {
        return Plaka;
    }

    public void setPlaka(String plaka) {
        Plaka = plaka;
    }

    public int[] getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int[] photoID) {
        this.photoID = photoID;
    }

    public BigDecimal getTramer() {
        return Tramer;
    }

    public void setTramer(BigDecimal tramer) {
        Tramer = tramer;
    }

    public String getBoyaDurumu() {
        return BoyaDurumu;
    }

    public void setBoyaDurumu(String boyaDurumu) {
        BoyaDurumu = boyaDurumu;
    }

    public BigDecimal getAlisFiyati() {
        return AlisFiyati;
    }

    public void setAlisFiyati(BigDecimal alisFiyati) {
        AlisFiyati = alisFiyati;
    }

    public BigDecimal getSatisFiyati() {
        return SatisFiyati;
    }

    public void setSatisFiyati(BigDecimal satisFiyati) {
        SatisFiyati = satisFiyati;
    }

    public String[] getMasraflar() {
        return Masraflar;
    }

    public void setMasraflar(String[] masraflar) {
        Masraflar = masraflar;
    }

    public HashMap getMasrafTutari() {
        return MasrafTutari;
    }

    public void setMasrafTutari(HashMap masrafTutari) {
        MasrafTutari = masrafTutari;
    }

    public BigDecimal getFaturaFiyati() {
        return FaturaFiyati;
    }

    public void setFaturaFiyati(BigDecimal faturaFiyati) {
        FaturaFiyati = faturaFiyati;
    }

    public int getAracID() {
        return AracID;
    }

    public void setAracID(int aracID) {
        AracID = aracID;
    }
}
