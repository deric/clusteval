ClustEval documentation
=======================

TODO: images!

Introduction
------------
ClustEval is an automated framework for cluster analysis written in Java which comes together with a Ruby on Rails website. This includes most common subtasks of every cluster analysis, such as 

* data preprocessing 
* data normalization
* data conversion
* clustering method execution
* parameter training and
* visualizations

Download & Installation
-----------------------

Basic Usage
-----------
After you downloaded and installed clusteval , you need to know how to use it. The
backend server and client are distributed as two executables which can be simply started
with a single command in the command line. Both can be invoked with different
command line parameters, which will be explained in the next sections.
For the following scenarios we assume, that the website is ready to use.

Backend Server

The Framework
-------------
Our framework clusteval is intended to perform automatized cluster analysis of arbi-
trary data sets and clustering methods. The goal is, that any clustering method known
to the framework can be applied to any known data set (with certain exceptions, partly
inflicted by the clustering methods itself and partly inflicted by the framework con-
straints).

In general clusteval is divided into a backend and a frontend. Figure 1 shows
the general structure of the framework. The backend is reponsible for doing all the
calculations including clusterings and the frontend has only visualization purposes.

Backend
-------
The backend of the framework is responsible for all calculations. It consists of a server
and a client component. The server takes commands from the client and does the
calculations internally and in a multithreaded way. The client can query the server to
get the current status of a calculation or to give commands to the server which might
control current processes. Figure 2 shows the general structure of the backend and the
components it contains.

Server
^^^^^^
In principle the core of all tasks of the backend server is, to apply clustering methods to
data (data set and goldstandard) in an automatized and autonomous way, using only the
configurations and inputs the user specified. The produced results have to be parsed
in such a way, that the frontend can easily collect certain information and visualize
them. Thus the components used by the backend that are not directly included into
the framework programatically but need to be provided can be summarized as

* Data (data sets & Goldstandards)
* Clustering Methods
* Configurations

Additional components that can be extended and might be needed in case the
provided standard functionality of the framework is not sufficient for the user

* Data input formats (including parsers)
* Run result formats (including parsers)
* Clustering Quality Measures
* Distance Measures
* Parameter Optimization Methods
* data set types
* (Data, Run & Run-Data) Statistics
* data set generators

All these components have to be located in the repository of the framework (see 4.1
for more details). The repository is a file system hierarchy located at a specified path
and contains all components used by and available to the framework. data sets, cluster-
ing methods or configurations outside the repository cannot be used by the framework.
After these components have been made available to the backend, they can be
combined almost arbitrarily. In the following we will describe the dependencies of each
of these components which need to be fulfilled such that a new component of each type
can be recognized and used by the framework.

Client
^^^^^^
The backend client is a small command-line tool which gives commands to the back-
end server, for example to execute a certain run or terminate a run that is currently
executing. It offers tab completion and communicates with the server using the Rserve
package via TCP/IP.

Repository
^^^^^^^^^^
The backend server is based on a central repository which concludes all files in its folder
structure. You can easily start a framework with a different set of files by simply using
another repository.

Repository Folder Structure
"""""""""""""""""""""""""""

* data: Contains all data-related files.

  * configs [*.dataconfig]: Contains the data configuration files 4.9.1.
  * data sets: Contains all data set-related files 4.3.
  
    * configs [*.dsconfig]: Contains the data set configuration files 4.9.3.
    * [subfolder for every data set]: The data set files themselves.
  * goldstandards: Contains all goldstandard-related files 4.4.
  
    * configs [*.gsconfig]: Contains the goldstandard configurations 4.9.5.
    * [subfolder for every goldstandard]: Contains the goldstandard files themselves.
* programs: Contains all program-related files

  * configs [*.config]: Contains all program configuration files 4.9.7.
  * [subfolder for every program]: The program files themselves.
* results: The results of run executions 4.11.

  * [subfolder for every run execution]: A subfolder contains the results of one run execution.
  
    * clusters: The clustering results, including clustering qualities and graphics.
    * configs: Copies of all used configuration files of this run execution to enable exact reproduction.
    * inputs: Copies of all used inputs of this run execution to enable exact reproduction.
    * logs: All log files corresponding to this run execution.
* runs: All run-related files.

  * [*.run: a file for every run]: Contains the run-files.
* supp: Contains supplementary material.

  * clustering: Supplementary material related to clusterings.
  * paramOptimization: Contains clustering parameter optimization methods 4.8.
  
    * [*.jar]: Each jar-file corresponds to a parameter optimization method and is loaded dynamically by the framework.
  * qualityMeasures: Contains clustering quality measures 4.6.
  
    * [*.jar]: Each jar-file corresponds to a clustering quality measure and is loaded dynamically by the framework.
  * formats: Contains all formats used by the framework.
  
    * data set: Contains all data set formats 4.5.
      * [*.jar]: Each jar-file corresponds to a data set format and is loaded dynamically by the framework.
      
    * runresult: Contains all runresult formats 4.5.
      * [*.jar]: Each jar-file corresponds to a runresult format and is loaded dynamically by the framework.

Clustering Methods
^^^^^^^^^^^^^^^^^^
Clustering Methods (technically also called Programs throughout this guide) can be
executed by the framework, and be applied to data to calculate clusterings. In order
to include a new clustering method and use it within the framework,

* the executable of the method has to be made available to the framework (an exception are Clustering Methods provided through the R framework, see 4.2.2),
* the method itself has to be specified in a configuration file (called program configuration)
* all other components (e.g. input and output formats) specified in the program configuration need to be available

The configuration file for a clustering method (short program configuration) con-
tains all information required, such that the framework can execute the method in
an automatized and autonomous way. These information include for example, among
others, the name of the method, its supported input formats, its output format, its
parameters (including type and valid range of values). An exact description of how
program configurations look like and which options and settings need to be specified
can be found in 4.9.7.
clusteval ships with a set of clustering methods including

* Affinity Propagation
* Hierarchical Clustering (Rserve)
* K-Means (Rserve)
* Markov Clustering
* Spectral Clustering (Rserve)
* Transitivity Clustering

For every of these clustering methods a program configuration is also provided,
such that they are directly usable from the start. Of course these program configurations
can be modified and adapted to the user's needs.


Standalone Methods
""""""""""""""""""

are programs that come as an executable. Those can be performed by the framework,
after they have been specified in a program configuration. The executable needs to be
compatible to the server architecture clusteval runs on and they need to be executable
(+x modifier). How you can add your own standalone programs into the framework
can be found here 11.1.1

R Methods (Rserve)
""""""""""""""""""

are programs, that are implemented within some R package. Arbitrary methods imple-
mented in R can be used as a program, as long as they can be made available within
R on the server. This implies that the corresponding R Program is available for your
R version and that it can be compiled and installed on your server architecture. How
you can add your own R Programs into the framework can be found here 11.1.2.

Data Sets
^^^^^^^^^
To add a dataset to the framework and make it usable, such that clustering methods
can be applied to it, you have to

* insert the dataset file into the repository of the backend
* insert a header into the dataset which specifies its format, format version and type
* specify the dataset in a configuration file (called dataset configuration)

The dataset configuration contains the name and path of the dataset and other details
how a possible conversion of the dataset should be handled. An exact description of
how dataset configurations look like and which options and settings need to be specified
can be found in 4.9.3.
clusteval ships with a set of datasets of different types (PPI, Gene Expression,
Protein similarity, Word-Sense disambiguation), for example

* subsets of SCOP Astral95 v1.61,
* Brown et al. protein simliarities,
* leukemia microarray gene expression (Broad Institute),
* word context counts for word-sense disambiguation

Gold Standards
^^^^^^^^^^^^^^
When assessing the qualities of a resulting clustering for most measures a goldstandard corresponding to the dataset is needed. The comparison of the clustering and goldstandard is then integrated into the calculation of the clustering quality measure (see 4.6).

Goldstandards for a dataset are in principle optional. Some operations can be also performed without a goldstandard and also some clustering quality measures do not require a goldstandard (for example Silhouette Value). 

Nevertheless, to be able to perform all operations on the dataset, a goldstandard is required. To add a goldstandard to the framework, you have to

* insert the goldstandard file into the repository of the backend
* specify the goldstandard in a configuration file (called goldstandard configuration)

The goldstandard configuration contains the name and path to the goldstandard file. Since the framework does only support one goldstandard format, this does not need to be provided. An exact description of how goldstandard configurations look like and which options and settings need to be specified can be found in 4.9.5.

Input & Output Formats
^^^^^^^^^^^^^^^^^^^^^^

As already mentioned, datasets have their own formats and clustering methods can
require different input and output formats. The general process how these formats link
together can be visualized as seen in figure 4.
A dataset of a certain format known to the framework is converted into the standard
input format of the framework using the parser belonging to the format of the dataset.
Then the dataset in the standard format is converted to any of the supported input
formats of the clustering method using the parser belonging to the chosen supported
input format of the clustering method. Now the clustering method is applied to the
dataset in the supported format. A clustering result is produced in the format of the
clustering method. This result is then converted to the standard output format of the
framework using the parser belonging to the format of the result. The framework then
has access to the clustering results of the clustering method applied to the dataset in a
format it understands, such that diverse operations can be performed on the result.

If a new clustering method is added to the framework, its input and output formats
need to be known to the framework.
clusteval ships with a set of supported input and output formats. The input
formats are

TODO: remove this list; it should be somehow visible from the API itself

* APRowSimDataSetFormat
* BLASTDataSetFormat
* MatrixDataSetFormat
* RowSimDataSetFormat
* SimMatrixDataSetFormat
* TransClustSimMatrixDataSetFormat

and the output formats are

* APRunResultFormat
* MCLRunResultFormat
* TabSeparatedRunResultFormat
* TransClustRunResultFormat

If the new clustering method requires another input format not in the list, you will
have to make it available to the framework by writing

* a wrapper class for this dataset format and
* a parser, which converts the standardized input format of this framework to this input format.

If the new clustering method has a so far unknown output format, you will have to
provide

* a wrapper class for this output format as well as
* a parser that converts that format to the standardized output format.

When this clustering method is applied to a dataset, the resulting clustering in the
new format is converted to a standardized output format using your parser, such that
further analyses can be performed regardless of the used clustering method.
For more information on how the framework can be extended by new input or output
formats see 4.5 respectively.

Standard Input Format
"""""""""""""""""""""
The standard input format is a SimMatrixDataSetFormat which is described under
4.5.6.

Standard Output Format
""""""""""""""""""""""
The standard output format contains one clustering generated for parameter values
p 1 = v1,...,p K = vK in one line with clusters c1, ..., cK, cluster sizes size(ci) = si.
Every cluster ci contains elements e i 1, ..., e i si with fuzzy coefficients f i 1, ..., f i si.
The format for this looks as follows:

TODO

The parameter names and values on the left have to be separated by a TAB from
the string "Clustering" and the clustering on the right. If the fuzzy coefficients are
missing, the framework will not be able to parse the result file.

TODO: Move the following format descriptions into the javadoc

APRowSimDataSetFormat
"""""""""""""""""""""
This input format is used by Affinity Propagation. It is similar to the RowSimDataSet-
Format, except that it accepts only numbers as ids and that it leaves out lines where
id1=id2 such that it looks like this::

	1	2	0.2
	1	3	0.6
	2	1	0.2
	2	3	0.5
	3	1	0.6
	3	2	0.5

=== === ==========
Id1 Id2 Similarity
=== === ==========
1   2   0.2
1   3   0.6
2   1   0.2
2   3   0.5
3   1   0.6
3   2   0.5
=== === ==========

BLASTDataSetFormat
""""""""""""""""""

TODO

The BLAST dataset format needs a all-vs-all BLAST file and a corresponding FASTA
file.
Please note, that the FASTA file has to be named exactly like the BLAST file
plus the additional .fasta extension. If the BLAST file is named like MyBlastFile.blast,
then the FASTA file only be found by the framework, when it lies in the same directory
and is named MyBlastFile.blast.fasta.

MatrixDataSetFormat
"""""""""""""""""""

TODO

This input format is a absolute dataset format, that means it contains samples together
with their absolute coordinates:

RowSimDataSetFormat
"""""""""""""""""""

TODO

This input format consists of tab-separated rows looking as follows:

SimMatrixDataSetFormat
""""""""""""""""""""""
The SimMatrixDataSetFormat is a complete quadratic tab-separated similarity matrix
with header row and column (containing ids). A dataset file with the SimMatrix-
DataSetFormat could look as follows:

TODO

There are no spaces in this file, only tabs. It does not necessarily need to be symmetric,
it depends on the clustering method, whether it supports asymmetric similarity data.

TransClustSimMatrixDataSetFormat
""""""""""""""""""""""""""""""""
This format can be used by Transitivity Clustering and it looks as follows:

TODO

APRunResultFormat
"""""""""""""""""
This is the result format of Affinity Propagation.

MCLRunResultFormat
""""""""""""""""""
This is the result format of Markov Clustering.

TransClustRunResultFormat
"""""""""""""""""""""""""
This is the result format of Transitivity Clustering.


Clustering Quality Measures
^^^^^^^^^^^^^^^^^^^^^^^^^^^
The clustering quality measures are used by the framework to assess the quality of cal-
culated clusterings. clusteval ships with a standard set of clustering quality measures

TODO: remove this list; it should be somehow visible from the API itself

* F1 & F2-Score
* False Discovery Rate (FDR)
* False Positive Rate (FPR)
* Rand Index
* Sensitivity
* Specificity
* Silhouette Value (Java & R implementation)

Please check 4.6 for more information on how to extend the framework by new clustering
quality measures.

Distance Measures
^^^^^^^^^^^^^^^^^
The distance measures are used when converting absolute datasets (containing absolute
coordinates) to relative datasets (pairwise similarities). The distance measures define
how to assess the similarity between a pair of objects given their absolute coordinates.
clusteval ships with the following distance measures

TODO: remove this list; it should be somehow visible from the API itself

* Euclidian
* Hoeffding D Statistic (Rserve)
* Pearson Correlation Coefficient (Rserve)
* Spearman Correlation Coefficient (Rserve)

Please check 4.7 for more information on how to extend the framework by new distance
measures.

Parameter Optimization Methods
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
The backend can perform automatized and autonomous optimization of parameters of
clustering methods. This is an iterative procedure where the backend assesses qualities
of clustering results of the last iteration and adapts the parameter for the next iteration
in order to find optimal parameters for the method on the given data. The parameter
optimization method determines the following aspects:

1 the number of iterations of the optimization process
2 the parameter sets evaluated
3 the handling of diverging iterations
4 the storage of the iteration results in RAM

clusteval ships with the following set of parameter optimization methods

TODO: remove this list; it should be somehow visible from the API itself

* Affinity Propagation Divisive Parameter Optimization Method
* Affinity Propagation Parameter Optimization Method
* Divisive Parameter Optimization Method
* Gap Statistic Parameter Optimization Method
* Layered Divisive Parameter Optimization Method
* Transitivity Clustering Parameter Optimization Method
* Transitivity Clustering Quantile Parameter Optimization Method

Detailed information about each of these methods can be found in [1]. Please check 4.8
for more information on how to extend the framework by new parameter optimization
methods.

Configuration Files
^^^^^^^^^^^^^^^^^^^
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
"""""""""""""""""""
A data configuration is a file, that combines two other configurations together: A
dataset configuration (see 4.9.3) and a goldstandard configuration (see 4.9.5). Later
on when you create a run (and its configuration) and in this run you want to apply
two clustering methods to three datasets (together with their goldstandards) you will
do so by telling the run configuration the names of the three corresponding data con-
figurations. Please note: The data configuration file has to have the file extension
.dataconfig, otherwise it will not be recognized by the framework.

* datasetConfig: This option has to be set to the name of the dataset configuration (see 4.9.3), not the name of the file.
* goldstandardConfig: This option has to be set to the name of the goldstandard configuration (see 4.9.5), not the name of the file.

Example Data Configuration
""""""""""""""""""""""""""
A data configuration could look as follows::

	datasetConfig = astral_1
	goldstandardConfig = astral_1_161
	
Dataset Configuration
"""""""""""""""""""""
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

Example Dataset Configuration
"""""""""""""""""""""""""""""
A dataset configuration could look as follows::

	datasetName = astral_1_161
	datasetFile = blastResults.txt
	datasetFormat = BLASTDataSetFormat
	distanceMeasureAbsoluteToRelative = EuclidianDistanceMeasure
	
GoldStandard Configuration
""""""""""""""""""""""""""
A goldstandard configuration tells the framework meta information about the corre-
sponding goldstandard. That is: The internal name of the goldstandard and its file-
name.

* goldstandardName: This name is used to find and access goldstandards within the framework. The name of the goldstandard has to be identical to the subfolder of the corresponding goldstandard.
* goldstandardFile: This option has to be set to the filename of the goldstandard file residing within the subfolder of the goldstandard.

Example Goldstandard Configuration
""""""""""""""""""""""""""""""""""
A goldstandard configuration could look as follows::

	goldstandardName = astral_1_161
	goldstandardFile = astral_161.goldstandard_3.txt
	
Program Configuration
"""""""""""""""""""""
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
  
Example Program Configuration
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
""""
Runs are entities that can be performed by the backend server. A run is defined by a file in the folder <REPOSITORY ROOT>/runs . The name of that file (without extension) also defines the name of the run. Depending on the type of the run this file contains several other components which configure the process when the run is performed. Figure 6 shows the different types of runs and how they relate to each other.

Every run is defined in a run-file in the corresponding folder of the repository. Depending on the type of the run, different options are available that can be specified in the run-file. Common to all types of runs are the following options:

* mode: This entry can be set to "clustering", "parameter optimization", "dataAnalysis", "runAnalysis" or "runDataAnalysis". These types can be found in the aforementioned figure and are described in the following paragraphs.

TODO: robustness analysis run

Execution Runs
""""""""""""""
Execution runs calculate clusterings during their execution and assess qualities for every of those clusterings. Clusterings are calculated by applying clustering methods to datasets using a certain parameter set. That is why execution runs have sets of both, program and data configurations. During execution time every program configuration is applied to every data configuration in a pairwise manner. For every calculated clustering a set of clustering quality measures are assessed.

In general the options of such a combination of data and program configuration will be taken from these configurations respectively, but can be overridden by the options in the run configuration, That means parameter values defined in the program as well as in the run configuration will be taken from the latter.

For execution runs, additionally to the options defined for all runs (see Run Files), the following options for the run-file are defined:

* programConfig: This entry has to be set to a single name or a comma-separated list of names of program configurations. When this run is performed, these program configurations will be pairwise combined with the data configurations given in the option "dataConfig".
* dataConfig: This entry has to be set to a single name or a comma-separated list of names of data configurations. When this run is performed, these data configurations will be pairwise combined with the program configurations given in the option "programConfig".
* qualityMeasures: This option determines, which quality measures will be assessed for every clustering calculated during the run process. When this run is a clustering run (see option "mode"), then for every pair of data and program configurations there will be only one clustering as a result for which quality measures will be evaluated. When the mode is set to "parameter optimization", for every iteration during the parameter optimization process these quality measures will be evaluated.
* [<programConfigName> :] If a dedicated section is found in this run file that is called like one of the program configurations given in option "programConfig", several parameters can be overridden individually only for this program configuration which are 

* <parameterName>: The program parameter with the given name which needs to be defined in the program configuration can be fixed to a certain value.
  
Clustering Runs
"""""""""""""""
Clustering runs are a type of execution run, that means they calculate clusterings by applying every program configuration to every data configuration. Afterwards they assess the qualities of those clusterings in terms of several clustering quality measures.

In the case of clustering runs for every pair of program and data configuration exactly one clustering is calculated and assessed. Clustering runs are visualized in figure 7.

For clustering runs, the options are the same as for all execution runs (see Execution Run Files).

Parameter Optimization Runs
"""""""""""""""""""""""""""
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
"""""""""""""
Analysis runs assess certain properties of objects of interest. An analysis run has a set of target objects and a set of statistics, that should be assessed for each of the target objects. That means, during execution time for every target object every statistic is assessed in a pairwise manner.

Data Analysis Runs
""""""""""""""""""
In case of data analysis runs the target objects to analyze are data configurations (indirectly datasets) and the statistics are data statistics, that is properties of datasets. Data analysis runs are visualized in figure 9.

For data analysis runs the following options for the run-file are defined:

* dataStatistics: A comma separated list of data statistics to assess for the given data configurations.
* dataConfig: A comma separated list of data configurations to analyse.

Run Analysis Runs
"""""""""""""""""
In case of run analysis runs the target objects to analyze are clusterings (results of execution runs) and the statistics are run statistics, that is properties of execution run
results. Run analysis runs are visualized in figure 10.

For run analysis runs the following options for the run-file are defined:

* runStatistics: A comma separated list of run statistics to assess for the given execution run results.
* uniqeRunIdentifiers: A comma separated list of identifiers of execution run results. See 4.11 for an explanation on run result identifiers.

Run-Data Analysis Runs
""""""""""""""""""""""
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
	
Run Results
"""""""""""
When a run is performed, a unique run identifier is determined which includes the start time and date and the name of the run. If the run exampleRun is performed at the 5th of July 2012 at 12:58:38, its unique run identifier is::

	06_05_2012-12_58_38_exampleRun

which is also used as the subfolder to store its results in::

	<REPOSITORY ROOT>/results/06_05_2012-12_58_38_exampleRun.

Every such folder contains some subfolders. Common to all run types are the following subfolders:

* <REPOSITORY ROOT>/results/<runIdentifier>/configs : Contains the configuration files that are used in this run, which includes all data-, dataset-, goldstandard- and program configurations as well as the run file.
* <REPOSITORY ROOT>/results/<runIdentifier>/inputs : Contains backups of all the input files used in this run, which includes all datasets referenced by the data configurations.
* <REPOSITORY ROOT>/results/<runIdentifier>/goldstandards : Contains backups of all the goldstandard files used in this run.
* <REPOSITORY ROOT>/results/<runIdentifier>/logs : Contains different log files, one for the complete run and one for every iteration performed during the run.

Execution Run Results
"""""""""""""""""""""
Execution run result folders additionally contain the following subfolders:

* <REPOSITORY ROOT>/results/<runIdentifier>/clusters

Analysis Run Results
""""""""""""""""""""
Analysis run result folders additionally contain the following subfolders:

* <REPOSITORY ROOT>/results/<runIdentifier>/analyses


Website
--------
The frontend website is designed to give a visual representation of the results calculated by the backend and also of the datasets, goldstandards, configurations available in the repository. The website is divided into several sections which will be discussed in 8.1. Here we describe, which information you can find in which section. Afterwards it follows a short explanation for every task you can realize using the website, including how to compare available clustering methods or datasets and how to interprete visualized run results.

Overview
^^^^^^^
This section presents you with a comparison matrix, containing the best achieved clustering qualities for every pair of clustering method and dataset. Above the matrix you
can select from a list, which clustering quality measure you want to compare. Values in bold indicate the optimal clustering quality in the respective row. By hitting the Invert matrix button, you can interchange datasets with clustering methods, rows with columns.

Data Sets
^^^^^^^^^
On the left hand side you have different subsections to navigate to. Now you are at the "Overview" page.

* Overview shows you a list of all available datasets. The datasets are grouped together, based on their type.
  
  * By clicking on a dataset, you will be lead to information only about that dataset.
  * General shows general information about the dataset including the first 10 lines of the raw file and a download link.
  * Statistics shows data statistics assessed for this dataset.
  * Comparison shows a comparison table, how different clustering methods perform on this dataset, measured by different clustering quality measures.
  * Best Clusterings is comparable to the "Comparison" subsection, but also shows the parameter sets, that lead to the optimal clusterings.
  * Clusterings shows all qualities of clusterings measured with a certain clustering quality measure that were calculated for this dataset together with the corresponding parameter sets.
* Comparison will show you a table containing the optimal clustering qualities clustering methods achieved on a chosen dataset together with the parameter sets used.
  

Clustering Methods
^^^^^^^^^^^^^^^^^^
On the left hand side you have different subsections to navigate to. Now you are at the "Overview" page. 

* The overview shows you a list of all available clustering methods. For the clustering methods that ship with clusteval there will be shown a short description and a literature reference for more detailed information. 

  * Clicking on "Details" of a specific clustering method, will lead you to information only about that method.
  * General provides you with general information and a download link of the executable.
  * Performance shows a comparison table, how this clustering method performs on different datasets measured by different clustering quality measures.
  * Best Clusterings is comparable to the "Performance" subsection, but also shows the parameter sets, that lead to the optimal clusterings.
  * Comparison will show you a table containing the optimal clustering qualities a chosen clustering method achieved on different datasets together with the parameter sets used.

Measures
^^^^^^^^
This section shows you the available clustering quality measures.

* By clicking on a specific clustering quality measure you will get more information about it, including a formal definition.
  
Submit
^^^^^^
This section allows you to contribute your own clustering methods or datasets to clusteval.

* General shows a short text, what you can do within this section.
* Submit dataset presents you an email form to send an email to the clusteval server to request an addition of your new dataset.
* Submit method presents you an email form to send and email to the clusteval server to request an addition of your new clustering method.
  
Advanced
^^^^^^^^
The advanced section is only available after logging in into the website. This section shows more detailed information about the single runs that were performed, which run results were produced and all other data that is stored within the repository including configuration files.

* Clustering Method Configurations shows a table with all program configurations.
  
  * By clicking on a specific program configuration, you will see detailed information only about that configuration including e.g. the contents of the file or defined program parameters.
  * Additionally you see a second table containing the clusterings that were calculated for this program configuration.
* Data Configurations shows a table with all data configurations.
  
  * By clicking on a specific data configuration, you will see detailed information only about that configuration including e.g. the contents of the file or defined program parameters.
  * Additionally you see a second table containing the clusterings that were calculated for this data configuration.
    
* Dataset Configurations shows a table with all dataset configurations. 
  
  * By clicking on a specific dataset configuration, you will see detailed information only about that configuration.

* Goldstandard Configurations shows a table with all goldstandard configurations.
  
  * By clicking on a specific goldstandard configuration, you will see detailed information only about that configuration.

* Runs shows a table with all runs. 
    
  * By clicking on a specific run, you will see detailed information. Depending on the run type these information will vary.
  * For execution runs the used program and data configurations as well as the assessed clustering quality measures will be shown, for analysis runs the statistics to assess and the target objects (either data configurations, execution run results or both data analysis run results and execution run results together). For parameter optimization runs the used parameter optimization methods and optimization parameters will be listed.
* Results shows the run results calculated by the backend. Depending on the type of the run that corresponds to these run results, the representation varies.

  * Clustering Runs: Here only the program and data configurations together with the clustering quality measures to assess are shown.
  * Parameter Optimization Runs: Additionally to the details of clustering runs here also the used parameter optimization methods are listed together with the optimization parameters for each program configuration.
  * Data Analysis Runs: The data configurations to assess and the data statistics are shown.
  * Run Analysis Runs: The unique execution run result identifier are listed together with the run statistics to assess.
  * Run-Data Analysis Runs: The unique run result identifier of the execution run results and of the data analysis run results are shown together with the Run-Data Statistics to assess for pairs of these run results. 
    
Clustering Run Results
^^^^^^^^^^^^^^^^^^^^^^
A table is shown, with every pair of data and program configuration together with the evaluated parameter set and achieved clustering quality.

Parameter Optimization Run Results
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
For every pair of program and data configuration a graph and a table is shown. The graph contains the clustering qualities achieved in every iteration. It is good for visual inspection of the general optimization course. The table contains the same information, but in a textual format. It contains for every performed iteration of the parameter optimization process the evaluated parameter set, the assessed clustering quality measures together with the qualities of the resulting clusterings.

Data Analysis Run Results
^^^^^^^^^^^^^^^^^^^^^^^^^
For every data configuration you see a table containing rows for every assessed data statistic. On the left the name of the data statistic is shown and on the right you see either a plot or a string representation of the calculated data statistic. 

Run Analysis Run Results
^^^^^^^^^^^^^^^^^^^^^^^^
For every execution run result you see a table containing rows for every assessed run statistic. On the left the name of the run statistic is shown and on the right you see either a plot or a string representation of the calculated run statistic.

Run-Data Analysis Run Results
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
For every pair of execution run result and data analysis run result you see a table containing rows for every assessed run-data statistic. On the left the name of the run-data statistic is shown and on the right you see either a plot or a string representation of the calculated run-data statistic.

Database
--------
The SQL database of the frontend stores a subset of the data contained in the repository of the backend. The stored information can then be retrieved and visualized by the website.

Tables
^^^^^^
In the following we will give a short description of every table of the mysql database. Table names in square brackets correspond to rather technical tables, that are just required by the models of the ruby on rails website and do not have a strong meaning with regard to contents.

* Hint 1 : All tables that correspond to and are responsible for storing repository objects have a foreign key to the repository table. Thus for every repository object it is known, to which repository it belongs. This is not mentioned in the following descriptions.
* Hint 2 : The abbreviation FK means Foreign Key.
* Hint 3 : Column names are denoted in italic.
* Hint 4 : When a run is performed, certain files are copied into a new result folder. This includes datasets, goldstandards and all configuration files. These files in the result folder are mapped to their original files they correspond to in the original repository. These relationships are stored in the database in a separate column which is named after the table name plus the postfix " id". For example datasets store this relationship in the column "dataset id".

TODO: definitely outdated!

* [aboutus]: A technical table containing the information regarding the 'About us' section of the website.
* [admins]: A technical table containing the information regarding the 'Admin' section of the website.
* cluster objects: Every clustering contains clusters, which again contain cluster objects. This table stores all cluster objects with their name and knows, to which cluster they belong (cluster id, FK).
* clustering quality measure optimums: For visualization and interpretation of results the website needs to know, whether a certain clustering quality measure is optimal when min- or maximized. This table maps every measure to 'Minimum' or 'Maximum' (name).
* clustering quality measures: This table keeps track of all the clustering quality measures available in the framework. For every measure it stores its name, minimal and maximal value (minValue and maxValue) and whether the measure requires a goldstandard (requiresGoldStandard ). On the website every clustering quality measure has a readable alias. This alias is stored in the column (alias).
* clusterings: This table holds all the clusterings that were calculated and are stored in the repository. Every parsed clustering corresponds to a file in the repository, for which we store its absolute path (absPath).
* clusters: Every clustering has clusters. This table holds all clusters and maps them to their corresponding clustering. Every cluster has a name.
* data configs: A table holding all data configurations. Every data configuration has an absolute path (absPath), a name, a corresponding dataset configuration (dataset config id, FK) and a goldstandard configuration (goldstandard config id, FK).
* dataset configs: A table holding all dataset configurations. Every dataset configuration has an absolute path (absPath), a name and a corresponding dataset (dataset id, FK). 
* dataset formats: A table holding all dataset formats. Every format has a name and an alias.
* dataset types: This table holds all types of datasets. For every dataset type it stores a name. On the website every dataset type has a readable alias. For every dataset type this table stores the alias.
* datasets: This table holds all datasets. For every dataset its absolute path (absPath), checksum, format (dataset format id, FK) and type (dataset type id, FK) is stored.
* goldstandard configs: This table holds all goldstandard configurations. For every goldstandard configuration its absolute path (absPath), name and corresponding goldstandard (goldstandard id, FK) is stored.
* goldstandards: This table holds all goldstandards. For every goldstandard its absolute path (absPath), and the corresponding goldstandard (goldstandard id, FK) is stored.
* [helps]: A technical table containing the information regarding the 'Help' section of the website.
* [mains]: A technical table containing the information regarding the startpage of the website.
* optimizable program parameters: This table stores the program parameters (program parameter id, FK) of a program configuration (program config id, FK), that can be optimized.
* parameter optimization methods: This table stores all available parameter optimization methods (name) registered in a repository (repository id, FK).
* program configs: All program configurations registered in a repository are stored in this table. Every program configuration has a name, an absolute path (absPath), different invocation formats for different scenarios (invocationFormat, invocationFormatWithoutGoldStandard, invocationFormatParameterOptimization, invocationFormatParameterOptimizationWithoutGoldStandard ) and a boolean whether the program expects input with normalized similiarites (expectsNormalizedDataSet). For every program configuration we store the corresponding repository (repository id, FK), the program (program id, FK) this configuration belongs to, the run result format (run result format id, FK) of the program using this configuration.
* program configs compatible dataset formats: Every program configuration (program config id, FK) has a set of compatible dataset formats (dataset format id, FK), which the program will understand when it is executed using this configuration.
* [program descriptions]: This table stores descriptions of clustering methods, for when they are shown on the website.
* [program images]: When this table contains an image for a clustering method, it will be shown on the website.
* program parameter types: This table contains the names (name) of the different possible program parameter types (see 4.9.7 for more information on the types of parameters supported by clusteval ).
* program parameters: This table stores the program parameters defined in a program configuration (program config id, FK). Every program parameter has a type (program parameter type id, FK), a name, an (optional) description, a minValue, a maxValue and a default value (def ).
* [program publications]: When this table contains publication information for a clustering method, it will be shown on the website.
* programs: This tables stores all clustering methods together with their absPath and an alias, which is used to represent this clustering method on the website.
* repositories: The repositories that are using this database to store their results. Every repository has a absolute base directory (basePath) and a type (repository type id, FK).
* repository types: The types that repositories can have. Every type has a name. Check out 4.1 for more information on which repository types exist.
* run analyses: This table holds all analysis runs. Every analysis run is also a run (run id, FK).
* run analysis statistics: Every analysis run (run analysis id, FK) evaluates certain statistics (statistic id, FK).
* run clusterings: This table holds all clustering runs. Every clustering run is also a execution run (run execution id, FK).
* run data analyses: This table holds all data analysis runs. Every data analysis run is also an analysis run (run analysis id, FK).
* run data analysis data configs: Every data analysis run analysis a set of data configurations wrapping datasets. This table holds the data configurations (data config id, FK) that a certain data analysis run (run data analysis id, FK) analyses.
* run execution data configs: An execution run applies program configurations to data configurations. This table stores the data configurations (data config id, FK) belonging to execution runs (run execution id, FK).
* run execution parameter values: An execution run can specify values for program parameters. This table stores for every execution run (run execution id, FK), program configuration (program config id, FK) and program parameter (program parameter id, FK) the specified value.
* run execution program configs: An execution run applies program configurations to data configurations. This table stores the program configurations (program config id, FK) belonging to execution runs (run execution id, FK).
* run execution quality measures: An execution run applies clustering methods to datasets and assesses clustering quality measures. This table stores the execution run (run execution id, FK) together with the clustering quality measures (clustering quality measure id, FK) to assess.
* run executions: This table holds all execution runs. Every execution run is also a run (run id, FK).
* run internal parameter optimizations: This table holds all internal parameter optimization runs. Every such run is also an execution run (run execution id, FK).
* run parameter optimization methods: A parameter optimization run uses parameter optimization methods to optimize parameters. For a certain parameter optimization run (run parameter optimization id, FK) for every program configuration (program config id, FK) a different parameter optimization method (parameter optimization method id, FK) and a clustering quality measure to optimize can be specified.
* run parameter optimization parameters: A parameter optimization run optimizes parameters of clustering methods. This table stores for a certain run (run parameter optimization id, FK) for every program configuration contained (program config id, FK) the parameters (program parameter id, FK) to optimize.
* run parameter optimization quality measures: A parameter optimization run optimizes parameters by maximizing or minimizing clustering quality measures. This table stores all clustering quality measures (clustering quality measure id, FK) to assess for the calculated clusterings.
* run parameter optimizations: This table holds all parameter optimization runs. Every parameter optimization run is also an execution run (run execution id, FK).
* run result data analysis data configs statistics: A data analysis run assesses statistics for certain data configurations. This table stores the assessed statistics (statistic id, FK) for every run result (run result id, FK) generated by a
* run result formats: This table holds all run result formats. Every run result format has a name.
* run results: When a run is executed, it produces a unique folder in the results directory of the repository. These folders are stored in this table together with the type of the corresponding run (run id, FK) that created this result (run type id, FK), an absolute path to the results folder (absPath), the uniqueRunIdentifier of this run result (which corresponds to the name of the folder) and the date the run result was created.
* run results analyses: When an analysis run is executed, it produces a unique folder in the results directory of the repository. Every analysis run result is also a run result (run result id, FK).
* run results clusterings: When a clustering run is executed, it produces a unique folder in the results directory of the repository. Every clustering run result is also an execution run result (run results execution id, FK).
* run results data analyses: When a data analysis run is executed, it produces a unique folder in the results directory of the repository. Every data analysis run result is also an analysis run result (run results analysis id, FK).
* run results executions: When an execution run is executed, it produces a unique folder in the results directory of the repository. Every execution run result is also a run result (run result id, FK).
* run results internal parameter optimizations: When an internal parameter optimization run is executed, it produces a unique folder in the results directory of the repository. Every internal parameter optimization run result is also an execution run result (run results execution id, FK).
* run results parameter optimizations: When a parameter optimization run is executed, it produces a set of iterative run results, that are all summarized in .complete-files for every pair of program and data configuration (program config id, FK) and (data config id, FK). Every parameter optimization run result is also an execution run result (run results execution id, FK).
* run results parameter optimizations parameter set iterations: Every parameter optimization produces clustering results for a set of iterations. In each iteration a different parameter set (run results parameter optimizations parameter set id, FK) is evaluated. This table holds the number of the iteration, together with the parameter set, the produced clustering (clustering id, FK) and the parameter set in a string representation (paramSetAsString).
* run results parameter optimizations parameter set parameters: This table holds the program parameters (program parameter id, FK) that belong to parameter sets (run results parameter optimizations parameter set id, FK) contained in a parameter optimization run result (run results parameter optimization id, FK), evaluated by the framework.
* run results parameter optimizations parameter sets: This table holds the parameter sets evaluated during a parameter optimization run and contained in a parameter optimization run result (run results parameter optimization id, FK).
* run results parameter optimizations parameter values: This table contains the value of a certain program parameter (run results parameter optimizations parame FK) evaluated in a certain parameter optimization iteration (run results parameter optimizations parame FK).
* run results parameter optimizations qualities: In every iteration of a parameter optimization a parameter set is evaluated and clus- tering qualities are assessed. This table holds the clustering quality measure (cluster quality measure id, FK) together with the assessed quality.
* run results run analyses: When a run analysis run is executed, it produces a unique folder in the results directory of the repository. Every run analysis run result is also an analysis run result (run results analysis id, FK).
* run results run data analyses: When a run-data analysis run is executed, it produces a unique folder in the results directory of the repository. Every run-data analysis run result is also an analysis run result (run results analysis id, FK).
* run run analyses: This table holds all run analysis runs. Every run analysis run is also an analysis run (run analysis id, FK).
* run run analysis run identifiers: Every run analysis run analyses (run run analysis id, FK) a set of run results with certain identifiers (runIdentifier ).
* run run data analyses: This table holds all run-data analysis runs. Every run-data analysis run is also an analysis run (run analysis id, FK).
* run run data analysis data identifiers: Every run-data analysis run analyzes (run run analysis id, FK) a set of data analysis run results with certain identifiers (dataIdentifier ).
* run run data analysis run identifiers: Every run-data analysis run analyzes (run run analysis id, FK) a set of execution run results with certain identifiers (runIdentifier ).
* run types: This table holds all types of runs. Every type has a name. Check out 6 for more information on which run types exist.
* runs: This table holds all runs. Every run has a type (run type id, FK), an absolute path (absPath), a name and a status.
* [schema migrations]: This table holds all the migrations of the ruby on rails website.
* statistics: This table holds all the statistics registered in a repository. Every statistic has a name and an alias. The alias is used on the website as a readable name.
* statistics datas: This table holds all the data statistics. Every data statistic is also a statistic (statistic id, FK).
* statistics runs: This table holds all the run statistics. Every run statistic is also a statistic (statistic id, FK).
* statistics run datas: This table holds all the run-data statistics. Every run-data statistic is also a statistic (statistic id, FK).
* [submit datasets]: This table corresponds to the section "Submit Dataset" of the website.
* [submit methods]: This table corresponds to the section "Submit Clustering Method" of the website.
* [submits]: This table corresponds to the "Submit" section of the website.
* [users]: This table holds all the users, that have registered on the website.

Extending ClustEval
-------------------
clusteval can be extended in different ways. The following sections will show you, which functionality you can add to the framework and how.

Clustering Methods
^^^^^^^
As explained in 4.2 clusteval supports two different kinds of clustering methods: Stan-
dalone programs and R programs. Standalone programs are those, for which you have
to provide an executable file which then will be executed by the framework. R programs
are methods implemented in R, which will be invoked by clusteval by using the Rserve
interface.

Standalone Programs
"""""
Standalone programs can be added to clusteval by
1. putting the executable file (together with all required shared libraries) into a
respective folder in the repository programs directory
<REPOSITORY ROOT>/programs/<programFolder>/<executable>
2. putting a program configuration file (see 4.9.7) into the repository program con-
figuration directory
<REPOSITORY ROOT>/programs/configs
3. if the program requires a new input format, follow the instructions under 11.3 for
the new input format
4. if the program has an unknown output format, follow the instructions under 11.4
for the new output format

R Programs
"""""
R programs can be added to clusteval by
1. extending the class de.clusteval.program.r.RProgram with your own class MyRProgram .
You have to provide your own implementations for the following methods, other-
wise the framework will not be able to load your class.
(a) public MyRProgram(Repository) : The constructor of your class taking a
repository parameter. This constructor has to be implemented and public,
otherwise the framework will not be able to load your class.
(b) public MyRProgram(MyRProgram) : The copy constructor of your class
taking another instance of your class. This constructor has to be imple-
mented and public.
(c) public String getAlias() : This alias is used whenever this program is visu-
ally represented and a readable name is needed. This is used to represent
your program on the website for example.
(d) public String getInvocationFormat() : This is the invocation of the R method
including potential parameters, that have to be defined in the program con-
figuration.
(e) public Set getRequiredLibraries() : This method returns the set of strings,
with names of all required R libraries this program uses.
(f) public Process exec(DataConfig,ProgramConfig,String[],Map,Map) : In this
method the actual execution of the R Program happens. In here you have
to implement the invocation of the R method via Rserve and any pre- and
postcalculations necessary. The communications with R can be visualized
by the following code snippet:
try {
// precalculations
double[] input = ...;
...
MyRengine rEngine = new MyRengine("");
try {
rEngine.assign("input",input);
rEngine.eval("result <- yourMethodInvocation()");
REXP result = rEngine.eval("result@.Data");
// postcalculations
...
} catch (RserveException e) {
e.printStackTrace();
} finally {
rEngine.close();
}
} catch (Exception e) {
e.printStackTrace();
}
// for return type compatibility reasons
return null;
2. Creating a jar file named MyRProgram.jar containing the MyRProgram.class
compiled on your machine in the correct folder structure corresponding to the
packages:
de/clusteval/program/r/MyRProgram.class
3. Putting the MyRProgram.jar into the programs folder of the repository:
<REPOSITORY ROOT>/programs
The backend server will recognize and try to load the new program automatically
the next time, the RProgramFinderThread checks the filesystem.

Dataset Types
^^^^^^^
Dataset types can be added to clusteval by
1. extending the class de.clusteval.data.dataset.type.DataSetType with your own
class MyDataSetType . You have to provide your own implementations for the
following methods, otherwise the framework will not be able to load your class.
(a) public MyDataSetType(Repository, boolean,long, File) : The constructor of
your class. This constructor has to be implemented and public, otherwise
the framework will not be able to load your class.
(b) public MyDataSetType(MyDataSetType) : The copy constructor of your
class taking another instance of your class. This constructor has to be im-
plemented and public.
(c) public String getAlias() : This alias is used whenever this program is visu-
ally represented and a readable name is needed. This is used to represent
your program on the website for example.
2. Creating a jar file named MyDataSetType.jar containing the MyDataSetType.class
compiled on your machine in the correct folder structure corresponding to the
packages:
de/clusteval/data/dataset/type/MyDataSetType.class
3. Putting the MyDataSetType.jar into the dataset types folder of the repository:
<REPOSITORY ROOT>/supp/types/dataset
The backend server will recognize and try to load the new dataset type automat-
ically the next time, the DataSetTypeFinderThread checks the filesystem.

Dataset Formats
^^^^^^^
A dataset format MyDataSetFormat can be added to clusteval by
1. extending the class de.clusteval.data.dataset.format.DataSetFormat with your
own class MyDataSetFormat . You have to provide your own implementations
for the following methods, otherwise the framework will not be able to load your
dataset format.
(a) public MyDataSetFormat(Repository, boolean, long, File, int) : The construc-
tor of your dataset format class. This constructor has to be implemented
and public, otherwise the framework will not be able to load your dataset
format.
(b) public MyDataSetFormat(MyDataSetFormat) : The copy constructor of your
class taking another instance of your class. This constructor has to be im-
plemented and public.
2. extending the class de.clusteval.data.dataset.format.DataSetFormatParser with
your own class MyDataSetFormatParser . You have to provide your own imple-
mentations for the following methods, otherwise the framework will not be able
to load your class.
public DataSet convertToStandardFormat(DataSet,
(a)
ConversionInputToStandardConfiguration)
: This method converts
the given dataset to the standard input format of the framework using the
given conversion configuration. This assumes, that the passed dataset has
this format.
public DataSet convertToThisFormat(DataSet, DataSetFormat,
ConversionConfiguration)
: This method
(b)
converts the given dataset to the given input format using the conversion
configuration.
(c) public Object parse(DataSet) : This method parses the given dataset and
returns an object, wrapping the contents of the dataset (e.g. an instance of
SimilarityMatrix or DataMatrix ).
3. Creating a jar file named MyDataSetFormat.jar containing the MyDataSetFormat.class
and MyDataSetFormatParser.class compiled on your machine in the correct
folder structure corresponding to the packages:
de/clusteval/data/dataset/format/MyDataSetFormat.class
de/clusteval/data/dataset/format/MyDataSetFormatParser.class
4. Putting the MyDataSetFormat.jar into the dataset formats folder of the reposi-
tory:
<REPOSITORY ROOT>/supp/formats/dataset
The backend server will recognize and try to load the new dataset format auto-
matically the next time, the DataSetFormatFinderThread checks the filesystem.


Run Result Formats
^^^^^^^
A runresult format MyRunResultFormat can be added to clusteval by
1. extending the class de.clusteval.run.result.format.RunResultFormat with your
own class MyRunResultFormat . You have to provide your own implementations
for the following methods, otherwise the framework will not be able to load your
runresult format.
(a) public MyRunResultFormat(Repository, boolean, long, File) : The construc-
tor of your runresult format class. This constructor has to be implemented
and public, otherwise the framework will not be able to load your runresult
format.
(b) public MyRunResultFormat(MyRunResultFormat) : The copy constructor
of your class taking another instance of your class. This constructor has to
be implemented and public.
2. extending the class de.clusteval.run.result.format.RunResultFormatParser with
your own class MyRunResultFormatParser . You have to provide your own im-
plementations for the following methods, otherwise the framework will not be able
to load your class.
(a) public void convertToStandardFormat() : This method converts the given run-
result to the standard runresult format of the framework. The converted
runresult has to be named exactly as the input file postfixed with the exten-
sion ".conv". The original runresult
<REPOSITORY ROOT>/results/<runIdentifier>/clusters/TransClust sfld.1.result
has to be converted to
<REPOSITORY ROOT>/results/<runIdentifier>/clusters/TransClust sfld.1.result.conv
by this method. A wrapper o
3. Creating a jar file named MyRunResultFormat.jar containing the MyRunResultFormat.class
and MyRunResultFormatParser.class compiled on your machine in the correct
folder structure corresponding to the packages:
de/clusteval/run/result/format/MyRunResultFormat.class
de/clusteval/run/result/format/MyRunResultFormatParser.class
4. Putting the MyRunResultFormat.jar into the runresult formats folder of the
repository:
<REPOSITORY ROOT>/supp/formats/runresult
The backend server will recognize and try to load the new runresult format auto-
matically the next time, the RunResultFormatFinderThread checks the filesys-
tem.

Parameter Optimization Methods
^^^^^^^
A parameter optimization method MyParameterOptimizationMethod can be added
to clusteval by
1. extending the class de.clusteval.cluster.paramOptimization.ParameterOptimizationMethod
with your own class MyParameterOptimizationMethod . You have to provide
your own implementations for the following methods, otherwise the framework
will not be able to load your parameter optimization method.
public MyParameterOptimizationMethod(Repository, boolean, long, File,
ParameterOptimizationRun, ProgramConfig, DataConfig, List,
(a)
ClusteringQualityMeasure, int[], boolean)
: The
constructor for your parameter optimization method. This constructor has
to be implemented and public, otherwise the framework will not be able to
load your parameter optimization method.
public MyParameterOptimizationMethod( MyParameterOptimization-
(b) Method)
: The
copy constructor for your parameter optimization method. This constructor
has to be implemented and public, otherwise the framework will not be able
to load your parameter optimization method.
(c) public List getCompatibleDataSetFormatBaseClasses() : A list of dataset
formats, this parameter optimization method can be used for. If the list is
empty, all dataset formats are assumed to be compatible.
(d) public List getCompatibleProgramNames() : A list of names of all programs
that are compatible to this parameter optimization method. If the list is
empty, all programs are assumed to be compatible.
(e) public boolean hasNext() : This method indicates, whether their is another
parameter set to evaluate. This method must not change the current
parameter set, as it may be invoked several times before next() is invoked.
(f) protected ParameterSet getNextParameterSet(ParameterSet) : Returns the
next parameter set to evaluate. This method may change the internal status
of the parameter optimization method, in that it stores the newly determined
and returned parameter set as the current parameter set.
(g) public Set getRequiredRlibraries() : Returns a set of names of all R li-
braries, this parameter optimization method requires.
(h) public int getTotalIterationCount() : This is the total iteration count this
parameter optimization method will perform. The returned value might not
correspond to the expected value, when the method is instantiated. There-
fore always use the return value of this method, when trying to determine
the finished percentage of the parameter optimization process.
2. Creating a jar file named MyParameterOptimizationMethod.jar containing the
MyParameterOptimizationMethod.class compiled on your machine in the correct
folder structure corresponding to the packages:
de/clusteval/cluster/paramOptimization/MyParameterOptimizationMethod.class
3. Putting the MyParameterOptimizationMethod.jar into the parameter optimiza-
tion methods folder of the repository:
<REPOSITORY ROOT>/supp/clustering/paramOptimization
The backend server will recognize and try to load the new parameter optimization
method automatically the next time, the ParameterOptimizationMethodFinderThread
checks the filesystem.


Distance Measures
^^^^^^^
A distance measure MyDistanceMeasure can be added to clusteval by
1. extending the class de.clusteval.data.distance.DistanceMeasure with your own
class MyDistanceMeasure . You have to provide your own implementations for
the following methods, otherwise the framework will not be able to load your
distance measure.
(a) public MyDistanceMeasure(Repository, boolean, long, File) : The construc-
tor for your distance measure. This constructor has to be implemented and
public, otherwise the framework will not be able to load your distance mea-
sure.
(b) public MyDistanceMeasure(MyDistanceMeasure) : The copy constructor for
your distance measure. This constructor has to be implemented and public,
otherwise the framework will not be able to load your distance measure.
(c) public double getDistance(double[],double[]) : This method is the core of
your distance measure. It returns the distance of the two points specified by
the absolute coordinates in the two double arrays.
(d) public boolean supportsMatrix() : This method indicates, whether your dis-
tance measure can calculate distances of a whole set of point-pairs, i.e. your
distance measure implements the method getDistances(double[][]).
(e) public double[][] getDistances(double[][]) : The absolute coordinates of the
points are stored row-wise in the given matrix and distances are calculated
between every pair of rows. Position [i][j] of the returned double[][] matrix
contains the distance between the i-th and j-th row of the input matrix.
(f) public Set getRequiredRlibraries() : Returns a set of names of all R li-
braries, this distance measure requires.
2. Creating a jar file named MyDistanceMeasure.jar containing the MyDistanceMeasure.class
compiled on your machine in the correct folder structure corresponding to the
packages:
de/clusteval/data/distance/MyDistanceMeasure.class
3. Putting the MyDistanceMeasure.jar into the distance measure folder of the
repository:
<REPOSITORY ROOT>/supp/distanceMeasures
The backend server will recognize and try to load the new distance measure au-
tomatically the

Clustering Quality Measures
^^^^^^^
A clustering quality measure MyClusteringQualityMeasure can be added to clusteval
by
1. extending the class de.clusteval.cluster.quality.ClusteringQualityMeasure with
your own class MyClusteringQualityMeasure . You have to provide your own
implementations for the following methods, otherwise the framework will not be
able to load your clustering quality measure.
(a) public MyClusteringQualityMeasure(Repository, boolean, long, File) : The
constructor for your distance measure. This constructor has to be imple-
mented and public, otherwis
(b) public MyClusteringQualityMeasure(MyClusteringQualityMeasure) : The copy
constructor for your distance measure. This constructor has to be imple-
mented and public, otherwise the framework will not be able to load your
clustering quality measure.
(c) public String getAlias() : This method returns a readable alias for this clus-
tering quality measure which is used e.g. on the website.
(d) public double getMinimum() : Returns the minimal value this measure can
calculate.
(e) public double getMaximum() : Returns the maximal value this measure can
calculate.
(f) public boolean requiresGoldStandard() : Indicates, whether this clustering
quality measure requires a goldstandard to assess the quality of a given
clustering.
(g) public ClusteringQualityMeasureValue getQualityOfClustering(Clustering) :
This method is the core of your clustering quality measure. It assesses and
returns the quality of the given clustering.
(h) public boolean isBetterThanHelper(ClusteringQualityMeasureValue : This
method is used by sorting algorithms of the framework to compare clustering
quality measure results and find the optimal parameter sets.
(i) public Set getRequiredRlibraries() : Returns a set of names of all R li-
braries, this clustering quality measure requires.
2. Creating a jar file named MyClusteringQualityMeasure.jar containing the MyClusteringQualityM
compiled on your machine in the correct folder structure corresponding to the
packages:
de/clusteval/cluster/quality/MyClusteringQualityMeasure.class
3. Putting the MyClusteringQualityMeasure.jar into the clustering quality measure
folder of the repository:
<REPOSITORY ROOT>/supp/clustering/qualityMeasures
The backend server will recognize and try to load the new clustering quality mea-
sure automatically the next time, the ClusteringQualityMeasureFinderThread
checks the filesystem.

Data Statistics
^^^^^^^
A data statistic MyDataStatistic can be added to clusteval by
1. extending the class de.clusteval.data.statistic.DataStatistic with your own class
MyDataStatistic . You have to provide your own implementations for the follow-
ing methods, otherwise the framework will not be able to load your class.
(a) public MyDataStatistic(Repository, boolean, long, File) : The constructor
for your data statistic. This constructor has to be implemented and public,
otherwise the framework will not be able to load your class.
(b) public MyDataStatistic(MyDataStatistic) : The copy constructor for your
data statistic. This constructor has to be implemented and public, otherwise
the framework will not be able to load your class.
(c) public boolean requiresGoldStandard() : Indicates, whether this data statis-
tic requires a goldstandard to assess the property of a given dataset.
(d) public String getAlias() : This method returns a readable alias for this data
statistic which is used e.g. on the website.
(e) public void parseFromString(String) : This method interprets the string and
fills this statistic object with its parsed contents.
(f) public Set getRequiredRlibraries() : Returns a set of names of all R li-
braries, this data statistic requires.
2. extending the class de.clusteval.data.statistic.DataStatisticCalculator with your
own class MyDataStatisticCalculator . You have to provide your own implemen-
tations for the following methods, otherwise the framework will not be able to
load your class.
(a) public MyDataStatisticCalculator(Repository, long, File, DataConfig) : The
constructor for your data statistic calculator. This constructor has to be im-
plemented and public, otherwise the framework will not be able to load your
class.
(b) public MyDataStatisticCalculator(MyDataStatisticCalculator) : The copy
constructor for your data statistic calculator. This constructor has to be
implemented and public, otherwise the framework will not be able to load
your class.
(c) protected MyDataStatistic calculateResult() : This method is the core of
your data statistic calculator. It analysis the given data configuration and
returns a wrapper object for the results.
(d) public void writeOutputTo(File) : After calculateResult() has been invoked,
this method writes the assessed results into the given file.
3. Creating a jar file named MyDataStatisticCalculator.jar containing the MyDataStatistic.class
and MyDataStatisticCalculator.class compiled on your machine in the correct
folder structure corresponding to the packages:
de/clusteval/data/statistics/MyDataStatistic.class
de/clusteval/data/statistics/MyDataStatisticCalculator.class
4. Putting the MyDataStatistic.jar into the data statistics folder of the repository:
<REPOSITORY ROOT>/supp/statistics/data
The backend server will recognize and try to load the new data statistics auto-
matically the next time, the DataStatisticFinderThread checks the filesystem.

Run Statistics
^^^^^^^
See the API documentation of :java:ref:`RunStatistic`.


Run-Data Statistics
^^^^^^^
A run-data statistic MyRunDataStatistic can be added to clusteval by
1. extending the class de.clusteval.run.statistic.RunDataStatistic with your own
class MyRunDataStatistic . You have to provide your own implementations for
the following methods, otherwise the framework will not be able to load your
class.
(a) public MyRunDataStatistic(Repository, boolean, long, File) : The construc-
tor for your run-data statistic. This constructor has to be implemented and
public, otherwise the framework will not be able to load your class.
(b) public MyRunDataStatistic(MyRunDataStatistic) : The copy constructor
for your run-data statistic. This constructor has to be implemented and
public, otherwise the framework will not be able to load your class.
(c) public String getAlias() : This method returns a readable alias for this run-
data statistic which is used e.g. on the website.
(d) public void parseFromString(String) : This method interprets the string and
fills this statistic object with its parsed contents.
(e) public Set getRequiredRlibraries() : Returns a set of names of all R li-
braries, this run-data statistic requires.
2. extending the class de.clusteval.run.statistic.RunDataStatisticCalculator with
your own class MyRunDataStatisticCalculator . You have to provide your own
implementations for the following methods, otherwise the framework will not be
able to load your class.
(a) public MyRunDataStatisticCalculator(Repository, long, File, DataConfig) :
The constructor for your run-data statistic calculator. This constructor has
to be implemented and public, otherwise the framework will not be able to
load your class.
(b) public MyRunDataStatisticCalculator(MyRunDataStatisticCalculator) : The
copy constructor for your run-data statistic calculator. This constructor has
to be implemented and public, otherwise the framework will not be able to
load your class.
(c) protected MyRunDataStatistic calculateResult() : This method is the core
of your run-data statistic calculator. It analysis the given runresults (data
analysis and clustering) and returns a wrapper object for the results.
(d) public void writeOutputTo(File) : After calculateResult() has been invoked,
this method writes the assessed results into the given file.
3. Creating a jar file named MyRunDataStatisticCalculator.jar containing the MyRunDataStatistic.
and MyRunDataStatisticCalculator.class compiled on your machine in the cor-
rect folder structure corresponding to the packages:
de/clusteval/run/statistics/MyRunDataStatistic.class
de/clusteval/run/statistics/MyRunDataStatisticCalculator.class
4. Putting the MyRunDataStatistic.jar into the run-data statistics folder of the
repository:
<REPOSITORY ROOT>/supp/statistics/rundata
The backend server will recognize and try to load the new run-data statistics au-
tomatically the next time, the RunDataStatisticFinderThread checks the filesys-
tem.