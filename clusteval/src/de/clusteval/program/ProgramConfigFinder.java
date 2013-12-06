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
package de.clusteval.program;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;

import de.clusteval.framework.repository.RegisterException;
import de.clusteval.framework.repository.Repository;
import de.clusteval.framework.repository.RepositoryObject;
import de.clusteval.utils.FileFinder;


import utils.ArrayIterator;

/**
 * Objects of this class look for new run-files in the run-directory defined in
 * the corresponding repository.
 * 
 * @author Christian Wiwie
 * 
 * 
 */
public class ProgramConfigFinder extends FileFinder {

	/**
	 * Instantiates a new run finder.
	 * 
	 * @param repository
	 *            The repository to register the new program configurations at.
	 * @throws RegisterException
	 */
	public ProgramConfigFinder(final Repository repository)
			throws RegisterException {
		super(repository, System.currentTimeMillis(), new File(
				repository.getBasePath(ProgramConfig.class)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Finder#checkFile(java.io.File)
	 */
	@Override
	protected boolean checkFile(File file) {
		return file.isFile() && file.getName().endsWith(".config");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Finder#getBaseDir()
	 */
	@Override
	protected File getBaseDir() {
		return new File(this.repository.getBasePath(ProgramConfig.class));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Finder#getClassToFind()
	 */
	@Override
	protected Class<?> getClassToFind() {
		return ProgramConfig.class;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Finder#getIterator()
	 */
	@Override
	protected Iterator<File> getIterator() {
		return new ArrayIterator<File>(getBaseDir().listFiles());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.FileFinder#getRegisteredObjectSet()
	 */
	@Override
	protected Collection<? extends RepositoryObject> getRegisteredObjectSet() {
		return this.repository.getCollection(ProgramConfig.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.FileFinder#parseObjectFromFile(java.io.File)
	 */
	@Override
	protected RepositoryObject parseObjectFromFile(File file) throws Exception {
		return ProgramConfig.parseFromFile(file);
	}
}
