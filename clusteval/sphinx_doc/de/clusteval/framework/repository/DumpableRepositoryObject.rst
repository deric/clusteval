.. java:import:: java.io File

DumpableRepositoryObject
========================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public abstract class DumpableRepositoryObject extends RepositoryObject

   :author: Christian Wiwie

Constructors
------------
DumpableRepositoryObject
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DumpableRepositoryObject(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: DumpableRepositoryObject

   Instantiates a new dumpable repository object.

   :param repository: The repository this object is registered in.
   :param register: Whether this object should be registered implicitely in the repository or if the user wants to register manually later.
   :param changeDate: The changedate of this object can be used for identification and equality checks of objects.
   :param absPath: The absolute path of this object is used for identification and equality checks of objects.
   :throws RegisterException:

DumpableRepositoryObject
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DumpableRepositoryObject(Repository repository, long changeDate, File absPath) throws RegisterException
   :outertype: DumpableRepositoryObject

   Instantiates a new dumpable repository object.

   This is a convenience constructor which implicitely registers the new object in its repository.

   :param repository: The repository this object is registered in.
   :param changeDate: The changedate of this object can be used for identification and equality checks of objects.
   :param absPath: The absolute path of this object is used for identification and equality checks of objects.
   :throws RegisterException:

DumpableRepositoryObject
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DumpableRepositoryObject(RepositoryObject other) throws RegisterException
   :outertype: DumpableRepositoryObject

   The copy constructor for dumpable repository objects.

   Cloned repository objects are never registered at the repository.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
dumpToFile
^^^^^^^^^^

.. java:method:: public final void dumpToFile() throws RepositoryObjectDumpException
   :outertype: DumpableRepositoryObject

   :throws RepositoryObjectDumpException:

dumpToFileHelper
^^^^^^^^^^^^^^^^

.. java:method:: protected abstract void dumpToFileHelper() throws RepositoryObjectDumpException
   :outertype: DumpableRepositoryObject

