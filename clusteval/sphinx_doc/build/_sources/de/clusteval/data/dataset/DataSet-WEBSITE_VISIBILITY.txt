.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.security InvalidParameterException

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: utils SimilarityMatrix.NUMBER_PRECISION

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.data.dataset.format AbsoluteDataSetFormat

.. java:import:: de.clusteval.data.dataset.format ConversionInputToStandardConfiguration

.. java:import:: de.clusteval.data.dataset.format ConversionStandardToInputConfiguration

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.data.dataset.format DataSetFormatParser

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format RelativeDataSetFormat

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.dataset.type DataSetType

.. java:import:: de.clusteval.data.preprocessing DataPreprocessor

.. java:import:: de.clusteval.framework ClustevalBackendServer

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryEvent

.. java:import:: de.clusteval.framework.repository RepositoryMoveEvent

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.framework.repository RepositoryRemoveEvent

.. java:import:: de.clusteval.framework.repository RepositoryReplaceEvent

.. java:import:: de.clusteval.utils FormatConversionException

.. java:import:: de.clusteval.utils NamedDoubleAttribute

.. java:import:: de.clusteval.utils NamedIntegerAttribute

.. java:import:: de.clusteval.utils RNotAvailableException

DataSet.WEBSITE_VISIBILITY
==========================

.. java:package:: de.clusteval.data.dataset
   :noindex:

.. java:type:: public enum WEBSITE_VISIBILITY
   :outertype: DataSet

   This enum describes the visibility of a dataset on the website.

   :author: Christian Wiwie

Enum Constants
--------------
HIDE
^^^^

.. java:field:: public static final DataSet.WEBSITE_VISIBILITY HIDE
   :outertype: DataSet.WEBSITE_VISIBILITY

   This dataset is not visible on the website at all. It is not even listed in the list of all datasets.

SHOW_ALWAYS
^^^^^^^^^^^

.. java:field:: public static final DataSet.WEBSITE_VISIBILITY SHOW_ALWAYS
   :outertype: DataSet.WEBSITE_VISIBILITY

   This dataset is listed and also selected to be shown by default on the website.

SHOW_OPTIONAL
^^^^^^^^^^^^^

.. java:field:: public static final DataSet.WEBSITE_VISIBILITY SHOW_OPTIONAL
   :outertype: DataSet.WEBSITE_VISIBILITY

   The dataset is listed under all datasets, but not selected by default.

