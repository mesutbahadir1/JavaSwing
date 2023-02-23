/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stok_takip;

/**
* @file stok_takip.java
* @description Belirli bir şirketin stok durumunu kontrol eden program.
* @assignment Bahar Dönemi 1.Proje
* @date 17/05/2022
* @author Muhammed Mesut Bahadır - muhammed.bahadir@stu.fsm.edu.tr
*/
class Urunler {
    private String urunId,urunAd,urunGrubu,urunAdedi,urunTarihi,urunFiyati;

    public Urunler(String urunId, String urunAd, String urunGrubu, String urunAdedi, String urunTarihi, String urunFiyati) {
        this.urunId = urunId;
        this.urunAd = urunAd;
        this.urunGrubu = urunGrubu;
        this.urunAdedi = urunAdedi;
        this.urunTarihi = urunTarihi;
        this.urunFiyati=urunFiyati;
    }

    public String getUrunId() {
        return urunId;
    }

    public String getUrunAd() {
        return urunAd;
    }

    public String getUrunGrubu() {
        return urunGrubu;
    }

    public String getUrunAdedi() {
        return urunAdedi;
    }

    public String getUrunTarihi() {
        return urunTarihi;
    }

    public String getUrunFiyati() {
        return urunFiyati;
    }
    
}
