.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.context ContextFinderThread

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.data.dataset.format DataSetFormatFinderThread

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.threading SupervisorThread

.. java:import:: de.clusteval.program.r RProgram

.. java:import:: de.clusteval.program.r RProgramFinderThread

.. java:import:: de.clusteval.utils Finder

.. java:import:: de.clusteval.utils FinderThread

ProgramConfigFinderThread
=========================

.. java:package:: de.clusteval.program
   :noindex:

.. java:type:: public class ProgramConfigFinderThread extends FinderThread<ProgramConfig>

   :author: Christian Wiwie

Constructors
------------
ProgramConfigFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ProgramConfigFinderThread(SupervisorThread supervisorThread, Repository repository, boolean checkOnce)
   :outertype: ProgramConfigFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new program configurations.
   :param checkOnce: If true, this thread only checks once for new program configurations.

ProgramConfigFinderThread
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ProgramConfigFinderThread(SupervisorThread supervisorThread, Repository repository, long sleepTime, boolean checkOnce)
   :outertype: ProgramConfigFinderThread

   :param supervisorThread:
   :param repository: The repository to check for new program configurations.
   :param sleepTime: The time between two checks.
   :param checkOnce: If true, this thread only checks once for new program configurations.

Methods
-------
beforeFind
^^^^^^^^^^

.. java:method:: @Override protected void beforeFind()
   :outertype: ProgramConfigFinderThread

getFinder
^^^^^^^^^

.. java:method:: @Override protected Finder<ProgramConfig> getFinder() throws RegisterException
   :outertype: ProgramConfigFinderThread

