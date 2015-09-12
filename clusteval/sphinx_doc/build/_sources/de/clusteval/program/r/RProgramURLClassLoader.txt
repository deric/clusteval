.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util Iterator

.. java:import:: utils ArrayIterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils JARFinder

RProgramURLClassLoader
======================

.. java:package:: de.clusteval.program.r
   :noindex:

.. java:type::  class RProgramURLClassLoader extends URLClassLoader

Fields
------
parent
^^^^^^

.. java:field:: protected RProgramFinder parent
   :outertype: RProgramURLClassLoader

Constructors
------------
RProgramURLClassLoader
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RProgramURLClassLoader(RProgramFinder parent, URL[] urls, ClassLoader loaderParent)
   :outertype: RProgramURLClassLoader

   :param urls:
   :param parent:
   :param loaderParent:

Methods
-------
loadClass
^^^^^^^^^

.. java:method:: @Override public Class<?> loadClass(String name) throws ClassNotFoundException
   :outertype: RProgramURLClassLoader

