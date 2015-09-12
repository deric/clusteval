.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util ArrayList

.. java:import:: java.util Collections

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: org.slf4j Logger

.. java:import:: org.slf4j LoggerFactory

.. java:import:: file FileUtils

RepositoryObject
================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public abstract class RepositoryObject implements RepositoryListener

   A \ :java:ref:`RepositoryObject`\  provides integrated functionalities in terms of automatic handling by the \ :java:ref:`Repository`\  it is registered in.

   Functionality of this repository registration includes

   ..

   * automatic detection of changes of repository objects
   * automatic notification of changes about other repository objects this object listens to
   * notifications of other objects about changes of this object
   * central access to all objects of the framework in the repository
   * copy handling

   :author: Christian Wiwie

Fields
------
absPath
^^^^^^^

.. java:field:: protected File absPath
   :outertype: RepositoryObject

   The absolute path of this object is used for identification and equality checks of objects.

changeDate
^^^^^^^^^^

.. java:field:: protected long changeDate
   :outertype: RepositoryObject

   The changedate of this object can be used for identification and equality checks of objects.

listener
^^^^^^^^

.. java:field:: protected Set<RepositoryListener> listener
   :outertype: RepositoryObject

   A set with all the listeners, that want to be informed about changes of this object.

log
^^^

.. java:field:: protected Logger log
   :outertype: RepositoryObject

repository
^^^^^^^^^^

.. java:field:: protected Repository repository
   :outertype: RepositoryObject

   The repository this object is registered in.

Constructors
------------
RepositoryObject
^^^^^^^^^^^^^^^^

.. java:constructor:: public RepositoryObject(Repository repository, long changeDate, File absPath) throws RegisterException
   :outertype: RepositoryObject

   Instantiates a new repository object.

   This is a convenience constructor which implicitely registers the new object in its repository.

   :param repository: The repository this object is registered in.
   :param changeDate: The changedate of this object can be used for identification and equality checks of objects.
   :param absPath: The absolute path of this object is used for identification and equality checks of objects.
   :throws RegisterException:

RepositoryObject
^^^^^^^^^^^^^^^^

.. java:constructor:: public RepositoryObject(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: RepositoryObject

   Instantiates a new repository object.

   :param repository: The repository this object is registered in.
   :param register: Whether this object should be registered implicitely in the repository or if the user wants to register manually later.
   :param changeDate: The changedate of this object can be used for identification and equality checks of objects.
   :param absPath: The absolute path of this object is used for identification and equality checks of objects.
   :throws RegisterException:

RepositoryObject
^^^^^^^^^^^^^^^^

.. java:constructor:: public RepositoryObject(RepositoryObject other) throws RegisterException
   :outertype: RepositoryObject

   The copy constructor for repository objects.

   Cloned repository objects are never registered at the repository.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
addListener
^^^^^^^^^^^

.. java:method:: public boolean addListener(RepositoryListener listener)
   :outertype: RepositoryObject

   Add a listener to this objects listeners. Those are for example informed when this object is removed from the repository or replaced by another object.

   :param listener: The new listener.
   :return: True, if the listener was added successfully

clone
^^^^^

.. java:method:: @Override public abstract RepositoryObject clone()
   :outertype: RepositoryObject

copyTo
^^^^^^

.. java:method:: public boolean copyTo(File copyDestination)
   :outertype: RepositoryObject

   A convenience method for \ :java:ref:`copyTo(File,boolean)`\ , with overwriting enabled.

   :param copyDestination: The absolute path to the destination file.
   :return: True, if the copy operation was successful.

copyTo
^^^^^^

.. java:method:: public boolean copyTo(File copyDestination, boolean overwrite)
   :outertype: RepositoryObject

   A convenience method for \ :java:ref:`copyTo(File,boolean,boolean)`\ , with waiting for the operation to finish.

   :param copyDestination: The absolute path to the destination file.
   :param overwrite: Whether the possibly already existing target file should be overwritten.
   :return: True, if the copy operation was successful.

copyTo
^^^^^^

.. java:method:: public boolean copyTo(File copyDestination, boolean overwrite, boolean wait)
   :outertype: RepositoryObject

   This method copies the file corresponding to this repository object to the destination.

   \ **Hint:**\  Use the wait parameter with caution: It might increase the ressource load of this method considerably. Also the wait operation might not terminate, if source and target filesystem use different encodings and the equality checks return false.

   :param copyDestination: The absolute path to the destination file.
   :param overwrite: Whether the possibly already existing target file should be overwritten.
   :param wait: Whether to wait for this operation to finish, were the completion of the operation is determined by steadily comparing source and target file for equality.
   :return: True, if the copy operation was successful.

copyToFolder
^^^^^^^^^^^^

.. java:method:: public boolean copyToFolder(File copyFolderDestination)
   :outertype: RepositoryObject

   A convenience method for \ :java:ref:`copyToFolder(File,boolean)`\ , with overwriting enabled.

   :param copyFolderDestination: The folder in which this file should be copied
   :return: True, if the copy operation was successful.

copyToFolder
^^^^^^^^^^^^

.. java:method:: public boolean copyToFolder(File copyFolderDestination, boolean overwrite)
   :outertype: RepositoryObject

   This method copies the file corresponding to this repository object into the destination folder.

   :param copyFolderDestination: The folder in which this file should be copied
   :param overwrite: Whether a possibly already existing target file within the destination folder should be overwritten.
   :return: True, if the copy operation was successful.

doOnRegister
^^^^^^^^^^^^

.. java:method:: protected void doOnRegister()
   :outertype: RepositoryObject

   Do on register.

equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: RepositoryObject

getAbsolutePath
^^^^^^^^^^^^^^^

.. java:method:: public String getAbsolutePath()
   :outertype: RepositoryObject

   :return: The absolute path of this repository object.

   **See also:** :java:ref:`.absPath`

getChangeDate
^^^^^^^^^^^^^

.. java:method:: public long getChangeDate()
   :outertype: RepositoryObject

   :return: The changedate of this repository object.

   **See also:** :java:ref:`.changeDate`

getLog
^^^^^^

.. java:method:: public Logger getLog()
   :outertype: RepositoryObject

   :return: The logger of this object.

getRepository
^^^^^^^^^^^^^

.. java:method:: public Repository getRepository()
   :outertype: RepositoryObject

   :return: The repository this object is registered in.

   **See also:** :java:ref:`.repository`

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: RepositoryObject

moveTo
^^^^^^

.. java:method:: public boolean moveTo(File moveDestination)
   :outertype: RepositoryObject

   A convenience method for \ :java:ref:`moveTo(File,boolean)`\ , with overwriting enabled.

   :param moveDestination: The absolute path to the destination file.
   :return: True, if the move operation was successful.

moveTo
^^^^^^

.. java:method:: public boolean moveTo(File moveDest, boolean overwrite)
   :outertype: RepositoryObject

   This method moves the file corresponding to this repository object to the destination.

   \ **Hint:**\  Use the wait parameter with caution: It might increase the ressource load of this method considerably. Also the wait operation might not terminate, if source and target filesystem use different encodings and the equality checks return false.

   :param moveDest: The absolute path to the destination file.
   :param overwrite: Whether the possibly already existing target file should be overwritten.
   :return: True, if the move operation was successful.

moveToFolder
^^^^^^^^^^^^

.. java:method:: public boolean moveToFolder(File moveFolderDestination)
   :outertype: RepositoryObject

   A convenience method for \ :java:ref:`moveToFolder(File,boolean)`\ , with overwriting enabled.

   :param moveFolderDestination: The folder into which this file should be move
   :return: True, if the move operation was successful.

moveToFolder
^^^^^^^^^^^^

.. java:method:: public boolean moveToFolder(File moveFolderDestination, boolean overwrite)
   :outertype: RepositoryObject

   This method moves the file corresponding to this repository object into the destination folder.

   :param moveFolderDestination: The folder in which this file should be copied
   :param overwrite: Whether a possibly already existing target file within the destination folder should be overwritten.
   :return: True, if the copy operation was successful.

notify
^^^^^^

.. java:method:: @Override public void notify(RepositoryEvent e) throws RegisterException
   :outertype: RepositoryObject

register
^^^^^^^^

.. java:method:: public boolean register() throws RegisterException
   :outertype: RepositoryObject

   Any subclass needs to implement this method. It will be responsible to register a new object of the subclass at the repository.

   :throws RegisterException: An exception is thrown if something goes wrong during the registering process, that might be interesting to handle individually.
   :return: true, if successful

removeListener
^^^^^^^^^^^^^^

.. java:method:: public boolean removeListener(RepositoryListener listener)
   :outertype: RepositoryObject

   Remove a listener from this objects listener.

   :param listener: The listener to remove.
   :return: True, if the listener was removed successfully

setAbsolutePath
^^^^^^^^^^^^^^^

.. java:method:: public void setAbsolutePath(File absFilePath)
   :outertype: RepositoryObject

   :param absFilePath: The new absolute file path.

   **See also:** :java:ref:`.absPath`

unregister
^^^^^^^^^^

.. java:method:: public boolean unregister()
   :outertype: RepositoryObject

   Any subclass needs to implement this method. It will be responsible to unregister an object of the subclass from the repository.

   :return: true, if successful

