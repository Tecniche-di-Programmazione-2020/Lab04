/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */
package it.polito.tdp.lab04;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.fxml.FXML;


	

	import java.net.URL;
	import java.util.ResourceBundle;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.ChoiceBox;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

	public class FXMLController {
		private Model model;	
		private List<Corso> corsi;

	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ChoiceBox<Corso> listaCorsi;

	    @FXML
	    private TextField matricola;

	    @FXML
	    private TextField nome;

	    @FXML
	    private TextField cognome;

	    @FXML
	    private TextArea txtStampa;

	    @FXML
	    //Fatto
	    void doCercaCorsi(ActionEvent event) {
	    	txtStampa.clear();
	    	nome.clear();
	    	cognome.clear();
	    	
	    	

	    }

	    @FXML
	    void doCercaIscritti(ActionEvent event) {
	    	txtStampa.clear();
	    	try {
	    	Corso corso= listaCorsi.getValue();
	    	if(corso==null) {
	    		txtStampa.setText("Seleziona un corso!");
	    		return;
	    	}
	    	
	    	List<Studente> studenti= model.studentiIscrittiAlCorso(corso);
	    	
	    	StringBuilder sb = new StringBuilder();

			for (Studente studente : studenti) {

				sb.append(String.format("%-10s ", studente.getMatricola()));
				sb.append(String.format("%-20s ", studente.getCognome()));
				sb.append(String.format("%-20s ", studente.getNome()));
				sb.append(String.format("%-10s ", studente.getCds()));
				sb.append("\n");
			}

			txtStampa.appendText(sb.toString());
	    	} catch (RuntimeException e) {
				txtStampa.setText("ERRORE DI CONNESSIONE AL DATABASE!");
			}
	    	
	    }
	    
	    @FXML
	    void doCompleta(MouseEvent event) {
	    	Integer matricolanum=Integer.parseInt(matricola.getText());
	    	Studente stud= model.getStudente(matricolanum);
	    	nome.setText(stud.getNome());
	    	cognome.setText(stud.getCognome());
	    
	    }
	    @FXML
	    void doIscrivi(ActionEvent event) {
	    	Corso corso= listaCorsi.getValue();
	    	Integer matricolanum=Integer.parseInt(matricola.getText());
	    	Studente stud = model.getStudente(matricolanum);
	    	model.inscriviStudenteACorso(stud, corso);

	    }

	    @FXML
	    void doReset(ActionEvent event) {
	    	txtStampa.clear();
	    	nome.clear();
	    	cognome.clear();
	    	matricola.clear();

	    }

	    @FXML
	    void initialize() {
	        assert listaCorsi != null : "fx:id=\"listaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert matricola != null : "fx:id=\"matricola\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert nome != null : "fx:id=\"nome\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert cognome != null : "fx:id=\"cognome\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtStampa != null : "fx:id=\"txtStampa\" was not injected: check your FXML file 'Scene.fxml'.";
	       
	        

	    }
	    
	    public void setModel(Model model) {
	    	this.model = model;
	    	configuraCorsi();
	    }

		private void configuraCorsi() {
			corsi=model.getTuttiICorsi();
			listaCorsi.getItems().addAll(corsi);
			listaCorsi.getItems().add(null);
			
		}
	   
	}
