/**
 * 
 */
package de.clusteval.framework;

/**
 * This exception indicates that a certain class required an R library, which
 * could not be loaded.
 * 
 * @author Christian Wiwie
 * 
 */
public class RLibraryNotLoadedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 413025190326002304L;

	/**
	 * The name of the class that required the library.
	 */
	protected String className;

	/**
	 * The name of the Rlibrary that could not be loaded.
	 */
	protected String rLibrary;

	/**
	 * @param className
	 *            The name of the class that required the library.
	 * @param rLibrary
	 *            The name of the Rlibrary that could not be loaded.
	 * 
	 */
	public RLibraryNotLoadedException(final String className,
			final String rLibrary) {
		super("The R library '" + rLibrary + "' required by class '"
				+ className + "' could not be loaded");
		this.className = className;
		this.rLibrary = rLibrary;
	}

	/**
	 * @return The name of the class that required the library.
	 */
	public String getClassName() {
		return this.className;
	}

	/**
	 * @return The name of the Rlibrary that could not be loaded.
	 */
	public String getRLibrary() {
		return this.rLibrary;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof RLibraryNotLoadedException))
			return false;

		RLibraryNotLoadedException other = (RLibraryNotLoadedException) obj;
		return this.className.equals(other.className)
				&& this.rLibrary.equals(other.rLibrary);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return (this.className + this.rLibrary).hashCode();
	}

}
