.. java:import:: java.io File

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: java.util Iterator

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryEvent

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.framework.repository RepositoryRemoveEvent

.. java:import:: de.clusteval.framework.repository RepositoryReplaceEvent

Finder
======

.. java:package:: de.clusteval.utils
   :noindex:

.. java:type:: public abstract class Finder<T extends RepositoryObject> extends RepositoryObject

   :author: Christian Wiwie
   :param <T>:

Fields
------
classToFind
^^^^^^^^^^^

.. java:field:: protected Class<T> classToFind
   :outertype: Finder

foundInLastRun
^^^^^^^^^^^^^^

.. java:field:: protected boolean foundInLastRun
   :outertype: Finder

knownExceptions
^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, List<Throwable>> knownExceptions
   :outertype: Finder

Constructors
------------
Finder
^^^^^^

.. java:constructor:: public Finder(Repository repository, Class<T> classToFind) throws RegisterException
   :outertype: Finder

   :param repository:
   :param classToFind:
   :throws RegisterException:

Finder
^^^^^^

.. java:constructor:: public Finder(Finder<T> other) throws RegisterException
   :outertype: Finder

   The copy constructor of finder.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: protected abstract boolean checkFile(File file)
   :outertype: Finder

clone
^^^^^

.. java:method:: @Override public Finder<T> clone()
   :outertype: Finder

doOnFileFound
^^^^^^^^^^^^^

.. java:method:: protected abstract void doOnFileFound(File file) throws Exception
   :outertype: Finder

equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: Finder

findAndRegisterObjects
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings public void findAndRegisterObjects() throws RegisterException, InterruptedException
   :outertype: Finder

   Find files and try to parse them. If the parsing process is successful it will implicitely register the new object at the repository. if the object was known before it will updated, if and only if the changeDate of the found object is newer.

   :throws InterruptedException:
   :throws RegisterException:

foundInLastRun
^^^^^^^^^^^^^^

.. java:method:: public boolean foundInLastRun()
   :outertype: Finder

getBaseDir
^^^^^^^^^^

.. java:method:: protected File getBaseDir()
   :outertype: Finder

getClassToFind
^^^^^^^^^^^^^^

.. java:method:: protected final Class<T> getClassToFind()
   :outertype: Finder

getIterator
^^^^^^^^^^^

.. java:method:: protected abstract Iterator<File> getIterator()
   :outertype: Finder

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: Finder

notify
^^^^^^

.. java:method:: @Override public void notify(RepositoryEvent e)
   :outertype: Finder

