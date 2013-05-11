package de.clusteval.data.dataset.format;

import java.io.File;
import java.io.IOException;

import utils.SimilarityMatrix;
import de.clusteval.data.dataset.DataSet;
import de.clusteval.framework.repository.RegisterException;
import de.clusteval.framework.repository.Repository;

/**
 * @author Christian Wiwie
 * 
 */
public abstract class RelativeDataSetFormat extends DataSetFormat {

	/**
	 * Instantiates a new relative data set format.
	 * 
	 * @param repo
	 * @param register
	 * @param changeDate
	 * @param absPath
	 * 
	 * @param version
	 * @throws RegisterException
	 * 
	 */
	public RelativeDataSetFormat(final Repository repo, final boolean register,
			final long changeDate, final File absPath, final int version)
			throws RegisterException {
		super(repo, register, changeDate, absPath, version);
	}

	/**
	 * The copy constructor for this format.
	 * 
	 * @param other
	 *            The object to clone.
	 * @throws RegisterException
	 */
	public RelativeDataSetFormat(final RelativeDataSetFormat other)
			throws RegisterException {
		super(other);
	}

	@Override
	public final SimilarityMatrix parse(final DataSet dataSet)
			throws IllegalArgumentException, IOException,
			InvalidDataSetFormatVersionException {
		return (SimilarityMatrix) super.parse(dataSet);
	}
}
