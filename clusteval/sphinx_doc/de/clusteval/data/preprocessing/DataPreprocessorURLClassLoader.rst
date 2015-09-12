.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util Iterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils JARFinder

.. java:import:: de.clusteval.utils RecursiveSubDirectoryIterator

DataPreprocessorURLClassLoader
==============================

.. java:package:: de.clusteval.data.preprocessing
   :noindex:

.. java:type::  class DataPreprocessorURLClassLoader extends URLClassLoader

Fields
------
parent
^^^^^^

.. java:field:: protected DataPreprocessorFinder parent
   :outertype: DataPreprocessorURLClassLoader

Constructors
------------
DataPreprocessorURLClassLoader
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataPreprocessorURLClassLoader(DataPreprocessorFinder parent, URL[] urls, ClassLoader loaderParent)
   :outertype: DataPreprocessorURLClassLoader

   :param urls:
   :param parent:
   :param loaderParent:

Methods
-------
loadClass
^^^^^^^^^

.. java:method:: @Override public Class<?> loadClass(String name) throws ClassNotFoundException
   :outertype: DataPreprocessorURLClassLoader

