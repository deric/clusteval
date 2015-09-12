.. java:import:: de.clusteval.data.dataset DataSetFinderThread

RepositoryEntity
================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public abstract class RepositoryEntity<T extends RepositoryObject>

Fields
------
basePath
^^^^^^^^

.. java:field:: protected String basePath
   :outertype: RepositoryEntity

   The absolute path to the directory within this repository, where all datasets are stored.

printOnRegister
^^^^^^^^^^^^^^^

.. java:field:: protected boolean printOnRegister
   :outertype: RepositoryEntity

repository
^^^^^^^^^^

.. java:field:: protected Repository repository
   :outertype: RepositoryEntity

Constructors
------------
RepositoryEntity
^^^^^^^^^^^^^^^^

.. java:constructor:: public RepositoryEntity(Repository repository, String basePath)
   :outertype: RepositoryEntity

Methods
-------
getBasePath
^^^^^^^^^^^

.. java:method:: public String getBasePath()
   :outertype: RepositoryEntity

isInitialized
^^^^^^^^^^^^^

.. java:method:: public boolean isInitialized()
   :outertype: RepositoryEntity

register
^^^^^^^^

.. java:method:: public abstract <S extends T> boolean register(S object) throws RegisterException
   :outertype: RepositoryEntity

setInitialized
^^^^^^^^^^^^^^

.. java:method:: public void setInitialized()
   :outertype: RepositoryEntity

unregister
^^^^^^^^^^

.. java:method:: public abstract <S extends T> boolean unregister(S object)
   :outertype: RepositoryEntity

