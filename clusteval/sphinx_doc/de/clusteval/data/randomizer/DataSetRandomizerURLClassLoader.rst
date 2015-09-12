.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util Iterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils JARFinder

.. java:import:: de.clusteval.utils RecursiveSubDirectoryIterator

DataSetRandomizerURLClassLoader
===============================

.. java:package:: de.clusteval.data.randomizer
   :noindex:

.. java:type::  class DataSetRandomizerURLClassLoader extends URLClassLoader

Fields
------
parent
^^^^^^

.. java:field:: protected DataRandomizerFinder parent
   :outertype: DataSetRandomizerURLClassLoader

Constructors
------------
DataSetRandomizerURLClassLoader
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetRandomizerURLClassLoader(DataRandomizerFinder parent, URL[] urls, ClassLoader loaderParent)
   :outertype: DataSetRandomizerURLClassLoader

   :param urls:
   :param parent:
   :param loaderParent:

Methods
-------
loadClass
^^^^^^^^^

.. java:method:: @Override public Class<?> loadClass(String name) throws ClassNotFoundException
   :outertype: DataSetRandomizerURLClassLoader

