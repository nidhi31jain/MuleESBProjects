
MULE ESB Runtime:
==================
download Mule standalone runtime(without Anypoint Studio) from mule https://developer.mulesoft.com/download-mule-esb-runtime
mule-standalone-3.8.1.zip and follow below steps:

1)Download and install Apache Tomcat 6 from the Apache web site following the standard installation instructions.

2)In the Tomcat home directory, add the following line to the conf/server.xml file:
<Listener className="org.mule.module.tomcat.MuleTomcatListener" />

3)Copy the contents of the Mule lib folder with all its subdirectories except /boot to the mule-libs/ directory under your Tomcat home directory (create one if necessary). You do not need to flatten the directories.

4)Copy the mule-module-tomcat-<version>.jar file to the mule-libs/mule/ directory under your Tomcat home directory (if it is not there already).

5)Copy the following libraries from your Mule lib/boot/ directory to your Tomcat mule-libs/opt/ directory:

   jcl104-over-slf4j-1.5.0.jar

    log4j-1.2.14.jar

    slf4j-api-1.5.0.jar

    slf4j-log4j12-1.5.0.jar

6)In the Tomcat conf/catalina.properties file, add the following to common.loader (precede with a comma to separate it from existing values):
${catalina.home}/mule-libs/user/.jar,${catalina.home}/mule-libs/mule/.jar,${catalina.home}/mule-libs/opt/*.jar
