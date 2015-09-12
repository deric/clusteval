.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util ArrayList

.. java:import:: java.util Iterator

.. java:import:: java.util List

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils JARFinder

.. java:import:: de.clusteval.utils RecursiveSubDirectoryIterator

DataStatisticFinder
===================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public class DataStatisticFinder extends JARFinder<DataStatistic>

   :author: Christian Wiwie

Constructors
------------
DataStatisticFinder
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataStatisticFinder(Repository repository) throws RegisterException
   :outertype: DataStatisticFinder

   Instantiates a new data set format finder.

   :param repository: the repository
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: @Override protected boolean checkFile(File file)
   :outertype: DataStatisticFinder

classNamesForJARFile
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String[] classNamesForJARFile(File f)
   :outertype: DataStatisticFinder

getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: DataStatisticFinder

getURLClassLoader0
^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected URLClassLoader getURLClassLoader0(File f, ClassLoader parent) throws MalformedURLException
   :outertype: DataStatisticFinder

isJARLoaded
^^^^^^^^^^^

.. java:method:: @Override protected boolean isJARLoaded(File f)
   :outertype: DataStatisticFinder

search
^^^^^^

.. java:method:: protected List<URL> search(File f) throws MalformedURLException
   :outertype: DataStatisticFinder

