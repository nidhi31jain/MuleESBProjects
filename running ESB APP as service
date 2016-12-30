

you can do in 3 Ways:

PROCEDURE 1:
==============
MULE ESB Runtime:
==================
download Mule standalone runtime(without Anypoint Studio) from mule https://developer.mulesoft.com/download-mule-esb-runtime
mule-standalone-3.8.1.zip and follow below steps:
set environment variable MULE_HOME - C:\mule-standalone-3.8.1\

1) just go to Anypoint studio right click > export > Any point studio deployable  click -"Any point Studio project to Mule Deployable Archive(includes  Studio Metadata)" click on this to generate *.zip e.g sample.zip will be created.
just drop the zip file to apps folder like  C:\mule-standalone-3.8.1\apps\loginProvier.zip then it creates folder once start the mule.bat 

PROCEDURE 2:
==============
 just go to Anypoint studio right click > export >click "Publish to ApplicaitonRepository" it deploy on mmc(Mule Management console)
 it is licensed server.
 
 Requirements
 ============
To take MMC for a test drive, there are no special technical requirements. Just download the trial version.

To successfully run MMC in production, you need:

A Mule ESB Enterprise instance with a valid enterprise license

The MMC console application file (mmc.war) deployed in a supported web application server

The MMC agent .jar file, which is bundled with the Mule ESB Enterprise instance in versions 3.7.0 and newer. Previous versions of Mule ESB require the agent to be installed separately.
 

PROCEDURE 3:
==============
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
