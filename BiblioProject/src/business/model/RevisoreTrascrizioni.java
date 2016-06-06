package business.model;

import javax.swing.table.TableModel;

import business.implementation.OperaManagement;

public class RevisoreTrascrizioni extends RevisoreImmagine {

	public RevisoreTrascrizioni(String nome, String cognome,String userId, String psw,boolean status) {
		super(nome,cognome,userId,psw,status);
	}
	
	public void revisionaTr(/*file TEI */){
		//revisionaIm(image);
		//aprire finestra con trascrizione TEI
	}
	public void commenta(String testo){
		Commento commento=new Commento(this.userId,testo);
		new OperaManagement().addCommentoT(commento);
	}

	public TableModel viewCommenti(){
		return new OperaManagement().getCommentiT();
	}
}
