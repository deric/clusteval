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
package de.clusteval.data.goldstandard;

import java.io.File;

import de.clusteval.framework.repository.RegisterException;
import de.clusteval.framework.repository.Repository;
import de.clusteval.framework.repository.RepositoryEvent;
import de.clusteval.framework.repository.RepositoryObject;
import de.clusteval.framework.repository.RepositoryRemoveEvent;
import de.clusteval.framework.repository.RepositoryReplaceEvent;

/**
 * A goldstandard configuration encapsulates options and settings for a
 * goldstandard. During the execution of a run, when goldstandards are used,
 * settings are required that control the behaviour of how the goldstandard has
 * to be handled.
 * 
 * <p>
 * A goldstandard configuration corresponds to and is parsed from a file on the
 * filesystem in the corresponding folder of the repository (see
 * {@link Repository#goldStandardConfigBasePath} and
 * {@link GoldStandardConfigFinder}).
 * 
 * <p>
 * There are several options, that can be specified in the goldstandard
 * configuration file (see {@link #parseFromFile(File)}).
 * 
 * @author Christian Wiwie
 * 
 */
public class GoldStandardConfig extends RepositoryObject {

	/**
	 * A goldstandard configuration encapsulates a goldstandard. This attribute
	 * stores a reference to the goldstandard wrapper object.
	 */
	private GoldStandard goldStandard;

	/**
	 * Instantiates a new goldstandard configuration.
	 * 
	 * @param repository
	 *            The repository this goldstandard configuration should be
	 *            registered at.
	 * @param changeDate
	 *            The change date of this goldstandard configuration is used for
	 *            equality checks.
	 * @param absPath
	 *            The absolute path of this goldstandard configuration.
	 * @param goldstandard
	 *            The encapsulated goldstandard.
	 * @throws RegisterException
	 */
	public GoldStandardConfig(final Repository repository,
			final long changeDate, final File absPath,
			final GoldStandard goldstandard) throws RegisterException {
		super(repository, false, changeDate, absPath);

		this.goldStandard = goldstandard;
		if (this.register())
			this.goldStandard.addListener(this);
	}

	/**
	 * The copy constructor for goldstandard configurations.
	 * 
	 * @param goldstandardConfig
	 *            The goldstandard configuration to be cloned.
	 * @throws RegisterException
	 */
	public GoldStandardConfig(GoldStandardConfig goldstandardConfig)
			throws RegisterException {
		super(goldstandardConfig);
		this.goldStandard = goldstandardConfig.goldStandard.clone();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.repository.RepositoryObject#clone()
	 */
	@Override
	public GoldStandardConfig clone() {
		try {
			return new GoldStandardConfig(this);
		} catch (RegisterException e) {
			// should not occur
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @return The goldstandard this configuration belongs to.
	 * @see #goldStandard
	 */
	public GoldStandard getGoldstandard() {
		return goldStandard;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.RepositoryObject#notify(utils.RepositoryEvent)
	 */
	@Override
	public void notify(RepositoryEvent e) throws RegisterException {
		if (e instanceof RepositoryReplaceEvent) {
			RepositoryReplaceEvent event = (RepositoryReplaceEvent) e;
			if (event.getOld().equals(this))
				super.notify(event);
			else {
				if (event.getOld().equals(goldStandard)) {
					event.getOld().removeListener(this);
					this.log.info("GoldStandardConfig "
							+ this.absPath.getName()
							+ ": GoldStandard reloaded due to modifications in filesystem");
					event.getReplacement().addListener(this);
					// added 06.07.2012
					this.goldStandard = (GoldStandard) event.getReplacement();
				}
			}
		} else if (e instanceof RepositoryRemoveEvent) {
			RepositoryRemoveEvent event = (RepositoryRemoveEvent) e;
			if (event.getRemovedObject().equals(this))
				super.notify(event);
			else {
				if (event.getRemovedObject().equals(goldStandard)) {
					event.getRemovedObject().removeListener(this);
					this.log.info("GoldStandardConfig " + this
							+ ": Removed, because GoldStandard " + goldStandard
							+ " was removed.");
					RepositoryRemoveEvent newEvent = new RepositoryRemoveEvent(
							this);
					this.unregister();
					this.notify(newEvent);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.absPath.getName().replace(".gsconfig", "");
	}
}
