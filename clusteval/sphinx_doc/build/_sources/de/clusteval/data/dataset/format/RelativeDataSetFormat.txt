.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: utils SimilarityMatrix

.. java:import:: utils SimilarityMatrix.NUMBER_PRECISION

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

RelativeDataSetFormat
=====================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: public abstract class RelativeDataSetFormat extends DataSetFormat

   :author: Christian Wiwie

Constructors
------------
RelativeDataSetFormat
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RelativeDataSetFormat(Repository repo, boolean register, long changeDate, File absPath, int version) throws RegisterException
   :outertype: RelativeDataSetFormat

   Instantiates a new relative data set format.

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param version:
   :throws RegisterException:

RelativeDataSetFormat
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RelativeDataSetFormat(RelativeDataSetFormat other) throws RegisterException
   :outertype: RelativeDataSetFormat

   The copy constructor for this format.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
parse
^^^^^

.. java:method:: @Override public final SimilarityMatrix parse(DataSet dataSet, NUMBER_PRECISION precision) throws IllegalArgumentException, IOException, InvalidDataSetFormatVersionException
   :outertype: RelativeDataSetFormat

