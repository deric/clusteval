.. java:import:: java.io File

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: de.clusteval.data.dataset.format ConversionInputToStandardConfiguration

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

AbsoluteSpearmanCorrelationRDistanceMeasure
===========================================

.. java:package:: de.clusteval.data.distance
   :noindex:

.. java:type:: public class AbsoluteSpearmanCorrelationRDistanceMeasure extends DistanceMeasureR

   :author: Christian Wiwie

Constructors
------------
AbsoluteSpearmanCorrelationRDistanceMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public AbsoluteSpearmanCorrelationRDistanceMeasure(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: AbsoluteSpearmanCorrelationRDistanceMeasure

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

AbsoluteSpearmanCorrelationRDistanceMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public AbsoluteSpearmanCorrelationRDistanceMeasure(AbsoluteSpearmanCorrelationRDistanceMeasure other) throws RegisterException
   :outertype: AbsoluteSpearmanCorrelationRDistanceMeasure

   The copy constructor for this measure.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getDistanceHelper
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public double getDistanceHelper(double[] point1, double[] point2, MyRengine rEngine) throws REXPMismatchException, REngineException, InterruptedException
   :outertype: AbsoluteSpearmanCorrelationRDistanceMeasure

getDistancesHelper
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public double[][] getDistancesHelper(ConversionInputToStandardConfiguration config, double[][] matrix, MyRengine rEngine, int firstRow, int lastRow) throws REngineException, REXPMismatchException, InterruptedException
   :outertype: AbsoluteSpearmanCorrelationRDistanceMeasure

isSymmetric
^^^^^^^^^^^

.. java:method:: @Override public boolean isSymmetric()
   :outertype: AbsoluteSpearmanCorrelationRDistanceMeasure

supportsMatrix
^^^^^^^^^^^^^^

.. java:method:: @Override public boolean supportsMatrix()
   :outertype: AbsoluteSpearmanCorrelationRDistanceMeasure

