clusteval
=========

An Integrated Clustering Evaluation Framework for Cluster Analysis

This repository contains the eclipse java project of clusteval. This includes the sources of the backend server and client.

The eclipse java project for the components that can be loaded by the clusteval server dynamically during runtime is contained in this repository: https://github.com/wiwie/clustevalPackages

The frontend of clusteval including the Ruby on Rails website can be found in: https://github.com/wiwie/clustevalWebsite

## Rserve require packages

```R
packages <- function(pkg){
    new.pkg <- pkg[!(pkg %in% installed.packages()[, "Package"])]
    if (length(new.pkg))
        install.packages(new.pkg, dependencies = TRUE, repos='http://cran.rstudio.com/')
    sapply(pkg, require, character.only = TRUE)
}

packages(c("cluster","fields","Hmisc","igraph","kernlab","lattice","MASS","mlbench","stats","proxy","fpc","clv","lars","kohonen","clusterGeneration"))
```
