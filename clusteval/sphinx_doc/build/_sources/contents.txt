
ClustEval documentation
=======================

ClustEval is an automated framework for cluster analysis written in Java which comes together with a Ruby on Rails website. This includes most common subtasks of every cluster analysis, such as 

* :ref:`data preprocessing & data normalization <datapreprocessors>` 
* :ref:`data format conversion <formats>`
* :ref:`clustering method execution <clusteringmethods>`
* :ref:`parameter training and <paramoptmethods>`
* :ref:`visualizations <website>`
   
Getting Started
---------------

.. toctree::
   :maxdepth: 1
   
   download
   basicusage



The Framework
-------------

.. figure:: ../img/framework_flow.png
   :figwidth: 50 %
   :alt: process flow of ClustEval

   A general process diagram of ClustEval

Our framework clusteval is intended to perform automatized cluster analysis of arbi-
trary data sets and clustering methods. The goal is, that any clustering method known
to the framework can be applied to any known data set (with certain exceptions, partly
inflicted by the clustering methods itself and partly inflicted by the framework con-
straints).

In general clusteval is divided into a backend and a frontend. Figure 1 shows
the general structure of the framework. The backend is reponsible for doing all the
calculations including clusterings and the frontend has only visualization purposes.


.. toctree::
   :maxdepth: 1
   

   backend
   frontend

Extending ClustEval
-------------------
ClustEval can be extended in many ways. Please head over to :ref:`extendingclusteval` to get more information.
