.. java:import:: java.sql DriverManager

.. java:import:: java.sql ResultSet

.. java:import:: java.sql SQLException

.. java:import:: java.sql Statement

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.run Run

RunResultSQLCommunicator
========================

.. java:package:: de.clusteval.framework.repository.db
   :noindex:

.. java:type:: public class RunResultSQLCommunicator extends DefaultSQLCommunicator

   :author: Christian Wiwie

Constructors
------------
RunResultSQLCommunicator
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultSQLCommunicator(Repository repository, SQLConfig mysqlConfig) throws DatabaseConnectException
   :outertype: RunResultSQLCommunicator

   :param repository:
   :param mysqlConfig:
   :throws DatabaseConnectException:

Methods
-------
getDataSetFormatId
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getDataSetFormatId(String dataSetFormatClassSimpleName) throws SQLException
   :outertype: RunResultSQLCommunicator

getDataSetTypeId
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getDataSetTypeId(String dataSetTypeClassSimpleName) throws SQLException
   :outertype: RunResultSQLCommunicator

getParameterOptimizationMethodId
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getParameterOptimizationMethodId(String name) throws SQLException
   :outertype: RunResultSQLCommunicator

getRunAnalysisId
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunAnalysisId(int runId) throws SQLException
   :outertype: RunResultSQLCommunicator

getRunExecutionId
^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunExecutionId(int runId) throws SQLException
   :outertype: RunResultSQLCommunicator

getRunId
^^^^^^^^

.. java:method:: @Override protected int getRunId(Run run) throws SQLException
   :outertype: RunResultSQLCommunicator

getRunResultExecutionId
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultExecutionId(int runResultId) throws SQLException
   :outertype: RunResultSQLCommunicator

getRunResultFormatId
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultFormatId(String runResultFormatSimpleName) throws SQLException
   :outertype: RunResultSQLCommunicator

getRunResultId
^^^^^^^^^^^^^^

.. java:method:: @Override protected int getRunResultId(String uniqueRunIdentifier) throws SQLException
   :outertype: RunResultSQLCommunicator

getRunTypeId
^^^^^^^^^^^^

.. java:method:: @Override protected int getRunTypeId(String name) throws SQLException
   :outertype: RunResultSQLCommunicator

getStatisticId
^^^^^^^^^^^^^^

.. java:method:: @Override protected int getStatisticId(String statisticsName) throws SQLException
   :outertype: RunResultSQLCommunicator

initDB
^^^^^^

.. java:method:: @Override public void initDB()
   :outertype: RunResultSQLCommunicator

register
^^^^^^^^

.. java:method:: @Override protected int register(ProgramConfig object, boolean updateOnly)
   :outertype: RunResultSQLCommunicator

