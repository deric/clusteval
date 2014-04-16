/**
 * 
 */
package de.clusteval.run.runnable;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.clusteval.framework.RLibraryNotLoadedException;
import de.clusteval.run.result.NoRunResultFormatParserException;
import de.clusteval.utils.RNotAvailableException;

/**
 * @author Christian Wiwie
 * 
 */
public abstract class IterationRunnable implements Runnable {

	protected Logger log;
	protected IterationWrapper iterationWrapper;
	protected NoRunResultFormatParserException noRunResultException;
	protected IOException ioException;
	protected RLibraryNotLoadedException rLibraryException;
	protected RNotAvailableException rNotAvailableException;
	protected InterruptedException interruptedException;

	public IterationRunnable(final IterationWrapper iterationWrapper) {
		super();
		this.iterationWrapper = iterationWrapper;
		this.log = LoggerFactory.getLogger(getClass());
	}

	/**
	 * @return the noRunResultException
	 */
	public NoRunResultFormatParserException getNoRunResultException() {
		return noRunResultException;
	}

	/**
	 * @return the rNotAvailableException
	 */
	public RNotAvailableException getrNotAvailableException() {
		return rNotAvailableException;
	}

	/**
	 * @return the ioException
	 */
	public IOException getIoException() {
		return ioException;
	}

	/**
	 * @return the rLibraryException
	 */
	public RLibraryNotLoadedException getrLibraryException() {
		return rLibraryException;
	}

	public InterruptedException getInterruptedException() {
		return interruptedException;
	}
}
