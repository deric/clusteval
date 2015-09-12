.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util Iterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils JARFinder

.. java:import:: de.clusteval.utils RecursiveSubDirectoryIterator

DataRandomizerFinder
====================

.. java:package:: de.clusteval.data.randomizer
   :noindex:

.. java:type:: public class DataRandomizerFinder extends JARFinder<DataRandomizer>

   :author: Christian Wiwie

Constructors
------------
DataRandomizerFinder
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataRandomizerFinder(Repository repository) throws RegisterException
   :outertype: DataRandomizerFinder

   Instantiates a new data set Randomizer finder.

   :param repository: the repository
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: @Override protected boolean checkFile(File file)
   :outertype: DataRandomizerFinder

classNamesForJARFile
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String[] classNamesForJARFile(File f)
   :outertype: DataRandomizerFinder

getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: DataRandomizerFinder

getURLClassLoader0
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected URLClassLoader getURLClassLoader0(File f, ClassLoader parent) throws MalformedURLException
   :outertype: DataRandomizerFinder

isJARLoaded
^^^^^^^^^^^

.. java:method:: @Override protected boolean isJARLoaded(File f)
   :outertype: DataRandomizerFinder

