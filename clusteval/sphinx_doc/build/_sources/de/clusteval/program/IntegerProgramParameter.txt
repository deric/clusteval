.. java:import:: javax.script ScriptException

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils InternalAttributeException

IntegerProgramParameter
=======================

.. java:package:: de.clusteval.program
   :noindex:

.. java:type:: public class IntegerProgramParameter extends ProgramParameter<Integer>

   A type of program parameter that only holds integer values.

   :author: Christian Wiwie

Constructors
------------
IntegerProgramParameter
^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public IntegerProgramParameter(Repository repository, boolean register, ProgramConfig programConfig, String name, String desc, String minValue, String maxValue, String[] options, String def) throws RegisterException
   :outertype: IntegerProgramParameter

   The constructor of integer program parameters.

   :param repository: The repository to register the new parameter.
   :param register: Whether to register the new parameter.
   :param programConfig: The program configuration defining this parameter.
   :param name: The name of the parameter.
   :param desc: The description of the parameter.
   :param minValue: The minimal value of the parameter.
   :param maxValue: The maximal value of the parameter.
   :param options:
   :param def: The default value of the parameter.
   :throws RegisterException:

IntegerProgramParameter
^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public IntegerProgramParameter(IntegerProgramParameter other) throws RegisterException
   :outertype: IntegerProgramParameter

   The copy constructor of integer program parameters.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public IntegerProgramParameter clone()
   :outertype: IntegerProgramParameter

evaluateDefaultValue
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Integer evaluateDefaultValue(DataConfig dataConfig, ProgramConfig programConfig) throws InternalAttributeException
   :outertype: IntegerProgramParameter

evaluateMaxValue
^^^^^^^^^^^^^^^^

.. java:method:: @Override public Integer evaluateMaxValue(DataConfig dataConfig, ProgramConfig programConfig) throws InternalAttributeException
   :outertype: IntegerProgramParameter

evaluateMinValue
^^^^^^^^^^^^^^^^

.. java:method:: @Override public Integer evaluateMinValue(DataConfig dataConfig, ProgramConfig programConfig) throws InternalAttributeException
   :outertype: IntegerProgramParameter

evaluateOptions
^^^^^^^^^^^^^^^

.. java:method:: @Override public Integer[] evaluateOptions(DataConfig dataConfig, ProgramConfig programConfig) throws InternalAttributeException
   :outertype: IntegerProgramParameter

isMaxValueSet
^^^^^^^^^^^^^

.. java:method:: @Override public boolean isMaxValueSet()
   :outertype: IntegerProgramParameter

isMinValueSet
^^^^^^^^^^^^^

.. java:method:: @Override public boolean isMinValueSet()
   :outertype: IntegerProgramParameter

isOptionsSet
^^^^^^^^^^^^

.. java:method:: @Override public boolean isOptionsSet()
   :outertype: IntegerProgramParameter

parseFromStrings
^^^^^^^^^^^^^^^^

.. java:method:: public static IntegerProgramParameter parseFromStrings(ProgramConfig programConfig, String name, String desc, String minValue, String maxValue, String[] options, String def) throws RegisterException
   :outertype: IntegerProgramParameter

   Parse an integer program parameter from strings.

   :param programConfig: The program configuration defining this parameter.
   :param name: The name of the parameter.
   :param desc: The description of the parameter.
   :param minValue: The minimal value of the parameter.
   :param maxValue: The maximal value of the parameter.
   :param options:
   :param def: The default value of the parameter.
   :throws RegisterException:
   :return: The parsed integer program parameter.

