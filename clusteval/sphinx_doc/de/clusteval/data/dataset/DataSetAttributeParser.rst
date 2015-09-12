.. java:import:: java.io IOException

.. java:import:: java.util HashMap

.. java:import:: java.util Map

.. java:import:: java.util.regex Matcher

.. java:import:: java.util.regex Pattern

.. java:import:: utils.parse TextFileParser

DataSetAttributeParser
======================

.. java:package:: de.clusteval.data.dataset
   :noindex:

.. java:type:: public class DataSetAttributeParser extends TextFileParser

   :author: Christian Wiwie

Fields
------
attributeLinePrefix
^^^^^^^^^^^^^^^^^^^

.. java:field:: public static String attributeLinePrefix
   :outertype: DataSetAttributeParser

   Is used to determine whether a line contains an attribute

attributeLinePrefixPattern
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: public static Pattern attributeLinePrefixPattern
   :outertype: DataSetAttributeParser

   The pattern build from the attributeLinePrefix

attributeValues
^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, String> attributeValues
   :outertype: DataSetAttributeParser

Constructors
------------
DataSetAttributeParser
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetAttributeParser(String absFilePath) throws IOException
   :outertype: DataSetAttributeParser

   :param absFilePath:
   :throws IOException:

Methods
-------
getAttributeValues
^^^^^^^^^^^^^^^^^^

.. java:method:: public Map<String, String> getAttributeValues()
   :outertype: DataSetAttributeParser

   :return: A map containing all attributes together with their values.

processLine
^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected void processLine(String[] key, String[] value)
   :outertype: DataSetAttributeParser

