/**
 * 
 */
package de.clusteval.data.distance;

import de.clusteval.framework.repository.Repository;

/**
 * @author Christian Wiwie
 * 
 */
public interface DistanceMeasureFactory {

	/**
	 * @param repository
	 * @return
	 */
	public DistanceMeasure newInstance(final Repository repository);
}
