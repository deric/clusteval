.. java:import:: java.io File

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.run Run

ExecutionRunResult
==================

.. java:package:: de.clusteval.run.result
   :noindex:

.. java:type:: public abstract class ExecutionRunResult extends RunResult

   :author: Christian Wiwie

Fields
------
dataConfig
^^^^^^^^^^

.. java:field:: protected DataConfig dataConfig
   :outertype: ExecutionRunResult

   The data config.

programConfig
^^^^^^^^^^^^^

.. java:field:: protected ProgramConfig programConfig
   :outertype: ExecutionRunResult

   The program config.

Constructors
------------
ExecutionRunResult
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ExecutionRunResult(Repository repository, long changeDate, File absPath, String runIdentString, Run run, DataConfig dataConfig, ProgramConfig programConfig) throws RegisterException
   :outertype: ExecutionRunResult

   :param repository:
   :param changeDate:
   :param absPath:
   :param runIdentString:
   :param run:
   :param dataConfig:
   :param programConfig:
   :throws RegisterException:

ExecutionRunResult
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ExecutionRunResult(ExecutionRunResult other) throws RegisterException
   :outertype: ExecutionRunResult

   The copy constructor of run results.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public abstract ExecutionRunResult clone()
   :outertype: ExecutionRunResult

getDataConfig
^^^^^^^^^^^^^

.. java:method:: public DataConfig getDataConfig()
   :outertype: ExecutionRunResult

   :return: The data configuration wrapping the dataset on which this runresult was produced.

getProgramConfig
^^^^^^^^^^^^^^^^

.. java:method:: public ProgramConfig getProgramConfig()
   :outertype: ExecutionRunResult

   :return: The program configuration wrapping the program that produced this runresult.

