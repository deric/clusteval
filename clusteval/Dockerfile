FROM andreptb/oracle-java
RUN apt-get update && apt-get -y install git r-base
RUN mkdir /clustevalBackend
WORKDIR /clustevalBackend
ADD ./clusteval/packages /clustevalBackend
WORKDIR /
RUN git clone https://github.com/wiwie/clustevalPackages
RUN mv /clustevalPackages/clustevalPackages/repository /clustevalRepository