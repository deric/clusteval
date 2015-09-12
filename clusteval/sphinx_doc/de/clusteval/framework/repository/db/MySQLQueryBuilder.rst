.. java:import:: java.sql Connection

.. java:import:: java.sql SQLException

.. java:import:: java.sql Statement

.. java:import:: java.util List

MySQLQueryBuilder
=================

.. java:package:: de.clusteval.framework.repository.db
   :noindex:

.. java:type:: public class MySQLQueryBuilder extends SQLQueryBuilder

   :author: Christian Wiwie

Constructors
------------
MySQLQueryBuilder
^^^^^^^^^^^^^^^^^

.. java:constructor:: public MySQLQueryBuilder(SQLConfig sqlConfig)
   :outertype: MySQLQueryBuilder

   :param sqlConfig:

Methods
-------
checkIfPresent
^^^^^^^^^^^^^^

.. java:method:: @Override protected String checkIfPresent(String table, String column, String value)
   :outertype: MySQLQueryBuilder

createStatement
^^^^^^^^^^^^^^^

.. java:method:: @Override protected Statement createStatement(Connection conn) throws SQLException
   :outertype: MySQLQueryBuilder

createTableLike
^^^^^^^^^^^^^^^

.. java:method:: @Override protected String createTableLike(String table, String otherTable)
   :outertype: MySQLQueryBuilder

delete
^^^^^^

.. java:method:: @Override protected String delete(String tableName, String value, String columnName)
   :outertype: MySQLQueryBuilder

delete
^^^^^^

.. java:method:: @Override protected String delete(String tableName, String[] value, String[] columnName)
   :outertype: MySQLQueryBuilder

deleteWhereIn
^^^^^^^^^^^^^

.. java:method:: @Override protected String deleteWhereIn(String tableName, String[] value, String columnName)
   :outertype: MySQLQueryBuilder

dropTable
^^^^^^^^^

.. java:method:: @Override protected String dropTable(String table)
   :outertype: MySQLQueryBuilder

getConnectionstring
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public String getConnectionstring()
   :outertype: MySQLQueryBuilder

insert
^^^^^^

.. java:method:: @Override protected String insert(String tableName, String[] columnNames, List<String[]> values)
   :outertype: MySQLQueryBuilder

insert
^^^^^^

.. java:method:: @Override protected String insert(String tableName, String[] columnNames, String[] values)
   :outertype: MySQLQueryBuilder

insertSelectWhereNotIn
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String insertSelectWhereNotIn(String tableName, String selectTable, String columnName, String[] values)
   :outertype: MySQLQueryBuilder

refreshMaterializedView
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String refreshMaterializedView(String view)
   :outertype: MySQLQueryBuilder

renameTable
^^^^^^^^^^^

.. java:method:: @Override protected String renameTable(String table, String newTableName)
   :outertype: MySQLQueryBuilder

select
^^^^^^

.. java:method:: @Override protected String select(String tableName, String columnName, String[] columnNames, String[] values)
   :outertype: MySQLQueryBuilder

update
^^^^^^

.. java:method:: @Override protected String update(String tableName, String[] columnNames, String[] values, int rowId)
   :outertype: MySQLQueryBuilder

