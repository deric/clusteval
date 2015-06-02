/**
 * 
 */
package de.clusteval.program.r;

import java.util.Map;

import de.clusteval.data.DataConfig;
import de.clusteval.program.ProgramConfig;

/**
 * @author Christian Wiwie
 *
 */

public class RProgramThread extends Thread {

	protected Exception ex;
	protected RProgram rProgram;
	protected DataConfig dataConfig;
	protected ProgramConfig programConfig;
	protected String[] invocationLine;
	protected Map<String, String> effectiveParams;
	protected Map<String, String> internalParams;

	/**
	 * @param rProgram
	 * @param dataConfig
	 * @param programConfig
	 * @param invocationLine
	 * @param effectiveParams
	 * @param internalParams
	 */
	public RProgramThread(final RProgram rProgram, final DataConfig dataConfig,
			final ProgramConfig programConfig, final String[] invocationLine,
			final Map<String, String> effectiveParams,
			final Map<String, String> internalParams) {
		super();

		this.rProgram = rProgram;
		this.dataConfig = dataConfig;
		this.programConfig = programConfig;
		this.invocationLine = invocationLine;
		this.effectiveParams = effectiveParams;
		this.internalParams = internalParams;

	}

	@Override
	public void run() {
		try {
			this.rProgram.beforeExec(dataConfig, programConfig, invocationLine,
					effectiveParams, internalParams);
			this.rProgram.doExec(dataConfig, programConfig, invocationLine,
					effectiveParams, internalParams);
			this.rProgram.afterExec(dataConfig, programConfig, invocationLine,
					effectiveParams, internalParams);
		} catch (Exception e) {
			ex = e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#interrupt()
	 */
	@Override
	public void interrupt() {
		super.interrupt();
		this.rProgram.rEngine.interrupt();
		this.dataConfig.getRepository().clearRengineForCurrentThread();
	}

	public Exception getException() {
		return this.ex;
	}
}