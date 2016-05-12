package business.model;

import java.awt.*;

public class RevisoreTrascrizioni extends RevisoreImmagine {

	public RevisoreTrascrizioni(String nome, String cognome,String userId, String psw) {
		super(nome,cognome,userId,psw);
	}
	public RevisoreTrascrizioni(String userId, String psw) {
		super(userId,psw);
	}
	
	public void revisionaTr(/*file TEI */Image image){
		revisionaIm(image);
		//aprire finestra con trascrizione TEI
	}
	public void commenta(String testo /*,file TEI*/){
		Commento commento=new Commento(/*titolo file*/,this.userId,testo);
		// salvare commento nel DB
	}

}
