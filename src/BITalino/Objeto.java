/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BITalino;


import java.io.Serializable;

/**
 *
 * @author delga
 */


class Objeto implements Serializable {
    private String _dato;

    public Objeto (String dato) {
        this._dato = dato;
    }

    public String toString() {
        return this._dato;
    }
}