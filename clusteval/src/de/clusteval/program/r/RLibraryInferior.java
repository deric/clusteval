/**
 * 
 */
package de.clusteval.program.r;

import java.util.Set;

/**
 * @author Christian Wiwie
 * 
 */
public interface RLibraryInferior {

	/**
	 * @return A set with names of all R libraries this class requires.
	 */
	public Set<String> getRequiredRlibraries();

}
