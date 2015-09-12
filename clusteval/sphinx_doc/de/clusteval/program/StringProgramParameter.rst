.. java:import:: javax.script ScriptException

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils InternalAttributeException

StringProgramParameter
======================

.. java:package:: de.clusteval.program
   :noindex:

.. java:type:: public class StringProgramParameter extends ProgramParameter<String>

   A type of program parameter that only holds string values.

   :author: Christian Wiwie

Constructors
------------
StringProgramParameter
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public StringProgramParameter(Repository repository, boolean register, ProgramConfig programConfig, String name, String desc, String[] options, String def) throws RegisterException
   :outertype: StringProgramParameter

   The constructor of string program parameters.

   :param repository: The repository to register the new parameter.
   :param register: Whether to register the new parameter.
   :param programConfig: The program configuration defining this parameter.
   :param name: The name of the parameter.
   :param desc: The description of the parameter.
   :param options: The possible values of this parameter.
   :param def: The default value of the parameter.
   :throws RegisterException:

StringProgramParameter
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public StringProgramParameter(StringProgramParameter other) throws RegisterException
   :outertype: StringProgramParameter

   The copy constructor of string program parameters.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public StringProgramParameter clone()
   :outertype: StringProgramParameter

evaluateDefaultValue
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public String evaluateDefaultValue(DataConfig dataConfig, ProgramConfig programConfig) throws InternalAttributeException
   :outertype: StringProgramParameter

evaluateMaxValue
^^^^^^^^^^^^^^^^

.. java:method:: @Override public String evaluateMaxValue(DataConfig dataConfig, ProgramConfig programConfig) throws InternalAttributeException
   :outertype: StringProgramParameter

evaluateMinValue
^^^^^^^^^^^^^^^^

.. java:method:: @Override public String evaluateMinValue(DataConfig dataConfig, ProgramConfig programConfig) throws InternalAttributeException
   :outertype: StringProgramParameter

evaluateOptions
^^^^^^^^^^^^^^^

.. java:method:: @Override public String[] evaluateOptions(DataConfig dataConfig, ProgramConfig programConfig) throws InternalAttributeException
   :outertype: StringProgramParameter

isMaxValueSet
^^^^^^^^^^^^^

.. java:method:: @Override public boolean isMaxValueSet()
   :outertype: StringProgramParameter

isMinValueSet
^^^^^^^^^^^^^

.. java:method:: @Override public boolean isMinValueSet()
   :outertype: StringProgramParameter

isOptionsSet
^^^^^^^^^^^^

.. java:method:: @Override public boolean isOptionsSet()
   :outertype: StringProgramParameter

parseFromStrings
^^^^^^^^^^^^^^^^

.. java:method:: public static StringProgramParameter parseFromStrings(ProgramConfig programConfig, String name, String desc, String[] options, String def) throws RegisterException
   :outertype: StringProgramParameter

   Parse a string program parameter from strings.

   :param programConfig: The program configuration defining this parameter.
   :param name: The name of the parameter.
   :param desc: The description of the parameter.
   :param options: The possible values of the parameter.
   :param def: The default value of the parameter.
   :throws RegisterException:
   :return: The parsed string program parameter.

