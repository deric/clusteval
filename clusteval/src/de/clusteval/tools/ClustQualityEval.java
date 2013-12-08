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
package de.clusteval.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.ProgressPrinter;
import ch.qos.logback.classic.Level;
import de.clusteval.cluster.Clustering;
import de.clusteval.cluster.quality.ClusteringQualityMeasure;
import de.clusteval.cluster.quality.ClusteringQualitySet;
import de.clusteval.cluster.quality.UnknownClusteringQualityMeasureException;
import de.clusteval.data.DataConfig;
import de.clusteval.data.dataset.format.InvalidDataSetFormatVersionException;
import de.clusteval.data.dataset.format.UnknownDataSetFormatException;
import de.clusteval.data.goldstandard.format.UnknownGoldStandardFormatException;
import de.clusteval.framework.ClustevalBackendServer;
import de.clusteval.framework.repository.InvalidRepositoryException;
import de.clusteval.framework.repository.Repository;
import de.clusteval.framework.repository.RepositoryAlreadyExistsException;
import de.clusteval.framework.repository.config.RepositoryConfigNotFoundException;
import de.clusteval.framework.repository.config.RepositoryConfigurationException;
import file.FileUtils;

/**
 * @author Christian Wiwie
 * 
 */
public class ClustQualityEval {

	protected Repository repo;
	protected DataConfig dataConfig;
	protected ProgressPrinter printer;

	public ClustQualityEval(final String absRepoPath,
			final String dataConfigName) throws FileNotFoundException,
			RepositoryAlreadyExistsException, InvalidRepositoryException,
			RepositoryConfigNotFoundException,
			RepositoryConfigurationException,
			UnknownClusteringQualityMeasureException, InterruptedException {
		super();
		ClustevalBackendServer.logLevel(Level.INFO);
		this.repo = new Repository(absRepoPath, null);
		this.repo.initialize();

		this.dataConfig = this.repo.getStaticObjectWithName(DataConfig.class,dataConfigName);

		List<ClusteringQualityMeasure> measures = new ArrayList<ClusteringQualityMeasure>();

		for (Class<? extends ClusteringQualityMeasure> measureClass : this.repo
				.getClusteringQualityMeasureClasses()) {
			measures.add(ClusteringQualityMeasure.parseFromString(this.repo,
					measureClass.getSimpleName()));
		}

		File f = new File(
				FileUtils.buildPath(repo.getBasePath(), "clusterings"));
		File[] childs = f.listFiles();
		this.printer = new MyProgressPrinter(childs.length, true);
		((ch.qos.logback.classic.Logger) LoggerFactory
				.getLogger(Logger.ROOT_LOGGER_NAME))
				.info("Assessing qualities of clusterings ...");
		for (File clusteringFile : childs) {
			try {
				if (!clusteringFile.getName().endsWith(".qual")) {
					Clustering cl = Clustering.parseFromFile(this.repo,
							clusteringFile.getAbsoluteFile(), false)
							.getSecond();
					ClusteringQualitySet quals = cl.assessQuality(
							this.dataConfig, measures);

					String qualityFile = clusteringFile.getAbsolutePath()
							+ ".qual";
					if (!new File(qualityFile).exists()) {

						for (ClusteringQualityMeasure qualityMeasure : quals
								.keySet()) {
							FileUtils.appendStringToFile(qualityFile,
									qualityMeasure.getClass().getSimpleName()
											+ "\t" + quals.get(qualityMeasure)
											+ "\n");
						}
					}
				}
				this.printer.update(this.printer.getCurrentPos() + 1);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (UnknownGoldStandardFormatException e) {
				e.printStackTrace();
			} catch (UnknownDataSetFormatException e) {
				e.printStackTrace();
			} catch (InvalidDataSetFormatVersionException e) {
				e.printStackTrace();
			}
		}
		System.exit(0);
	}

	public static void main(String[] args) throws FileNotFoundException,
			RepositoryAlreadyExistsException, InvalidRepositoryException,
			RepositoryConfigNotFoundException,
			RepositoryConfigurationException,
			UnknownClusteringQualityMeasureException, InterruptedException {
		new ClustQualityEval(args[0], args[1]);
	}
}

class MyProgressPrinter extends ProgressPrinter {

	/**
	 * 
	 */
	public MyProgressPrinter(final long upperLimit,
			final boolean printOnNewPercent) {
		super(upperLimit, printOnNewPercent);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.ProgressPrinter#log(java.lang.String)
	 */
	@Override
	protected void log(String message) {
		this.log.info(message);
	}
}
