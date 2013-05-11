/**
 * 
 */
package de.clusteval.data.dataset.format;

/**
 * @author Christian Wiwie
 * 
 */
public class ConversionStandardToInputConfiguration
		extends
			ConversionConfiguration {

	/**
	 * 
	 */
	public ConversionStandardToInputConfiguration() {
		super();
	}

	/**
	 * The copy constructof of this class.
	 * 
	 * @param other
	 *            The object to clone.
	 */
	@SuppressWarnings("unused")
	public ConversionStandardToInputConfiguration(
			final ConversionStandardToInputConfiguration other) {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public ConversionStandardToInputConfiguration clone() {
		return new ConversionStandardToInputConfiguration(this);
	}

}
