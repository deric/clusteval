.. _extendingclusteval:

Extending ClustEval
-------------------
ClustEval can be extended in different ways. The following sections will show you, which functionality you can add to the framework and how.

Clustering Methods
^^^^^^^
As explained in 4.2 clusteval supports two different kinds of clustering methods: Stan-
dalone programs and R programs. Standalone programs are those, for which you have
to provide an executable file which then will be executed by the framework. R programs
are methods implemented in R, which will be invoked by clusteval by using the Rserve
interface.

Standalone Programs
"""""
See the API documentation of :java:ref:`StandaloneProgram`.

R Programs
"""""
See the API documentation of :java:ref:`RProgram`.

For a list of available R programs see the `corresponding  <../../sphinx_doc_packages/build/de/clusteval/program/r/package-index.html>`_ package.

Data Set Types
^^^^^^^
See the API documentation of :java:ref:`DataSetType`.

For a list of available data set types see the `data set type <../../sphinx_doc_packages/build/de/clusteval/data/dataset/type/package-index.html>`_ package.

.. _clusteval_extend_formats:

Formats
^^^^^^^

Data Set Formats
""""""
See the API documentation of :java:ref:`DataSetFormat`.

For a list of available data formats see the `corresponding  <../../sphinx_doc_packages/build/de/clusteval/data/dataset/format/package-index.html>`_ package.

Run Result Formats
"""""""""
See the API documentation of :java:ref:`RunResultFormat`.

For a list of available run result formats see the `corresponding  <../../sphinx_doc_packages/build/de/clusteval/run/result/format/package-index.html>`_ package.


.. _clusteval_extend_parameter_optimization_method:

Parameter Optimization Methods
^^^^^^^
See the API documentation of :java:ref:`ParameterOptimizationMethod`


For a list of available parameter optimization methods see the `corresponding  <../../sphinx_doc_packages/build/de/clusteval/cluster/paramOptimization/package-index.html>`_ package.


.. _clusteval_extend_distance_measures:

Distance Measures
^^^^^^^
See the API documentation of :java:ref:`DistanceMeasure`

For a list of distance measures see the `corresponding  <../../sphinx_doc_packages/build/de/clusteval/data/distance/package-index.html>`_ package.

.. _clusteval_extend_quality_measures:

Clustering Quality Measures
^^^^^^^
See the API documentation of :java:ref:`ClusteringQualityMeasure`

For a list of clustering quality measures see the `corresponding  <../../sphinx_doc_packages/build/de/clusteval/cluster/quality/package-index.html>`_ package.

Statistics
^^^^^^^
ClustEval can analyze properties of clusterings, data sets and relationship between the two. We call such properties run, data and run-data statistics respectively. 

For more information about how to extend ClustEval with your own statistics have a look at

* the API documentation of :java:ref:`RunStatistic`,
* the API documentation of :java:ref:`DataStatistic`,
* the API documentation of :java:ref:`RunDataStatistic`.

For a list of available statistics see the `run statistics  <../../sphinx_doc_packages/build/de/clusteval/run/statistics/package-index.html>`_ and `data statistics  <../../sphinx_doc_packages/build/de/clusteval/data/statistics/package-index.html>`_ packages.

.. _clusteval_extend_data_preprocessors:

Data Preprocessors
^^^^^^^^^^^^^^^^^^
See the API documentation of :java:ref:`DataPreprocessor`

For a list of data preprocessors see the `corresponding  <../../sphinx_doc_packages/build/de/clusteval/data/preprocessing/package-index.html>`_ package.


.. _clusteval_extend_data_randomizers:

Data Randomizers
^^^^^^^^^^^^^^^^^^
See the API documentation of :java:ref:`DataRandomizer`

For a list of data randomizer see the `corresponding  <../../sphinx_doc_packages/build/de/clusteval/data/randomizer/package-index.html>`_ package.


.. _clusteval_extend_dataset_generators:

Data Set Generators
^^^^^^^^^^^^^^^^^^
See the API documentation of :java:ref:`DataSetGenerator`

For a list of data set generator see the `corresponding  <../../sphinx_doc_packages/build/de/clusteval/data/dataset/generator/package-index.html>`_ package.