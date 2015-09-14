.. java:import:: java.io IOException

.. java:import:: java.util Map

TabSeparatedRunResultFormatParser
=================================

.. java:package:: de.clusteval.run.result.format
   :noindex:

.. java:type:: public class TabSeparatedRunResultFormatParser extends RunResultFormatParser

   This class is a dummy class and is not going to be used.

   :author: Christian Wiwie

Constructors
------------
TabSeparatedRunResultFormatParser
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public TabSeparatedRunResultFormatParser(Map<String, String> internalParams, Map<String, String> params, String absFilePath) throws IOException
   :outertype: TabSeparatedRunResultFormatParser

   :param internalParams:
   :param params:
   :param absFilePath:
   :throws IOException:

Methods
-------
convertToStandardFormat
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void convertToStandardFormat()
   :outertype: TabSeparatedRunResultFormatParser

getLineOutput
^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected String getLineOutput(String[] key, String[] value)
   :outertype: TabSeparatedRunResultFormatParser

processLine
^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected void processLine(String[] key, String[] value)
   :outertype: TabSeparatedRunResultFormatParser

