.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util HashMap

.. java:import:: java.util Iterator

.. java:import:: java.util Map

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils JARFinder

.. java:import:: de.clusteval.utils RecursiveSubDirectoryIterator

DataSetTypeURLClassLoader
=========================

.. java:package:: de.clusteval.data.dataset.type
   :noindex:

.. java:type::  class DataSetTypeURLClassLoader extends URLClassLoader

Fields
------
parent
^^^^^^

.. java:field:: protected DataSetTypeFinder parent
   :outertype: DataSetTypeURLClassLoader

Constructors
------------
DataSetTypeURLClassLoader
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetTypeURLClassLoader(DataSetTypeFinder parent, URL[] urls, ClassLoader loaderParent)
   :outertype: DataSetTypeURLClassLoader

   :param urls:
   :param parent:
   :param loaderParent:

Methods
-------
loadClass
^^^^^^^^^

.. java:method:: @Override public Class<?> loadClass(String name) throws ClassNotFoundException
   :outertype: DataSetTypeURLClassLoader

