#!/bin/bash

CLASSPATH=.:/home/hadoop/jade/lib/jade.jar:/home/hadoop/jade/lib/commons-codec/commons-codec-1.3.jar:/home/hadoop/ctfan/jade/jar:/home/hadoop/jade/add-ons/migration/lib/migration.jar:/home/hadoop/hadoop/hadoop-ant-0.20.203.0.jar:/home/hadoop/hadoop/ivy/ivy-2.1.0.jar:/home/hadoop/hadoop/hadoop-core-0.20.203.0.jar:/home/hadoop/hadoop/lib/jasper-runtime-5.5.12.jar:/home/hadoop/hadoop/lib/junit-4.5.jar:/home/hadoop/hadoop/lib/jackson-mapper-asl-1.0.1.jar:/home/hadoop/hadoop/lib/commons-math-2.1.jar:/home/hadoop/hadoop/lib/jsp-2.1/jsp-api-2.1.jar:/home/hadoop/hadoop/lib/jsp-2.1/jsp-2.1.jar:/home/hadoop/hadoop/lib/jetty-util-6.1.26.jar:/home/hadoop/hadoop/lib/core-3.1.1.jar:/home/hadoop/hadoop/lib/commons-net-1.4.1.jar:/home/hadoop/hadoop/lib/jetty-6.1.26.jar:/home/hadoop/hadoop/lib/log4j-1.2.15.jar:/home/hadoop/hadoop/lib/commons-daemon-1.0.1.jar:/home/hadoop/hadoop/lib/xmlenc-0.52.jar:/home/hadoop/hadoop/lib/slf4j-log4j12-1.4.3.jar:/home/hadoop/hadoop/lib/commons-collections-3.2.1.jar:/home/hadoop/hadoop/lib/aspectjtools-1.6.5.jar:/home/hadoop/hadoop/lib/jasper-compiler-5.5.12.jar:/home/hadoop/hadoop/lib/commons-lang-2.4.jar:/home/hadoop/hadoop/lib/kfs-0.2.2.jar:/home/hadoop/hadoop/lib/servlet-api-2.5-20081211.jar:/home/hadoop/hadoop/lib/commons-logging-api-1.0.4.jar:/home/hadoop/hadoop/lib/oro-2.0.8.jar:/home/hadoop/hadoop/lib/commons-codec-1.4.jar:/home/hadoop/hadoop/lib/jsch-0.1.42.jar:/home/hadoop/hadoop/lib/hsqldb-1.8.0.10.jar:/home/hadoop/hadoop/lib/commons-el-1.0.jar:/home/hadoop/hadoop/lib/jets3t-0.6.1.jar:/home/hadoop/hadoop/lib/commons-logging-1.1.1.jar:/home/hadoop/hadoop/lib/commons-httpclient-3.0.1.jar:/home/hadoop/hadoop/lib/commons-digester-1.8.jar:/home/hadoop/hadoop/lib/jackson-core-asl-1.0.1.jar:/home/hadoop/hadoop/lib/commons-configuration-1.6.jar:/home/hadoop/hadoop/lib/mockito-all-1.8.5.jar:/home/hadoop/hadoop/lib/commons-beanutils-core-1.8.0.jar:/home/hadoop/hadoop/lib/commons-beanutils-1.7.0.jar:/home/hadoop/hadoop/lib/slf4j-api-1.4.3.jar:/home/hadoop/hadoop/lib/aspectjrt-1.6.5.jar:/home/hadoop/hadoop/lib/commons-cli-1.2.jar:/home/hadoop/hadoop/hadoop-examples-0.20.203.0.jar:/home/hadoop/hadoop/hadoop-tools-0.20.203.0.jar:/home/hadoop/hadoop/hadoop-test-0.20.203.0.jar
export CLASSPATH;

#/home/hadoop/hadoop/bin/hadoop fs -rmr /usr/ctfan/output;

java jade.Boot -host 120.126.145.102 -container -container-name private206 -jade_core_messaging_MessageManager_maxqueuesize 40000000 java206Admin:tw.idv.ctfan.cloud.middleware.Java.JavaAdminAgent\("/home/hadoop/ctfan, 120.126.145.102"\);
