FROM andreptb/oracle-java
RUN apt-get update && apt-get -y install git
RUN mkdir /clustevalBackend
WORKDIR /clustevalBackend
ADD ./packages /clustevalBackend