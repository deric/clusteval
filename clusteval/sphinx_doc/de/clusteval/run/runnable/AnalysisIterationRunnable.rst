.. java:import:: java.io BufferedWriter

.. java:import:: java.io File

.. java:import:: java.io FileWriter

.. java:import:: java.io IOException

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.statistics StatisticCalculateException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.run.statistics RunStatistic

.. java:import:: de.clusteval.utils FormatConversionException

.. java:import:: de.clusteval.utils RNotAvailableException

.. java:import:: de.clusteval.utils Statistic

.. java:import:: de.clusteval.utils StatisticCalculator

.. java:import:: file FileUtils

AnalysisIterationRunnable
=========================

.. java:package:: de.clusteval.run.runnable
   :noindex:

.. java:type:: public abstract class AnalysisIterationRunnable<S extends Statistic, IW extends AnalysisIterationWrapper<S>> extends IterationRunnable<IW>

   :author: Christian Wiwie

Fields
------
calcFile
^^^^^^^^

.. java:field:: protected File calcFile
   :outertype: AnalysisIterationRunnable

   A temporary variable needed during execution of this runnable.

result
^^^^^^

.. java:field:: protected S result
   :outertype: AnalysisIterationRunnable

Constructors
------------
AnalysisIterationRunnable
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public AnalysisIterationRunnable(IW iterationWrapper)
   :outertype: AnalysisIterationRunnable

   :param iterationWrapper:

Methods
-------
beforeStatisticCalculate
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract void beforeStatisticCalculate()
   :outertype: AnalysisIterationRunnable

   A helper method of \ :java:ref:`doRun()`\ , which can be overridden to do any kind of precalculations and operations needed before a statistic is assessed.

doRun
^^^^^

.. java:method:: @Override public void doRun() throws InterruptedException
   :outertype: AnalysisIterationRunnable

getOutputPath
^^^^^^^^^^^^^

.. java:method:: protected abstract String getOutputPath()
   :outertype: AnalysisIterationRunnable

   A helper method for \ :java:ref:`doRun()`\ . It returns the absolute path to the result file for the current statistic to be calculated.

   This method is abstract since it has to provide different behaviour for different subtypes of this class.

   :return: Abstract path to the output file.

getStatistic
^^^^^^^^^^^^

.. java:method:: public S getStatistic()
   :outertype: AnalysisIterationRunnable

getStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract StatisticCalculator<S> getStatisticCalculator() throws FormatConversionException, IOException, InvalidDataSetFormatVersionException, RegisterException, SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, UnknownDataSetFormatException
   :outertype: AnalysisIterationRunnable

   A helper method for \ :java:ref:`doRun()`\  which returns the statistic calculator for the current statistic to be calculated.

   This method is abstract since it has to provide different behaviour for different subtypes of this class.

   :throws IllegalAccessException:
   :throws IllegalArgumentException:
   :throws NoSuchMethodException:
   :throws InstantiationException:
   :throws InvalidDataSetFormatVersionException:
   :throws UnknownDataSetFormatException:
   :throws SecurityException:
   :throws InvocationTargetException:
   :throws IOException:
   :throws FormatConversionException:
   :throws RegisterException:

setStatistic
^^^^^^^^^^^^

.. java:method:: public void setStatistic(S statistic)
   :outertype: AnalysisIterationRunnable

