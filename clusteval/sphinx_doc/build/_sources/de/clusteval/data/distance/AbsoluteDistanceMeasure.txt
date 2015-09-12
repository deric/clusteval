.. java:import:: java.io File

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: utils ArraysExt

.. java:import:: de.clusteval.data.dataset.format ConversionInputToStandardConfiguration

.. java:import:: de.clusteval.framework RLibraryRequirement

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

AbsoluteDistanceMeasure
=======================

.. java:package:: de.clusteval.data.distance
   :noindex:

.. java:type:: @RLibraryRequirement public class AbsoluteDistanceMeasure extends DistanceMeasureR

   :author: Christian Wiwie

Constructors
------------
AbsoluteDistanceMeasure
^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public AbsoluteDistanceMeasure(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: AbsoluteDistanceMeasure

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

AbsoluteDistanceMeasure
^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public AbsoluteDistanceMeasure(AbsoluteDistanceMeasure other) throws RegisterException
   :outertype: AbsoluteDistanceMeasure

   The copy constructor for this measure.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getDistanceHelper
^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected double getDistanceHelper(double[] point1, double[] point2, MyRengine rEngine) throws REngineException, REXPMismatchException
   :outertype: AbsoluteDistanceMeasure

getDistancesHelper
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected double[][] getDistancesHelper(ConversionInputToStandardConfiguration config, double[][] matrix, MyRengine rEngine, int firstRow, int lastRow) throws REngineException, REXPMismatchException, InterruptedException
   :outertype: AbsoluteDistanceMeasure

isSymmetric
^^^^^^^^^^^

.. java:method:: @Override public boolean isSymmetric()
   :outertype: AbsoluteDistanceMeasure

supportsMatrix
^^^^^^^^^^^^^^

.. java:method:: @Override public boolean supportsMatrix()
   :outertype: AbsoluteDistanceMeasure

