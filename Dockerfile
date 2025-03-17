# Docker file sample[I havent tried this]
FROM newimage
COPY src  /home/abhishek/Ak/Dev/Selenium4-Cucumber-Hybrid-Framework/src
COPY extent-test-output  /home/abhishek/Ak/Dev/Selenium4-Cucumber-Hybrid-Framework/extent-test-output
COPY pom.xml	/home/abhishek/Ak/Dev/Selenium4-Cucumber-Hybrid-Framework/pom.xml
COPY testng.xml	/home/abhishek/Ak/Dev/Selenium4-Cucumber-Hybrid-Framework/testng.xml
ENV DISPLAY=:99.0
WORKDIR /home/abhishek/Ak/Dev/Selenium4-Cucumber-Hybrid-Framework
ENTRYPOINT mvn clean test