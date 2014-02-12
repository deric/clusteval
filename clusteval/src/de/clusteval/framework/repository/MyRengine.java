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
package de.clusteval.framework.repository;

import java.util.HashSet;
import java.util.Set;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.clusteval.framework.RLibraryNotLoadedException;

/**
 * This class is used throughout the framework to provide access to the R
 * framework.
 * 
 * <p>
 * This class is a wrapper class for {@link RConnection} which adds convenience
 * functions.
 * 
 * @author Christian Wiwie
 * 
 */
public class MyRengine {

	protected RConnection connection;

	protected Logger log;

	protected Set<String> loadedLibraries;

	/**
	 * @param string
	 *            The parameter string.
	 * @throws RserveException
	 */
	public MyRengine(String string) throws RserveException {
		super();

		this.connection = new RConnection(string);
		this.log = LoggerFactory.getLogger(this.getClass());
		this.loadedLibraries = new HashSet<String>();
	}

	/**
	 * This method tries to load the library with the given name.
	 * 
	 * <p>
	 * If the library could not be loaded, this method throws a
	 * {@link RLibraryNotLoadedException}.
	 * 
	 * @param name
	 *            The name of the library.
	 * @param requiredByClass
	 *            The name of the class that requires the library.
	 * @return True, if the library was loaded successfully or was loaded
	 *         before.
	 * @throws RLibraryNotLoadedException
	 */
	public boolean loadLibrary(final String name, final String requiredByClass)
			throws RLibraryNotLoadedException {
		try {
			if (this.loadedLibraries.contains(name))
				return true;
			this.log.debug("Loading R library '" + name + "' ...");
			this.eval("library(" + name + ")");
			this.loadedLibraries.add(name);
			this.log.debug("R library '" + name + "' loaded successfully");
			return true;
		} catch (RserveException e) {
			this.log.debug("R library '" + name + "' loading failed");
			throw new RLibraryNotLoadedException(requiredByClass, name);
		}
	}

	/**
	 * This method clears all variables stored in the session corresponding to
	 * this rengine.
	 * 
	 * @throws RserveException
	 */
	public void clear() throws RserveException {
		this.eval("rm(list=ls(all=TRUE))");
	}

	/**
	 * This method allows to assign a two-dimensional double array.
	 * 
	 * @param arg0
	 *            The variable name in R.
	 * @param arg1
	 *            A two-dimensional double array which is assigned to the new
	 *            variable.
	 * @throws REngineException
	 */
	public void assign(String arg0, double[][] arg1) throws REngineException {
		int x = arg1.length;
		int y = x > 0 ? arg1[0].length : 0;
		double[] oneDim = new double[x * y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				oneDim[j + i * y] = arg1[i][j];
			}
		}
		this.eval(arg0 + " <- c()");
		this.connection.assign(arg0, oneDim);
		this.eval(arg0 + " <- matrix(" + arg0 + ",nrow=" + x + ",ncol=" + y + ",byrow=T)");
//		for (int i = 0; i < arg1.length; i++) {
//			this.connection.assign(arg0 + "_" + i, arg1[i]);
//			this.eval(arg0 + " <- rbind(" + arg0 + "," + arg0 + "_" + i + ")");
//			this.eval("remove(" + arg0 + "_" + i + ")");
//		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.rosuda.REngine.Rserve.RConnection#eval(java.lang.String)
	 */
	public REXP eval(String cmd) throws RserveException {
		this.connection.assign(".tmp.", cmd);
		REXP r;
		try {
			r = this.connection
					.eval("try(eval(parse(text=.tmp.)),silent=TRUE)");
			if (r == null)
				throw new RserveException(this.connection, "Evaluation error");
			else if (r.inherits("try-error"))
				try {
					throw new RserveException(this.connection, r.asString()
							.replace("\n", " - "));
				} catch (REXPMismatchException e) {
					throw new RserveException(this.connection,
							"Evaluation error");
				}
			return r;
		} catch (REngineException e) {
			throw new RserveException(this.connection, e.getMessage());
		}
	}

	/**
	 * TODO: use this instead of printStackTrace() This method logs the last
	 * error.
	 */
	public void printLastError() {
		log.error("R error: " + this.connection.getLastError());
	}

	public void assign(String arg0, int[] arg1) throws REngineException {
		this.connection.assign(arg0, arg1);
	}

	public void assign(String arg0, double[] arg1) throws REngineException {
		this.connection.assign(arg0, arg1);
	}

	public String getLastError() {
		return this.connection.getLastError();
	}

	protected boolean close() {
		return this.connection.close();
	}

	public void assign(String arg0, String[] arg1) throws REngineException {
		this.connection.assign(arg0, arg1);
	}
}