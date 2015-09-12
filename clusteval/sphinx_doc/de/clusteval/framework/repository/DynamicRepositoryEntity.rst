.. java:import:: java.util ArrayList

.. java:import:: java.util Collection

.. java:import:: java.util Collections

.. java:import:: java.util HashMap

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: de.clusteval.framework RLibraryNotLoadedException

.. java:import:: de.clusteval.framework RLibraryRequirement

.. java:import:: de.clusteval.utils UnsatisfiedRLibraryException

DynamicRepositoryEntity
=======================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public class DynamicRepositoryEntity<T extends RepositoryObject> extends RepositoryEntity<T>

Fields
------
classes
^^^^^^^

.. java:field:: protected Map<String, Class<? extends T>> classes
   :outertype: DynamicRepositoryEntity

loadedClasses
^^^^^^^^^^^^^

.. java:field:: protected static Map<String, Class<? extends RepositoryObject>> loadedClasses
   :outertype: DynamicRepositoryEntity

objects
^^^^^^^

.. java:field:: protected Map<String, List<T>> objects
   :outertype: DynamicRepositoryEntity

   A map containing all objects registered in this entity.

parent
^^^^^^

.. java:field:: protected DynamicRepositoryEntity<T> parent
   :outertype: DynamicRepositoryEntity

Constructors
------------
DynamicRepositoryEntity
^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DynamicRepositoryEntity(Repository repository, DynamicRepositoryEntity<T> parent, String basePath)
   :outertype: DynamicRepositoryEntity

Methods
-------
ensureLibraries
^^^^^^^^^^^^^^^

.. java:method:: protected <S extends T> boolean ensureLibraries(Class<S> classObject) throws InterruptedException
   :outertype: DynamicRepositoryEntity

   This method assumes, that the class that is passed is currently registered in this repository.

   If the R libraries are not satisfied, the class is removed from the repository.

   :param classObject: The class for which we want to ensure R library dependencies.
   :throws UnsatisfiedRLibraryException:
   :throws InterruptedException:
   :return: True, if all R library dependencies are fulfilled.

getClasses
^^^^^^^^^^

.. java:method:: public Collection<Class<? extends T>> getClasses()
   :outertype: DynamicRepositoryEntity

getRegisteredClass
^^^^^^^^^^^^^^^^^^

.. java:method:: public Class<? extends T> getRegisteredClass(String className)
   :outertype: DynamicRepositoryEntity

   This method looks up and returns (if it exists) the class with the given name.

   :param className: The name of the class.
   :return: The class with the given name or null, if it does not exist.

getRegisteredObject
^^^^^^^^^^^^^^^^^^^

.. java:method:: public <S extends T> S getRegisteredObject(S obj)
   :outertype: DynamicRepositoryEntity

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
   :outertype: DynamicRepositoryEntity

isClassAvailable
^^^^^^^^^^^^^^^^

.. java:method:: public static boolean isClassAvailable(String fullClassName)
   :outertype: DynamicRepositoryEntity

isClassRegistered
^^^^^^^^^^^^^^^^^

.. java:method:: public <S extends T> boolean isClassRegistered(Class<S> classToRegister)
   :outertype: DynamicRepositoryEntity

   This method checks whether a class is registered in this repository.

   :param classToRegister: The class to look up.
   :return: True, if the class was registered.

isClassRegistered
^^^^^^^^^^^^^^^^^

.. java:method:: public boolean isClassRegistered(String className)
   :outertype: DynamicRepositoryEntity

   This method checks whether a class with the given name is registered in this repository.

   :param className: The name of the class to look up.
   :return: True, if the class was registered.

register
^^^^^^^^

.. java:method:: @Override public <S extends T> boolean register(S object) throws RegisterException
   :outertype: DynamicRepositoryEntity

   This method registers a new object.

   First by invoking \ :java:ref:`getRegisteredObject(RepositoryObject)`\  the method checks, whether another object equalling the new object has been registered before.

   If there is no old equalling object, the new object is simply registered at the repository.

   If there is an old equalling object, their \ **changedates**\  are compared. The new object is only registered, if the changedate of the new object is newer than the changedate of the old object. If the changedate is newer, the new object is registered at the repository and a \ :java:ref:`RepositoryReplaceEvent`\  is being thrown. This event tells the old object and all its listeners in \ :java:ref:`RepositoryObject.listener`\ , that it has been replaced by the new object. This allows all objects to update their references to the old object to the new object.

   The method also tells the \ :java:ref:`repository.sqlCommunicator`\  of the repository, that a new object has been registered and causes him, to handle the new object.

   :param object:
   :throws RegisterException:

registerClass
^^^^^^^^^^^^^

.. java:method:: public <S extends T> boolean registerClass(Class<S> object)
   :outertype: DynamicRepositoryEntity

   This method registers a new class. It is only registered, if it was not before.

   :param object: The new object to register.
   :return: True, if the new object has been registered.

unregister
^^^^^^^^^^

.. java:method:: @Override public <S extends T> boolean unregister(S object)
   :outertype: DynamicRepositoryEntity

   This method unregisters the passed object.

   If the object has been registered before and was unregistered now, this method tells the sql communicator such that he can also handle the removal of the object.

   :param object:

unregisterClass
^^^^^^^^^^^^^^^

.. java:method:: public <S extends T> boolean unregisterClass(Class<S> c)
   :outertype: DynamicRepositoryEntity

   This method unregisters the passed object.

   If the object has been registered before and was unregistered now, this method tells the sql communicator such that he can also handle the removal of the object.

   :param c: The object to be removed.
   :return: True, if the object was remved successfully

