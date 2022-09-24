:: local Path Nikos
cd F:\Alexandrio\4_Year\DSYS\[10b]_JavaRMI_v4\JavaRMI\src
C:\Java\jdk1.8.0_271\bin\javac compute\Compute.java compute\Task.java
C:\Java\jdk1.8.0_271\bin\jar cvf C:\wamp64\www\www_tech\compute.jar compute\*.class

C:\Java\jdk1.8.0_271\bin\javac -cp C:\wamp64\www\www_tech\compute.jar engine\ComputeEngine.java

C:\Java\jdk1.8.0_271\bin\javac -cp C:\wamp64\www\www_tech\compute.jar client/ComputePi.java client/Pi.java
copy client\Pi.class C:\wamp64\www\www_tech\

