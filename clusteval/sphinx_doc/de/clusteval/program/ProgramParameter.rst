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

ProgramParameter
================

.. java:package:: de.clusteval.program
   :noindex:

.. java:type:: public abstract class ProgramParameter<T> extends RepositoryObject

   An object of this class corresponds to a parameter of a program.

   Therefore a program parameter has a reference to a program configuration in which it was defined.

   A program parameter has a certain \ :java:ref:`name`\  unique for the program configuration, a \ :java:ref:`description`\ , a minimal value \ :java:ref:`minValue`\ , a maximal value \ :java:ref:`maxValue`\  and a default value \ :java:ref:`def`\ .

   :author: Christian Wiwie
   :param <T>:

Fields
------
def
^^^

.. java:field:: protected String def
   :outertype: ProgramParameter

   The default value of this parameter. The attribute holds a string, because the value of this variable can hold a placeholder which is replaced dynamically by the framework, e.g $(meanSimilarity).

description
^^^^^^^^^^^

.. java:field:: protected String description
   :outertype: ProgramParameter

   A program parameter can have a description.

maxValue
^^^^^^^^

.. java:field:: protected String maxValue
   :outertype: ProgramParameter

   The maximal value this parameter can be set to. The attribute holds a string, because the value of this variable can hold a placeholder which is replaced dynamically by the framework, e.g $(meanSimilarity).

minValue
^^^^^^^^

.. java:field:: protected String minValue
   :outertype: ProgramParameter

   The minimal value this parameter can be set to. The attribute holds a string, because the value of this variable can hold a placeholder which is replaced dynamically by the framework, e.g $(meanSimilarity).

name
^^^^

.. java:field:: protected String name
   :outertype: ProgramParameter

   The name of this parameter has to be unique for the program configuration and program.

options
^^^^^^^

.. java:field:: protected String[] options
   :outertype: ProgramParameter

   The possible values this parameter can be set to. The attribute holds a string[], because the values of this variable can hold placeholders which are replaced dynamically by the framework, e.g $(meanSimilarity).

programConfig
^^^^^^^^^^^^^

.. java:field:: protected ProgramConfig programConfig
   :outertype: ProgramParameter

   The program configuration which defined this parameter.

Constructors
------------
ProgramParameter
^^^^^^^^^^^^^^^^

.. java:constructor:: public ProgramParameter(Repository repository, boolean register, ProgramConfig programConfig, String name, String desc, String minValue, String maxValue, String[] options, String def) throws RegisterException
   :outertype: ProgramParameter

   Instantiates a new program parameter.

   The absolute path of a program parameter is defined as the absolute path of its program configuration concatenated with its name, separated by a colon.

   :param repository: The repository at which to register this program parameter.
   :param register: A boolean indicating, whether to register this object at a repository.
   :param programConfig: The program configuration which defined this parameter.
   :param name: The name of this parameter has to be unique for the program configuration and program.
   :param desc: The name of this parameter has to be unique for the program configuration and program.
   :param minValue: The minimal value this parameter can be set to (see \ :java:ref:`minValue`\ ).
   :param maxValue: The maximal value this parameter can be set to (see \ :java:ref:`maxValue`\ ).
   :param options: The possible values of this parameter.
   :param def: The default value of this parameter (see \ :java:ref:`def`\ ).
   :throws RegisterException:

ProgramParameter
^^^^^^^^^^^^^^^^

.. java:constructor:: public ProgramParameter(ProgramParameter<T> other) throws RegisterException
   :outertype: ProgramParameter

   The copy constructor of program parameters.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public abstract ProgramParameter<T> clone()
   :outertype: ProgramParameter

cloneParameterList
^^^^^^^^^^^^^^^^^^

.. java:method:: public static List<ProgramParameter<?>> cloneParameterList(List<ProgramParameter<?>> programParameters)
   :outertype: ProgramParameter

   A helper method for cloning a list of parameters.

   :param programParameters: The optimization parameters to clone.
   :return: The list of cloned optimization parameters.

cloneParameterListList
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static List<List<ProgramParameter<?>>> cloneParameterListList(List<List<ProgramParameter<?>>> programParameters)
   :outertype: ProgramParameter

   A helper method for cloning a list of parameters.

   :param programParameters: The optimization parameters to clone.
   :return: The list of cloned optimization parameters.

equals
^^^^^^

.. java:method:: @Override public boolean equals(Object o)
   :outertype: ProgramParameter

evaluateDefaultValue
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public abstract T evaluateDefaultValue(DataConfig dataConfig, ProgramConfig programConfig) throws InternalAttributeException
   :outertype: ProgramParameter

   This method evaluates the string representation of the default value \ :java:ref:`def`\  to a value corresponding to the dynamic type of this object, e.g. in case this parameter is a double parameter, it is evaluated to a double value.

   The method requires a data and program configuration, since the string representation can contain a placeholder of a internal variable which is replaced by looking it up during runtime. $(meanSimilarity) for example is evaluated by looking into the data and calculating the mean similarity of the input.

   :param dataConfig: The data configuration which might be needed to evaluate certain placeholder variables.
   :param programConfig: The program configuration which might be needed to evaluate certain placeholder variables.
   :throws InternalAttributeException:
   :return: The evaluated value of the \ :java:ref:`def`\  variable.

evaluateMaxValue
^^^^^^^^^^^^^^^^

.. java:method:: public abstract T evaluateMaxValue(DataConfig dataConfig, ProgramConfig programConfig) throws InternalAttributeException
   :outertype: ProgramParameter

   This method evaluates the string representation of the maximal value \ :java:ref:`maxValue`\  to a value corresponding to the dynamic type of this object, e.g. in case this parameter is a double parameter, it is evaluated to a double value.

   The method requires a data and program configuration, since the string representation can contain a placeholder of a internal variable which is replaced by looking it up during runtime. $(meanSimilarity) for example is evaluated by looking into the data and calculating the mean similarity of the input.

   :param dataConfig: The data configuration which might be needed to evaluate certain placeholder variables.
   :param programConfig: The program configuration which might be needed to evaluate certain placeholder variables.
   :throws InternalAttributeException:
   :return: The evaluated value of the \ :java:ref:`maxValue`\  variable.

evaluateMinValue
^^^^^^^^^^^^^^^^

.. java:method:: public abstract T evaluateMinValue(DataConfig dataConfig, ProgramConfig programConfig) throws InternalAttributeException
   :outertype: ProgramParameter

   This method evaluates the string representation of the minimal value \ :java:ref:`minValue`\  to a value corresponding to the dynamic type of this object, e.g. in case this parameter is a double parameter, it is evaluated to a double value.

   The method requires a data and program configuration, since the string representation can contain a placeholder of a internal variable which is replaced by looking it up during runtime. $(meanSimilarity) for example is evaluated by looking into the data and calculating the mean similarity of the input.

   :param dataConfig: The data configuration which might be needed to evaluate certain placeholder variables.
   :param programConfig: The program configuration which might be needed to evaluate certain placeholder variables.
   :throws InternalAttributeException:
   :return: The evaluated value of the \ :java:ref:`minValue`\  variable.

evaluateOptions
^^^^^^^^^^^^^^^

.. java:method:: public abstract T[] evaluateOptions(DataConfig dataConfig, ProgramConfig programConfig) throws InternalAttributeException
   :outertype: ProgramParameter

   This method evaluates the string representation of the options \ :java:ref:`options`\  to a value corresponding to the dynamic type of this object, e.g. in case this parameter is a double parameter, it is evaluated to a double value.

   The method requires a data and program configuration, since the string representation can contain a placeholder of a internal variable which is replaced by looking it up during runtime. $(meanSimilarity) for example is evaluated by looking into the data and calculating the mean similarity of the input.

   :param dataConfig: The data configuration which might be needed to evaluate certain placeholder variables.
   :param programConfig: The program configuration which might be needed to evaluate certain placeholder variables.
   :throws InternalAttributeException:
   :return: The evaluated value of the \ :java:ref:`minValue`\  variable.

getDefault
^^^^^^^^^^

.. java:method:: public String getDefault()
   :outertype: ProgramParameter

   :return: The default value of this parameter.

getDescription
^^^^^^^^^^^^^^

.. java:method:: public String getDescription()
   :outertype: ProgramParameter

   :return: The description of this parameter.

getMaxValue
^^^^^^^^^^^

.. java:method:: public String getMaxValue()
   :outertype: ProgramParameter

   :return: The maximal value of this parameter.

getMinValue
^^^^^^^^^^^

.. java:method:: public String getMinValue()
   :outertype: ProgramParameter

   :return: The minimal value of this parameter.

getName
^^^^^^^

.. java:method:: public String getName()
   :outertype: ProgramParameter

   :return: The name of this parameter.

getOptions
^^^^^^^^^^

.. java:method:: public String[] getOptions()
   :outertype: ProgramParameter

   :return: The possible values of this parameter.

getProgramConfig
^^^^^^^^^^^^^^^^

.. java:method:: public ProgramConfig getProgramConfig()
   :outertype: ProgramParameter

   :return: The program configuration which defined this parameter.

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: ProgramParameter

isMaxValueSet
^^^^^^^^^^^^^

.. java:method:: public abstract boolean isMaxValueSet()
   :outertype: ProgramParameter

   This method checks, whether the \ :java:ref:`maxValue`\  variable has been set to a correct not-null value.

   :return: True, if the variable has been set correctly, false otherwise.

isMinValueSet
^^^^^^^^^^^^^

.. java:method:: public abstract boolean isMinValueSet()
   :outertype: ProgramParameter

   This method checks, whether the \ :java:ref:`minValue`\  variable has been set to a correct not-null value.

   :return: True, if the variable has been set correctly, false otherwise.

isOptionsSet
^^^^^^^^^^^^

.. java:method:: public abstract boolean isOptionsSet()
   :outertype: ProgramParameter

   This method checks, whether the \ :java:ref:`options`\  variable has been set to a correct not-null value.

   :return: True, if the variable has been set correctly, false otherwise.

parseFromConfiguration
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static ProgramParameter<?> parseFromConfiguration(ProgramConfig programConfig, String name, SubnodeConfiguration config) throws RegisterException, UnknownParameterType
   :outertype: ProgramParameter

   Parses a program parameter from a section of a configuration file.

   This method only delegates depending on the type of the program parameter to the methods \ :java:ref:`DoubleProgramParameter.parseFromStrings(ProgramConfig,String,String,String,String,String)`\ , \ :java:ref:`IntegerProgramParameter.parseFromStrings(ProgramConfig,String,String,String,String,String)`\  and \ :java:ref:`StringProgramParameter.parseFromStrings(ProgramConfig,String,String,String,String,String)`\ .

   :param programConfig: The program configuration in which the program parameter has been defined.
   :param name: The name of the program parameter.
   :param config: The section of the configuration, which contains the information about this parameter.
   :throws UnknownParameterType:
   :throws RegisterException:
   :return: The parsed program parameter.

setDefault
^^^^^^^^^^

.. java:method:: public void setDefault(String def)
   :outertype: ProgramParameter

   Sets the default value of this parameter.

   :param def: The new default value of this parameter.

setMaxValue
^^^^^^^^^^^

.. java:method:: public void setMaxValue(String maxValue)
   :outertype: ProgramParameter

   Sets the maximal value.

   :param maxValue: The new maximal value

setMinValue
^^^^^^^^^^^

.. java:method:: public void setMinValue(String minValue)
   :outertype: ProgramParameter

   Sets the minimal value.

   :param minValue: The new minimal value.

setOptions
^^^^^^^^^^

.. java:method:: public void setOptions(String[] options)
   :outertype: ProgramParameter

   Sets the minimal value.

   :param options: The possible values of this parameter.

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: ProgramParameter

