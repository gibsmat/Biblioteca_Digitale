package business;

import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * The Class Eccezioni.
 */
public class Eccezioni extends RuntimeException {

		/**
		 * Instantiates a new eccezioni.
		 */
		public Eccezioni() {
			super();
		}

		/**
		 * Instantiates a new eccezioni.
		 *
		 * @param message the message
		 * @param cause the cause
		 * @param enableSuppression the enable suppression
		 * @param writableStackTrace the writable stack trace
		 */
		public Eccezioni(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
		}

		/**
		 * Instantiates a new eccezioni.
		 *
		 * @param message the message
		 * @param cause the cause
		 */
		public Eccezioni(String message, Throwable cause) {
			super(message, cause);
			JOptionPane.showMessageDialog(null, message+"\n"+cause);
		}

		/**
		 * Instantiates a new eccezioni.
		 *
		 * @param message the message
		 */
		public Eccezioni(String message) {
			super(message);
			JOptionPane.showMessageDialog(null, message);
		}

		/**
		 * Instantiates a new eccezioni.
		 *
		 * @param cause the cause
		 */
		public Eccezioni(Throwable cause) {
			super(cause);
			JOptionPane.showMessageDialog(null, cause);
		}
		
		
	}

