.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util Arrays

.. java:import:: java.util List

.. java:import:: utils SimilarityMatrix

.. java:import:: utils SimilarityMatrix.NUMBER_PRECISION

.. java:import:: de.clusteval.data.dataset DataSet.WEBSITE_VISIBILITY

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format RelativeDataSetFormat

.. java:import:: de.clusteval.data.dataset.type DataSetType

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

RelativeDataSet
===============

.. java:package:: de.clusteval.data.dataset
   :noindex:

.. java:type:: public class RelativeDataSet extends DataSet

   A relative dataset contains data in terms of pairwise similarities or distances between object pairs. From these no absolute coordinates of the objects can be deduced. Thus a relative dataset can never be converted to an absolute dataset (lossfree).

   :author: Christian Wiwie

Constructors
------------
RelativeDataSet
^^^^^^^^^^^^^^^

.. java:constructor:: public RelativeDataSet(Repository repository, boolean register, long changeDate, File absPath, String alias, RelativeDataSetFormat dsFormat, DataSetType dsType, WEBSITE_VISIBILITY websiteVisibility) throws RegisterException
   :outertype: RelativeDataSet

   :param repository: the repository this dataset should be registered at.
   :param register: Whether this dataset should be registered in the repository.
   :param changeDate: The change date of this dataset is used for equality checks.
   :param absPath: The absolute path of this dataset.
   :param alias: A short alias name for this data set.
   :param dsFormat: The format of this dataset.
   :param dsType: The type of this dataset
   :throws RegisterException:

RelativeDataSet
^^^^^^^^^^^^^^^

.. java:constructor:: public RelativeDataSet(RelativeDataSet dataset) throws RegisterException
   :outertype: RelativeDataSet

   :param dataset:
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public RelativeDataSet clone()
   :outertype: RelativeDataSet

getDataSetContent
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public SimilarityMatrix getDataSetContent()
   :outertype: RelativeDataSet

getDataSetFormat
^^^^^^^^^^^^^^^^

.. java:method:: @Override public RelativeDataSetFormat getDataSetFormat()
   :outertype: RelativeDataSet

getIds
^^^^^^

.. java:method:: @Override public List<String> getIds()
   :outertype: RelativeDataSet

isInMemory
^^^^^^^^^^

.. java:method:: @Override public boolean isInMemory()
   :outertype: RelativeDataSet

loadIntoMemory
^^^^^^^^^^^^^^

.. java:method:: @Override public boolean loadIntoMemory(NUMBER_PRECISION precision) throws IllegalArgumentException, IOException, InvalidDataSetFormatVersionException
   :outertype: RelativeDataSet

setDataSetContent
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean setDataSetContent(Object newContent)
   :outertype: RelativeDataSet

unloadFromMemory
^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean unloadFromMemory()
   :outertype: RelativeDataSet

