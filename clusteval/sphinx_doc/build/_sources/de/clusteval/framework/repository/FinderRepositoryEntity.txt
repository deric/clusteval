.. java:import:: de.clusteval.utils Finder

FinderRepositoryEntity
======================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public class FinderRepositoryEntity extends StaticRepositoryEntity<Finder>

   :author: Christian Wiwie

Constructors
------------
FinderRepositoryEntity
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public FinderRepositoryEntity(Repository repository, StaticRepositoryEntity<Finder> parent, String basePath)
   :outertype: FinderRepositoryEntity

   :param repository:
   :param parent:
   :param basePath:

Methods
-------
registerWhenExisting
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected <S extends Finder> boolean registerWhenExisting(S old, S object) throws RegisterException
   :outertype: FinderRepositoryEntity

unregisterAfterRemove
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected <S extends Finder> void unregisterAfterRemove(S object)
   :outertype: FinderRepositoryEntity

