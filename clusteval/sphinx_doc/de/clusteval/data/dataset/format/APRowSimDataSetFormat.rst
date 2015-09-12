.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils FormatVersion

APRowSimDataSetFormat
=====================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: @FormatVersion public class APRowSimDataSetFormat extends RowSimDataSetFormat

   This input format is used by Affinity Propagation. It is similar to the RowSimDataSet-Format, except that it accepts only numbers as ids and that it leaves out lines where id1=id2. Example::

       1    2    0.2
       1    3    0.6
       2    1    0.2
       2    3    0.5
       3    1    0.6
       3    2    0.5

   :author: Christian Wiwie

Constructors
------------
APRowSimDataSetFormat
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public APRowSimDataSetFormat(Repository repo, boolean register, long changeDate, File absPath, int version) throws RegisterException
   :outertype: APRowSimDataSetFormat

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param version:
   :throws RegisterException:

APRowSimDataSetFormat
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public APRowSimDataSetFormat(APRowSimDataSetFormat other) throws RegisterException
   :outertype: APRowSimDataSetFormat

   The copy constructor for this format.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: APRowSimDataSetFormat

getDataSetFormatParser
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected DataSetFormatParser getDataSetFormatParser()
   :outertype: APRowSimDataSetFormat

moveDataSetTo
^^^^^^^^^^^^^

.. java:method:: @Override public boolean moveDataSetTo(DataSet dataSet, File moveDestination, boolean overwrite)
   :outertype: APRowSimDataSetFormat

