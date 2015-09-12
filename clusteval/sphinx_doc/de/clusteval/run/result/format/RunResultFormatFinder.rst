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

RunResultFormatFinder
=====================

.. java:package:: de.clusteval.run.result.format
   :noindex:

.. java:type:: public class RunResultFormatFinder extends JARFinder<RunResultFormat>

   :author: Christian Wiwie

Constructors
------------
RunResultFormatFinder
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultFormatFinder(Repository repository) throws RegisterException
   :outertype: RunResultFormatFinder

   Instantiates a new data set format finder.

   :param repository: the repository
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: @Override protected boolean checkFile(File file)
   :outertype: RunResultFormatFinder

classNamesForJARFile
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String[] classNamesForJARFile(File f)
   :outertype: RunResultFormatFinder

getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: RunResultFormatFinder

getURLClassLoader0
^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected URLClassLoader getURLClassLoader0(File f, ClassLoader parent) throws MalformedURLException
   :outertype: RunResultFormatFinder

isJARLoaded
^^^^^^^^^^^

.. java:method:: @Override protected boolean isJARLoaded(File f)
   :outertype: RunResultFormatFinder

search
^^^^^^

.. java:method:: protected List<URL> search(File f) throws MalformedURLException
   :outertype: RunResultFormatFinder

