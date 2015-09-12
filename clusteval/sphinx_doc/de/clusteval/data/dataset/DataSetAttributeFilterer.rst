.. java:import:: java.io IOException

.. java:import:: utils.parse TextFileParser

DataSetAttributeFilterer
========================

.. java:package:: de.clusteval.data.dataset
   :noindex:

.. java:type:: public class DataSetAttributeFilterer extends TextFileParser

   :author: Christian Wiwie

Constructors
------------
DataSetAttributeFilterer
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetAttributeFilterer(String absFilePath) throws IOException
   :outertype: DataSetAttributeFilterer

   :param absFilePath:
   :throws IOException:

Methods
-------
checkLine
^^^^^^^^^

.. java:method:: @Override protected boolean checkLine(String line)
   :outertype: DataSetAttributeFilterer

getLineOutput
^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected String getLineOutput(String[] key, String[] value)
   :outertype: DataSetAttributeFilterer

isLockingTargetFile
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean isLockingTargetFile()
   :outertype: DataSetAttributeFilterer

processLine
^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected void processLine(String[] key, String[] value)
   :outertype: DataSetAttributeFilterer

