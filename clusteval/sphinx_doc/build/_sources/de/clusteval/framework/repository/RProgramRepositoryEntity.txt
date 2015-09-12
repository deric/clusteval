.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: de.clusteval.program Program

.. java:import:: de.clusteval.program.r RProgram

RProgramRepositoryEntity
========================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public class RProgramRepositoryEntity extends DynamicRepositoryEntity<RProgram>

   :author: Christian Wiwie

Fields
------
programEntity
^^^^^^^^^^^^^

.. java:field:: protected StaticRepositoryEntity<Program> programEntity
   :outertype: RProgramRepositoryEntity

Constructors
------------
RProgramRepositoryEntity
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RProgramRepositoryEntity(Repository repository, StaticRepositoryEntity<Program> programEntity, DynamicRepositoryEntity<RProgram> parent, String basePath)
   :outertype: RProgramRepositoryEntity

   :param repository:
   :param programEntity:
   :param parent:
   :param basePath:

Methods
-------
ensureLibraries
^^^^^^^^^^^^^^^

.. java:method:: @Override protected <S extends RProgram> boolean ensureLibraries(Class<S> classObject) throws InterruptedException
   :outertype: RProgramRepositoryEntity

register
^^^^^^^^

.. java:method:: @Override public boolean register(RProgram rProgram) throws RegisterException
   :outertype: RProgramRepositoryEntity

registerClass
^^^^^^^^^^^^^

.. java:method:: @Override public <S extends RProgram> boolean registerClass(Class<S> object)
   :outertype: RProgramRepositoryEntity

