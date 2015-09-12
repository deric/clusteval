.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util Iterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils JARFinder

.. java:import:: de.clusteval.utils RecursiveSubDirectoryIterator

ClusteringQualityMeasureFinder
==============================

.. java:package:: de.clusteval.cluster.quality
   :noindex:

.. java:type:: public class ClusteringQualityMeasureFinder extends JARFinder<ClusteringQualityMeasure>

   :author: Christian Wiwie

Constructors
------------
ClusteringQualityMeasureFinder
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringQualityMeasureFinder(Repository repository) throws RegisterException
   :outertype: ClusteringQualityMeasureFinder

   Instantiates a new clustering quality measure finder.

   :param repository: The repository to register the new data configurations at.
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: @Override protected boolean checkFile(File file)
   :outertype: ClusteringQualityMeasureFinder

classNamesForJARFile
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String[] classNamesForJARFile(File f)
   :outertype: ClusteringQualityMeasureFinder

getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: ClusteringQualityMeasureFinder

getURLClassLoader0
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected URLClassLoader getURLClassLoader0(File f, ClassLoader parent) throws MalformedURLException
   :outertype: ClusteringQualityMeasureFinder

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: ClusteringQualityMeasureFinder

isJARLoaded
^^^^^^^^^^^

.. java:method:: @Override protected boolean isJARLoaded(File f)
   :outertype: ClusteringQualityMeasureFinder

