.. java:import:: javax.script ScriptException

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils InternalAttributeException

DoubleProgramParameter
======================

.. java:package:: de.clusteval.program
   :noindex:

.. java:type:: public class DoubleProgramParameter extends ProgramParameter<Double>

   :author: Christian Wiwie

Constructors
------------
DoubleProgramParameter
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: protected DoubleProgramParameter(Repository repository, boolean register, ProgramConfig programConfig, String name, String desc, String minValue, String maxValue, String[] options, String def) throws RegisterException
   :outertype: DoubleProgramParameter

   The constructor for double program parameters.

   :param repository: The repository to register the new parameter.
   :param register: Whether to register the new parameter.
   :param programConfig: The program configuration defining this parameter.
   :param name: The name of the parameter.
   :param desc: The description of the parameter.
   :param minValue: The minimal value of the parameter.
   :param maxValue: The maximal value of the parameter.
   :param def: The default value of the parameter.
   :throws RegisterException:

DoubleProgramParameter
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DoubleProgramParameter(DoubleProgramParameter other) throws RegisterException
   :outertype: DoubleProgramParameter

   The copy constructor of double program parameters.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public DoubleProgramParameter clone()
   :outertype: DoubleProgramParameter

evaluateDefaultValue
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Double evaluateDefaultValue(DataConfig dataConfig, ProgramConfig programConfig) throws InternalAttributeException
   :outertype: DoubleProgramParameter

evaluateMaxValue
^^^^^^^^^^^^^^^^

.. java:method:: @Override public Double evaluateMaxValue(DataConfig dataConfig, ProgramConfig programConfig) throws InternalAttributeException
   :outertype: DoubleProgramParameter

evaluateMinValue
^^^^^^^^^^^^^^^^

.. java:method:: @Override public Double evaluateMinValue(DataConfig dataConfig, ProgramConfig programConfig) throws InternalAttributeException
   :outertype: DoubleProgramParameter

evaluateOptions
^^^^^^^^^^^^^^^

.. java:method:: @Override public Double[] evaluateOptions(DataConfig dataConfig, ProgramConfig programConfig) throws InternalAttributeException
   :outertype: DoubleProgramParameter

isMaxValueSet
^^^^^^^^^^^^^

.. java:method:: @Override public boolean isMaxValueSet()
   :outertype: DoubleProgramParameter

isMinValueSet
^^^^^^^^^^^^^

.. java:method:: @Override public boolean isMinValueSet()
   :outertype: DoubleProgramParameter

isOptionsSet
^^^^^^^^^^^^

.. java:method:: @Override public boolean isOptionsSet()
   :outertype: DoubleProgramParameter

parseFromStrings
^^^^^^^^^^^^^^^^

.. java:method:: public static DoubleProgramParameter parseFromStrings(ProgramConfig programConfig, String name, String desc, String minValue, String maxValue, String[] options, String def) throws RegisterException
   :outertype: DoubleProgramParameter

   Parse a double program parameter from strings.

   :param programConfig: The program configuration defining this parameter.
   :param name: The name of the parameter.
   :param desc: The description of the parameter.
   :param minValue: The minimal value of the parameter.
   :param maxValue: The maximal value of the parameter.
   :param def: The default value of the parameter.
   :throws RegisterException:
   :return: The parsed double program parameter.

