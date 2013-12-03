/**
 * 
 */
package de.clusteval.framework;

import java.util.HashSet;
import java.util.Set;

import org.rosuda.REngine.Rserve.RserveException;

/**
 * @author Christian Wiwie
 * 
 */
public class REnginePool {

	protected Set<MyRengine> availableREngines;
	protected Set<MyRengine> lockedREngines;

	/**
	 * @param poolSize
	 * @throws RserveException
	 * 
	 */
	public REnginePool(final int poolSize) throws RserveException {
		super();
		this.availableREngines = new HashSet<MyRengine>();
		this.lockedREngines = new HashSet<MyRengine>();
		for (int i = 0; i < poolSize; i++)
			this.availableREngines.add(new MyRengine(""));
	}

	public synchronized MyRengine retrieveAndLock() {
		// wait until another thread releases an REngine
		if (this.availableREngines.isEmpty()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				return null;
			}
		}
		MyRengine result = this.availableREngines.iterator().next();
		this.availableREngines.remove(result);
		this.lockedREngines.add(result);
		return result;
	}

	public synchronized void release(final MyRengine rEngine) {
		// release the rengine
		this.lockedREngines.remove(rEngine);
		this.availableREngines.add(rEngine);
		// notify one thread, which will either wake up a thread release another
		// rEngine and then eventually wake up a retrieving thread, or directly
		// wake up a retrieving thread.
		this.notify();
	}
	
	public synchronized void close() {
		for (MyRengine rEngine : this.availableREngines)
			rEngine.close();
		this.availableREngines.clear();
		for (MyRengine rEngine : this.lockedREngines)
			rEngine.close();
		this.lockedREngines.clear();
	}
}
