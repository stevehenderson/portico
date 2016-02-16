# portico
Portico was forked from openvlc/portico (https://github.com/openlvc/portico)
Please check out http://www.porticoproject.org/ for more information

**Thank you portico for sharing this wonderful project!!!**

Major change log from the upstream version:

- Changed codebase/propoerties to match my java install
- Commentedd out   `<verifyJdk location="${jdk.home.win32}" arch="x86"/>` from `hla13.xml` and `ieee1516e.xml` at `codebase\profiles\windows`  This line is needed to compile on x32, and I don't need to.  Note:  I could have installed an x32 java environment and avoid this..

##Building Portico (Windows 10)

The majority of portico is implemented in Java.  The CPP builds larelgy wrap the java code with JNI.  So I recommend building and testing java first.

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
- Set JDK appropriately

####Compile java library
- open a shell in codebase
- Type: `ant java.compile`

####Test Java library
- Using same command shell from above
- Type: `ant java.test`

###Building Compile C++

- Grabbed VS2010 Express here: http://go.microsoft.com/?linkid=9709969
- Installed it (note, I installed on top of Visual Studio 2015) Hopefully this won't break anything
- Opened a command shell
- Typed: "C:\Program Files (x86)\Microsoft Visual Studio 10.0\Common7\Tools\vsvars32.bat"  (note:quotes super important)
- Edited: codebase\cpp\hla13\src\common.h
          Changed L139 to: `#include "C:\Program Files\Java\jdk1.8.0_74\include\jni.h"`
- Copied `jni_md.h` in `JAVA_HOME\include\Win32` to `JAVA_HOME\include`
- type: ant cpp.compile

