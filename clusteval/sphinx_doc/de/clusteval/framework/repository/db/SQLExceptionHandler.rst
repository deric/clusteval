.. java:import:: java.sql Connection

.. java:import:: java.sql SQLException

SQLExceptionHandler
===================

.. java:package:: de.clusteval.framework.repository.db
   :noindex:

.. java:type:: public abstract class SQLExceptionHandler

   :author: Christian Wiwie

Fields
------
sqlCommunicator
^^^^^^^^^^^^^^^

.. java:field:: protected SQLCommunicator sqlCommunicator
   :outertype: SQLExceptionHandler

Constructors
------------
SQLExceptionHandler
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SQLExceptionHandler(SQLCommunicator sqlCommunicator)
   :outertype: SQLExceptionHandler

Methods
-------
handleException
^^^^^^^^^^^^^^^

.. java:method:: public abstract void handleException(SQLException e)
   :outertype: SQLExceptionHandler

