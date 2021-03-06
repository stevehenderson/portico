# portico
Portico was forked from openvlc/portico (https://github.com/openlvc/portico)
Please check out http://www.porticoproject.org/ for more information

**Thank you @openlvc for sharing this wonderful project!!!**

##Building Portico on Windows 10

I recommend building and testing java first.

###Building Java

Java environment.  This is my setup for Java.  I've installed both x64 and x32 versions of the jre and jdk:

```
C:\Program Files\java\jdk1.8.0_64
C:\Program Files\java\jre1.8.0_64
C:\Program Files (x86)\java\jdk1.8.0_64
C:\Program Files (x86)\java\jre1.8.0_64
JAVA_HOME=C:\Program Files\Java\jdk1.8.0_74

c:\dev\portico\codebase>java -version
java version "1.8.0_74"
Java(TM) SE Runtime Environment (build 1.8.0_74-b02)
Java HotSpot(TM) 64-Bit Server VM (build 25.74-b02, mixed mode)

```

####Check out the Java settings
- Edit:  codebase/build.properties
- Set JDK appropriately.  This is mine:

```
#################################
# Java Development Kit Settings #
#################################
# Windows values need either "/" or "\\\" for path separation. Back-slash is
# escaped when the properties file is read, and then again by Ant.
jdk.home.macosx  = /Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home
jdk.home.linux32 = /usr/lib/jvm/java-8-oracle
jdk.home.linux64 = /usr/lib/jvm/java-8-oracle
jdk.home.win32   = c:/Program Files (x86)/Java/jdk1.8.0_74
jdk.home.win64   = c:/Program Files/Java/jdk1.8.0_74
```

####Compile java library
- open a shell in codebase
- Type: `ant java.compile`

####Test Java library
- Using same command shell from above
- Type: `ant java.test`


####Where's the library?

`codebase\dist\portico-2.1.0\lib\portico.jar`

###Building Compile C++

- Grabbed VS2010 Express here: http://go.microsoft.com/?linkid=9709969
- Installed it (note, I installed on top of Visual Studio 2015) Hopefully this won't break anything
- Opened a command shell
- Typed: "C:\Program Files (x86)\Microsoft Visual Studio 10.0\Common7\Tools\vsvars32.bat"  (note:quotes super important)
- ~~Copied `jni_md.h` in `JAVA_HOME\include\Win32` to `JAVA_HOME\include`~~
- Commented out Lines 87-88  in `codebase\profiles\windows\hla13.xml`
```
	<!-- <compile-hla13 compiler="vc10" arch="amd64" build="debug"/> -->
	<!-- <compile-hla13 compiler="vc10" arch="amd64" build="release"/> -->
```
- Commented out Lines 81-82 lines in `codebase\profiles\windows\ieee1516e.xml`
```
	<!-- <compile-ieee1516e compiler="vc10" arch="amd64" build="debug"/> -->
	<!-- <compile-ieee1516e compiler="vc10" arch="amd64" build="release"/> -->
```
- type: ant cpp.compile

-If it all goes well, you should see some dll's (`libfedtim, etc`) here:

```
codebase\build\cpp\win32\hla13\complete\vc10
codebase\build\cpp\win32\ieee1516e\complete\vc10
```

##Running the examples

I had one issue when running the IEEE1516e example.  It kept throwing an error about attributes not being found.  The issue is the restrauantprocess.fom was missing a required attribute.  So I added the following to `codebase/dist/portico-2.1.0/examples/java/ieee1516e/foms/RestrauntProcesses.xml` (After Line 54).

```
<attribute>
        <name>HLAprivilegeToDeleteObject</name>
        <dataType>HLAtoken</dataType>
        <updateType>Static</updateType>
        <updateCondition>NA</updateCondition>
        <ownership>DivestAcquire</ownership>
        <sharing>PublishSubscribe</sharing>
        <transportation>HLAreliable</transportation>
        <order>TimeStamp</order>
        <semantics>NA</semantics>
</attribute>        
```

I added the same attribute to the RestrauntProcesses.xml file at `codebase/src/java/ieee1516e/examples/java/ieee1516e/foms/RestrauntProcesses.xml`