.. java:import:: java.sql Connection

.. java:import:: java.sql ResultSet

.. java:import:: java.sql SQLException

.. java:import:: java.sql Statement

.. java:import:: java.util List

PostgreSQLQueryBuilder
======================

.. java:package:: de.clusteval.framework.repository.db
   :noindex:

.. java:type:: public class PostgreSQLQueryBuilder extends SQLQueryBuilder

   :author: Christian Wiwie

Constructors
------------
PostgreSQLQueryBuilder
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public PostgreSQLQueryBuilder(SQLConfig sqlConfig)
   :outertype: PostgreSQLQueryBuilder

   :param sqlConfig:

Methods
-------
checkIfPresent
^^^^^^^^^^^^^^

.. java:method:: @Override protected String checkIfPresent(String table, String column, String value)
   :outertype: PostgreSQLQueryBuilder

createStatement
^^^^^^^^^^^^^^^

.. java:method:: @Override protected Statement createStatement(Connection conn) throws SQLException
   :outertype: PostgreSQLQueryBuilder

createTableLike
^^^^^^^^^^^^^^^

.. java:method:: @Override protected String createTableLike(String table, String otherTable)
   :outertype: PostgreSQLQueryBuilder

delete
^^^^^^

.. java:method:: @Override protected String delete(String tableName, String value, String columnName)
   :outertype: PostgreSQLQueryBuilder

delete
^^^^^^

.. java:method:: @Override protected String delete(String tableName, String[] value, String[] columnName)
   :outertype: PostgreSQLQueryBuilder

deleteWhereIn
^^^^^^^^^^^^^

.. java:method:: @Override protected String deleteWhereIn(String tableName, String[] value, String columnName)
   :outertype: PostgreSQLQueryBuilder

dropTable
^^^^^^^^^

.. java:method:: @Override protected String dropTable(String table)
   :outertype: PostgreSQLQueryBuilder

getConnectionstring
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public String getConnectionstring()
   :outertype: PostgreSQLQueryBuilder

insert
^^^^^^

.. java:method:: @Override protected String insert(String tableName, String[] columnNames, List<String[]> values)
   :outertype: PostgreSQLQueryBuilder

insert
^^^^^^

.. java:method:: @Override protected String insert(String tableName, String[] columnNames, String[] values)
   :outertype: PostgreSQLQueryBuilder

insertSelectWhereNotIn
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String insertSelectWhereNotIn(String tableName, String selectTable, String columnName, String[] values)
   :outertype: PostgreSQLQueryBuilder

refreshMaterializedView
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String refreshMaterializedView(String view)
   :outertype: PostgreSQLQueryBuilder

renameTable
^^^^^^^^^^^

.. java:method:: @Override protected String renameTable(String table, String newTableName)
   :outertype: PostgreSQLQueryBuilder

select
^^^^^^

.. java:method:: @Override protected String select(String tableName, String columnName, String[] columnNames, String[] values)
   :outertype: PostgreSQLQueryBuilder

update
^^^^^^

.. java:method:: @Override protected String update(String tableName, String[] columnNames, String[] values, int rowId)
   :outertype: PostgreSQLQueryBuilder

