.. java:import:: java.io IOException

.. java:import:: java.util Map

.. java:import:: utils StringExt

clusterONERunResultFormatParser
===============================

.. java:package:: de.clusteval.run.result.format
   :noindex:

.. java:type:: public class clusterONERunResultFormatParser extends RunResultFormatParser

   :author: Christian Wiwie

Constructors
------------
clusterONERunResultFormatParser
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public clusterONERunResultFormatParser(Map<String, String> internalParams, Map<String, String> params, String absFilePath) throws IOException
   :outertype: clusterONERunResultFormatParser

   :param internalParams:
   :param params:
   :param absFilePath:
   :throws IOException:

Methods
-------
convertToStandardFormat
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void convertToStandardFormat() throws IOException
   :outertype: clusterONERunResultFormatParser

getLineOutput
^^^^^^^^^^^^^

.. java:method:: @Override protected String getLineOutput(String[] key, String[] value)
   :outertype: clusterONERunResultFormatParser

processLine
^^^^^^^^^^^

.. java:method:: @Override protected void processLine(String[] key, String[] value)
   :outertype: clusterONERunResultFormatParser

