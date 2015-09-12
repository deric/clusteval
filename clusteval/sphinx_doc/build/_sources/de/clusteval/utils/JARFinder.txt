.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util ArrayList

.. java:import:: java.util Collection

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: file FileUtils

JARFinder
=========

.. java:package:: de.clusteval.utils
   :noindex:

.. java:type:: public abstract class JARFinder<T extends RepositoryObject> extends Finder<T>

   :author: Christian Wiwie
   :param <T>:

Fields
------
classLoaders
^^^^^^^^^^^^

.. java:field:: protected Map<URL, URLClassLoader> classLoaders
   :outertype: JARFinder

loadedJarFileChangeDates
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, Long> loadedJarFileChangeDates
   :outertype: JARFinder

waitingFiles
^^^^^^^^^^^^

.. java:field:: protected Map<File, List<File>> waitingFiles
   :outertype: JARFinder

Constructors
------------
JARFinder
^^^^^^^^^

.. java:constructor:: public JARFinder(Repository repository, Class<T> classToFind) throws RegisterException
   :outertype: JARFinder

   :param repository:
   :throws RegisterException:

Methods
-------
classNamesForJARFile
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String[] classNamesForJARFile(File f)
   :outertype: JARFinder

doOnFileFound
^^^^^^^^^^^^^

.. java:method:: @Override protected void doOnFileFound(File file) throws Exception
   :outertype: JARFinder

findAndRegisterObjects
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void findAndRegisterObjects() throws RegisterException, InterruptedException
   :outertype: JARFinder

getRegisteredObjectSet
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected Collection<Class<? extends T>> getRegisteredObjectSet()
   :outertype: JARFinder

getURLClassLoader0
^^^^^^^^^^^^^^^^^^

.. java:method:: protected URLClassLoader getURLClassLoader0(File f) throws MalformedURLException
   :outertype: JARFinder

getURLClassLoader0
^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract URLClassLoader getURLClassLoader0(File f, ClassLoader parent) throws MalformedURLException
   :outertype: JARFinder

getURLClassLoaderAndStore
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected final URLClassLoader getURLClassLoaderAndStore(File f) throws MalformedURLException
   :outertype: JARFinder

getURLClassLoaderAndStore
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected final URLClassLoader getURLClassLoaderAndStore(File f, ClassLoader parent) throws MalformedURLException
   :outertype: JARFinder

isJARLoaded
^^^^^^^^^^^

.. java:method:: protected boolean isJARLoaded(File f)
   :outertype: JARFinder

   We check whether the jar file has been loaded, using its modification date. The jar is only assumed do be loaded, if the modification dates are equal.

   :param f: The jar file we want to load.
   :return: true, if the jar file has been loaded, false otherwise.

loadClass
^^^^^^^^^

.. java:method:: protected Class<?> loadClass(String className, URLClassLoader loader) throws ClassNotFoundException
   :outertype: JARFinder

loadJAR
^^^^^^^

.. java:method:: protected void loadJAR(File f) throws MalformedURLException
   :outertype: JARFinder

   Load jar.

   :param f: the f
   :throws MalformedURLException: the malformed url exception
   :throws IllegalAccessException: the illegal access exception
   :throws InstantiationException: the instantiation exception

loadJAR
^^^^^^^

.. java:method:: protected void loadJAR(File f, URLClassLoader loader) throws MalformedURLException
   :outertype: JARFinder

removeOldObject
^^^^^^^^^^^^^^^

.. java:method:: protected void removeOldObject(Class<? extends T> object)
   :outertype: JARFinder

validateRegisteredObjects
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void validateRegisteredObjects()
   :outertype: JARFinder

