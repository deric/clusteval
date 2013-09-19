/*******************************************************************************
 * Copyright (c) 2013 Christian Wiwie.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Christian Wiwie - initial API and implementation
 ******************************************************************************/
/**
 * 
 */
package de.clusteval.cluster;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Pair;
import utils.parse.TextFileParser;
import utils.text.TextFileMapParser;
import de.clusteval.cluster.quality.ClusteringQualityMeasure;
import de.clusteval.cluster.quality.ClusteringQualityMeasureValue;
import de.clusteval.cluster.quality.ClusteringQualitySet;
import de.clusteval.cluster.quality.UnknownClusteringQualityMeasureException;
import de.clusteval.framework.repository.NoRepositoryFoundException;
import de.clusteval.framework.repository.Repository;

/**
 * A parser for files containing parameter sets and clusterings.
 * 
 * @author Christian Wiwie
 */
public class ClusteringParser extends TextFileParser {

	protected Repository repository;

	protected boolean parseQualities;

	/**
	 * This variable holds the results after parsing
	 */
	protected Pair<Map<String, Double>, Clustering> result;

	/**
	 * A temporary variable of no use after parsing.
	 */
	protected List<String> params;

	/**
	 * Instantiates a new clustering parser.
	 * 
	 * @param repository
	 * 
	 * @param absFilePath
	 *            the abs file path
	 * @param parseQualities
	 *            True, if the qualities of the clusterings should also be
	 *            parsed. Those will be taken from .qual-files.
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public ClusteringParser(final Repository repository,
			final String absFilePath, final boolean parseQualities)
			throws IOException {
		super(absFilePath, new int[]{0}, new int[]{1});
		this.repository = repository;
		this.setLockTargetFile(true);
		this.params = new ArrayList<String>();
		this.parseQualities = parseQualities;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.parse.TextFileParser#processLine(java.lang.String[],
	 * java.lang.String[])
	 */
	@Override
	protected void processLine(String[] key, String[] value) {

		String parameterString = key[0];

		if (this.currentLine == 0) {
			String[] params = parameterString.split(",");
			for (String param : params)
				this.params.add(param.intern());
			return;
		}

		Clustering result;
		try {

			Repository repo = Repository.getRepositoryForPath(absoluteFilePath);
			if (repo.getParent() != null)
				repo = repo.getParent();

			result = new Clustering();
			String[] params = parameterString.split(",");

			Map<String, Double> paramValues = new HashMap<String, Double>();
			for (int pos = 0; pos < this.params.size(); pos++) {
				paramValues.put(this.params.get(pos), Double.valueOf(Double
						.valueOf(params[pos]).doubleValue()));
			}

			String clusteringString = value[0];
			String[] clusters = clusteringString.split(";");
			int no = 1;
			for (String cluster : clusters) {
				Cluster c = new Cluster((no++ + "").intern());
				String[] items = cluster.split(",");
				for (String item : items) {
					String[] itemSplit = item.split(":");
					c.add(new ClusterItem(itemSplit[0].intern()), Float
							.valueOf(Float.valueOf(itemSplit[1]).floatValue()));
				}
				result.addCluster(c);
			}

			this.result = Pair.getPair(paramValues, result);
		} catch (NoRepositoryFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.parse.TextFileParser#finishProcess()
	 */
	@Override
	public void finishProcess() {
		// parse qualities
		if (parseQualities) {
			final File qualityFile = new File(this.absoluteFilePath.replace(
					".conv", ".qual"));
			if (qualityFile.exists()) {
				try {
					TextFileMapParser parser = new TextFileMapParser(
							qualityFile.getAbsolutePath(), 0, 1);
					parser.process();
					Map<String, String> result = parser.getResult();
					ClusteringQualitySet qualitySet = new ClusteringQualitySet();
					for (String measure : result.keySet()) {
						ClusteringQualityMeasure clMeasure;
						clMeasure = ClusteringQualityMeasure.parseFromString(
								this.repository, measure);
						qualitySet.put(clMeasure, ClusteringQualityMeasureValue
								.getForDouble(Double.parseDouble(result
										.get(measure))));
					}
					this.result.getSecond().setQualities(qualitySet);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (UnknownClusteringQualityMeasureException e) {
					e.printStackTrace();
				}
			}
		}

		super.finishProcess();
	}

	/**
	 * @return A map containing parameter sets and corresponding clusterings.
	 */
	public Pair<Map<String, Double>, Clustering> getClusterings() {
		return this.result;
	}
}
