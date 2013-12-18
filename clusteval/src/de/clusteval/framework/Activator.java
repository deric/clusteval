/**
 * 
 */
package de.clusteval.framework;

/**
 * @author Christian Wiwie
 *
 */
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import de.clusteval.utils.ILauncherService;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		String[] args = context.getService(context
				.getServiceReference(String[].class));
		ClustevalBackendServer.main(args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("stopping clusteval");
	}

}
