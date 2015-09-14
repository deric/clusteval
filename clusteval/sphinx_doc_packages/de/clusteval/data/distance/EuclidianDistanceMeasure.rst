.. java:import:: java.io File

.. java:import:: java.security InvalidParameterException

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: de.clusteval.data.dataset.format ConversionInputToStandardConfiguration

.. java:import:: de.clusteval.framework RLibraryRequirement

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

EuclidianDistanceMeasure
========================

.. java:package:: de.clusteval.data.distance
   :noindex:

.. java:type:: @RLibraryRequirement public class EuclidianDistanceMeasure extends DistanceMeasureR

   :author: Christian Wiwie

Constructors
------------
EuclidianDistanceMeasure
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public EuclidianDistanceMeasure(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: EuclidianDistanceMeasure

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

EuclidianDistanceMeasure
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public EuclidianDistanceMeasure(EuclidianDistanceMeasure other) throws RegisterException
   :outertype: EuclidianDistanceMeasure

   The copy constructor for this measure.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getDistanceHelper
^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected double getDistanceHelper(double[] point1, double[] point2, MyRengine rEngine) throws REngineException, REXPMismatchException
   :outertype: EuclidianDistanceMeasure

getDistancesHelper
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected double[][] getDistancesHelper(ConversionInputToStandardConfiguration config, double[][] matrix, MyRengine rEngine, int firstRow, int lastRow) throws REngineException, REXPMismatchException, InterruptedException
   :outertype: EuclidianDistanceMeasure

isSymmetric
^^^^^^^^^^^

.. java:method:: @Override public boolean isSymmetric()
   :outertype: EuclidianDistanceMeasure

supportsMatrix
^^^^^^^^^^^^^^

.. java:method:: @Override public boolean supportsMatrix()
   :outertype: EuclidianDistanceMeasure

