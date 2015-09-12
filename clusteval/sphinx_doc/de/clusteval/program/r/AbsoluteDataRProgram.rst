.. java:import:: java.io File

.. java:import:: java.util Map

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset AbsoluteDataSet

.. java:import:: de.clusteval.data.dataset DataMatrix

.. java:import:: de.clusteval.framework RLibraryNotLoadedException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.utils RNotAvailableException

AbsoluteDataRProgram
====================

.. java:package:: de.clusteval.program.r
   :noindex:

.. java:type:: public abstract class AbsoluteDataRProgram extends RProgram

   :author: Christian Wiwie

Constructors
------------
AbsoluteDataRProgram
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public AbsoluteDataRProgram(Repository repository, long changeDate, File absPath) throws RegisterException
   :outertype: AbsoluteDataRProgram

   :param repository: the repository this program should be registered at.
   :param changeDate: The change date of this program is used for equality checks.
   :param absPath: The absolute path of this program.
   :throws RegisterException:

AbsoluteDataRProgram
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public AbsoluteDataRProgram(AbsoluteDataRProgram rProgram) throws RegisterException
   :outertype: AbsoluteDataRProgram

   The copy constructor for rprograms.

   :param rProgram: The object to clone.
   :throws RegisterException:

Methods
-------
beforeExec
^^^^^^^^^^

.. java:method:: @Override protected void beforeExec(DataConfig dataConfig, ProgramConfig programConfig, String[] invocationLine, Map<String, String> effectiveParams, Map<String, String> internalParams) throws REngineException, RLibraryNotLoadedException, RNotAvailableException, InterruptedException
   :outertype: AbsoluteDataRProgram

extractDataSetContent
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected DataMatrix extractDataSetContent(DataConfig dataConfig)
   :outertype: AbsoluteDataRProgram

