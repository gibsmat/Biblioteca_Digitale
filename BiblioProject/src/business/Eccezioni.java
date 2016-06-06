package business;

import javax.swing.JOptionPane;

public class Eccezioni extends RuntimeException {

		public Eccezioni() {
			super();
		}

		public Eccezioni(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
		}

		public Eccezioni(String message, Throwable cause) {
			super(message, cause);
			JOptionPane.showMessageDialog(null, message+"\n"+cause);
		}

		public Eccezioni(String message) {
			super(message);
			JOptionPane.showMessageDialog(null, message);
		}

		public Eccezioni(Throwable cause) {
			super(cause);
			JOptionPane.showMessageDialog(null, cause);
		}
		
		
	}

