.. _website:

Website
--------
The frontend website is designed to give a visual representation of the results calculated by the backend and also of the datasets, goldstandards, configurations available in the repository. The website is divided into several sections which will be discussed in the following. Here we describe, which information you can find in which section. Afterwards it follows a short explanation for every task you can realize using the website, including how to compare available clustering methods or datasets and how to interprete visualized run results.

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