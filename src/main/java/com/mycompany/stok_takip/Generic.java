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
public class Generic<T> {

    T object;

    public Generic(T title) {
        object = title;

    }

    public T getData() {
        return object;
    }
}
