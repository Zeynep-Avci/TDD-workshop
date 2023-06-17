# Group Armend Zeynep Lukas

# TDD Basic Example

This project shows a basic TDD example with some of the most common annotations.

This project used Java and Maven.

We have to declare the maven-surefire-plugin in the pom.xml file and configure the dependencies of this plugin. 

We have to declare the following dependencies:

The junit-platform-surefire-provider dependency allows us to run tests that use either the “old” JUnit (3 or 4) or JUnit 5.

If we want to run tests that use either JUnit 3 or 4, we have to declare the junit-vintage-engine dependency.

If we want to run tests that use JUnit 5, we have to declare the junit-jupiter-engine dependency.

* Junit Jupiter Dependency graph
    - https://junit.org/junit5/docs/current/user-guide/
* JUnit Annotation
    - https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations

  
## Maven goals
### Run the unit tests
```
mvn clean test
```

### Generate javadoc for the source code
```
mvn javadoc:javadoc
```

### Generate javadoc for the test code
```
mvn javadoc:test-javadoc
```

### Generate Jacoco source code coverage report
```
mvn test jacoco:report
```

### Check if thresholds limits are achieved
```
mvn test jacoco:check
```

### Generates a PIT Mutation coverage report to target/pit-reports/YYYYMMDDHHMI
```
mvn org.pitest:pitest-maven:mutationCoverage
```

### Generates a quicker PIT Mutation coverage report to target/pit-reports/YYYYMMDDHHMI
```
mvn org.pitest:pitest-maven:mutationCoverage -DwithHistory
```

### Complete example

``` 
mvn test jacoco:report org.pitest:pitest-maven:mutationCoverage -DhistoryInputFile=target\fasterPitMutationTesting-history.txt -DhistoryOutputFile=target\fasterPitMutationTesting-history.txt -Dsonar.pitest.mode=reuseReport -Dthreads=4 -DtimestampedReports=false
```
## Jacoco dependencies
* https://github.com/pitest/pitest-junit5-plugin
  - https://mvnrepository.com/artifact/org.pitest/pitest-junit5-plugin
    - required to work with JUnit5

## Testplan

### Subtraction 

#### Test Case subtraction 2 - 1 = 1

firster Operand = 2

second Operand = 1

Expected Result = 1

#### Test Case substraction 2 - 3 = -1

first operand = 2

second operand = 3 

Expected result


#### Test Case substraction 3 - (-5) = 8

first operand = 3

second operand = -5

expected result = 8

#### Test Case substraction -3 - 3 = -6

first operand = -3

second operand = 3

Expected Result = -6

#### Test Case substraction -3 - (-3) = 0

first operand = - 3

second operand = - 3

expected Result = 0

#### Test Case substraction 0 - 0 = 0

first operand = 0

second operand = 0

expected result = 0

### Division

#### Test Case Division by 0

divisor = 0

expected result = illegal argument exception

#### Test Case Division  5 divided by 1 = 5

dividend = 5 

divisor = 1

expected result = 5

#### Test Case Division 3 divided by 2 = 1.5

dividend = 3

divisor = 2

Expected result = 1.5

#### Test Case Division 0 divided by 192 = 0

dividend = 0

divisor = 192

Expected result = 0


#### Test Case Division -2 divided by -2 = 1

dividend = -2

divisor = -2

expected result = 1

#### Test Case Division 2 divided by -2 = -1

dividend = 2

divisor = -2

expected result = -1

#### Test Case Division -2 divided by 2 = -1

dividend = -2

divisor = 2 

expected result = -1

### Multiplication

#### Test Case Multiplication 1 times 5 = 5

firstOperand = 1

secondOperand = 5

expected result = 5

#### Test Case Multiplication 0 times 8000 = 0

firstOperand = 0

secondOperand = 8000

expected result = 0

#### Test Case Multiplication 8000 times 0 = 0

firstOperand = 8000

secondOperand = 0

expected result = 0

#### Test Case Multiplication -5 times 5 = -25

firstOperand = -5

secondOperand = 5 

expected result = -25

#### Test Case Multiplication 5 times -5 = -25

firstOperand = 5

secondOperand = -5 

expected result = -25

#### Test Case Multiplication -5 times -5 = 25

firstOperand = -5 

secondOperand = -5

expected result = 25

### Factorial 

#### Test Case Factorial 0!

firstOperand = 0

expected result = 1

#### Test Case Factorial 6!

firstOperand = 6

expectedResult = 720

#### Test case Factorial (-6)!

firstOperand = -6

expectedResult = throw illegal argument exception


