.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util Iterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils JARFinder

.. java:import:: de.clusteval.utils RecursiveSubDirectoryIterator

DataSetGeneratorURLClassLoader
==============================

.. java:package:: de.clusteval.data.dataset.generator
   :noindex:

.. java:type::  class DataSetGeneratorURLClassLoader extends URLClassLoader

Fields
------
parent
^^^^^^

.. java:field:: protected DataSetGeneratorFinder parent
   :outertype: DataSetGeneratorURLClassLoader

Constructors
------------
DataSetGeneratorURLClassLoader
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetGeneratorURLClassLoader(DataSetGeneratorFinder parent, URL[] urls, ClassLoader loaderParent)
   :outertype: DataSetGeneratorURLClassLoader

   :param urls:
   :param parent:
   :param loaderParent:

Methods
-------
loadClass
^^^^^^^^^

.. java:method:: @Override public Class<?> loadClass(String name) throws ClassNotFoundException
   :outertype: DataSetGeneratorURLClassLoader

