.. java:import:: java.util Collection

.. java:import:: java.util HashMap

.. java:import:: java.util HashSet

.. java:import:: java.util Map

StaticRepositoryEntity
======================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public class StaticRepositoryEntity<T extends RepositoryObject> extends RepositoryEntity<T>

Fields
------
nameToObject
^^^^^^^^^^^^

.. java:field:: protected Map<String, T> nameToObject
   :outertype: StaticRepositoryEntity

objects
^^^^^^^

.. java:field:: protected Map<T, T> objects
   :outertype: StaticRepositoryEntity

   A map containing all datasets registered in this repository.

parent
^^^^^^

.. java:field:: protected StaticRepositoryEntity<T> parent
   :outertype: StaticRepositoryEntity

Constructors
------------
StaticRepositoryEntity
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public StaticRepositoryEntity(Repository repository, StaticRepositoryEntity<T> parent, String basePath)
   :outertype: StaticRepositoryEntity

Methods
-------
asCollection
^^^^^^^^^^^^

.. java:method:: public Collection<T> asCollection()
   :outertype: StaticRepositoryEntity

findByString
^^^^^^^^^^^^

.. java:method:: public T findByString(String search)
   :outertype: StaticRepositoryEntity

   This method looks up and returns (if it exists) the data configuration with the given name.

   :param search:

getRegisteredObject
^^^^^^^^^^^^^^^^^^^

.. java:method:: public <S extends T> S getRegisteredObject(S obj)
   :outertype: StaticRepositoryEntity

   This method checks, whether there is an object registered, that is equal to the passed object and returns it.

   Equality is checked in terms of

   ..

   * \ **object.hashCode == other.hashCode**\
   * \ **object.equals(other)**\

   since internally the repository uses hash datastructures.

   By default the \ :java:ref:`RepositoryObject.equals(Object)`\  method is only based on the absolute path of the repository object and the repositories of the two objects, this means two repository objects are considered the same if they are stored in the same repository and they have the same absolute path.

   :param obj:

getRegisteredObject
^^^^^^^^^^^^^^^^^^^

.. java:method:: public <S extends T> S getRegisteredObject(S object, boolean ignoreChangeDate)
   :outertype: StaticRepositoryEntity

register
^^^^^^^^

.. java:method:: @Override public <S extends T> boolean register(S object) throws RegisterException
   :outertype: StaticRepositoryEntity

   This method registers a new object.

   First by invoking \ :java:ref:`getRegisteredObject(RepositoryObject)`\  the method checks, whether another object equalling the new object has been registered before.

   If there is no old equalling object, the new object is simply registered at the repository.

   If there is an old equalling object, their \ **changedates**\  are compared. The new object is only registered, if the changedate of the new object is newer than the changedate of the old object. If the changedate is newer, the new object is registered at the repository and a \ :java:ref:`RepositoryReplaceEvent`\  is being thrown. This event tells the old object and all its listeners in \ :java:ref:`RepositoryObject.listener`\ , that it has been replaced by the new object. This allows all objects to update their references to the old object to the new object.

   The method also tells the \ :java:ref:`repository.sqlCommunicator`\  of the repository, that a new object has been registered and causes him, to handle the new object.

   :param object:
   :throws RegisterException:

registerWhenExisting
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected <S extends T> boolean registerWhenExisting(S old, S object) throws RegisterException
   :outertype: StaticRepositoryEntity

registerWithoutExisting
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected <S extends T> boolean registerWithoutExisting(S object)
   :outertype: StaticRepositoryEntity

unregister
^^^^^^^^^^

.. java:method:: @Override public <S extends T> boolean unregister(S object)
   :outertype: StaticRepositoryEntity

   This method unregisters the passed object.

   If the object has been registered before and was unregistered now, this method tells the sql communicator such that he can also handle the removal of the object.

   :param object:

unregisterAfterRemove
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected <S extends T> void unregisterAfterRemove(S object)
   :outertype: StaticRepositoryEntity

