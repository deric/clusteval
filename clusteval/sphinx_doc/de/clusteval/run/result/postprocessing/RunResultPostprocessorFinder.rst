.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util Iterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils JARFinder

.. java:import:: de.clusteval.utils RecursiveSubDirectoryIterator

RunResultPostprocessorFinder
============================

.. java:package:: de.clusteval.run.result.postprocessing
   :noindex:

.. java:type:: public class RunResultPostprocessorFinder extends JARFinder<RunResultPostprocessor>

   :author: Christian Wiwie

Constructors
------------
RunResultPostprocessorFinder
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultPostprocessorFinder(Repository repository) throws RegisterException
   :outertype: RunResultPostprocessorFinder

   Instantiates a new data set generator finder.

   :param repository: the repository
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: @Override protected boolean checkFile(File file)
   :outertype: RunResultPostprocessorFinder

classNamesForJARFile
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String[] classNamesForJARFile(File f)
   :outertype: RunResultPostprocessorFinder

getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: RunResultPostprocessorFinder

getURLClassLoader0
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected URLClassLoader getURLClassLoader0(File f, ClassLoader parent) throws MalformedURLException
   :outertype: RunResultPostprocessorFinder

isJARLoaded
^^^^^^^^^^^

.. java:method:: @Override protected boolean isJARLoaded(File f)
   :outertype: RunResultPostprocessorFinder

