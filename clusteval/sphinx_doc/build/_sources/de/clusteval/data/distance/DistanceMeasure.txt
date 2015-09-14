.. java:import:: java.io File

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: utils SimilarityMatrix

.. java:import:: de.clusteval.data.dataset.format ConversionInputToStandardConfiguration

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.program.r RLibraryInferior

.. java:import:: de.clusteval.utils RNotAvailableException

DistanceMeasure
===============

.. java:package:: de.clusteval.data.distance
   :noindex:

.. java:type:: public abstract class DistanceMeasure extends RepositoryObject implements RLibraryInferior

   A distance measure MyDistanceMeasure can be added to ClustEval by

   1. extending this class with your own class MyDistanceMeasure . You have to provide your own implementations for the following methods, otherwise the framework will not be able to load your distance measure:

     * :java:ref:`DistanceMeasure(Repository, boolean, long, File)` : The constructor for your distance measure. This constructor has to be implemented and public, otherwise the framework will not be able to load your distance measure.
     * :java:ref:`DistanceMeasure(MyDistanceMeasure)` : The copy constructor for your distance measure. This constructor has to be implemented and public, otherwise the framework will not be able to load your distance measure.
     * :java:ref:`getDistance(double[],double[])` : This method is the core of your distance measure. It returns the distance of the two points specified by the absolute coordinates in the two double arrays.
     * :java:ref:`supportsMatrix()` : This method indicates, whether your distance measure can calculate distances of a whole set of point-pairs, i.e. your distance measure implements the method getDistances(double[][]).
     * :java:ref:`getDistances(double[][])` : The absolute coordinates of the points are stored row-wise in the given matrix and distances are calculated between every pair of rows. Position [i][j] of the returned double[][] matrix contains the distance between the i-th and j-th row of the input matrix.

   2. Creating a jar file named MyDistanceMeasure.jar containing the MyDistanceMeasure.class compiled on your machine in the correct folder structure corresponding to the packages:

     * de/clusteval/data/distance/MyDistanceMeasure.class

   3. Putting the MyDistanceMeasure.jar into the distance measure folder of the repository:

     * <REPOSITORY ROOT>/supp/distanceMeasures

   The backend server will recognize and try to load the new distance measure au- tomatically the

   :author: Christian Wiwie

Constructors
------------
DistanceMeasure
^^^^^^^^^^^^^^^

.. java:constructor:: public DistanceMeasure(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: DistanceMeasure

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

DistanceMeasure
^^^^^^^^^^^^^^^

.. java:constructor:: public DistanceMeasure(DistanceMeasure other) throws RegisterException
   :outertype: DistanceMeasure

   The copy constructor of this distance measures.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public final DistanceMeasure clone()
   :outertype: DistanceMeasure

equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: DistanceMeasure

getDistance
^^^^^^^^^^^

.. java:method:: public abstract double getDistance(double[] point1, double[] point2) throws RNotAvailableException, InterruptedException
   :outertype: DistanceMeasure

   :param point1: A point with double valued coordinates.
   :param point2: A point with double valued coordinates.
   :throws InterruptedException:
   :throws RNotAvailableException:
   :return: Distance between point1 and point2.

getDistances
^^^^^^^^^^^^

.. java:method:: public abstract SimilarityMatrix getDistances(ConversionInputToStandardConfiguration config, double[][] matrix) throws RNotAvailableException, InterruptedException
   :outertype: DistanceMeasure

   This method calculates all pairwise distances between the rows of a matrix.

   :param matrix: A matrix containing samples in each row and features in the columns.
   :throws InterruptedException:
   :throws RNotAvailableException:
   :return: Matrix containing all pairwise distances of rows of the matrix

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: DistanceMeasure

isSymmetric
^^^^^^^^^^^

.. java:method:: public abstract boolean isSymmetric()
   :outertype: DistanceMeasure

   This method indicates whether the similarity s(x,y)==s(y,x).

   :return: True, if this distance measure is symmetric, false otherwise.

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static DistanceMeasure parseFromString(Repository repository, String distanceMeasure) throws UnknownDistanceMeasureException
   :outertype: DistanceMeasure

   Parses the from string.

   :param repository: the repository
   :param distanceMeasure: the distance measure
   :throws UnknownDistanceMeasureException:
   :return: the distance measure

supportsMatrix
^^^^^^^^^^^^^^

.. java:method:: public abstract boolean supportsMatrix()
   :outertype: DistanceMeasure

   This method indicates, whether a distance measure supports the bulk calculation of all pairwise distances of rows of a matrix with rows of a second matrix. Overwrite it in your subclass and return the appropriate boolean value. If your subclass supports matrices you also have to overwrite \ :java:ref:`getDistances(double[][])`\  with a correct implementation.

   :return: True, if this distance measure supports bulk distance calculation of matrices.

