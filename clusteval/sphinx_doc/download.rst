.. _download:


Download & Installation
========

Docker & Docker Compose (OS X and Linux only)
-----------------------
ClustEval can be installed using `Docker <https://www.docker.com/>`_ and `Docker Compose <https://www.docker.com/docker-compose>`_ on OS X and Linux.

1. `Install Docker & Docker-Compose <http://docs.docker.com/compose/install/>`_
2. Check out `this <https://github.com/wiwie/clustevalDocker>`_ GitHub repository.
3. Execute "docker-compose up" in the folder containing the docker-compose.yml from the checked out repository.


VirtualBox Image (Windows, OS X, Linux, Solaris)
-----------------------

Download & Set-Up
^^^^^^^^
You can also install ClustEval by downloading one of our VirtualBox images. All VirtualBox images contain an installation of Ubuntu 14.04.3 and have the user **clusteval** preinstalled with password **clusteval**. The user has administrator rights.

We provide two VirtualBox images:

================================================================================================================================================   =================  ==========
Link                                                                                                                                               ClustEval Version  Date
================================================================================================================================================   =================  ==========
`ClustEval Complete <http://clusteval.sdu.dk/ClustEval.vdi>`_                                                                                          1.3                17.09.2015
`ClustEval NetInstall <http://clusteval.sdu.dk/ClustEval%20Full.vdi>`_                                                                             Latest             -
================================================================================================================================================   =================  ==========

**ClustEval Complete**
  This image has ClustEval already installed and you can just start up backend, frontend and are ready to go. 

**ClustEval NetInstall**
  This image comes only with an installation script which downloads all necessary components from the web. it is thus smaller, but after download of the ClustEval VirtualBox an internet connection is required. 


After downloading one of the above Virtualbox images, you need to create a Linux/Ubuntu VirtualBox host and add the image as hard disk. Make sure to allow sufficient RAM to the box. We recommend at least 2GB.

Start-Up
^^^^^^^^
Both VirtualBox images come with Ubuntu 14.04.3 and have an active user clusteval with password clusteval.

After creating a new VirtualBox host and adding one of the images as disk, to VirtualBox booting them up logging in The "ClustEval Complete" image has a shortcut on the desktop



Manual Download & Installation
-----------------------
We provide GitHub repositories for all individual components of ClustEval.


Dependencies
^^^^^^^

Backend
"""""""

In order to use the backend you need

**Java**
  A working installation of Oracle Java 7 to execute server and client jar-executables
**R**
  An R installation and the R package Rserve which allows communication between Java and R.
  
  
Frontend
"""""""

**Ruby & Rails**
  To be able to execute the website
**PostgreSQL / MySQL**
  Currently the backend supports postgreSQL and MySQL.




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



