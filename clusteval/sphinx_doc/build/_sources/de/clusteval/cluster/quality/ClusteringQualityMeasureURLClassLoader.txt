.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util Iterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils JARFinder

.. java:import:: de.clusteval.utils RecursiveSubDirectoryIterator

ClusteringQualityMeasureURLClassLoader
======================================

.. java:package:: de.clusteval.cluster.quality
   :noindex:

.. java:type::  class ClusteringQualityMeasureURLClassLoader extends URLClassLoader

Fields
------
parent
^^^^^^

.. java:field:: protected ClusteringQualityMeasureFinder parent
   :outertype: ClusteringQualityMeasureURLClassLoader

Constructors
------------
ClusteringQualityMeasureURLClassLoader
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringQualityMeasureURLClassLoader(ClusteringQualityMeasureFinder parent, URL[] urls, ClassLoader loaderParent)
   :outertype: ClusteringQualityMeasureURLClassLoader

   :param urls:
   :param parent:
   :param loaderParent:

Methods
-------
loadClass
^^^^^^^^^

.. java:method:: @Override public Class<?> loadClass(String name) throws ClassNotFoundException
   :outertype: ClusteringQualityMeasureURLClassLoader

