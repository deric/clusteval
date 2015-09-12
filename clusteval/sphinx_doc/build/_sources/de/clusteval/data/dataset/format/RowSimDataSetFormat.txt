.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils FormatVersion

RowSimDataSetFormat
===================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: @FormatVersion public class RowSimDataSetFormat extends RelativeDataSetFormat

   :author: Christian Wiwie

Constructors
------------
RowSimDataSetFormat
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RowSimDataSetFormat(Repository repo, boolean register, long changeDate, File absPath, int version) throws RegisterException
   :outertype: RowSimDataSetFormat

   Instantiates a new row sim data set format.

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param version:
   :throws RegisterException:

RowSimDataSetFormat
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RowSimDataSetFormat(RowSimDataSetFormat other) throws RegisterException
   :outertype: RowSimDataSetFormat

   The copy constructor for this format.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: RowSimDataSetFormat

getDataSetFormatParser
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected DataSetFormatParser getDataSetFormatParser()
   :outertype: RowSimDataSetFormat

