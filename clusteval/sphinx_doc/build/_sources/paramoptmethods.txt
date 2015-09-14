.. _paramoptmethods:

Parameter Optimization Methods - Finding Good Clustering Parameters
-----------------

.. figure:: ../img/framework_flow_parameterOptimization.png
   :figwidth: 50 %
   :alt: schema of parameter optimization

   A schema of parameter optimization in ClustEval
   
The backend can perform automatized and autonomous optimization of parameters of
clustering methods. This is an iterative procedure where the backend assesses qualities
of clustering results of the last iteration and adapts the parameter for the next iteration
in order to find optimal parameters for the method on the given data. The parameter
optimization method determines the following aspects:

1. the number of iterations of the optimization process
2. the parameter sets evaluated
3. the handling of diverging iterations
4. the storage of the iteration results in RAM

ClustEval ships with a standard set of parameter optimization methods. You can find a list `here <../../sphinx_doc_packages/build/de/clusteval/cluster/paramOptimization/package-index.html>`_

Check :ref:`clusteval_extend_parameter_optimization_method` for more information on how to extend the framework by new parameter optimization
methods.
