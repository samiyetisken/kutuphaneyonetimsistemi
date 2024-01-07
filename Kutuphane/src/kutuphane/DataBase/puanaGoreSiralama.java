/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package kutuphane.DataBase;
import javax.swing.DefaultListModel;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/**
 *
 * @author Sami
 */
public class puanaGoreSiralama implements degerlendirmeSiralamaStrategy{
    @Override
          public DefaultListModel<Degerlendir> sirala(DefaultListModel<Degerlendir> listModel) {
        List<Degerlendir> degerlendirList = Collections.list(listModel.elements());

        // Sort in descending order based on puan attribute
        degerlendirList.sort(Comparator.comparingInt(degerlendir -> Integer.parseInt(((Degerlendir) degerlendir).getPuan())).reversed());

        // Specify the type parameter for DefaultListModel
        DefaultListModel<Degerlendir> sortedListModel = new DefaultListModel<>();
        degerlendirList.forEach(sortedListModel::addElement);

        return sortedListModel;
    }
    
}
