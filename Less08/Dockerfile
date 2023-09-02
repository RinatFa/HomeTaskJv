FROM bellsoft/liberica-openjdk-alpine
COPY ./java ./src5
RUN mkdir ./out
RUN javac -sourcepath ./src5 -d out src5/org/_811286/sample/Main.java
CMD java -classpath ./out org._811286.sample.Main
