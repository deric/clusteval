.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util Iterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils JARFinder

.. java:import:: de.clusteval.utils RecursiveSubDirectoryIterator

DataPreprocessorFinder
======================

.. java:package:: de.clusteval.data.preprocessing
   :noindex:

.. java:type:: public class DataPreprocessorFinder extends JARFinder<DataPreprocessor>

   :author: Christian Wiwie

Constructors
------------
DataPreprocessorFinder
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataPreprocessorFinder(Repository repository) throws RegisterException
   :outertype: DataPreprocessorFinder

   Instantiates a new data set generator finder.

   :param repository: the repository
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: @Override protected boolean checkFile(File file)
   :outertype: DataPreprocessorFinder

classNamesForJARFile
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String[] classNamesForJARFile(File f)
   :outertype: DataPreprocessorFinder

getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: DataPreprocessorFinder

getURLClassLoader0
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected URLClassLoader getURLClassLoader0(File f, ClassLoader parent) throws MalformedURLException
   :outertype: DataPreprocessorFinder

isJARLoaded
^^^^^^^^^^^

.. java:method:: @Override protected boolean isJARLoaded(File f)
   :outertype: DataPreprocessorFinder

