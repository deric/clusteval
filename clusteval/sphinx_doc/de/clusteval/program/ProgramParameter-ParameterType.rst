.. java:import:: java.io File

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util Iterator

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: org.apache.commons.configuration SubnodeConfiguration

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.utils InternalAttributeException

ProgramParameter.ParameterType
==============================

.. java:package:: de.clusteval.program
   :noindex:

.. java:type:: public enum ParameterType
   :outertype: ProgramParameter

   An enumeration for parameter types. Program parameters can be of different type and this enumeration helps distinguishing them.

   :author: Christian Wiwie

Enum Constants
--------------
FLOAT
^^^^^

.. java:field:: public static final ProgramParameter.ParameterType FLOAT
   :outertype: ProgramParameter.ParameterType

   A float parameter holding float values.

INTEGER
^^^^^^^

.. java:field:: public static final ProgramParameter.ParameterType INTEGER
   :outertype: ProgramParameter.ParameterType

   An integer parameter holding integer values.

STRING
^^^^^^

.. java:field:: public static final ProgramParameter.ParameterType STRING
   :outertype: ProgramParameter.ParameterType

   A string parameter holding string values.

