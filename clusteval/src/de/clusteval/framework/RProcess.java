/**
 * 
 */
package de.clusteval.framework;

import java.io.InputStream;
import java.io.OutputStream;

import de.clusteval.framework.repository.MyRengine;

/**
 * @author Christian Wiwie
 * 
 */
public class RProcess extends Process {

	protected MyRengine rEngine;

	public RProcess(MyRengine rEngine) {
		super();
		this.rEngine = rEngine;
	}

	public MyRengine getRengine() {
		return this.rEngine;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Process#getOutputStream()
	 */
	@Override
	public OutputStream getOutputStream() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Process#getInputStream()
	 */
	@Override
	public InputStream getInputStream() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Process#getErrorStream()
	 */
	@Override
	public InputStream getErrorStream() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Process#waitFor()
	 */
	@Override
	public int waitFor() throws InterruptedException {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Process#exitValue()
	 */
	@Override
	public int exitValue() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Process#destroy()
	 */
	@Override
	public void destroy() {
	}

}
