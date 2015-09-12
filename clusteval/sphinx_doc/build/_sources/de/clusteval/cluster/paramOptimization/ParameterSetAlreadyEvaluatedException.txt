.. java:import:: de.clusteval.program ParameterSet

ParameterSetAlreadyEvaluatedException
=====================================

.. java:package:: de.clusteval.cluster.paramOptimization
   :noindex:

.. java:type:: public class ParameterSetAlreadyEvaluatedException extends Exception

   :author: Christian Wiwie

Fields
------
iterationNumber
^^^^^^^^^^^^^^^

.. java:field:: protected final long iterationNumber
   :outertype: ParameterSetAlreadyEvaluatedException

paramSet
^^^^^^^^

.. java:field:: protected final ParameterSet paramSet
   :outertype: ParameterSetAlreadyEvaluatedException

previousIterationNumber
^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected final long previousIterationNumber
   :outertype: ParameterSetAlreadyEvaluatedException

Constructors
------------
ParameterSetAlreadyEvaluatedException
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ParameterSetAlreadyEvaluatedException(long iterationNumber, long previousIterationNumber, ParameterSet paramSet)
   :outertype: ParameterSetAlreadyEvaluatedException

Methods
-------
getIterationNumber
^^^^^^^^^^^^^^^^^^

.. java:method:: public long getIterationNumber()
   :outertype: ParameterSetAlreadyEvaluatedException

getParameterSet
^^^^^^^^^^^^^^^

.. java:method:: public ParameterSet getParameterSet()
   :outertype: ParameterSetAlreadyEvaluatedException

getPreviousIterationNumber
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public long getPreviousIterationNumber()
   :outertype: ParameterSetAlreadyEvaluatedException

