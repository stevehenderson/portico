# portico
Portico was forked from openvlc/portico (https://github.com/openlvc/portico)
Please check out http://www.porticoproject.org/ for more information

Major change log from the upstream version:

- Changed codebase/propoerties to match my java install
- Removed references to `<verifyJdk location="${jdk.home.win32}" arch="x86"/>` from `hla13.xml` and `ieee1516e.xml` at `codebase\profiles\windows`

##Building Portico (Windows 10)

###Check out the Java settings
- Edit:  codebase/build.properties
- Set JDK appropriately

###Compile java library
- open a shell in codebase
- Type: `ant java.compile`

###Test Java library
- Using same command shell from above
- Type: `ant java.test`

###Compile C++

I'm trying to compile it with Visual Studio 2015..here goes!
