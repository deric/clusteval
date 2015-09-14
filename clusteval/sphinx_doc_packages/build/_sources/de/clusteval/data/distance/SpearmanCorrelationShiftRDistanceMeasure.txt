.. java:import:: java.io File

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: de.clusteval.data.dataset.format ConversionInputToStandardConfiguration

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

SpearmanCorrelationShiftRDistanceMeasure
========================================

.. java:package:: de.clusteval.data.distance
   :noindex:

.. java:type:: public class SpearmanCorrelationShiftRDistanceMeasure extends DistanceMeasureR

   :author: Christian Wiwie

Constructors
------------
SpearmanCorrelationShiftRDistanceMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SpearmanCorrelationShiftRDistanceMeasure(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: SpearmanCorrelationShiftRDistanceMeasure

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

SpearmanCorrelationShiftRDistanceMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SpearmanCorrelationShiftRDistanceMeasure(SpearmanCorrelationShiftRDistanceMeasure other) throws RegisterException
   :outertype: SpearmanCorrelationShiftRDistanceMeasure

   The copy constructor for this measure.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getDistanceHelper
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public double getDistanceHelper(double[] point1, double[] point2, MyRengine rEngine) throws REXPMismatchException, REngineException, InterruptedException
   :outertype: SpearmanCorrelationShiftRDistanceMeasure

getDistancesHelper
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public double[][] getDistancesHelper(ConversionInputToStandardConfiguration config, double[][] matrix, MyRengine rEngine, int firstRow, int lastRow) throws REngineException, REXPMismatchException, InterruptedException
   :outertype: SpearmanCorrelationShiftRDistanceMeasure

isSymmetric
^^^^^^^^^^^

.. java:method:: @Override public boolean isSymmetric()
   :outertype: SpearmanCorrelationShiftRDistanceMeasure

supportsMatrix
^^^^^^^^^^^^^^

.. java:method:: @Override public boolean supportsMatrix()
   :outertype: SpearmanCorrelationShiftRDistanceMeasure

