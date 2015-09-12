.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util HashMap

.. java:import:: java.util Iterator

.. java:import:: java.util Map

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils JARFinder

.. java:import:: de.clusteval.utils RecursiveSubDirectoryIterator

DataSetTypeFinder
=================

.. java:package:: de.clusteval.data.dataset.type
   :noindex:

.. java:type:: public class DataSetTypeFinder extends JARFinder<DataSetType>

   The Class DataSetTypeFinder.

   :author: Christian Wiwie

Fields
------
classLoaders
^^^^^^^^^^^^

.. java:field:: protected static Map<URL, URLClassLoader> classLoaders
   :outertype: DataSetTypeFinder

Constructors
------------
DataSetTypeFinder
^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetTypeFinder(Repository repository) throws RegisterException
   :outertype: DataSetTypeFinder

   Instantiates a new data set format finder.

   :param repository: the repository
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: @Override protected boolean checkFile(File file)
   :outertype: DataSetTypeFinder

classNamesForJARFile
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String[] classNamesForJARFile(File f)
   :outertype: DataSetTypeFinder

getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: DataSetTypeFinder

getURLClassLoader0
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected URLClassLoader getURLClassLoader0(File f, ClassLoader parent) throws MalformedURLException
   :outertype: DataSetTypeFinder

isJARLoaded
^^^^^^^^^^^

.. java:method:: @Override protected boolean isJARLoaded(File f)
   :outertype: DataSetTypeFinder

