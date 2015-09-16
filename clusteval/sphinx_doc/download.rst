.. _download:


Dependencies
============

Backend
-------

In order to use the backend you need

**Java**
  A working installation of Oracle Java 7 to execute server and client jar-executables
**R**
  An R installation and the R package Rserve which allows communication between Java and R.
  
  
Frontend
--------

**Ruby & Rails**
  To be able to execute the website
**PostgreSQL / MySQL**
  Currently the backend supports postgreSQL and MySQL.

Download & Installation
========

Docker & Docker Compose
-----------------------
ClustEval can be installed using `Docker <https://www.docker.com/>`_ and `Docker Compose <https://www.docker.com/docker-compose>`_ on OS X and Linux.

1. `Install Docker & Docker-Compose <http://docs.docker.com/compose/install/>`_
2. Check out `this <https://github.com/wiwie/clustevalDocker>`_ GitHub repository.
3. Execute "docker-compose up" in the folder containing the docker-compose.yml from the checked out repository.


VirtualBox Image
-----------------------
We provide a VirtualBox Image containing a ClustEval backend and frontend installations. The VirtualBox image is based on a Debian installation which uses the above Docker Compose script to check out the newest version of ClustEval.

============================================================================================================================================================   =======
Link                                                                                                                                                           Version
============================================================================================================================================================   =======
TODO                                                                                                                                                           Latest
============================================================================================================================================================   =======



Manual Download & Installation
-----------------------
We provide GitHub repositories for all individual components of ClustEval.

Download Backend Executables (Client & Server)
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

The backend consists of a client and a server component. Both can be downloaded separately as a jar-executable. Also, all available dynamic components which can be loaded by the backend are available on GitHub as jars. It is sufficient to copy the "programs" and "supp" subfolders of the "repository" folder in the clustevalPackages GitHub repository into the local repository.

============================================================================================================================================================   =======
Link                                                                                                                                                           Version
============================================================================================================================================================   =======
`Backend Server <https://github.com/wiwie/clusteval/blob/master/clusteval/packages/clustevalBackendServer.jar?raw=true>`_                                      Latest
`Backend Client <https://github.com/wiwie/clusteval/blob/master/clusteval/packages/clustevalBackendClient.jar?raw=true>`_                                      Latest
`Dynamic Packages <https://github.com/wiwie/clustevalPackages/tree/master/clustevalPackages/repository>`_                                                      Latest
============================================================================================================================================================   =======


Download Example Repository
^^^^^^^^^^^^^^
We provide an example repository containing some data sets, gold standards, clustering methods and configurations. It is hosted on GitHub.

============================================================================================================================================================    =======
Link	                                                                                                                                                        Version
============================================================================================================================================================    =======
`Repository <https://github.com/wiwie/clustevalDockerRepository>`_                                                                                              Latest
`Repository as zip-file <https://github.com/wiwie/clustevalDockerRepository/archive/master.zip>`_                                                               Latest
============================================================================================================================================================    =======


Download Frontend (Website & SQL DB Structure)
^^^^^^^^^^^^^^^^^^^^^^^

============================================================================================================================================================    =======
Link	                                                                                                                                                        Version
============================================================================================================================================================    =======
`Website <https://github.com/wiwie/clustevalWebsite>`_                                                                                                          Latest
`Website as zip-file <https://github.com/wiwie/clustevalWebsite/archive/master.zip>`_                                                                           Latest
============================================================================================================================================================    =======


Installation
^^^^^^^^^^^^



Frontend
^^^^^^^^
TODO
For a detailed step-by-step installation guide for the frontend, please check out the installation section of the clusteval technical documentation. You can download a zip containing all parts of the frontend here:



