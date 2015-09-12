.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util Iterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils JARFinder

.. java:import:: de.clusteval.utils RecursiveSubDirectoryIterator

ParameterOptimizationMethodFinder
=================================

.. java:package:: de.clusteval.cluster.paramOptimization
   :noindex:

.. java:type:: public class ParameterOptimizationMethodFinder extends JARFinder<ParameterOptimizationMethod>

   :author: Christian Wiwie

Constructors
------------
ParameterOptimizationMethodFinder
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ParameterOptimizationMethodFinder(Repository repository) throws RegisterException
   :outertype: ParameterOptimizationMethodFinder

   Instantiates a new clustering quality measure finder.

   :param repository: The repository to register the new data configurations at.
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: @Override protected boolean checkFile(File file)
   :outertype: ParameterOptimizationMethodFinder

classNamesForJARFile
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String[] classNamesForJARFile(File f)
   :outertype: ParameterOptimizationMethodFinder

getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: ParameterOptimizationMethodFinder

getURLClassLoader0
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected URLClassLoader getURLClassLoader0(File f, ClassLoader parent) throws MalformedURLException
   :outertype: ParameterOptimizationMethodFinder

isJARLoaded
^^^^^^^^^^^

.. java:method:: @Override protected boolean isJARLoaded(File f)
   :outertype: ParameterOptimizationMethodFinder

