.. _formats:

Formats - Input & Output
-------
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

Available Formats
^^^^^^^^^^^^^^^^^^
For lists of all available input and result formats see `here  <../../sphinx_doc_packages/build/de/clusteval/data/dataset/format/package-index.html>`_ and `here  <../../sphinx_doc_packages/build/de/clusteval/run/result/format/package-index.html>`_ respectively.

Providing New Formats
^^^^^^^^^^^^^^^^^^

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


For more information on how the extend ClustEval by new formats see :ref:`clusteval_extend_formats`.

Standard Input Format
^^^^^^^^^^^^^^^^^^
The standard input format is a SimMatrixDataSetFormat which is described under
4.5.6.

Standard Output Format
^^^^^^^^^^^^^^^^^^
The standard output format contains one clustering generated for parameter values
p 1 = v1,...,p K = vK in one line with clusters c1, ..., cK, cluster sizes size(ci) = si.
Every cluster ci contains elements e i 1, ..., e i si with fuzzy coefficients f i 1, ..., f i si.
The format for this looks as follows:

TODO

The parameter names and values on the left have to be separated by a TAB from
the string "Clustering" and the clustering on the right. If the fuzzy coefficients are
missing, the framework will not be able to parse the result file.
