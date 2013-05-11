/**
 * 
 */
package de.clusteval.data.dataset.format;

import java.util.ArrayList;
import java.util.List;

import de.clusteval.data.distance.DistanceMeasure;
import de.clusteval.data.preprocessing.DataPreprocessor;

/**
 * @author Christian Wiwie
 * 
 */
public class ConversionInputToStandardConfiguration
		extends
			ConversionConfiguration {

	protected static List<DataPreprocessor> clonePreprocessors(
			List<DataPreprocessor> preprocessors) {
		List<DataPreprocessor> result = new ArrayList<DataPreprocessor>();

		for (DataPreprocessor proc : preprocessors)
			result.add(proc.clone());

		return result;
	}

	protected List<DataPreprocessor> preprocessorsBeforeDistance;

	protected DistanceMeasure distanceMeasureAbsoluteToRelative;

	protected List<DataPreprocessor> preprocessorsAfterDistance;

	/**
	 * @param distanceMeasure
	 * @param preprocessorsBeforeDistance
	 * @param preprocessorsAfterDistance
	 * 
	 */
	public ConversionInputToStandardConfiguration(
			final DistanceMeasure distanceMeasure,
			final List<DataPreprocessor> preprocessorsBeforeDistance,
			final List<DataPreprocessor> preprocessorsAfterDistance) {
		super();

		this.distanceMeasureAbsoluteToRelative = distanceMeasure;
		this.preprocessorsBeforeDistance = preprocessorsBeforeDistance;
		this.preprocessorsAfterDistance = preprocessorsAfterDistance;
	}

	/**
	 * The copy constructor for this class.
	 * 
	 * @param other
	 *            The object to clone.
	 */
	public ConversionInputToStandardConfiguration(
			final ConversionInputToStandardConfiguration other) {
		super();

		this.distanceMeasureAbsoluteToRelative = other.distanceMeasureAbsoluteToRelative
				.clone();
		this.preprocessorsBeforeDistance = clonePreprocessors(other.preprocessorsBeforeDistance);
		this.preprocessorsAfterDistance = clonePreprocessors(other.preprocessorsAfterDistance);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public ConversionInputToStandardConfiguration clone() {
		return new ConversionInputToStandardConfiguration(this);
	}

	/**
	 * @return The distance measure to use during the conversion of absolute to
	 *         relative datasets.
	 */
	public DistanceMeasure getDistanceMeasureAbsoluteToRelative() {
		return this.distanceMeasureAbsoluteToRelative;
	}

	/**
	 * @return The preprocessors to apply to the dataset before it is converted
	 *         to pairwise distances/similarities.
	 */
	public List<DataPreprocessor> getPreprocessorsBeforeDistance() {
		return this.preprocessorsBeforeDistance;
	}

	/**
	 * @return The preprocessors to apply to the dataset after it is converted
	 *         to pairwise distances/similarities.
	 */
	public List<DataPreprocessor> getPreprocessorsAfterDistance() {
		return this.preprocessorsAfterDistance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ConversionInputToStandardConfiguration))
			return false;

		ConversionInputToStandardConfiguration other = (ConversionInputToStandardConfiguration) obj;

		return this.distanceMeasureAbsoluteToRelative
				.equals(other.distanceMeasureAbsoluteToRelative);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.distanceMeasureAbsoluteToRelative.hashCode();
	}

}
