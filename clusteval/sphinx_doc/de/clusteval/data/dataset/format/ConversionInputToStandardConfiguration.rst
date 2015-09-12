.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: utils SimilarityMatrix.NUMBER_PRECISION

.. java:import:: de.clusteval.data.distance DistanceMeasure

.. java:import:: de.clusteval.data.preprocessing DataPreprocessor

ConversionInputToStandardConfiguration
======================================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: public class ConversionInputToStandardConfiguration extends ConversionConfiguration

   :author: Christian Wiwie

Fields
------
distanceMeasureAbsoluteToRelative
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected DistanceMeasure distanceMeasureAbsoluteToRelative
   :outertype: ConversionInputToStandardConfiguration

preprocessorsAfterDistance
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected List<DataPreprocessor> preprocessorsAfterDistance
   :outertype: ConversionInputToStandardConfiguration

preprocessorsBeforeDistance
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected List<DataPreprocessor> preprocessorsBeforeDistance
   :outertype: ConversionInputToStandardConfiguration

similarityPrecision
^^^^^^^^^^^^^^^^^^^

.. java:field:: protected NUMBER_PRECISION similarityPrecision
   :outertype: ConversionInputToStandardConfiguration

Constructors
------------
ConversionInputToStandardConfiguration
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ConversionInputToStandardConfiguration(DistanceMeasure distanceMeasure, NUMBER_PRECISION similarityPrecision, List<DataPreprocessor> preprocessorsBeforeDistance, List<DataPreprocessor> preprocessorsAfterDistance)
   :outertype: ConversionInputToStandardConfiguration

   :param distanceMeasure:
   :param preprocessorsBeforeDistance:
   :param preprocessorsAfterDistance:

ConversionInputToStandardConfiguration
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ConversionInputToStandardConfiguration(ConversionInputToStandardConfiguration other)
   :outertype: ConversionInputToStandardConfiguration

   The copy constructor for this class.

   :param other: The object to clone.

Methods
-------
clone
^^^^^

.. java:method:: @Override public ConversionInputToStandardConfiguration clone()
   :outertype: ConversionInputToStandardConfiguration

clonePreprocessors
^^^^^^^^^^^^^^^^^^

.. java:method:: protected static List<DataPreprocessor> clonePreprocessors(List<DataPreprocessor> preprocessors)
   :outertype: ConversionInputToStandardConfiguration

equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: ConversionInputToStandardConfiguration

getDistanceMeasureAbsoluteToRelative
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public DistanceMeasure getDistanceMeasureAbsoluteToRelative()
   :outertype: ConversionInputToStandardConfiguration

   :return: The distance measure to use during the conversion of absolute to relative datasets.

getPreprocessorsAfterDistance
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<DataPreprocessor> getPreprocessorsAfterDistance()
   :outertype: ConversionInputToStandardConfiguration

   :return: The preprocessors to apply to the dataset after it is converted to pairwise distances/similarities.

getPreprocessorsBeforeDistance
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<DataPreprocessor> getPreprocessorsBeforeDistance()
   :outertype: ConversionInputToStandardConfiguration

   :return: The preprocessors to apply to the dataset before it is converted to pairwise distances/similarities.

getSimilarityPrecision
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public NUMBER_PRECISION getSimilarityPrecision()
   :outertype: ConversionInputToStandardConfiguration

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: ConversionInputToStandardConfiguration

