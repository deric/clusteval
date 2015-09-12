.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util Iterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils JARFinder

.. java:import:: de.clusteval.utils RecursiveSubDirectoryIterator

DistanceMeasureFinder
=====================

.. java:package:: de.clusteval.data.distance
   :noindex:

.. java:type:: public class DistanceMeasureFinder extends JARFinder<DistanceMeasure>

   :author: Christian Wiwie

Constructors
------------
DistanceMeasureFinder
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DistanceMeasureFinder(Repository repository) throws RegisterException
   :outertype: DistanceMeasureFinder

   :param repository:
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: @Override protected boolean checkFile(File file)
   :outertype: DistanceMeasureFinder

classNamesForJARFile
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String[] classNamesForJARFile(File f)
   :outertype: DistanceMeasureFinder

getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: DistanceMeasureFinder

getURLClassLoader0
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected URLClassLoader getURLClassLoader0(File f, ClassLoader parent) throws MalformedURLException
   :outertype: DistanceMeasureFinder

isJARLoaded
^^^^^^^^^^^

.. java:method:: @Override protected boolean isJARLoaded(File f)
   :outertype: DistanceMeasureFinder

