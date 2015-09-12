.. java:import:: java.io File

.. java:import:: java.security InvalidParameterException

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: de.clusteval.data.dataset.format ConversionInputToStandardConfiguration

.. java:import:: de.clusteval.framework RLibraryRequirement

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

HoeffdingDRDistanceMeasure
==========================

.. java:package:: de.clusteval.data.distance
   :noindex:

.. java:type:: @RLibraryRequirement public class HoeffdingDRDistanceMeasure extends DistanceMeasureR

   :author: Christian Wiwie

Constructors
------------
HoeffdingDRDistanceMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public HoeffdingDRDistanceMeasure(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: HoeffdingDRDistanceMeasure

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

HoeffdingDRDistanceMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public HoeffdingDRDistanceMeasure(HoeffdingDRDistanceMeasure other) throws RegisterException
   :outertype: HoeffdingDRDistanceMeasure

   The copy constructor for this measure.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getDistanceHelper
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public double getDistanceHelper(double[] point1, double[] point2, MyRengine rEngine) throws REngineException, REXPMismatchException, InterruptedException
   :outertype: HoeffdingDRDistanceMeasure

getDistancesHelper
^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public double[][] getDistancesHelper(ConversionInputToStandardConfiguration config, double[][] matrix, MyRengine rEngine, int firstRow, int lastRow) throws InvalidParameterException
   :outertype: HoeffdingDRDistanceMeasure

isSymmetric
^^^^^^^^^^^

.. java:method:: @Override public boolean isSymmetric()
   :outertype: HoeffdingDRDistanceMeasure

supportsMatrix
^^^^^^^^^^^^^^

.. java:method:: @Override public boolean supportsMatrix()
   :outertype: HoeffdingDRDistanceMeasure

