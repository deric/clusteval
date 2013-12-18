/**
 * 
 */
package de.clusteval.data.distance;

import java.io.File;

import org.junit.Test;

import de.clusteval.framework.ClustevalBackendServer;
import de.clusteval.framework.repository.Repository;
import de.clusteval.framework.repository.StubSQLCommunicator;
import de.clusteval.utils.AbstractClustEvalTest;

/**
 * @author Christian Wiwie
 * 
 */
public class TestDistanceMeasure extends AbstractClustEvalTest {

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.clusteval.utils.AbstractClustEvalTest#setUp()
	 */
	@Override
	public void setUp() throws Exception {
		ClustevalBackendServer.getBackendServerConfiguration()
				.setCheckForRunResults(false);
		super.setUp();
	}

	@Test
	public void testParseFromFile() throws UnknownDistanceMeasureException {
		DistanceMeasure.parseFromString(getRepository(),
				"EuclidianDistanceMeasure");
	}

}
