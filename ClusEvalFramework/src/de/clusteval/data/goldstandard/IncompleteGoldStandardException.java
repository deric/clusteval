/**
 * 
 */
package de.clusteval.data.goldstandard;

import java.util.Set;

/**
 * @author Christian Wiwie
 * 
 */
public class IncompleteGoldStandardException extends GoldStandardException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4986352597738030172L;

	/**
	 * @param missingIds
	 */
	public IncompleteGoldStandardException(final Set<String> missingIds) {
		super("The goldstandard is missing entries: " + missingIds);
	}

}
