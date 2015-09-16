Database
--------
The SQL database of the frontend stores a subset of the data contained in the repository of the backend. The stored information can then be retrieved and visualized by the website.

Supported SQL derivates
^^^^^^^^^^^^^^^^^^^^^^^
Currently, the ClustEval backend supports MySQL and postgreSQL. The website uses postgreSQL by default because of its support for materialized views. See :ref:`repository_config` for an explanation how to configure a database for a repository.

Tables
^^^^^^
In the following we will give a short description of every table of the database.

* Hint 1 : All tables that correspond to and are responsible for storing repository objects have a foreign key to the repository table. Thus for every repository object it is known, to which repository it belongs. This is not mentioned in the following descriptions.
* Hint 2 : The abbreviation FK means Foreign Key.
* Hint 3 : Column names are denoted in italic.
* Hint 4 : When a run is performed, certain files are copied into a new result folder. This includes datasets, goldstandards and all configuration files. These files in the result folder are mapped to their original files they correspond to in the original repository. These relationships are stored in the database in a separate column which is named after the table name plus the postfix " id". For example datasets store this relationship in the column "dataset id".

**cluster_objects**
  Every clustering contains clusters, which again contain cluster objects. This table stores all cluster objects with their name and knows, to which cluster they belong (cluster id, FK).
**clustering_quality_measure_optimums**
  For visualization and interpretation of results the website needs to know, whether a certain clustering quality measure is optimal when min- or maximized. This table maps every measure to 'Minimum' or 'Maximum' (name).
**clustering_quality_measures**
  This table keeps track of all the clustering quality measures available in the framework. For every measure it stores its name, minimal and maximal value (minValue and maxValue) and whether the measure requires a goldstandard (requiresGoldStandard ). On the website every clustering quality measure has a readable alias. This alias is stored in the column (alias).
**clusterings**
  This table holds all the clusterings that were calculated and are stored in the repository. Every parsed clustering corresponds to a file in the repository, for which we store its absolute path (absPath).
**clusters**
  Every clustering has clusters. This table holds all clusters and maps them to their corresponding clustering. Every cluster has a name.
**data_configs**
  A table holding all data configurations. Every data configuration has an absolute path (absPath), a name, a corresponding dataset configuration (dataset config id, FK) and a goldstandard configuration (goldstandard config id, FK).
**dataset_configs**
  A table holding all dataset configurations. Every dataset configuration has an absolute path (absPath), a name and a corresponding dataset (dataset id, FK). 
**dataset_descriptions**
  Holds descriptions of each data set. Is seeded by the seeds.db file of the Rails app.
**dataset_formats**
  A table holding all dataset formats. Every format has a name and an alias.
**dataset_images**
  Contains the name of the image correspond to a data set, if it has one.
**dataset_publications**
  Contains the references of data sets, if available.
**dataset_types**
  This table holds all types of datasets. For every dataset type it stores a name. On the website every dataset type has a readable alias. For every dataset type this table stores the alias.
**dataset_visibilities**
  Determines whether a data set is visible on the website (by default).
**datasets**
  This table holds all datasets. For every dataset its absolute path (absPath), checksum, format (dataset format id, FK) and type (dataset type id, FK) is stored.
**goldstandard configs**
  This table holds all goldstandard configurations. For every goldstandard configuration its absolute path (absPath), name and corresponding goldstandard (goldstandard id, FK) is stored.
**goldstandards**
  This table holds all goldstandards. For every goldstandard its absolute path (absPath), and the corresponding goldstandard (goldstandard id, FK) is stored.
**optimizable_program_parameters**
  This table stores the program parameters (program parameter id, FK) of a program configuration (program config id, FK), that can be optimized.
**parameter_optimization_methods**
  This table stores all available parameter optimization methods (name) registered in a repository (repository id, FK).
**program_configs**
  All program configurations registered in a repository are stored in this table. Every program configuration has a name, an absolute path (absPath), different invocation formats for different scenarios (invocationFormat, invocationFormatWithoutGoldStandard, invocationFormatParameterOptimization, invocationFormatParameterOptimizationWithoutGoldStandard ) and a boolean whether the program expects input with normalized similiarites (expectsNormalizedDataSet). For every program configuration we store the corresponding repository (repository id, FK), the program (program id, FK) this configuration belongs to, the run result format (run result format id, FK) of the program using this configuration.
**program_configs_compatible_dataset_formats**
  Every program configuration (program config id, FK) has a set of compatible dataset formats (dataset format id, FK), which the program will understand when it is executed using this configuration.
**program_parameter_types**
  This table contains the names (name) of the different possible program parameter types (see 4.9.7 for more information on the types of parameters supported by clusteval ).
**program_parameters**
  This table stores the program parameters defined in a program configuration (program config id, FK). Every program parameter has a type (program parameter type id, FK), a name, an (optional) description, a minValue, a maxValue and a default value (def ).
**programs**
  This tables stores all clustering methods together with their absPath and an alias, which is used to represent this clustering method on the website.
**repositories**
  The repositories that are using this database to store their results. Every repository has a absolute base directory (basePath) and a type (repository type id, FK).
**repository_types**
  The types that repositories can have. Every type has a name. Check out 4.1 for more information on which repository types exist.
**run_analyses**
  This table holds all analysis runs. Every analysis run is also a run (run id, FK).
**run_analysis_statistics**
  Every analysis run (run analysis id, FK) evaluates certain statistics (statistic id, FK).
**run_clusterings**
  This table holds all clustering runs. Every clustering run is also a execution run (run execution id, FK).
**run_data_analyses**
  This table holds all data analysis runs. Every data analysis run is also an analysis run (run analysis id, FK).
**run_data_analysis_data_configs**
  Every data analysis run analysis a set of data configurations wrapping datasets. This table holds the data configurations (data config id, FK) that a certain data analysis run (run data analysis id, FK) analyses.
**run_execution_data_configs**
  An execution run applies program configurations to data configurations. This table stores the data configurations (data config id, FK) belonging to execution runs (run execution id, FK).
**run_execution_parameter_values**
  An execution run can specify values for program parameters. This table stores for every execution run (run execution id, FK), program configuration (program config id, FK) and program parameter (program parameter id, FK) the specified value.
**run_execution_program_configs**
  An execution run applies program configurations to data configurations. This table stores the program configurations (program config id, FK) belonging to execution runs (run execution id, FK).
**run_execution_quality_measures**
  An execution run applies clustering methods to datasets and assesses clustering quality measures. This table stores the execution run (run execution id, FK) together with the clustering quality measures (clustering quality measure id, FK) to assess.
**run_executions**
  This table holds all execution runs. Every execution run is also a run (run id, FK).
**run_internal_parameter_optimizations**
  This table holds all internal parameter optimization runs. Every such run is also an execution run (run execution id, FK).
**run_parameter_optimization_methods**
  A parameter optimization run uses parameter optimization methods to optimize parameters. For a certain parameter optimization run (run parameter optimization id, FK) for every program configuration (program config id, FK) a different parameter optimization method (parameter optimization method id, FK) and a clustering quality measure to optimize can be specified.
**run_parameter_optimization_parameters**
 A parameter optimization run optimizes parameters of clustering methods. This table stores for a certain run (run parameter optimization id, FK) for every program configuration contained (program config id, FK) the parameters (program parameter id, FK) to optimize.
**run_parameter_optimization_quality_measures**
  A parameter optimization run optimizes parameters by maximizing or minimizing clustering quality measures. This table stores all clustering quality measures (clustering quality measure id, FK) to assess for the calculated clusterings.
**run_parameter_optimizations**
  This table holds all parameter optimization runs. Every parameter optimization run is also an execution run (run execution id, FK).
**run_result_formats**
  This table holds all run result formats. Every run result format has a name.
**run_results**
  When a run is executed, it produces a unique folder in the results directory of the repository. These folders are stored in this table together with the type of the corresponding run (run id, FK) that created this result (run type id, FK), an absolute path to the results folder (absPath), the uniqueRunIdentifier of this run result (which corresponds to the name of the folder) and the date the run result was created.
**run_results_analyses**
  When an analysis run is executed, it produces a unique folder in the results directory of the repository. Every analysis run result is also a run result (run result id, FK).
**run_results_clustering_qualities**
  Holds the qualities for each program config, data config, parameter set of a particular run.
**run_results_clusterings**
  When a clustering run is executed, it produces a unique folder in the results directory of the repository. Every clustering run result is also an execution run result (run results execution id, FK).
**run_results_data_analyses**
  When a data analysis run is executed, it produces a unique folder in the results directory of the repository. Every data analysis run result is also an analysis run result (run results analysis id, FK).
**run_results_executions**
  When an execution run is executed, it produces a unique folder in the results directory of the repository. Every execution run result is also a run result (run result id, FK).
**run_results_internal_parameter_optimizations**
  When an internal parameter optimization run is executed, it produces a unique folder in the results directory of the repository. Every internal parameter optimization run result is also an execution run result (run results execution id, FK).
**run_results_parameter_optimizations**
  When a parameter optimization run is executed, it produces a set of iterative run results, that are all summarized in .complete-files for every pair of program and data configuration (program config id, FK) and (data config id, FK). Every parameter optimization run result is also an execution run result (run results execution id, FK).
**run_results_parameter_optimizations_parameter_set_iterations**
  Every parameter optimization produces clustering results for a set of iterations. In each iteration a different parameter set (run results parameter optimizations parameter set id, FK) is evaluated. This table holds the number of the iteration, together with the parameter set, the produced clustering (clustering id, FK) and the parameter set in a string representation (paramSetAsString).
**run_results_parameter_optimizations_parameter_set_parameters**
  This table holds the program parameters (program parameter id, FK) that belong to parameter sets (run results parameter optimizations parameter set id, FK) contained in a parameter optimization run result (run results parameter optimization id, FK), evaluated by the framework.
**run_results_parameter_optimizations_parameter_sets**
  This table holds the parameter sets evaluated during a parameter optimization run and contained in a parameter optimization run result (run results parameter optimization id, FK).
**run_results_parameter_optimizations_parameter_values**
  This table contains the value of a certain program parameter (run results parameter optimizations parame FK) evaluated in a certain parameter optimization iteration (run results parameter optimizations parame FK).
**run_results_parameter_optimizations_qualities**
  In every iteration of a parameter optimization a parameter set is evaluated and clus- tering qualities are assessed. This table holds the clustering quality measure (cluster quality measure id, FK) together with the assessed quality.
**run_results_run_analyses**
  When a run analysis run is executed, it produces a unique folder in the results directory of the repository. Every run analysis run result is also an analysis run result (run results analysis id, FK).
**run_results_run_data_analyses**
  When a run-data analysis run is executed, it produces a unique folder in the results directory of the repository. Every run-data analysis run result is also an analysis run result (run results analysis id, FK).
**run_run_analyses**
  This table holds all run analysis runs. Every run analysis run is also an analysis run (run analysis id, FK).
**run_run_analysis_run_identifiers**
  Every run analysis run analyses (run run analysis id, FK) a set of run results with certain identifiers (runIdentifier ).
**run_run_data_analyses**
  This table holds all run-data analysis runs. Every run-data analysis run is also an analysis run (run analysis id, FK).
**run_run_data_analysis_data_identifiers**
  Every run-data analysis run analyzes (run run analysis id, FK) a set of data analysis run results with certain identifiers (dataIdentifier ).
**run_run_data_analysis_run_identifiers**
  Every run-data analysis run analyzes (run run analysis id, FK) a set of execution run results with certain identifiers (runIdentifier ).
**run_types**
  This table holds all types of runs. Every type has a name. Check out 6 for more information on which run types exist.
**runs**
  This table holds all runs. Every run has a type (run type id, FK), an absolute path (absPath), a name and a status.
**statistics**
  This table holds all the statistics registered in a repository. Every statistic has a name and an alias. The alias is used on the website as a readable name.
**statistics_data**
  This table holds all the data statistics. Every data statistic is also a statistic (statistic id, FK).
**statistics_runs**
  This table holds all the run statistics. Every run statistic is also a statistic (statistic id, FK).
**statistics_run_data**
  This table holds all the run-data statistics. Every run-data statistic is also a statistic (statistic id, FK).

Technical Tables
""""""""""""""""
 The following tables correspond to rather technical tables, that are just required by the models of the ruby on rails website and do not have a strong meaning with regard to contents.

**[aboutus]**
  A technical table containing the information regarding the 'About us' section of the website.
**[aboutus_impressums]**
  A technical table containing the information regarding the 'Impressum' section of the website.
**[admins]**
  A technical table containing the information regarding the 'Admin' section of the website.
**[help_installations]**
  Models of the help installation section of the website.
**[help_publications]**
  Models of the help publications section of the website.
**[help_source_codes]**
  Models of the help source code section of the website.
**[help_technical_documentations]**
  Models of the help technical documentations section of the website.
**[helps]**
  A technical table containing the information regarding the 'Help' section of the website.
**[impressions]**
  A technical table containing the impressions of the website.
**[mains]**
  A technical table containing the information regarding the startpage of the website.
**[program descriptions]**
  This table stores descriptions of clustering methods, for when they are shown on the website.
**[program images]**
  When this table contains an image for a clustering method, it will be shown on the website.
**[program publications]**
  When this table contains publication information for a clustering method, it will be shown on the website.
**[schema_migrations]**
  This table holds all the migrations of the ruby on rails website.
**[small_rankings]**
  ClustEval makes use of reusable modules in its website; one of them is the small ranking cell, which shows highcharts diagrams.
**[submit_datasets]**
  This table corresponds to the section "Submit Dataset" of the website.
**[submit_methods]**
  This table corresponds to the section "Submit Clustering Method" of the website.
**[submits]**
  This table corresponds to the "Submit" section of the website.
**[users]**
  This table holds all the users, that have registered on the website.







Materialized Views
^^^^^^^^^^^^^^^^^^
**dataset_statistics**
  Lists all statistics for a particular data set
**dataset_recent_statistics**
  Lists all statistics for a particular data set, but only the most recent version of each statistic.
**parameter_optimization_data_configs_iterations**
  Lists all parameter optimization iterations that have ever been calculated per data configuration.
**parameter_optimization_iterations**
  Lists all parameter optimization iterations.
**parameter_optimization_iterations_exts**
  Additionally joins the above information with the corresponding data set and clustering method.
**parameter_optimization_iteration_exts_configs**
  TODO
**parameter_optimization_iterations_woparam**
  TODO
**parameter_optimization_max_qual_rows**
  Lists those parameter optimization iterations (including all information such as used parameter set) which achieved the highest qualities for a particular quality measure, clustering method and data set.
**parameter_optimization_max_quals**
  Lists the highest achieved qualities for a particular quality measure, clustering method and data set (this is useful for quality measures that are best if maximized).
**parameter_optimization_min_quals**
  Lists the lowest achieved quality values for a particular quality measure, clustering method and data set (this is useful for quality measures that are best if minimized).
**run_result_data_analysis_data_configs_statistics**
  A data analysis run assesses statistics for certain data configurations. This table stores the assessed statistics (statistic id, FK) for every run result (run result id, FK) generated by an analysis run.
**run_results_data_configs_rankings**
  Holds the best performances of all clustering methods and clustering quality measures for one particular data configuration.
**run_results_program_configs_rankings**
  Holds the best performances of one particular program configuration for all clustering quality measures and data configurations.