.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util Iterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils FormatVersion

.. java:import:: de.clusteval.utils JARFinder

.. java:import:: de.clusteval.utils RecursiveSubDirectoryIterator

DataSetFormatFinder
===================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: public class DataSetFormatFinder extends JARFinder<DataSetFormat>

   :author: Christian Wiwie

Constructors
------------
DataSetFormatFinder
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetFormatFinder(Repository repository) throws RegisterException
   :outertype: DataSetFormatFinder

   Instantiates a new data set format finder.

   :param repository: the repository
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: @Override protected boolean checkFile(File file)
   :outertype: DataSetFormatFinder

classNamesForJARFile
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String[] classNamesForJARFile(File f)
   :outertype: DataSetFormatFinder

getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: DataSetFormatFinder

getURLClassLoader0
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected URLClassLoader getURLClassLoader0(File f, ClassLoader parent) throws MalformedURLException
   :outertype: DataSetFormatFinder

isJARLoaded
^^^^^^^^^^^

.. java:method:: @Override protected boolean isJARLoaded(File f)
   :outertype: DataSetFormatFinder

