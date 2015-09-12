.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util Iterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils JARFinder

.. java:import:: de.clusteval.utils RecursiveSubDirectoryIterator

ContextURLClassLoader
=====================

.. java:package:: de.clusteval.context
   :noindex:

.. java:type::  class ContextURLClassLoader extends URLClassLoader

Fields
------
parent
^^^^^^

.. java:field:: protected ContextFinder parent
   :outertype: ContextURLClassLoader

Constructors
------------
ContextURLClassLoader
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ContextURLClassLoader(ContextFinder parent, URL[] urls, ClassLoader loaderParent)
   :outertype: ContextURLClassLoader

   :param urls:
   :param parent:
   :param loaderParent:

Methods
-------
loadClass
^^^^^^^^^

.. java:method:: @Override public Class<?> loadClass(String name) throws ClassNotFoundException
   :outertype: ContextURLClassLoader

