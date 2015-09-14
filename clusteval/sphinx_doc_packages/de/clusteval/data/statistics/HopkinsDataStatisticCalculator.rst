.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: org.rosuda REngine.REXP

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: utils ArraysExt

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset AbsoluteDataSet

.. java:import:: de.clusteval.data.dataset DataMatrix

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.goldstandard.format UnknownGoldStandardFormatException

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

HopkinsDataStatisticCalculator
==============================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public class HopkinsDataStatisticCalculator extends DataStatisticRCalculator<HopkinsDataStatistic>

   :author: Christian Wiwie

Constructors
------------
HopkinsDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public HopkinsDataStatisticCalculator(Repository repository, long changeDate, File absPath, DataConfig dataConfig) throws RegisterException
   :outertype: HopkinsDataStatisticCalculator

   :param repository:
   :param changeDate:
   :param absPath:
   :param dataConfig:
   :throws RegisterException:

HopkinsDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public HopkinsDataStatisticCalculator(HopkinsDataStatisticCalculator other) throws RegisterException
   :outertype: HopkinsDataStatisticCalculator

   The copy constructor for this statistic calculator.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
calculateResultHelper
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected HopkinsDataStatistic calculateResultHelper(MyRengine rEngine) throws IncompatibleDataConfigDataStatisticException, UnknownGoldStandardFormatException, UnknownDataSetFormatException, IllegalArgumentException, IOException, InvalidDataSetFormatVersionException, RegisterException, REngineException, REXPMismatchException, InterruptedException
   :outertype: HopkinsDataStatisticCalculator

writeOutputToHelper
^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected void writeOutputToHelper(File absFolderPath, MyRengine rEngine)
   :outertype: HopkinsDataStatisticCalculator

