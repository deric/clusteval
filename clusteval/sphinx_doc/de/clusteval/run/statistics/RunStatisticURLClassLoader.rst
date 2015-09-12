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

RunStatisticURLClassLoader
==========================

.. java:package:: de.clusteval.run.statistics
   :noindex:

.. java:type::  class RunStatisticURLClassLoader extends URLClassLoader

Fields
------
parent
^^^^^^

.. java:field:: protected RunStatisticFinder parent
   :outertype: RunStatisticURLClassLoader

Constructors
------------
RunStatisticURLClassLoader
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunStatisticURLClassLoader(RunStatisticFinder parent, URL[] urls, ClassLoader loaderParent)
   :outertype: RunStatisticURLClassLoader

   :param urls:
   :param parent:
   :param loaderParent:

Methods
-------
loadClass
^^^^^^^^^

.. java:method:: @Override public Class<?> loadClass(String name) throws ClassNotFoundException
   :outertype: RunStatisticURLClassLoader

