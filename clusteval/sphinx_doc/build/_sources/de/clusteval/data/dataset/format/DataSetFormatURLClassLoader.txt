.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util Iterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils FormatVersion

.. java:import:: de.clusteval.utils JARFinder

.. java:import:: de.clusteval.utils RecursiveSubDirectoryIterator

DataSetFormatURLClassLoader
===========================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type::  class DataSetFormatURLClassLoader extends URLClassLoader

Fields
------
parent
^^^^^^

.. java:field:: protected DataSetFormatFinder parent
   :outertype: DataSetFormatURLClassLoader

Constructors
------------
DataSetFormatURLClassLoader
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetFormatURLClassLoader(DataSetFormatFinder parent, URL[] urls, ClassLoader loaderParent)
   :outertype: DataSetFormatURLClassLoader

   :param urls:
   :param parent:
   :param loaderParent:

Methods
-------
loadClass
^^^^^^^^^

.. java:method:: @Override public Class<?> loadClass(String name) throws ClassNotFoundException
   :outertype: DataSetFormatURLClassLoader

