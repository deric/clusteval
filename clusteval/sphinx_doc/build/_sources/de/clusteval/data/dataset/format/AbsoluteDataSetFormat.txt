.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: utils SimilarityMatrix.NUMBER_PRECISION

.. java:import:: de.clusteval.data.dataset DataMatrix

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

AbsoluteDataSetFormat
=====================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: public abstract class AbsoluteDataSetFormat extends DataSetFormat

   :author: Christian Wiwie

Constructors
------------
AbsoluteDataSetFormat
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public AbsoluteDataSetFormat(Repository repo, boolean register, long changeDate, File absPath, int version) throws RegisterException
   :outertype: AbsoluteDataSetFormat

   Instantiates a new absolute data set format.

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param version:
   :throws RegisterException:

AbsoluteDataSetFormat
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public AbsoluteDataSetFormat(AbsoluteDataSetFormat other) throws RegisterException
   :outertype: AbsoluteDataSetFormat

   The copy constructor for this format.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
parse
^^^^^

.. java:method:: @Override public final DataMatrix parse(DataSet dataSet, NUMBER_PRECISION precision) throws IllegalArgumentException, IOException, InvalidDataSetFormatVersionException
   :outertype: AbsoluteDataSetFormat

