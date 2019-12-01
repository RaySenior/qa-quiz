1. Install Apache Maven:
https://maven.apache.org/install.html
2. Run command "mvn clean test"


Bugs:

1. Creating triangle:
Expected result - save up to 10 triangles.
Actual result - save up 11 triangles.

2. Delete method with null triangleID:
Actual result - status code 200.
Expected result - status code 4xx with error message.

3. Delete method with non exist triangleID:
Actual result - status code 200.
Expected result - status code 400 with error message about wrong id.

4. Get perimeter method with empty triangleID:
Actual result - empty response.
Expected result - response with error message about wrong id.