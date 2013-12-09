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
package de.clusteval.data.dataset.format;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.Iterator;

import de.clusteval.framework.repository.RegisterException;
import de.clusteval.framework.repository.Repository;
import de.clusteval.utils.FormatVersion;
import de.clusteval.utils.JARFinder;
import de.clusteval.utils.RecursiveSubDirectoryIterator;

/**
 * @author Christian Wiwie
 */
public class DataSetFormatFinder extends JARFinder<DataSetFormat> {

	/**
	 * Instantiates a new data set format finder.
	 * 
	 * @param repository
	 *            the repository
	 * @param changeDate
	 * @param absPath
	 * @throws RegisterException
	 */
	public DataSetFormatFinder(final Repository repository,
			final long changeDate, final File absPath) throws RegisterException {
		super(repository, changeDate, absPath);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.JARFinder#getRegisteredObjectSet()
	 */
	@Override
	protected Collection<Class<? extends DataSetFormat>> getRegisteredObjectSet() {
		return repository.getClasses(DataSetFormat.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.JARFinder#removeOldObject(java.lang.Class)
	 */
	@Override
	protected void removeOldObject(Class<? extends DataSetFormat> object) {
		repository.unregisterClass(DataSetFormat.class, object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Finder#checkFile(java.io.File)
	 */
	@Override
	protected boolean checkFile(File file) {
		return file.getName().endsWith("DataSetFormat.jar");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.JARFinder#classNameForJARFile(java.io.File)
	 */
	@Override
	protected String[] classNamesForJARFile(File f) {
		return new String[]{
				"de.clusteval.data.dataset.format."
						+ f.getName().replace(".jar", ""),
				"de.clusteval.data.dataset.format."
						+ f.getName().replace(".jar", "Parser")};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Finder#getBaseDir()
	 */
	@Override
	protected File getBaseDir() {
		return new File(this.repository.getBasePath(DataSetFormat.class));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Finder#getClassToFind()
	 */
	@Override
	protected Class<?> getClassToFind() {
		return DataSetFormat.class;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Finder#getIterator()
	 */
	@Override
	protected Iterator<File> getIterator() {
		return new RecursiveSubDirectoryIterator(getBaseDir());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.JARFinder#isJARLoaded(java.io.File)
	 */
	@Override
	protected boolean isJARLoaded(File f) {
		return super.isJARLoaded(f)
				&& this.repository.isClassRegistered(DataSetFormat.class,
						"de.clusteval.data.dataset.format."
								+ f.getName().replace(".jar", ""));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.JARFinder#getURLClassLoader(java.io.File)
	 */
	@Override
	protected URLClassLoader getURLClassLoader0(File f, final ClassLoader parent)
			throws MalformedURLException {
		URL url = f.toURI().toURL();
		return new DataSetFormatURLClassLoader(this, new URL[]{url}, parent);
	}
}

class DataSetFormatURLClassLoader extends URLClassLoader {

	protected DataSetFormatFinder parent;

	/**
	 * @param urls
	 * @param parent
	 * @param loaderParent
	 */
	public DataSetFormatURLClassLoader(DataSetFormatFinder parent, URL[] urls,
			ClassLoader loaderParent) {
		super(urls, loaderParent);
		this.parent = parent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.ClassLoader#loadClass(java.lang.String)
	 */
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		Class<?> result = super.loadClass(name, true);

		if (name.startsWith("de.clusteval.data.dataset.format")
				&& !name.equals("de.clusteval.data.dataset.format.DataSetFormat")
				&& !name.equals("de.clusteval.data.dataset.format.DataSetFormatParser")
				&& !name.equals("de.clusteval.data.dataset.format.AbsoluteDataSetFormat")
				&& !name.equals("de.clusteval.data.dataset.format.RelativeDataSetFormat")) {
			if (name.endsWith("DataSetFormat")) {
				@SuppressWarnings("unchecked")
				Class<? extends DataSetFormat> dataSetFormat = (Class<? extends DataSetFormat>) result;

				// the class needs to have a version annotation
				if (!result.isAnnotationPresent(FormatVersion.class)) {
					ClassNotFoundException ex = new ClassNotFoundException(
							"The dataset format class "
									+ result.getSimpleName()
									+ " is missing the version information");
					throw ex;
				}

				if (this.parent.getRepository().registerClass(
						DataSetFormat.class, dataSetFormat))
					this.parent.getLog().info(
							"DataSetFormat " + name + " loaded");

				// get the annotation
				FormatVersion anno = result.getAnnotation(FormatVersion.class);

				this.parent.getRepository().putCurrentDataSetFormatVersion(
						dataSetFormat.getSimpleName(), anno.version());
			} else if (name.endsWith("DataSetFormatParser")) {
				@SuppressWarnings("unchecked")
				Class<? extends DataSetFormatParser> dataSetFormatParser = (Class<? extends DataSetFormatParser>) result;

				// the class needs to have a version annotation
				if (!result.isAnnotationPresent(FormatVersion.class)) {
					ClassNotFoundException ex = new ClassNotFoundException(
							"The dataset format parser class "
									+ result.getSimpleName()
									+ " is missing the version information");
					throw ex;
				}

				// get the annotation
				FormatVersion anno = result.getAnnotation(FormatVersion.class);

				// and the version of the parser needs to correspond to the
				// newest version of the format
				int formatVersion;
				try {
					formatVersion = this.parent.getRepository()
							.getCurrentDataSetFormatVersion(
									dataSetFormatParser.getSimpleName()
											.replace("Parser", ""));

					if (formatVersion > anno.version())
						throw new ClassNotFoundException(
								"The dataset format parser class "
										+ result.getSimpleName()
										+ " is outdated (was version "
										+ anno.version() + " but required is "
										+ formatVersion + ")");
				} catch (UnknownDataSetFormatException e) {
				}

				if (this.parent.getRepository().registerDataSetFormatParser(
						dataSetFormatParser))
					this.parent.getLog().info(
							"DataSetFormatParser " + name + " loaded");

			}
		}
		return result;
	}
}
