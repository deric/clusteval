/**
 * 
 */
package de.clusteval.cluster.paramOptimization;

import de.clusteval.cluster.quality.ClusteringQualitySet;


/**
 * @author Christian Wiwie
 *
 */
public interface IDivergingParameterOptimizationMethod {
	/**
	 * @param minimalQualities
	 */
	public void giveFeedbackNotTerminated(ClusteringQualitySet minimalQualities);
}
