.. java:import:: java.io File

.. java:import:: java.util List

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program Program

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramParameter

.. java:import:: de.clusteval.run.result.format RunResultFormat

RProgramConfig
==============

.. java:package:: de.clusteval.program.r
   :noindex:

.. java:type:: public class RProgramConfig extends ProgramConfig

   Objects of this class encapsulate the configuration of rprograms.

   In principle this class does the same as a regular \ :java:ref:`ProgramConfig`\ , except that it takes the invocatin formats from the rprogram.

   :author: Christian Wiwie

Constructors
------------
RProgramConfig
^^^^^^^^^^^^^^

.. java:constructor:: public RProgramConfig(Repository repository, boolean register, long changeDate, File absPath, Program program, RunResultFormat outputFormat, List<DataSetFormat> compatibleDataSetFormats, List<ProgramParameter<?>> params, List<ProgramParameter<?>> optimizableParameters, boolean expectsNormalizedDataSet, int maxExecutionTimeMinutes) throws RegisterException
   :outertype: RProgramConfig

   Instantiates a new rprogram configuration.

   :param repository: The repository this program configuration should be registered at.
   :param register: A boolean indicating whether to register this rprogram configuration.
   :param changeDate: The change date of this program configuration is used for equality checks.
   :param absPath: The absolute path of this program configuration.
   :param program: The program this program configuration belongs to.
   :param outputFormat: The output format of the program.
   :param compatibleDataSetFormats: A list of compatible dataset formats of the encapsulated program.
   :param params: The parameters of the program.
   :param optimizableParameters: The parameters of the program, that can be optimized.
   :param expectsNormalizedDataSet: Whether the encapsulated program requires normalized input.
   :throws RegisterException:

RProgramConfig
^^^^^^^^^^^^^^

.. java:constructor:: public RProgramConfig(RProgramConfig programConfig) throws RegisterException
   :outertype: RProgramConfig

   The copy constructor for RProgram configurations.

   :param programConfig: The rprogram configuration to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public RProgramConfig clone()
   :outertype: RProgramConfig

