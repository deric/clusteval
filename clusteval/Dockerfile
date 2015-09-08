FROM andreptb/oracle-java
RUN apt-get update && apt-get -y install git r-base
RUN Rscript -e 'install.packages(c("cluster","clv","stats","igraph","fields","e1071","fpc","sprint","kohonen","kernlab","lars","MASS","mlbench","Rserve"), repos="http://cran.rstudio.com/")'
RUN mkdir /clustevalBackend
WORKDIR /clustevalBackend
ADD ./packages /clustevalBackend
WORKDIR /
RUN git clone https://github.com/wiwie/clustevalPackages
RUN mv /clustevalPackages/clustevalPackages/repository /clustevalRepository