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
package de.clusteval.run.result.format;

/**
 * The Class UnknownRunResultFormatException.
 * 
 * @author Christian Wiwie
 */
public class UnknownRunResultFormatException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4703586012634484344L;

	/**
	 * Instantiates a new unknown run result format exception.
	 * 
	 * @param string
	 *            the string
	 */
	public UnknownRunResultFormatException(String string) {
		super(string);
	}

}
