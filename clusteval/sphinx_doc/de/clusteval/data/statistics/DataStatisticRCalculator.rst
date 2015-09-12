.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.goldstandard.format UnknownGoldStandardFormatException

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils RNotAvailableException

DataStatisticRCalculator
========================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public abstract class DataStatisticRCalculator<T extends DataStatistic> extends DataStatisticCalculator<T>

   This class is parent class of all different kind of analyses on a DataConfig. This analyses can be performed unrelated to clustering, since it only requires the dataset (and optionally the goldstandard).

   :author: Christian Wiwie
   :param <T>:

Constructors
------------
DataStatisticRCalculator
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataStatisticRCalculator(Repository repository, long changeDate, File absPath, DataConfig dataConfig) throws RegisterException
   :outertype: DataStatisticRCalculator

   :param repository:
   :param changeDate:
   :param absPath:
   :param dataConfig:
   :throws RegisterException:

DataStatisticRCalculator
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataStatisticRCalculator(DataStatisticRCalculator<T> other) throws RegisterException
   :outertype: DataStatisticRCalculator

   The copy constructor of data statistic calculators.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
calculateResult
^^^^^^^^^^^^^^^

.. java:method:: @Override protected final T calculateResult() throws DataStatisticCalculateException
   :outertype: DataStatisticRCalculator

calculateResultHelper
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract T calculateResultHelper(MyRengine rEngine) throws IncompatibleDataConfigDataStatisticException, UnknownGoldStandardFormatException, UnknownDataSetFormatException, IllegalArgumentException, IOException, InvalidDataSetFormatVersionException, RegisterException, REngineException, REXPMismatchException, InterruptedException
   :outertype: DataStatisticRCalculator

writeOutputTo
^^^^^^^^^^^^^

.. java:method:: @Override public final void writeOutputTo(File absFolderPath) throws REngineException, RNotAvailableException, InterruptedException
   :outertype: DataStatisticRCalculator

writeOutputToHelper
^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract void writeOutputToHelper(File absFolderPath, MyRengine rEngine) throws REngineException, REXPMismatchException, InterruptedException
   :outertype: DataStatisticRCalculator

