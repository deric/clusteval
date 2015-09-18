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
`ClustEval Complete <http://clusteval.sdu.dk/ClustEval.vdi>`_                                                                                      1.3                17.09.2015
`ClustEval NetInstall <http://clusteval.sdu.dk/ClustEval%20Full.vdi>`_                                                                             Latest             -
================================================================================================================================================   =================  ==========

**ClustEval Complete**
  This image has version 1.3 of ClustEval already installed and you can just start up backend, frontend and are ready to go. 

**ClustEval NetInstall**
  This image comes only with an installation script which downloads the newest versions of all necessary components from the web. It is thus smaller, but after download of the ClustEval VirtualBox an internet connection is required. 


After downloading one of the above Virtualbox images, you need to create a Linux/Ubuntu VirtualBox host and add the image as hard disk. Make sure to allow sufficient RAM to the box. We recommend at least 2GB.

Start-Up
^^^^^^^^
Both VirtualBox images come with Ubuntu 14.04.3 and have an active user clusteval with password clusteval.

After creating a new VirtualBox host and adding one of the images as disk, to VirtualBox booting them up logging in The "ClustEval Complete" image has a shortcut on the desktop



Manual Download & Installation
-----------------------
To manually install ClustEval you first need to install the following dependencies. We provide all components of ClustEval in GitHub repositories.

Backend Dependencies
^^^^^^^
The backend is a Java application which communicates with R using Rserve. Thus, you need to install Java, R and Rserve.

Java
""""
A working installation of Java 7 to execute server and client jar-executables. We recommend you to use Oracle Java 7 (over Open-JDK), as we observed performance degenerations with Open-JDK and unexpected behaviour.


To install Oracle Java in Ubuntu execute the following commands in a terminal::

  sudo add-apt-repository ppa:webupd8team/java
  sudo apt-get update
  sudo apt-get install oracle-java7-installer
  
  
R >= 2.15 & Rserve
""""""""""
ClustEval uses some existing implementations of statistical calculations in R instead of implementing them from scratch in Java again. This is used in many components of ClustEval, such as distance measures, data statistics or clustering quality measures. To make R available in Java applications (like ClustEval), Rserve is required. Rserve acts as a distribution server to make R available via TCP/IP. Different interfaces are provided for Rserve, such that R can be used from within programs written in other programming languages, for example Java. 

In principle the clustering processes of ClustEval can be started without R or a running Rserve instance, but a lot of functionality will then not be available.

Hint: Rserve requires at least version 2.15 of R.

To install R in Ubuntu execute the following commands in a terminal::

  sudo apt-get update
  sudo apt-get install r-base
  
To then install the Rserve package and start up the Rserve daemon open an R terminal by typing R in the terminal and then execute the following commands::

  > install.packages("Rserve")
  > Rserve()
  
  
Frontend Dependencies
^^^^^^^^^^^^^^^^^^^^^

PostgreSQL >= 9.3 / MySQL
""""""""""""""""""
The website requires a database. At the moment PostgreSQL >= 9.3 and MySQL are supported.


In Ubuntu you can install postgreSQL as follows::

  sudo apt-get install postgresql

You can then connect to the server and create a database and a user::

  CREATE DATABASE clusteval;
  CREATE USER clusteval LOGIN UNENCRYPTED PASSWORD '<YOUR_PASSWORD>';
  GRANT ALL PRIVILEGES ON DATABASE clusteval to clusteval;


Alternatively, you can install MySQL with the following command::

  sudo apt-get install mysql-server
  
During the installation procedure you will be asked for a root password, and the credentials of a non-root user. Here we assume your non-root user to be **clusteval**.
  
You then need to create a database and to grant read and write permissions on that database to the **clusteval** user::

  CREATE DATABASE clusteval;
  GRANT ALL ON clusteval.* TO clusteval;


Ruby >= 2.2 & Rails >= 4.2
"""""""""""""""""""
The website is written in Ruby on Rails and thus requires the programming language Ruby as well as the web-framework Rails to be installed.

The easiest way to get an up-to-date installation of both is using rvm (Ruby Version Manager).

Thus, we first install rvm::

  sudo apt-get update
  sudo apt-get install curl
  \curl -L https://get.rvm.io | bash -s stable
  source ~/.rvm/scripts/rvm
  rvm requirements

We can now use rvm to install the current version of ruby and activate it::

  rvm install ruby
  rvm use ruby --default

We furthermore need the rubygems package which provides us with some tools, such as the gem tool which we can use to install Ruby on Rails gems::
  
  rvm rubygems current
  
And then we install the bundler gem, which is a gem that automatizes the installation of our ClustEval website::

  gem install bundler


Download Backend (Client & Server)
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
To use the backend it is sufficient to download the server and client jar executables. Alternatively, you can also check out the whole GitHub repository to have the Java sources as well (consumes much more space).

============================================================================================================================================================   =======
Link                                                                                                                                                           Version
============================================================================================================================================================   =======
`Backend Server Executable Only <https://github.com/wiwie/clusteval/blob/master/clusteval/packages/clustevalBackendServer.jar?raw=true>`_                      Latest
`Backend Client Executable Only <https://github.com/wiwie/clusteval/blob/master/clusteval/packages/clustevalBackendClient.jar?raw=true>`_                      Latest
`Backend GitHub repository <https://github.com/wiwie/clusteval>`_                                                                                              Latest
============================================================================================================================================================   =======


Set-Up a ClustEval Repository
^^^^^^^^^^^^^^
Here you have again two choices:

1. Clone our GitHub repository containing all dynamic components (e.g. formats, distance measures). This GitHub repository contains the folder "clustevalPackages/repository" which is a minimal ClustEval repository without any data sets, standalone programs, runs or configurations.
2. We provide a slightly larger example repository containing some data sets, gold standards, clustering methods and configurations. This repository is also used by our docker scripts and in the VirtualBox images. Hint: The dynamic components in this repository are not necessarily up-to-date.

============================================================================================================================================================    =======
Link	                                                                                                                                                        Version
============================================================================================================================================================    =======
`Minimal Repository on GitHub <https://github.com/wiwie/clustevalPackages>`_                                                                                    Latest
`Minimal Repository as zip-file <https://github.com/wiwie/clustevalPackages/archive/master.zip>`_                                                               Latest
`Larger Example Repository on GitHub <https://github.com/wiwie/clustevalDockerRepository>`_                                                                     Latest
`Larger Example Repository as zip-file <https://github.com/wiwie/clustevalDockerRepository/archive/master.zip>`_                                                Latest
============================================================================================================================================================    =======


Download Frontend (Website & SQL DB Structure)
^^^^^^^^^^^^^^^^^^^^^^^

============================================================================================================================================================    =======
Link	                                                                                                                                                        Version
============================================================================================================================================================    =======
`Website on GitHub <https://github.com/wiwie/clustevalWebsite>`_                                                                                                Latest
`Website as zip-file <https://github.com/wiwie/clustevalWebsite/archive/master.zip>`_                                                                           Latest
============================================================================================================================================================    =======


Install Website
^^^^^^^^^^^^

  
Now you can change to the root directory of the ClustEval website (the directory which contains the Gemfile - let's call it <WEBROOT>) within the directory into which you cloned our clustevalWebsite GitHub repository earlier and then execute::

  bundle install
  
This will now install all dependencies of our app and make it ready to be executed. This command will take some time.

Now we need to initialize the database. To that end you need to create a valid database configuration in <WEBROOT>/config/database.yml. You can use the template file <WEBROOT>/config/database.yml.example and adapt it. 

If you have installed postgreSQL on your local machine, it is running on port 5432 and you have created a user called **clusteval** with a password **clusteval**, you should set the file as follows::

  development:
    adapter: postgresql
    database: clusteval
    pool: 5
    timeout: 5000
    username: clusteval
    password: clusteval
    host: localhost
    port: 5432

  production:
    adapter: postgresql
    database: clusteval
    pool: 5
    timeout: 5000
    username: clusteval
    password: clusteval
    host: localhost
    port: 5432

Now we can initialize the database by executing::

  rake db:migrate && rake db:seed

and when it is finished you can start the ClustEval website with::

  rails server
  
This will make the website available at http://localhost:3000