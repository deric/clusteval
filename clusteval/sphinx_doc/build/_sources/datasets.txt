
Data Sets
---------
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
