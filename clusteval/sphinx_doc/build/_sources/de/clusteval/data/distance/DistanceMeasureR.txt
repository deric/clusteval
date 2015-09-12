.. java:import:: java.io File

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: utils SimilarityMatrix

.. java:import:: de.clusteval.data.dataset.format ConversionInputToStandardConfiguration

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils RNotAvailableException

DistanceMeasureR
================

.. java:package:: de.clusteval.data.distance
   :noindex:

.. java:type:: public abstract class DistanceMeasureR extends DistanceMeasure

   This type of distance measure uses the R framework.

   :author: Christian Wiwie

Constructors
------------
DistanceMeasureR
^^^^^^^^^^^^^^^^

.. java:constructor:: public DistanceMeasureR(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: DistanceMeasureR

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

DistanceMeasureR
^^^^^^^^^^^^^^^^

.. java:constructor:: public DistanceMeasureR(DistanceMeasureR other) throws RegisterException
   :outertype: DistanceMeasureR

   The copy constructor of this R distance measures.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getDistance
^^^^^^^^^^^

.. java:method:: @Override public final double getDistance(double[] point1, double[] point2) throws RNotAvailableException, InterruptedException
   :outertype: DistanceMeasureR

getDistanceHelper
^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract double getDistanceHelper(double[] point1, double[] point2, MyRengine rEngine) throws REngineException, REXPMismatchException, InterruptedException
   :outertype: DistanceMeasureR

getDistances
^^^^^^^^^^^^

.. java:method:: @Override public final SimilarityMatrix getDistances(ConversionInputToStandardConfiguration config, double[][] matrix) throws RNotAvailableException, InterruptedException
   :outertype: DistanceMeasureR

getDistancesHelper
^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract double[][] getDistancesHelper(ConversionInputToStandardConfiguration config, double[][] matrix, MyRengine rEngine, int firstRow, int lastRow) throws REngineException, REXPMismatchException, InterruptedException
   :outertype: DistanceMeasureR

