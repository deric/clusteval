.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util Arrays

.. java:import:: java.util List

.. java:import:: utils SimilarityMatrix.NUMBER_PRECISION

.. java:import:: de.clusteval.data.dataset DataSet.WEBSITE_VISIBILITY

.. java:import:: de.clusteval.data.dataset.format AbsoluteDataSetFormat

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.type DataSetType

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

AbsoluteDataSet
===============

.. java:package:: de.clusteval.data.dataset
   :noindex:

.. java:type:: public class AbsoluteDataSet extends DataSet

   An absolute dataset contains data in terms of absolute coordinates, that means similarities between object pairs can be calculated by looking at the absolute coordinates of two objects.

   :author: Christian Wiwie

Constructors
------------
AbsoluteDataSet
^^^^^^^^^^^^^^^

.. java:constructor:: public AbsoluteDataSet(Repository repository, boolean register, long changeDate, File absPath, String alias, AbsoluteDataSetFormat dsFormat, DataSetType dsType, WEBSITE_VISIBILITY websiteVisibility) throws RegisterException
   :outertype: AbsoluteDataSet

   :param repository: the repository this dataset should be registered at.
   :param register: Whether this dataset should be registered in the repository.
   :param changeDate: The change date of this dataset is used for equality checks.
   :param alias: A short alias name for this data set.
   :param absPath: The absolute path of this dataset.
   :param dsFormat: The format of this dataset.
   :param dsType: The type of this dataset
   :throws RegisterException:

AbsoluteDataSet
^^^^^^^^^^^^^^^

.. java:constructor:: public AbsoluteDataSet(AbsoluteDataSet dataset) throws RegisterException
   :outertype: AbsoluteDataSet

   :param dataset:
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public AbsoluteDataSet clone()
   :outertype: AbsoluteDataSet

getDataSetContent
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public DataMatrix getDataSetContent()
   :outertype: AbsoluteDataSet

getDataSetFormat
^^^^^^^^^^^^^^^^

.. java:method:: @Override public AbsoluteDataSetFormat getDataSetFormat()
   :outertype: AbsoluteDataSet

getIds
^^^^^^

.. java:method:: @Override public List<String> getIds()
   :outertype: AbsoluteDataSet

isInMemory
^^^^^^^^^^

.. java:method:: @Override public boolean isInMemory()
   :outertype: AbsoluteDataSet

loadIntoMemory
^^^^^^^^^^^^^^

.. java:method:: @Override public boolean loadIntoMemory(NUMBER_PRECISION precision) throws IllegalArgumentException, IOException, InvalidDataSetFormatVersionException
   :outertype: AbsoluteDataSet

setDataSetContent
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean setDataSetContent(Object newContent)
   :outertype: AbsoluteDataSet

unloadFromMemory
^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean unloadFromMemory()
   :outertype: AbsoluteDataSet

