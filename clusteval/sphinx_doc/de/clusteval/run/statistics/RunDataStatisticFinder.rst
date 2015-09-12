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

RunDataStatisticFinder
======================

.. java:package:: de.clusteval.run.statistics
   :noindex:

.. java:type:: public class RunDataStatisticFinder extends JARFinder<RunDataStatistic>

   :author: Christian Wiwie

Constructors
------------
RunDataStatisticFinder
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunDataStatisticFinder(Repository repository) throws RegisterException
   :outertype: RunDataStatisticFinder

   Instantiates a new data set format finder.

   :param repository: the repository
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: @Override protected boolean checkFile(File file)
   :outertype: RunDataStatisticFinder

classNamesForJARFile
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String[] classNamesForJARFile(File f)
   :outertype: RunDataStatisticFinder

getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: RunDataStatisticFinder

getURLClassLoader0
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected URLClassLoader getURLClassLoader0(File f, ClassLoader parent) throws MalformedURLException
   :outertype: RunDataStatisticFinder

isJARLoaded
^^^^^^^^^^^

.. java:method:: @Override protected boolean isJARLoaded(File f)
   :outertype: RunDataStatisticFinder

search
^^^^^^

.. java:method:: protected List<URL> search(File f) throws MalformedURLException
   :outertype: RunDataStatisticFinder

