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
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author DM3-2-11
 */
public class Kontroladorea {

    static ObservableList<Ibilgailuak> data = null;

    public static ObservableList<Ibilgailuak> datuakMemorianKargatu(File aukeratutakoa) throws FileNotFoundException, IOException {
        BufferedReader inputStream = null;
        try {
            inputStream = new BufferedReader(new FileReader(aukeratutakoa));
            data = FXCollections.observableArrayList();
            String hitza;
            while ((hitza = inputStream.readLine()) != null) {
                Scanner s = new Scanner(hitza).useDelimiter(",");
                Ibilgailuak kotxe = new Ibilgailuak(s.next(), s.next(), s.next(), s.next());   //añadir tipo de datos de las variables
                data.add(kotxe);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Ez da fitxategia aurkitu.");
        } finally {
            if (inputStream != null) {
                inputStream.close();
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
