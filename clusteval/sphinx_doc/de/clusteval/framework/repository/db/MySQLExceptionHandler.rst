.. java:import:: java.sql Connection

.. java:import:: java.sql SQLException

MySQLExceptionHandler
=====================

.. java:package:: de.clusteval.framework.repository.db
   :noindex:

.. java:type:: public class MySQLExceptionHandler extends SQLExceptionHandler

   :author: Christian Wiwie

Constructors
------------
MySQLExceptionHandler
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public MySQLExceptionHandler(SQLCommunicator sqlCommunicator)
   :outertype: MySQLExceptionHandler

   :param conn:

Methods
-------
handleException
^^^^^^^^^^^^^^^

.. java:method:: @Override public void handleException(SQLException e)
   :outertype: MySQLExceptionHandler

