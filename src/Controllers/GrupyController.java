
package Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import podstawy.BasicDemo;
import podstawy.BasicTools;
import weka.clusterers.EM;
import weka.core.Instances;
import weka.core.Utils;

/**
 *
 * @author Damian
 */


public class GrupyController implements Initializable {
  
    @FXML
    private TextArea text;
    
//public static void grupowanie()
//    throws Exception
//    {        
//        Instances data1 = BasicTools.loadData("./src/data/hurt_komp_zamowienia5.arff");
//       
//        //******** BUDOWA OBIEKTU GRUPUJACEGO DLA METODY kMeans ***********        
//        
//        /*
//        SimpleKMeans clusterer = new SimpleKMeans();        
//        //-N -> liczba srodkow
//        //-S -> Inicjacja generatora liczb pseudolosowych
//        String [] optionsKMeans = Utils.splitOptions("-N 4");// -S 1234");
//        clusterer.setOptions(optionsKMeans);
//
//        
//        //===== Ustawienie odleglosci        
//        clusterer.setDistanceFunction(new EuclideanDistance()); //Odleglosc euklidesowa
//        //kMeans.setDistanceFunction(new ManhattanDistance()); //Odleglosc miejska
//        
//*/        
//        //******** BUDOWA OBIEKTU GRUPUJACEGO DLA METODY EM ***********        
//        
//        
//        EM clusterer = new EM();        
//        //-I -> Maksymalna liczba iteracji algorytmu
//        //-N -> Wymuszenie liczby grup (-1 - dobiera sam)
//        //-S -> Inicjacja generatora liczb pseudolosowych
//        String [] optionsEM = Utils.splitOptions("-I 3 -N -4");//6 -S 1234");        
//        clusterer.setOptions(optionsEM);
//        
//        
//        //===== Grupowanie
//        clusterer.buildClusterer(data1);
//        
//        System.out.println(clusterer.toString()); //Wypisanie opisu grup
//        String wypisanie = clusterer.toString();
//        
//        System.out.println("Liczba skupien="+clusterer.getNumClusters()); //Dostep do liczby skupien
//          
//        //Instances centroids = clusterer.getClusterCentroids();        
//        //System.out.println(centroids.toString());
//
//
//    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                         
        try{
            
            
            String fileName = "./src/data/hurt_komp_zamowienia5.arff"; //Lokalizacja pliku z danymi
            Instances dataSet = BasicTools.loadData(fileName);
            int noObj = dataSet.numInstances(); //Pobranie informacji o liczbie obiektow
            int noAttr = dataSet.numAttributes(); //Pobranie informacji o liczbie atrybutow
            System.out.println("Liczba obiektow=" + noObj);
            System.out.println("Liczba atrybutow="+noAttr);
//            BasicDemo.grupowanie();


        Instances data1 = BasicTools.loadData("./src/data/hurt_komp_zamowienia5.arff");
       
        //******** BUDOWA OBIEKTU GRUPUJACEGO DLA METODY kMeans ***********        
        
        /*
        SimpleKMeans clusterer = new SimpleKMeans();        
        //-N -> liczba srodkow
        //-S -> Inicjacja generatora liczb pseudolosowych
        String [] optionsKMeans = Utils.splitOptions("-N 4");// -S 1234");
        clusterer.setOptions(optionsKMeans);

        
        //===== Ustawienie odleglosci        
        clusterer.setDistanceFunction(new EuclideanDistance()); //Odleglosc euklidesowa
        //kMeans.setDistanceFunction(new ManhattanDistance()); //Odleglosc miejska
        
*/        
        //******** BUDOWA OBIEKTU GRUPUJACEGO DLA METODY EM ***********        
        
        
        EM clusterer = new EM();        
        //-I -> Maksymalna liczba iteracji algorytmu
        //-N -> Wymuszenie liczby grup (-1 - dobiera sam)
        //-S -> Inicjacja generatora liczb pseudolosowych
        String [] optionsEM = Utils.splitOptions("-I 3 -N -4");//6 -S 1234");        
        clusterer.setOptions(optionsEM);
        
        
        //===== Grupowanie
        clusterer.buildClusterer(data1);
        
        System.out.println(clusterer.toString()); //Wypisanie opisu grup
        String wypisanie = clusterer.toString();
        
        System.out.println("Liczba skupien="+clusterer.getNumClusters()); //Dostep do liczby skupien

        //Instances centroids = clusterer.getClusterCentroids();        
        //System.out.println(centroids.toString());
        text.appendText("Liczba obiektow= " + noObj + "    " + "Liczba atrybutow= " + noAttr);
        text.appendText(clusterer.toString());

         
        
                    }
        catch (Exception e)
        {
            System.out.println("ERROR: "+e.getMessage());
            e.printStackTrace();
        }
    }
   
    
}


