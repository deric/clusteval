.. java:import:: java.io File

.. java:import:: java.util List

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryEvent

.. java:import:: de.clusteval.framework.repository RepositoryRemoveEvent

.. java:import:: de.clusteval.utils Statistic

AnalysisRun
===========

.. java:package:: de.clusteval.run
   :noindex:

.. java:type:: public abstract class AnalysisRun<S extends Statistic> extends Run

   An abstract class for all run types, that involve conduction of any analyses. This can involve analyses of data and/or clustering results.

   An analysis run has a list of statistics in \ :java:ref:`statistics`\ , that should be assessed for the objects of analysis.

   :author: Christian Wiwie
   :param <S>:

Fields
------
statistics
^^^^^^^^^^

.. java:field:: protected List<S> statistics
   :outertype: AnalysisRun

   The statistics that should be assessed for the objects of analysis.

Constructors
------------
AnalysisRun
^^^^^^^^^^^

.. java:constructor:: public AnalysisRun(Repository repository, Context context, long changeDate, File absPath, List<S> statistics) throws RegisterException
   :outertype: AnalysisRun

   :param repository: the repository
   :param context:
   :param changeDate: The date this run was performed.
   :param absPath: The absolute path to the file on the filesystem that corresponds to this run.
   :param statistics: The statistics that should be assessed for the objects of analysis.
   :throws RegisterException:

AnalysisRun
^^^^^^^^^^^

.. java:constructor:: public AnalysisRun(AnalysisRun<S> other) throws RegisterException
   :outertype: AnalysisRun

   Copy constructor for analysis runs.

   :param other: The analysis run to be cloned.
   :throws RegisterException:

Methods
-------
cloneStatistics
^^^^^^^^^^^^^^^

.. java:method:: protected abstract List<S> cloneStatistics(List<S> statistics)
   :outertype: AnalysisRun

   :param statistics:

getStatistics
^^^^^^^^^^^^^

.. java:method:: public List<S> getStatistics()
   :outertype: AnalysisRun

   :return: A list with all statistics that belong to this run.

   **See also:** :java:ref:`.statistics`

notify
^^^^^^

.. java:method:: @Override public void notify(RepositoryEvent e) throws RegisterException
   :outertype: AnalysisRun

