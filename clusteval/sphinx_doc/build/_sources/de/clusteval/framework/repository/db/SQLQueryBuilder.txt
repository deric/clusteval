.. java:import:: java.sql Connection

.. java:import:: java.sql SQLException

.. java:import:: java.sql Statement

.. java:import:: java.util List

SQLQueryBuilder
===============

.. java:package:: de.clusteval.framework.repository.db
   :noindex:

.. java:type:: public abstract class SQLQueryBuilder

   :author: Christian Wiwie

Fields
------
sqlConfig
^^^^^^^^^

.. java:field:: protected SQLConfig sqlConfig
   :outertype: SQLQueryBuilder

Constructors
------------
SQLQueryBuilder
^^^^^^^^^^^^^^^

.. java:constructor:: public SQLQueryBuilder(SQLConfig sqlConfig)
   :outertype: SQLQueryBuilder

   :param sqlConfig:

Methods
-------
checkIfPresent
^^^^^^^^^^^^^^

.. java:method:: protected abstract String checkIfPresent(String table, String column, String value)
   :outertype: SQLQueryBuilder

createStatement
^^^^^^^^^^^^^^^

.. java:method:: protected abstract Statement createStatement(Connection conn) throws SQLException
   :outertype: SQLQueryBuilder

createTableLike
^^^^^^^^^^^^^^^

.. java:method:: protected abstract String createTableLike(String table, String otherTable)
   :outertype: SQLQueryBuilder

delete
^^^^^^

.. java:method:: protected abstract String delete(String tableName, String value, String columnName)
   :outertype: SQLQueryBuilder

delete
^^^^^^

.. java:method:: protected abstract String delete(String tableName, String[] value, String[] columnName)
   :outertype: SQLQueryBuilder

deleteWhereIn
^^^^^^^^^^^^^

.. java:method:: protected abstract String deleteWhereIn(String tableName, String[] value, String columnName)
   :outertype: SQLQueryBuilder

dropTable
^^^^^^^^^

.. java:method:: protected abstract String dropTable(String table)
   :outertype: SQLQueryBuilder

getConnectionstring
^^^^^^^^^^^^^^^^^^^

.. java:method:: public abstract String getConnectionstring()
   :outertype: SQLQueryBuilder

   :param config:

insert
^^^^^^

.. java:method:: protected abstract String insert(String tableName, String[] columnNames, List<String[]> values)
   :outertype: SQLQueryBuilder

insert
^^^^^^

.. java:method:: protected abstract String insert(String tableName, String[] columnNames, String[] values)
   :outertype: SQLQueryBuilder

insertSelectWhereNotIn
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String insertSelectWhereNotIn(String tableName, String selectTable, String columnName, String[] values)
   :outertype: SQLQueryBuilder

refreshMaterializedView
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract String refreshMaterializedView(String view)
   :outertype: SQLQueryBuilder

renameTable
^^^^^^^^^^^

.. java:method:: protected abstract String renameTable(String table, String newTableName)
   :outertype: SQLQueryBuilder

select
^^^^^^

.. java:method:: protected abstract String select(String tableName, String columnName, String[] columnNames, String[] values)
   :outertype: SQLQueryBuilder

update
^^^^^^

.. java:method:: protected abstract String update(String tableName, String[] columnNames, String[] values, int rowId)
   :outertype: SQLQueryBuilder

