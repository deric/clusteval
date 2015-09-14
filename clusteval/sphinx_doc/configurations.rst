Configuration Files - Handling ClustEval
============
Above we already discussed that the framework needs program configurations,
dataset configurations and goldstandard configurations. Those configuration
files directly reference corresponding files (dataset, goldstandard, . . . ) on the filesys-
tem. Internally the framework has some abstraction layers to store all the configura-
tions. Figure 5 shows the overall abstractional structure of the configuration files used
in the backend. One can see that dataset- and goldstandard configuration are linked
together in a data configuration.

A run is an abstract entity that can be performed by the backend. Its execution
involves (in most cases) application of clustering methods to several datasets, and after-
wards clustering qualities are assessed using the goldstandards corresponding to each
dataset. A run corresponds to a run configuration file, which then again references
the program- and data configurations that should be pairwise combined.

When a run is performed by the backend, the clustering methods wrapped by all ref-
erenced program configurations are applied to all datasets indirectly referenced through
the data configurations.

Data Configurations
----------------
A data configuration is a file, that combines two other configurations together: A
dataset configuration (see 4.9.3) and a goldstandard configuration (see 4.9.5). Later
on when you create a run (and its configuration) and in this run you want to apply
two clustering methods to three datasets (together with their goldstandards) you will
do so by telling the run configuration the names of the three corresponding data con-
figurations. Please note: The data configuration file has to have the file extension
.dataconfig, otherwise it will not be recognized by the framework.

* datasetConfig: This option has to be set to the name of the dataset configuration (see 4.9.3), not the name of the file.
* goldstandardConfig: This option has to be set to the name of the goldstandard configuration (see 4.9.5), not the name of the file.

Example
""""""""""""""""""""""""""
A data configuration could look as follows::

	datasetConfig = astral_1
	goldstandardConfig = astral_1_161
	
Dataset Configuration
----------------
A dataset configuration tells the framework meta information about the corresponding
dataset. That is: The internal name of the dataset, its filename and its format.
datasetName: This name is used to find and access datasets within the framework.
The name of the dataset has to be identical to the subfolder of the corresponding
dataset.

* datasetFile: This option has to be set to the filename of the dataset file residing within the subfolder of the dataset.
* datasetFormat: This option tells the framework, which format the dataset is in. clusteval ships with a set of supported dataset formats. Please note, that the entries in this list have to be identical with the simple names of the corresponding dataset format classes.
* [distanceMeasureAbsoluteToRelative: ] This indicates, which distance measure should be used, when this dataset is converted to another format. Defaults to EuclidianDistanceMeasure.
* [preprocessorAfterDistance: ] A comma seperated list of data preprocessors to apply, before the data is converted to pairwise similarities (the standard input format)
* [preprocessorAfterDistance: ] A comma seperated list of data preprocessors to apply, after the data is converted to pairwise similarities (the standard input format)

Example
"""""""""""""""""""""""""""""
A dataset configuration could look as follows::

	datasetName = astral_1_161
	datasetFile = blastResults.txt
	datasetFormat = BLASTDataSetFormat
	distanceMeasureAbsoluteToRelative = EuclidianDistanceMeasure
	
GoldStandard Configuration
----------------
A goldstandard configuration tells the framework meta information about the corre-
sponding goldstandard. That is: The internal name of the goldstandard and its file-
name.

* goldstandardName: This name is used to find and access goldstandards within the framework. The name of the goldstandard has to be identical to the subfolder of the corresponding goldstandard.
* goldstandardFile: This option has to be set to the filename of the goldstandard file residing within the subfolder of the goldstandard.

Example
""""""""""""""""""""""""""""""""""
A goldstandard configuration could look as follows::

	goldstandardName = astral_1_161
	goldstandardFile = astral_161.goldstandard_3.txt
	
Program Configuration
----------------
For every clustering method there can be several configuration files. All program configurations have to be located in <REPOSITORY ROOT>/programs/configs . A program configuration tells the framework, what parameters the program expects, how to invoke the executable, with what parameter values to invoke it and several other information. Possible entries in a program configuration follow.

Please note: The program configuration file has to have the file extension .config ,
otherwise it will not be recognized by the framework.

* type: Indicates, whether the program described by this program configuration is a standalone or an R program. This option can be set to either standalone or the simple name of the R program class.
* program: This is the full name of the clustering method, this configuration references. When a clustering method is located in <REPOSITORY ROOT>/programs/some/program, then the full name of the program is "some/program"
* alias: This option is only interpreted for standalone programs. It tells the framework a alias of the corresponding program, which is used whenever the program needs to be represented in a readable format, e.g. on the website.
* parameters: A comma-separated list of parameters the program uses and which can be used when the program is invoked. These parameters need to be set to valid values before the program is actually applied to a dataset. Parameter values can be specificely defined either in a program or run configuration or, in case of parameter optimization runs, they are autonomously determined by the framework. If no value is defined for a program parameter at all, it will be set to its default value given in the program configuration.
* optimizationParameters: This option is only used, when a run is performed in parameter optimization mode. Then this list of parameters (that needs to be a subset of the list given in option "parameters") is used to determine, which parameters can be in principle optimized when this program is used in parameter optimization mode.
* compatibleDataSetFormats: This list tells the framework, which input formats this program supports. Please note, that the entries in this list have to be identical to the simple names of the classes of the corresponding dataset formats.
* outputFormat: This option tells the framework, what the output format of this program is. Please note, that the naming convention of this list follows the same rules as those of "compatibleDataSetFormats", as the value of this option has to be named exactly after the simple name of the corresponding class.
* expectsNormalizedDataSet: This option can be set to "true" or "false". By default, it is set to false. If you set it to true, the input similarities (only) for this program are normalized to values between 0 and 1. This may help you, if a clustering method does not support negative values or values outside certain ranges.
* [invocationFormat ] This is the section containing a set of invocation formats which tell the framework in string format, how to invoke this program. The invocation formats may contain program parameters or certain predefined variables, which are replaced by the framework during runtime. Such variable names are enclosed by % signs. All program parameters defined in the parameters section of the program configuration can be used in the invocation format string. Additionally the following variables are hardcoded for every program and cannot be used for other parameters:

  * %e% will be replaced by the absolute path of the executable
  * %i% will be replaced by the absolute path of the input
  * %o% will be replaced by the absolute path of the output
  * %gs% will be replaced by the absolute path of the goldstandard
  
  For example, if the option is set like this::
  
    invocationFormat = %e% %i% %preference% %o% maxits=%maxits% convits=%convits% 

  "preference", "maxits" and "convits" have to be defined in the "parameters" entry of the same program configuration.
* invocationFormat: This is the option which tells the framework, how to invoke this program in case we have a goldstandard and no parameter optimization run. All words enclosed with % will be replaced by the framework at runtime. All other variables in the invocation line have to be parameters defined in this program configuration.
* invocationFormatWithoutGoldStandard: This is how to invoke this program in case we have no goldstandard and no parameter optimization run.
* invocationFormatParameterOptimization: This is how to invoke this program in case we have a goldstandard and a parameter optimization run.
* invocationFormatParameterOptimizationWithoutGoldStandard: This is how to invoke this program in case we have no goldstandard and a parameter optimization run.
* [<parameterName> ] For every parameter defined in the list of entry "parameters", there needs to be an additional section in the program configuration, which tells the framework several information about the parameter:

* desc: A description of the parameter 
  * type: One of the types FLOAT ("2"), INTEGER ("1") or STRING ("0").
  * def: A default value for the parameter.
  * minValue: The minimal value for the parameter.
  * maxValue: The maximal value for the parameter.
  
Example
"""""""""""""""""""""""""""""
A program configuration could look as follows::

	program = APcluster
	parameters = preference,maxits,convits,dampfact
	optimizationParameters = preference,maxits,convits,dampfact
	executable = apcluster
	compatibleDataSetFormats = APRowSimDataSetFormat
	outputFormat = APRunResultFormat
	
	[invocationFormat]
	invocationFormat = %e %i %preference %o maxits=%maxits convits=%convits
	dampfact=%dampfact
	
	[maxits]
	desc = Max iterations
	type = 1
	def = 2000
	minValue = 2000
	maxValue = 5000
	
	[convits]
	desc = Cluster Center duration
	type = 1
	def = 200
	minValue = 200
	maxValue = 500
	
	[dampfact]
	type = 2
	def = 0.9
	minValue = 0.7
	maxValue = 0.99
	
	[preference]
	desc = Preference
	type = 2
	def = 0.5
	minValue = 0.0
	maxValue = 1.0
	
Runs
----------------
Runs are entities that can be performed by the backend server. A run is defined by a file in the folder <REPOSITORY ROOT>/runs . The name of that file (without extension) also defines the name of the run. Depending on the type of the run this file contains several other components which configure the process when the run is performed. Figure 6 shows the different types of runs and how they relate to each other.

Every run is defined in a run-file in the corresponding folder of the repository. Depending on the type of the run, different options are available that can be specified in the run-file. Common to all types of runs are the following options:

* mode: This entry can be set to "clustering", "parameter optimization", "dataAnalysis", "runAnalysis" or "runDataAnalysis". These types can be found in the aforementioned figure and are described in the following paragraphs.

TODO: robustness analysis run

Execution Runs
^^^^^^^^^^^^^^^^^^
Execution runs calculate clusterings during their execution and assess qualities for every of those clusterings. Clusterings are calculated by applying clustering methods to datasets using a certain parameter set. That is why execution runs have sets of both, program and data configurations. During execution time every program configuration is applied to every data configuration in a pairwise manner. For every calculated clustering a set of clustering quality measures are assessed.

In general the options of such a combination of data and program configuration will be taken from these configurations respectively, but can be overridden by the options in the run configuration, That means parameter values defined in the program as well as in the run configuration will be taken from the latter.

For execution runs, additionally to the options defined for all runs (see Run Files), the following options for the run-file are defined:

* programConfig: This entry has to be set to a single name or a comma-separated list of names of program configurations. When this run is performed, these program configurations will be pairwise combined with the data configurations given in the option "dataConfig".
* dataConfig: This entry has to be set to a single name or a comma-separated list of names of data configurations. When this run is performed, these data configurations will be pairwise combined with the program configurations given in the option "programConfig".
* qualityMeasures: This option determines, which quality measures will be assessed for every clustering calculated during the run process. When this run is a clustering run (see option "mode"), then for every pair of data and program configurations there will be only one clustering as a result for which quality measures will be evaluated. When the mode is set to "parameter optimization", for every iteration during the parameter optimization process these quality measures will be evaluated.
* [<programConfigName> :] If a dedicated section is found in this run file that is called like one of the program configurations given in option "programConfig", several parameters can be overridden individually only for this program configuration which are 

* <parameterName>: The program parameter with the given name which needs to be defined in the program configuration can be fixed to a certain value.
  
Clustering Runs
^^^^^^^^^^^^^^^^^^
Clustering runs are a type of execution run, that means they calculate clusterings by applying every program configuration to every data configuration. Afterwards they assess the qualities of those clusterings in terms of several clustering quality measures.

In the case of clustering runs for every pair of program and data configuration exactly one clustering is calculated and assessed. Clustering runs are visualized in figure 7.

For clustering runs, the options are the same as for all execution runs (see Execution Run Files).

Parameter Optimization Runs
^^^^^^^^^^^^^^^^^^
Parameter optimization runs are a type of execution run, that means they calculate clusterings by applying every program configuration to every data configuration. Afterwards they assess the qualities of those clusterings in terms of several clustering quality measures.

In contrast to clustering runs, parameter optimization runs calculate several clusterings for every pair of data and program configuration in a pairwise manner. Every clustering corresponds to a certain parameter set and the parameter sets to evaluate are determined by a parameter optimization method (see 4.8 for more information). Parameter optimization runs are visualized in figure 8.

For parameter optimization runs, additionally to the options defined for all execution runs (see Execution Run Files), the following options for the run-file are defined:

* optimizationMethod: The parameter optimization method to use when this run is performed.
* optimizationCriterion: The clustering quality measure which should be used as optimization criterion. This criterion is used to determine the optimal parameter set during the optimization process. Therefore it can influence the cause of the optimization process, if the chosen parameter optimization method integrates the qualities of previous iterations into future iterations.
* optimizationIterations: The number of total optimization iterations that should be performed for every pair of program and data configuration. Hint: This number might not be the number, the optimization process performs in the end, since it gives only a desirable number that might not be accurately realizable for a specific optimization method.
* [<programConfigName> :] If a dedicated section is found in this run file that is called like one of the program configurations given in option "programConfig", several parameters can be overridden individually only for this program configuration which are

* optimizationParameters: A comma separated list of the parameters that should be optimized for this program configuration 
  * optimizationMethod: The parameter optimization method to use for this program configuration
  
TODO: add missing options

Analysis Runs
^^^^^^^^^^^^^^^^^^
Analysis runs assess certain properties of objects of interest. An analysis run has a set of target objects and a set of statistics, that should be assessed for each of the target objects. That means, during execution time for every target object every statistic is assessed in a pairwise manner.

Data Analysis Runs
^^^^^^^^^^^^^^^^^^
In case of data analysis runs the target objects to analyze are data configurations (indirectly datasets) and the statistics are data statistics, that is properties of datasets. Data analysis runs are visualized in figure 9.

For data analysis runs the following options for the run-file are defined:

* dataStatistics: A comma separated list of data statistics to assess for the given data configurations.
* dataConfig: A comma separated list of data configurations to analyse.

Run Analysis Runs
^^^^^^^^^^^^^^^^^^
In case of run analysis runs the target objects to analyze are clusterings (results of execution runs) and the statistics are run statistics, that is properties of execution run
results. Run analysis runs are visualized in figure 10.

For run analysis runs the following options for the run-file are defined:

* runStatistics: A comma separated list of run statistics to assess for the given execution run results.
* uniqeRunIdentifiers: A comma separated list of identifiers of execution run results. See 4.11 for an explanation on run result identifiers.

Run-Data Analysis Runs
^^^^^^^^^^^^^^^^^^
In case of run-data analysis runs the target objects to analyze are pairs of data configurations and clusterings (results of execution runs) and the statistics are run-data statistics, that is relationships between execution run results and properties of data configurations. Run-Data analysis runs are visualized in figure 11.

For run-data analysis runs the following options for the run-file are defined:

* runDataStatistics: A comma separated list of run-data statistics to assess for every pair of given execution run result and data analysis result.
* uniqeRunIdentifiers: A comma separated list of identifiers of execution run results. See 4.11 for an explanation on run result identifiers.
* uniqeDataIdentifiers: A comma separated list of identifiers of data analysis run results. See 4.11 for an explanation on run result identifiers.


TODO: where to place the examples?

Example Parameter Optimization
""""""""""""""""""""""""""""""

A parameter optimization run could look as follows::

	programConfig = APcluster_1,TransClust_2,MCL_1
	dataConfig = astral_1_171
	qualityMeasures = TransClustF2ClusteringQualityMeasure,SilhouetteValueRClusteringQualityMeasure
	mode = parameter_optimization
	optimizationMethod = DivisiveParameterOptimizationMethod
	optimizationCriterion = SilhouetteValueRClusteringQualityMeasure
	optimizationIterations = 1001

	[TransClust_2]
	optimizationParameters = T

	[MCL_1]
	optimizationParameters = I

	[APcluster_1]
	optimizationParameters = preference,dampfact,maxits,convits
	optimizationMethod = APDivisiveParameterOptimizationMethod