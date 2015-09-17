.. java:import:: java.sql DriverManager

.. java:import:: java.sql ResultSet

.. java:import:: java.sql SQLException

.. java:import:: java.sql Statement

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.run Run

RunResultSQLCommunicator_pg
===========================

.. java:package:: de.clusteval.framework.repository.db
   :noindex:

.. java:type:: public class RunResultSQLCommunicator_pg extends DefaultSQLCommunicator

   :author: Christian Wiwie

Constructors
------------
RunResultSQLCommunicator_pg
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultSQLCommunicator_pg(Repository repository, SQLConfig mysqlConfig) throws DatabaseConnectException
   :outertype: RunResultSQLCommunicator_pg

   :param repository:
   :param mysqlConfig:
   :throws DatabaseConnectException:

Methods
-------
getDataSetFormatId
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getDataSetFormatId(String dataSetFormatClassSimpleName) throws SQLException
   :outertype: RunResultSQLCommunicator_pg

getDataSetTypeId
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getDataSetTypeId(String dataSetTypeClassSimpleName) throws SQLException
   :outertype: RunResultSQLCommunicator_pg

getParameterOptimizationMethodId
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getParameterOptimizationMethodId(String name) throws SQLException
   :outertype: RunResultSQLCommunicator_pg

getRunAnalysisId
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunAnalysisId(int runId) throws SQLException
   :outertype: RunResultSQLCommunicator_pg

getRunExecutionId
^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunExecutionId(int runId) throws SQLException
   :outertype: RunResultSQLCommunicator_pg

getRunId
^^^^^^^^

.. java:method:: @Override protected int getRunId(Run run) throws SQLException
   :outertype: RunResultSQLCommunicator_pg

getRunResultExecutionId
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultExecutionId(int runResultId) throws SQLException
   :outertype: RunResultSQLCommunicator_pg

getRunResultFormatId
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultFormatId(String runResultFormatSimpleName) throws SQLException
   :outertype: RunResultSQLCommunicator_pg

getRunResultId
^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultId(String uniqueRunIdentifier) throws SQLException
   :outertype: RunResultSQLCommunicator_pg

getRunTypeId
^^^^^^^^^^^^

.. java:method:: @Override protected int getRunTypeId(String name) throws SQLException
   :outertype: RunResultSQLCommunicator_pg

getStatisticId
^^^^^^^^^^^^^^

.. java:method:: @Override protected int getStatisticId(String statisticsName) throws SQLException
   :outertype: RunResultSQLCommunicator_pg

initDB
^^^^^^

.. java:method:: @Override public void initDB()
   :outertype: RunResultSQLCommunicator_pg

register
^^^^^^^^

.. java:method:: @Override protected int register(ProgramConfig object, boolean updateOnly)
   :outertype: RunResultSQLCommunicator_pg

