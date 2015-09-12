.. java:import:: java.io File

.. java:import:: java.io PrintWriter

.. java:import:: java.io StringWriter

.. java:import:: java.util ArrayList

.. java:import:: java.util Collection

.. java:import:: java.util HashSet

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.framework.repository RepositoryRemoveEvent

.. java:import:: de.clusteval.framework.repository.parse Parser

FileFinder
==========

.. java:package:: de.clusteval.utils
   :noindex:

.. java:type:: public abstract class FileFinder<T extends RepositoryObject> extends Finder<T>

   :author: Christian Wiwie
   :param <T>:

Constructors
------------
FileFinder
^^^^^^^^^^

.. java:constructor:: public FileFinder(Repository repository, Class<T> classToFind) throws RegisterException
   :outertype: FileFinder

   :param repository:
   :param classToFind:
   :throws RegisterException:

Methods
-------
doOnFileFound
^^^^^^^^^^^^^

.. java:method:: @Override protected void doOnFileFound(File file) throws InterruptedException, Exception
   :outertype: FileFinder

findAndRegisterObjects
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void findAndRegisterObjects() throws RegisterException, InterruptedException
   :outertype: FileFinder

getRegisteredObjectSet
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected Collection<? extends RepositoryObject> getRegisteredObjectSet()
   :outertype: FileFinder

parseObjectFromFile
^^^^^^^^^^^^^^^^^^^

.. java:method:: protected T parseObjectFromFile(File file) throws Exception
   :outertype: FileFinder

validateRegisteredObjects
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void validateRegisteredObjects() throws RegisterException
   :outertype: FileFinder

