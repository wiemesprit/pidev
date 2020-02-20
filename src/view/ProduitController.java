/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.easyride.Entite.Produit;
import com.easyride.Service.ServiceProduit;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author suare
 */
public class ProduitController implements Initializable {
  
    @FXML
    private TextField tfnom;
   @FXML
    private TextField    recherche;
    @FXML
    private TextField tfdescription;
     @FXML
    private TextField tfcouleur;
    @FXML
    private TextField tfprix;
    @FXML
    private Button ajouter;
    @FXML
    private TableView<Produit> table;
    @FXML
    private TableColumn<Produit,String> fnom;
    @FXML
    private TableColumn<Produit,String> fdescription;
     @FXML
    private TableColumn<Produit,String> fcouleur;
    @FXML
    private TableColumn<Produit,Integer> fprix;
    ObservableList <Produit> arr= FXCollections.observableArrayList();
    @FXML
    private Button delete;
    @FXML
    private Button update;
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
           
      
            
            fnom.setCellFactory(TextFieldTableCell.forTableColumn());
            fdescription.setCellFactory(TextFieldTableCell.forTableColumn());
            fcouleur.setCellFactory(TextFieldTableCell.forTableColumn());
            fprix.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>() {
                
                @Override
                public String toString(Integer object) {
                    return String.valueOf(object);
                }
                
                @Override
                public Integer fromString(String string) {
                    return Integer.parseInt(string);
                }
            }));
        Produit e= new Produit();
        fnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                fdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
                  fcouleur.setCellValueFactory(new PropertyValueFactory<>("couleur"));
                        fprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
                       
        try { 
            ServiceProduit ser = new ServiceProduit();
            arr=ser.readAll();
        } catch (SQLException ex) {
           
        }
        table.setItems((ObservableList<Produit>)arr);
                  
        
        
        
        FilteredList<Produit> filteredData = new FilteredList<>(arr, b -> true);
        recherche.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(E -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (E.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }// Filter matches first name.
                else {
                    return false;
                }
            });
        });
        SortedList<Produit> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
     
            
                        

    }    
    
    public void refresh(){
        
        fnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                fdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
                  fcouleur.setCellValueFactory(new PropertyValueFactory<>("couleur"));
                        fprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
                       
        try { 
            ServiceProduit ser = new ServiceProduit();
            arr=ser.readAll();
        } catch (SQLException ex) {
      
        }
        table.setItems((ObservableList<Produit>)arr);
     
                        
                        
    }
    
    
    @FXML
     private void ajouter(ActionEvent event) {
          
         
         String nom = tfnom.getText();
            String description = tfdescription.getText();
              String couleur = tfcouleur.getText();
            String prixP = tfprix.getText();
        int prix=Integer.parseInt(tfprix.getText());
        
            ServiceProduit sp = new ServiceProduit();
            Produit p = new Produit();
            p.setNom(nom);
            p.setDescription(description);
            p.setCouleur(couleur);
            p.setPrix(prix);
           
         try {
            sp.ajouter(p);   

            
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
    refresh();
    System.out.println("élément ajouter avec Success");
     }


    @FXML
    private void delete(ActionEvent Event)  {
        
        try {
            Produit a = table.getSelectionModel().getSelectedItem();
            ServiceProduit ser = new ServiceProduit();
            ser.delete(a);
            arr.clear();
            arr.addAll(ser.readAll());
        } catch (SQLException ex) {
           
        }
       refresh();
       System.out.println("élément supprimer avec Success");
  
    }

    @FXML
    private void update(ActionEvent event)  {
       
     
   
  
          try {
            Produit a = table.getSelectionModel().getSelectedItem();
              System.out.println(a);
            ServiceProduit ser = new ServiceProduit();
            ser.update(a);
   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
             System.out.println("modifier avec success");
        
            
        
    }
   

        
    

    @FXML
    private void imprimer(ActionEvent event) {
       
        PrinterJob printerJob = PrinterJob.createPrinterJob();
        if (printerJob.printPage(table)) {
            printerJob.endJob();
            System.out.println("printed");
        }
    }
   
    
  
    
}