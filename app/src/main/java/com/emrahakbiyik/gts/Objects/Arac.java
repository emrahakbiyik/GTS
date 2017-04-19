package com.emrahakbiyik.gts.Objects;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by emrahakbiyik on 12.04.2017.
 */

public class Arac {
    public String AracID;
    public String Rumuz;
    public String Marka;
    public String Model;
    public String Plaka;
    public int[] photoID;
    public String Tramer;
    public int[] BoyaDurumu;
    public BigDecimal AlisFiyati;
    public BigDecimal SatisFiyati;
    public String[] Masraflar;
    public HashMap MasrafTutari;
    public BigDecimal FaturaAlisFiyati;
    public BigDecimal FaturaSatisFiyati;
    // VergiTutari; // (fatura satış - alis fiyati + faturasatışfiyatı )*0,01




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

    public String getTramer() {
        return Tramer;
    }

    public void setTramer(String tramer) {
        Tramer = tramer;
    }

    public int[] getBoyaDurumu() {
        return BoyaDurumu;
    }

    public void setBoyaDurumu(int[] boyaDurumu) {
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

    public BigDecimal getFaturaAlisFiyati() {
        return FaturaAlisFiyati;
    }

    public void setFaturaAlisFiyati(BigDecimal faturaAlisFiyati) {
        FaturaAlisFiyati = faturaAlisFiyati;
    }

    public String getAracID() {
        return AracID;
    }

    public void setAracID(String aracID) {
        AracID = aracID;
    }

    public BigDecimal getFaturaSatisFiyati() {
        return FaturaSatisFiyati;
    }

    public void setFaturaSatisFiyati(BigDecimal faturaSatisFiyati) {
        FaturaSatisFiyati = faturaSatisFiyati;
    }
}
