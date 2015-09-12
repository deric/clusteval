.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util Iterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils JARFinder

.. java:import:: de.clusteval.utils RecursiveSubDirectoryIterator

RunResultPostprocessorURLClassLoader
====================================

.. java:package:: de.clusteval.run.result.postprocessing
   :noindex:

.. java:type::  class RunResultPostprocessorURLClassLoader extends URLClassLoader

Fields
------
parent
^^^^^^

.. java:field:: protected RunResultPostprocessorFinder parent
   :outertype: RunResultPostprocessorURLClassLoader

Constructors
------------
RunResultPostprocessorURLClassLoader
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultPostprocessorURLClassLoader(RunResultPostprocessorFinder parent, URL[] urls, ClassLoader loaderParent)
   :outertype: RunResultPostprocessorURLClassLoader

   :param urls:
   :param parent:
   :param loaderParent:

Methods
-------
loadClass
^^^^^^^^^

.. java:method:: @Override public Class<?> loadClass(String name) throws ClassNotFoundException
   :outertype: RunResultPostprocessorURLClassLoader

