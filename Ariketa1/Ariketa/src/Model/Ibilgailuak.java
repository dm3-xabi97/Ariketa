/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author DM3-2-11
 */
public class Ibilgailuak {

    private String modeloa;
    private String marka;
    private String matrikula;

    public Ibilgailuak(String modeloa, String marka, String matrikula) { //derrigortuta nago, ezta? public jartzera beste pakete batetik sortuko dudalako?
        this.modeloa = new String(modeloa);
        this.marka = new String(marka);
        this.matrikula = new String(matrikula);
    }

    public String getModeloa() {
        return modeloa;
    }

    public void setModeloa(String modeloa) {
        this.modeloa = modeloa;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getMatrikula() {
        return matrikula;
    }

    public void setMatrikula(String matrikula) {
        this.matrikula = matrikula;
    }

}
