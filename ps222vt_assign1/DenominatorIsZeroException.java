package ps222vt_assign1;
public class DenominatorIsZeroException extends Exception {
    /**
	 * Created a new exception to use in the Fraction.java when denominator
	 * is Zero.
	 */
	private static final long serialVersionUID = 1L;

	public DenominatorIsZeroException(String message) {
        super(message);
    }
}