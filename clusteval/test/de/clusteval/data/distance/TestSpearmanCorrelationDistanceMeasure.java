/**
 * 
 */
package de.clusteval.data.distance;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import utils.SimilarityMatrix.NUMBER_PRECISION;
import de.clusteval.data.dataset.format.ConversionInputToStandardConfiguration;
import de.clusteval.data.preprocessing.DataPreprocessor;
import de.clusteval.utils.AbstractClustEvalTest;
import de.clusteval.utils.RNotAvailableException;

/**
 * @author Christian Wiwie
 * 
 */
public class TestSpearmanCorrelationDistanceMeasure
		extends
			AbstractClustEvalTest {

	@Test
	public void test() throws UnknownDistanceMeasureException,
			RNotAvailableException {
		DistanceMeasure measure = DistanceMeasure.parseFromString(
				getRepository(), "SpearmanCorrelationRDistanceMeasure");
		Assert.assertTrue(measure != null);

		ConversionInputToStandardConfiguration config = new ConversionInputToStandardConfiguration(
				measure, NUMBER_PRECISION.FLOAT,
				new ArrayList<DataPreprocessor>(),
				new ArrayList<DataPreprocessor>());

		double[][] matrix = new double[][]{new double[]{1, 2, 1},
				new double[]{4, 5, 6}, new double[]{7, 8, 9}};

		System.out.println(measure.getDistances(config, matrix));
	}
}
