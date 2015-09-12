.. java:import:: java.io File

.. java:import:: java.util HashMap

.. java:import:: java.util Map

.. java:import:: de.clusteval.run.result ParameterOptimizationResult

.. java:import:: de.clusteval.run.result RunResult

.. java:import:: file FileUtils

RunResultRepositoryEntity
=========================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public class RunResultRepositoryEntity extends StaticRepositoryEntity<RunResult>

   :author: Christian Wiwie

Fields
------
runResultIdentifier
^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, RunResult> runResultIdentifier
   :outertype: RunResultRepositoryEntity

Constructors
------------
RunResultRepositoryEntity
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultRepositoryEntity(Repository repository, StaticRepositoryEntity<RunResult> parent, String basePath)
   :outertype: RunResultRepositoryEntity

   :param repository:
   :param parent:
   :param basePath:

Methods
-------
getAnalysisResultsBasePath
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getAnalysisResultsBasePath()
   :outertype: RunResultRepositoryEntity

   :return: The absolute path to the directory, where for a certain runresult (identified by its unique run identifier) all analysis results are stored.

getClusterResultsBasePath
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getClusterResultsBasePath()
   :outertype: RunResultRepositoryEntity

   The absolute path to the directory, where for a certain runresult (identified by its unique run identifier) all clustering results are stored.

getClusterResultsQualityBasePath
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getClusterResultsQualityBasePath()
   :outertype: RunResultRepositoryEntity

   The absolute path to the directory, where for a certain runresult (identified by its unique run identifier) all qualities of clustering results are stored.

getResultLogBasePath
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getResultLogBasePath()
   :outertype: RunResultRepositoryEntity

registerWhenExisting
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected <S extends RunResult> boolean registerWhenExisting(S old, S object)
   :outertype: RunResultRepositoryEntity

registerWithoutExisting
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected <S extends RunResult> boolean registerWithoutExisting(S object)
   :outertype: RunResultRepositoryEntity

unregisterAfterRemove
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected <S extends RunResult> void unregisterAfterRemove(S object)
   :outertype: RunResultRepositoryEntity

