.. java:import:: java.io File

.. java:import:: java.util Map

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: utils SimilarityMatrix

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset AbsoluteDataSet

.. java:import:: de.clusteval.data.dataset DataMatrix

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.framework RLibraryNotLoadedException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.utils RNotAvailableException

AbsoluteAndRelativeDataRProgram
===============================

.. java:package:: de.clusteval.program.r
   :noindex:

.. java:type:: public abstract class AbsoluteAndRelativeDataRProgram extends RProgram

   This class represents R programs, which are compatible to relative and absolute datasets.

   :author: Christian Wiwie

Constructors
------------
AbsoluteAndRelativeDataRProgram
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public AbsoluteAndRelativeDataRProgram(Repository repository, long changeDate, File absPath) throws RegisterException
   :outertype: AbsoluteAndRelativeDataRProgram

   :param repository:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

AbsoluteAndRelativeDataRProgram
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public AbsoluteAndRelativeDataRProgram(AbsoluteAndRelativeDataRProgram other) throws RegisterException
   :outertype: AbsoluteAndRelativeDataRProgram

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
beforeExec
^^^^^^^^^^

.. java:method:: @Override protected void beforeExec(DataConfig dataConfig, ProgramConfig programConfig, String[] invocationLine, Map<String, String> effectiveParams, Map<String, String> internalParams) throws RLibraryNotLoadedException, REngineException, RNotAvailableException, InterruptedException
   :outertype: AbsoluteAndRelativeDataRProgram

convertDistancesToAppropriateDatastructure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void convertDistancesToAppropriateDatastructure() throws RserveException, InterruptedException
   :outertype: AbsoluteAndRelativeDataRProgram

extractDataSetContent
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected Object extractDataSetContent(DataConfig dataConfig)
   :outertype: AbsoluteAndRelativeDataRProgram

