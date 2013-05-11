/**
 * 
 */
package de.clusteval.program;

/**
 * This exception is thrown, if a program parameter should be used during a
 * parameter optimization process but is not defined as a optimizable parameter.
 * 
 * @author Christian Wiwie
 * 
 */
public class NoOptimizableProgramParameterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -430736667056265544L;

	/**
	 * @param message
	 */
	public NoOptimizableProgramParameterException(String message) {
		super(message);
	}
}
