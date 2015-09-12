.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util Iterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils JARFinder

.. java:import:: de.clusteval.utils RecursiveSubDirectoryIterator

ParameterOptimizationMethodURLClassLoader
=========================================

.. java:package:: de.clusteval.cluster.paramOptimization
   :noindex:

.. java:type::  class ParameterOptimizationMethodURLClassLoader extends URLClassLoader

Fields
------
parent
^^^^^^

.. java:field:: protected ParameterOptimizationMethodFinder parent
   :outertype: ParameterOptimizationMethodURLClassLoader

Constructors
------------
ParameterOptimizationMethodURLClassLoader
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ParameterOptimizationMethodURLClassLoader(ParameterOptimizationMethodFinder parent, URL[] urls, ClassLoader loaderParent)
   :outertype: ParameterOptimizationMethodURLClassLoader

   :param urls:
   :param parent:
   :param loaderParent:

Methods
-------
findClass
^^^^^^^^^

.. java:method:: @Override protected Class<?> findClass(String name) throws ClassNotFoundException
   :outertype: ParameterOptimizationMethodURLClassLoader

