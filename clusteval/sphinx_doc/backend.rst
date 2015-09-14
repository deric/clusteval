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

.. toctree::
   :maxdepth: 1
   
   datasets
   goldstandards
   clusteringmethods
   configurations

Additional components that can be extended and might be needed in case the
provided standard functionality of the framework is not sufficient for the user

TODO: finish up     datasettypes    statistics    datasetgenerators datapreprocessors datarandomizer
   
   
.. toctree::
   :maxdepth: 1
   
   formats
   qualitymeasures
   distancemeasures
   paramoptmethods
   datasettypes
   statistics
   datasetgenerators
   datapreprocessors
   datarandomizer

All these components have to be located in the repository of the framework (see :ref:`repository`
for more details). The repository is a file system hierarchy located at a specified path
and contains all components used by and available to the framework. data sets, cluster-
ing methods or configurations outside the repository cannot be used by the framework.
After these components have been made available to the backend, they can be
combined almost arbitrarily. In the following we will describe the dependencies of each
of these components which need to be fulfilled such that a new component of each type
can be recognized and used by the framework.


More information about the above components can be found in the following sections:

.. toctree::
   :maxdepth: 1
   
   results
   


Client
^^^^^^
The backend client is a small command-line tool which gives commands to the back-
end server, for example to execute a certain run or terminate a run that is currently
executing. It offers tab completion and communicates with the server using the Rserve
package via TCP/IP.