.. java:import:: java.io File

.. java:import:: java.util Map

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: utils SimilarityMatrix

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.framework RLibraryNotLoadedException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.utils RNotAvailableException

RelativeDataRProgram
====================

.. java:package:: de.clusteval.program.r
   :noindex:

.. java:type:: public abstract class RelativeDataRProgram extends RProgram

   :author: Christian Wiwie

Constructors
------------
RelativeDataRProgram
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RelativeDataRProgram(Repository repository, long changeDate, File absPath) throws RegisterException
   :outertype: RelativeDataRProgram

   :param repository: the repository this program should be registered at.
   :param changeDate: The change date of this program is used for equality checks.
   :param absPath: The absolute path of this program.
   :throws RegisterException:

RelativeDataRProgram
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RelativeDataRProgram(RelativeDataRProgram rProgram) throws RegisterException
   :outertype: RelativeDataRProgram

   The copy constructor for rprograms.

   :param rProgram: The object to clone.
   :throws RegisterException:

Methods
-------
beforeExec
^^^^^^^^^^

.. java:method:: @Override protected void beforeExec(DataConfig dataConfig, ProgramConfig programConfig, String[] invocationLine, Map<String, String> effectiveParams, Map<String, String> internalParams) throws REngineException, RLibraryNotLoadedException, RNotAvailableException, InterruptedException
   :outertype: RelativeDataRProgram

extractDataSetContent
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected SimilarityMatrix extractDataSetContent(DataConfig dataConfig)
   :outertype: RelativeDataRProgram

