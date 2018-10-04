/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Ibilgailuak;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author DM3-2-11
 */
public class Kontroladorea {

    static ObservableList<Ibilgailuak> data = null;

    public static ObservableList<Ibilgailuak> datuakMemorianKargatu(File aukeratutakoa) throws FileNotFoundException, IOException {
        BufferedReader br = null;
        String[] arr;
        try {
            br = new BufferedReader(new FileReader(aukeratutakoa));
            data = FXCollections.observableArrayList();
            String hitza;
            while ((hitza = br.readLine()) != null) {
                arr = hitza.split(",");
                Ibilgailuak kotxe = new Ibilgailuak(arr[0], arr[1], arr[2], arr[3]);
                data.add(kotxe);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Ez da fitxategia aurkitu.");
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return data;
    }

    public static void gorde(File aukeratutakoa) {
        try {
            BufferedWriter outWriter = new BufferedWriter(new FileWriter(aukeratutakoa));

            for (Ibilgailuak kotxe : data) {
                outWriter.write(kotxe.toString());
                outWriter.newLine();
            }
            outWriter.close();
        } catch (IOException e) {
            System.out.println("Ezin izan da fitxategia zabaldu");
        }
    }
}
