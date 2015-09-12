DataMatrix
==========

.. java:package:: de.clusteval.data.dataset
   :noindex:

.. java:type:: public class DataMatrix

   This is a wrapper class for absolute data that needs to be stored in memory. The absolute coordinate values are stored as double values in a sparse matrix. That means default values of the matrix are not stored in memory.

   :author: Christian Wiwie

Fields
------
data
^^^^

.. java:field:: protected double[][] data
   :outertype: DataMatrix

ids
^^^

.. java:field:: protected String[] ids
   :outertype: DataMatrix

Constructors
------------
DataMatrix
^^^^^^^^^^

.. java:constructor:: public DataMatrix(String[] ids, double[][] data)
   :outertype: DataMatrix

   :param ids:
   :param data:

Methods
-------
getData
^^^^^^^

.. java:method:: public double[][] getData()
   :outertype: DataMatrix

   :return: The absolute coordinates of the objects contained in this matrix.

getIds
^^^^^^

.. java:method:: public String[] getIds()
   :outertype: DataMatrix

   :return: The object ids contained in this matrix.

