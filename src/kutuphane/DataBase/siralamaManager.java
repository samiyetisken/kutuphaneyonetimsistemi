/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kutuphane.DataBase;
import javax.swing.DefaultListModel;
/**
 *
 * @author Sami
 */
public class siralamaManager {
    private degerlendirmeSiralamaStrategy sortingStrategy;

    public siralamaManager(degerlendirmeSiralamaStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public DefaultListModel<Degerlendir> sirala(DefaultListModel<Degerlendir> listModel) {
        return sortingStrategy.sirala(listModel);
    }
}
