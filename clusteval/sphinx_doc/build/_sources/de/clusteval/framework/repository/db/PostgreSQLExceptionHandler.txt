.. java:import:: java.sql SQLException

PostgreSQLExceptionHandler
==========================

.. java:package:: de.clusteval.framework.repository.db
   :noindex:

.. java:type:: public class PostgreSQLExceptionHandler extends SQLExceptionHandler

   :author: Christian Wiwie

Constructors
------------
PostgreSQLExceptionHandler
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public PostgreSQLExceptionHandler(SQLCommunicator sqlCommunicator)
   :outertype: PostgreSQLExceptionHandler

   :param conn:

Methods
-------
handleException
^^^^^^^^^^^^^^^

.. java:method:: @Override public void handleException(SQLException e)
   :outertype: PostgreSQLExceptionHandler

