.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util Iterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils JARFinder

.. java:import:: de.clusteval.utils RecursiveSubDirectoryIterator

DistanceMeasureURLClassLoader
=============================

.. java:package:: de.clusteval.data.distance
   :noindex:

.. java:type::  class DistanceMeasureURLClassLoader extends URLClassLoader

Fields
------
parent
^^^^^^

.. java:field:: protected DistanceMeasureFinder parent
   :outertype: DistanceMeasureURLClassLoader

Constructors
------------
DistanceMeasureURLClassLoader
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DistanceMeasureURLClassLoader(DistanceMeasureFinder parent, URL[] urls, ClassLoader loaderParent)
   :outertype: DistanceMeasureURLClassLoader

   :param urls:
   :param parent:
   :param loaderParent:

Methods
-------
loadClass
^^^^^^^^^

.. java:method:: @Override public Class<?> loadClass(String name) throws ClassNotFoundException
   :outertype: DistanceMeasureURLClassLoader

