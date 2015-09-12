.. java:import:: de.clusteval.program ProgramParameter

ProgramParameterRepositoryEntity
================================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public class ProgramParameterRepositoryEntity<T extends ProgramParameter<?>> extends StaticRepositoryEntity<T>

   :author: Christian Wiwie

Constructors
------------
ProgramParameterRepositoryEntity
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ProgramParameterRepositoryEntity(Repository repository, StaticRepositoryEntity<T> parent, String basePath)
   :outertype: ProgramParameterRepositoryEntity

   :param repository:
   :param parent:
   :param basePath:

Methods
-------
registerWhenExisting
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected <S extends T> boolean registerWhenExisting(S old, S object) throws RegisterException
   :outertype: ProgramParameterRepositoryEntity

