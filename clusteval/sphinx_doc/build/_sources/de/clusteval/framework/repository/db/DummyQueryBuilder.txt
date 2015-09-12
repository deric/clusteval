.. java:import:: java.sql Connection

.. java:import:: java.sql SQLException

.. java:import:: java.sql Statement

.. java:import:: java.util List

DummyQueryBuilder
=================

.. java:package:: de.clusteval.framework.repository.db
   :noindex:

.. java:type:: public class DummyQueryBuilder extends SQLQueryBuilder

   :author: Christian Wiwie

Constructors
------------
DummyQueryBuilder
^^^^^^^^^^^^^^^^^

.. java:constructor:: public DummyQueryBuilder(SQLConfig sqlConfig)
   :outertype: DummyQueryBuilder

   :param sqlConfig:

Methods
-------
checkIfPresent
^^^^^^^^^^^^^^

.. java:method:: @Override protected String checkIfPresent(String table, String column, String value)
   :outertype: DummyQueryBuilder

createStatement
^^^^^^^^^^^^^^^

.. java:method:: @Override protected Statement createStatement(Connection conn) throws SQLException
   :outertype: DummyQueryBuilder

createTableLike
^^^^^^^^^^^^^^^

.. java:method:: @Override protected String createTableLike(String table, String otherTable)
   :outertype: DummyQueryBuilder

delete
^^^^^^

.. java:method:: @Override protected String delete(String tableName, String value, String columnName)
   :outertype: DummyQueryBuilder

delete
^^^^^^

.. java:method:: @Override protected String delete(String tableName, String[] value, String[] columnName)
   :outertype: DummyQueryBuilder

deleteWhereIn
^^^^^^^^^^^^^

.. java:method:: @Override protected String deleteWhereIn(String tableName, String[] value, String columnName)
   :outertype: DummyQueryBuilder

dropTable
^^^^^^^^^

.. java:method:: @Override protected String dropTable(String table)
   :outertype: DummyQueryBuilder

getConnectionstring
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public String getConnectionstring()
   :outertype: DummyQueryBuilder

insert
^^^^^^

.. java:method:: @Override protected String insert(String tableName, String[] columnNames, List<String[]> values)
   :outertype: DummyQueryBuilder

insert
^^^^^^

.. java:method:: @Override protected String insert(String tableName, String[] columnNames, String[] values)
   :outertype: DummyQueryBuilder

insertSelectWhereNotIn
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String insertSelectWhereNotIn(String tableName, String selectTable, String columnName, String[] values)
   :outertype: DummyQueryBuilder

refreshMaterializedView
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String refreshMaterializedView(String view)
   :outertype: DummyQueryBuilder

renameTable
^^^^^^^^^^^

.. java:method:: @Override protected String renameTable(String table, String newTableName)
   :outertype: DummyQueryBuilder

select
^^^^^^

.. java:method:: @Override protected String select(String tableName, String columnName, String[] columnNames, String[] values)
   :outertype: DummyQueryBuilder

update
^^^^^^

.. java:method:: @Override protected String update(String tableName, String[] columnNames, String[] values, int rowId)
   :outertype: DummyQueryBuilder

