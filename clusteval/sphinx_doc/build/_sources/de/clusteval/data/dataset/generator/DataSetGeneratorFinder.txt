.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util Iterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils JARFinder

.. java:import:: de.clusteval.utils RecursiveSubDirectoryIterator

DataSetGeneratorFinder
======================

.. java:package:: de.clusteval.data.dataset.generator
   :noindex:

.. java:type:: public class DataSetGeneratorFinder extends JARFinder<DataSetGenerator>

   :author: Christian Wiwie

Constructors
------------
DataSetGeneratorFinder
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetGeneratorFinder(Repository repository) throws RegisterException
   :outertype: DataSetGeneratorFinder

   Instantiates a new data set generator finder.

   :param repository: the repository
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: @Override protected boolean checkFile(File file)
   :outertype: DataSetGeneratorFinder

classNamesForJARFile
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String[] classNamesForJARFile(File f)
   :outertype: DataSetGeneratorFinder

getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: DataSetGeneratorFinder

getURLClassLoader0
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected URLClassLoader getURLClassLoader0(File f, ClassLoader parent) throws MalformedURLException
   :outertype: DataSetGeneratorFinder

isJARLoaded
^^^^^^^^^^^

.. java:method:: @Override protected boolean isJARLoaded(File f)
   :outertype: DataSetGeneratorFinder

