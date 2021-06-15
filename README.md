# FRC-Testing-Examples
Examples for testing (unit and integration) FRC Java code


2021.06.05  

I'm setting up the project today. Created the repo, and now following instructions here: https://docs.wpilib.org/en/stable/docs/romi-robot/imaging-romi.html  

I have a Romi with an image on it, but I'm going to make sure I have the latest image and setup. I have downloaded and installed the Romi image WPILibPi_image-v2021.2.1-Romi.zip, which is what I downloaded and installed previously.  


I ended up re-imaging the Romi image; I couldn't connect to it. 

Now I'm setting up the WPILib Romi Project.  

Success! I can control the Romi with the simulation. So we're at the same place I was in February with the status.  

Now to add some testing elements.  


2021.06.12  
To add some unit tests. Mark T of 2051 has given me some unit test samples in this branch:https://github.com/fixermark/team2051-simulator-demo/tree/unit-test-pose-estimator  

I ran the command `$ ./gradlew test` and the report is located at `../team2051-simulator-demo/build/reports/tests/test/index.html`, this shows a successful test run.  

Now, to add this same functionality to the FRC Testing. Do a diff between file:///home/dormouss/Projects/FIRST/GeneralTestingExperiments/team2051-simulator-demo/build.gradle and /home/dormouss/Projects/FIRST/Joint Team Projects/FRC-Testing-Examples/build.gradle


Mark T's repo has the JUNit4 test infrastructure. I'm going to refer to it but use Junit5 for future compatibility. I'm following along in the JUNit 5 documentation. I pull examples from the site here: `/home/dormouss/Projects/Learnings/JUnit/junit5-samples/junit5-jupiter-starter-gradle/`

https://www.arhohuttunen.com/junit-5-gradle-example/

Success! I have added the barebones bits and pieces and I successfully ran one test!


2021.06.14  
I'm adding some functionality from the 5740 bot to the demo project.

As a demo, I'm going to work on the command "ForceExtendHood"

I want to use the methods in the HoodSubsytem class, so I need to fake out the underlying components. The method `hoodAngleFinder` seems to be a piece of core functionality, so I'm starting there to add my mocks. The hood subsystem should be composable of mutliple sub-sub systems.  

