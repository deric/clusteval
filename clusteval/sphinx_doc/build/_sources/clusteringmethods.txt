.. _clusteringmethods:

Clustering Methods
------------------
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


Standalone
^^^^^^^^^^^^^^^^^^

are programs that come as an executable. Those can be performed by the framework,
after they have been specified in a program configuration. The executable needs to be
compatible to the server architecture clusteval runs on and they need to be executable
(+x modifier). How you can add your own standalone programs into the framework
can be found here 11.1.1

R (Rserve)
^^^^^^^^^^^^^^^^^^

are programs, that are implemented within some R package. Arbitrary methods imple-
mented in R can be used as a program, as long as they can be made available within
R on the server. This implies that the corresponding R Program is available for your
R version and that it can be compiled and installed on your server architecture. How
you can add your own R Programs into the framework can be found here 11.1.2.
