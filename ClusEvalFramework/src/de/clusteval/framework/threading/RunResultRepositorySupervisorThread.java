/**
 * 
 */
package de.clusteval.framework.threading;

import java.util.Map;

import de.clusteval.data.RunResultDataConfigFinderThread;
import de.clusteval.data.dataset.RunResultDataSetConfigFinderThread;
import de.clusteval.data.dataset.RunResultDataSetFinderThread;
import de.clusteval.data.goldstandard.GoldStandardConfigFinderThread;
import de.clusteval.framework.repository.Repository;
import de.clusteval.framework.repository.RunResultRepository;
import de.clusteval.program.ProgramConfigFinderThread;
import de.clusteval.run.RunResultRunFinderThread;

/**
 * A type of supervisor thread that supervises a {@link RunResultRepository}. In
 * contrast to {@link RepositorySupervisorThread}, this class only checks
 * certain things and has therefore less threads to supervise.
 * 
 * @author Christian Wiwie
 * 
 */
public class RunResultRepositorySupervisorThread extends SupervisorThread {

	/**
	 * @param repository
	 *            The repository this thread belongs to.
	 * @param threadSleepTimes
	 *            The sleep times of the created threads.
	 */
	@SuppressWarnings({"unchecked"})
	public RunResultRepositorySupervisorThread(Repository repository,
			Map<String, Long> threadSleepTimes) {
		super(repository,
				createList(
						// datasets in sub_directories
						RunResultDataSetFinderThread.class,
						RunResultDataSetConfigFinderThread.class,
						GoldStandardConfigFinderThread.class,
						RunResultDataConfigFinderThread.class,
						ProgramConfigFinderThread.class,
						RunResultRunFinderThread.class), threadSleepTimes, true);
		this.setName(this.getName().replace("Supervisor",
				"RunResultRepositorySupervisor"));
		this.start();
	}
}
