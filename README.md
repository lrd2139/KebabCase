# KebabCase: Affordable and Inclusive Housing Access API
Our API is designed to track housing options specifically for underserved communities. This service simplifies the process of finding affordable and inclusive housing that meets the unique needs of different groups. For instance, elderly individuals may prioritize housing that is near hospitals and healthcare facilities, while people with disabilities need accessible buildings with features like elevators and ramps. On the other hand, low-income families may focus on affordable housing near essential services such as food banks and social services.

Our API stores detailed data on housing units, tracking key elements like location and accessibility features. It will dynamically update as new housing options become available and update units that are no longer active or have experienced changes. This real-time approach will provide users with up-to-date information, helping them find housing that suits their specific requirements quickly and efficiently.

Our goal is to make this API as flexible and inclusive as possible, accommodating the diverse needs of underserved communities. Over time, we plan to expand the service to support a broader range of housing options and criteria, making it a valuable and reliable resource for those seeking affordable, inclusive housing options.

#### Personal Contributions

This project was a collaborative team effort, with each team member playing a key role in its development. My contributions focused on both backend and frontend aspects to ensure a seamless user experience:

- Developed several core API methods and wrote corresponding unit tests.
- Refactored and updated the API structure as the project evolved, improving maintainability.
- Designed the frontend with a user-friendly and scalable interface to effectively display data.
- Implemented frontend functionality that clearly and comprehensively showcased API capabilities.


## API Usage Instructions

Welcome to our API! Follow these steps to get started and understand how to use our API effectively.

### 1. Becoming a Client

To start using our API, you must formally sign up as a client by contacting us.
Once approved, we will provide you with a client token that grants you specific privileges depending on your intended use case.

### 2. Client Privileges

Your client token will determine your level of access and the actions you can perform.

- Housing Agencies:
    - Privileges: Create and edit privileges.
    - Use Case: If you’re listing new buildings or updating existing ones, your token will allow you to create and edit buildings or housing units.
- App Developers for Renters/Buyers:
    - Privileges: Read-only privileges.
    - Use Case: If your app displays housing information to users, your token will only allow you to view the data.

### 3. User Accounts for Your App

If your application allows users to interact with our API (e.g., save/like housing units or buildings), here’s how it works:

1. User Account Creation:
    - Your app users can create an account by sending a request to our `POST /users` endpoint.
2. User Authentication:
    - When users log in, you must send a `POST /authenticate` request with their credentials and your client name (e.g., HomeSweetHome) in the request body.
    - Upon successful authentication, a user token will be generated and returned. This token:
        - Links the user to your app.
        - Allows the user to save or interact with buildings and housing units.
        - Expires after a set period (a new token is issued with each login).

### 4. Making API Requests

When interacting with our API, always include the following in your requests:

- **Token in HTTP Request Headers**: Provide your token in the request headers as follows:

```
token: <YOUR-TOKEN>
```

- **Correct Privileges**: The token will be checked for the required privileges (e.g., `create`, `edit`, `view`). Ensure your token aligns with the operation you’re attempting.

### 5. Endpoint Reference

For detailed instructions on how to use specific API endpoints (e.g., GET, POST, PATCH), refer to our [SwaggerHub Documentation](https://app.swaggerhub.com/apis/TO2428/KebabCase/1.0.0). This includes endpoint descriptions, required parameters, example requests, and responses.

## Jira
https://kebab-case.atlassian.net/jira/software/projects/KAN/boards/1

## API Endpoints
https://app.swaggerhub.com/apis/TO2428/KebabCase/1.0.0

## JaCoCo Test Coverage Results
Most recent JaCoCo Test Coverage report is at:
jacoco-screenshot.png

## Deployment
This application has been deployed using Google Cloud App Engine.

With appropriate permissions, it can be deployed using the command:
gcloud app deploy

When deployed, it lives at: https://miniproject-2024.ue.r.appspot.com/

The database lives at Google Cloud and uses CloudSQL.

## Checkstyle Results
Checkstyle results are updated on each push to the "main" branch.
You can see the latest results in checkstyle-results.txt

## PMD Results
PMD results are updated on each push to the "main" branch.
You can see the latest results in pmd-results.txt

## Unit/Integration Test Results
Unit and integration test results are updated on each push to the "main" branch.
You can see the latest results in test-results.txt

## System Test Results
System test results are updated on each push to the "main" branch.
You can see the latest results in system-results.txt

The system tests run using the Postman CLI.
More information can be found at:

https://kebabcase.postman.co/

## Manual Test Plan
The file "manual-testing-checklist.txt" contains
the manual testing plan for the client application "Home Sweet Home"
that lives at https://home-sweet-home-lemon.vercel.app/


## Testing
This project uses **JUnit** for unit testing, **JaCoCo** for code coverage,
Maven **Checkstyle** for enforcing code style, and **PMD** for static code analysis.

### Before you start testing, make sure you have the following:
- **Maven**
- **Java 17**

## **JUnit Testing**
Use the following command to run all unit tests located at src/test/java/:
```
./mvnw test
```

## **JaCoCo Coverage**
Use the following command to generate a Jacoco Coverage report:
```
./mvnw jacoco:report
```
This will generate a report under the target/site/jacoco directory. Refer to view the index.html to view the report.

## **Static Analysis**
To perform static analysis with PMD, run the following command:
```
./mvnw pmd:pmd
```
This generates a static analysis report under target/site/pmd.html.

## **Checkstyle**
To checkstyle, run the following command:
```
./mvnw checkstyle:check
```

## First time startup instructions
0. Install the "brew" if you don't have it installed:

```/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"```

0. Install MySQL if you don't have it installed:

```brew install mysql@8.4```

```echo 'export PATH="/opt/homebrew/opt/mysql@8.4/bin:$PATH"' >> ~/.zshrc```

```brew services restart mysql@8.4```

```brew services stop mysql@8.4```

``exit``

Open new terminal

```mysql_secure_installation```

```
USE mysql;
UPDATE user SET authentication_string=PASSWORD('YourPasswordGoesHere') WHERE User='root';
FLUSH PRIVILEGES;
exit;
```
Note: Be sure to update YourPasswordGoesHere with your own root password

```
mysqladmin -u root -p shutdown
```

```
brew services start mysql@8.4
```


1. Run the following SQL commands to create the database:

```
CREATE DATABASE
IF
    NOT EXISTS kebabcase DEFAULT CHARACTER
    SET = 'utf8mb4' DEFAULT COLLATE 'utf8mb4_unicode_520_ci';

CREATE USER `kebabuser`@`localhost` IDENTIFIED BY 'kebabpass';

GRANT
ALTER,
SELECT,
CREATE,
DELETE,
DROP,
INDEX,
INSERT,
REFERENCES,
UPDATE
ON
kebabcase.*
TO `kebabuser` @`localhost`;

FLUSH PRIVILEGES;
```

2. Set the following line to "create" in application.properties:

spring.jpa.hibernate.ddl-auto=create

Start the application and Hibernate will create the tables for you.

Be sure to change the line back to "none" after the first time you start the application:

spring.jpa.hibernate.ddl-auto=none

3. Run the following SQL statements to populate your database with data:

```
-- users
INSERT INTO users (id, first_name, last_name, email_address, password, created_datetime, modified_datetime) VALUES
(1, 'John', 'Doe', 'john.doe@example.com', 'password123', '2024-01-01 10:00:00', '2024-01-01 10:00:00'),
(2, 'Jane', 'Smith', 'jane.smith@example.com', 'password456', '2024-02-01 10:00:00', '2024-02-01 10:00:00'),
(3, 'Emily', 'Johnson', 'emily.johnson@example.com', 'password789', '2024-03-01 10:00:00', '2024-03-01 10:00:00'),
(4, 'Luci', 'Feinberg', 'luci.feinberg@example.com', 'i<3elifia123', '2024-05-04 11:30:00', '2024-06-02 08:00:00');


-- clients
INSERT INTO clients (id, name, created_datetime, modified_datetime) VALUES
(1, 'HousingForAll', '2024-01-05 09:30:00', '2024-01-05 09:30:00'),
(2, 'AccessibleHomes', '2024-02-10 11:00:00', '2024-02-10 11:00:00'),
(3, 'BronxHousing', '2024-02-05 11:00:00', '2024-02-10 11:00:00'),
(4, 'BrooklynHousing', '2024-03-12 11:00:00', '2024-02-10 11:00:00'),
(5, 'HomeSweetHome', '2024-03-12 11:00:00', '2024-02-10 11:00:00');

-- tokens
INSERT INTO tokens (id, client_id, user_id, token, expiration_datetime, created_datetime, modified_datetime) VALUES
(1, 1, 1, 'john_doe_token', '2024-04-01 12:00:00', '2024-01-01 10:15:00', '2024-01-01 10:15:00'),
(2, 2, 2, 'jane_smith_token', '2024-05-01 12:00:00', '2024-02-01 10:15:00', '2024-02-01 10:15:00'),
(3, 1, 3, 'emily_johnson_token', '2024-06-01 12:00:00', '2024-03-01 10:15:00', '2024-03-01 10:15:00'),
(4, 2, 4, 'luci_feinberg_token', '2024-06-05 12:00:00', '2024-03-01 10:15:00', '2024-03-01 10:15:00');

INSERT INTO tokens (id, client_id, token, expiration_datetime, created_datetime, modified_datetime) VALUES
(5, 1, 'HousingForAll_token', '2024-04-01 12:00:00', '2024-01-01 10:15:00', '2024-01-01 10:15:00'),
(6, 2, 'AccessibleHomes_token', '2024-05-01 12:00:00', '2024-02-01 10:15:00', '2024-02-01 10:15:00'),
(7, 3, 'BronxHousing_token', '2024-06-01 12:00:00', '2024-03-01 10:15:00', '2024-03-01 10:15:00'),
(8, 4, 'BrooklynHousing_token', '2024-06-05 12:00:00', '2024-03-01 10:15:00', '2024-03-01 10:15:00');

-- buildings
INSERT INTO buildings (id, address, city, state, zip_code, created_datetime, modified_datetime) VALUES
(1, '123 Elm St', 'Brooklyn', 'NY', '62701', '2024-01-20 14:30:00', '2024-01-20 14:30:00'),
(2, '456 Oak Ave', 'Brooklyn', 'NY', '46142', '2024-02-22 14:30:00', '2024-02-22 14:30:00'),
(3, '789 Maple Blvd', 'Bronx', 'NY', '43215', '2024-03-15 14:30:00', '2024-03-15 14:30:00'),
(4, '111 Jojo St', 'Bronx', 'NY', '99999', '2024-04-15 14:30:00', '2024-03-15 14:30:00');


-- housing_units
INSERT INTO housing_units (id, building_id, unit_number, created_datetime, modified_datetime) VALUES
(1, 1, '1A', '2024-01-21 10:00:00', '2024-01-21 10:00:00'),
(2, 1, '1B', '2024-01-21 10:00:00', '2024-01-21 10:00:00'),
(3, 2, '2A', '2024-02-23 10:00:00', '2024-02-23 10:00:00'),
(4, 3, '3C', '2024-03-16 10:00:00', '2024-03-16 10:00:00'),
(5, 2, '8D', '2024-05-25 10:00:00', '2024-02-23 10:00:00'),
(6, 4, '4A', '2024-07-08 10:00:00', '2024-03-16 10:00:00');


-- building_features
INSERT INTO building_features (id, name) VALUES
(1, 'Elevator'),
(2, 'Ramps'),
(3, 'Near Hospital');


-- housing_unit_features
INSERT INTO housing_unit_features (id, name) VALUES
(1, 'Wheelchair Accessible'),
(2, 'Walk-in Shower'),
(3, 'Ground Floor');


-- building_feature_building_mappings
INSERT INTO building_feature_building_mappings (id, building_id, building_feature_id) VALUES
(1, 1, 1),  -- Building 1 has Elevator
(2, 1, 2),  -- Building 1 has Ramps
(3, 2, 3),  -- Building 2 is Near Hospital
(4, 3, 1),  -- Building 3 has Elevator
(5, 4, 2),  -- Building 4 has Ramps
(6, 4, 1),  -- Building 4 has Elevator
(7, 3, 3);  -- Building 3 is Near Hospital


-- housing_unit_feature_housing_unit_mappings
INSERT INTO housing_unit_feature_housing_unit_mappings (id, housing_unit_id, housing_unit_feature_id) VALUES
(1, 1, 1),  -- Housing unit 1A has Wheelchair Accessibility
(2, 2, 2),  -- Housing unit 1B has a Walk-in Shower
(3, 3, 3),  -- Housing unit 2A is on the Ground Floor
(4, 4, 1),  -- Housing unit 3C is on the Ground Floor
(5, 1, 2),  -- Housing unit 1A has a Walk-in Shower
(6, 2, 1),  -- Housing unit 1B has Wheelchair Accessibility
(7, 5, 3),  -- Housing unit 8D is on the Ground Floor
(8, 6, 1);  -- Housing unit 4A has Wheelchair Accessibility


-- housing_unit_user_mappings
INSERT INTO housing_unit_user_mappings (id, housing_unit_id, user_id, created_datetime, modified_datetime) VALUES
(1, 1, 1, '2024-01-21 10:05:00', '2024-01-21 10:05:00'),  -- John associated with Housing Unit 1A
(2, 2, 2, '2024-01-21 10:10:00', '2024-01-21 10:10:00'),  -- Jane associated with Housing Unit 1B
(3, 3, 3, '2024-02-23 10:05:00', '2024-02-23 10:05:00'),  -- Emily associated with Housing Unit 2A
(4, 4, 4, '2024-03-16 10:05:00', '2024-03-16 10:05:00'),  -- Luci associated with Housing Unit 3C
(5, 5, 1, '2024-02-25 10:00:00', '2024-02-25 10:00:00'),  -- John associated with Housing Unit 8D
(6, 6, 3, '2024-07-08 10:05:00', '2024-07-08 10:05:00');  -- Emily associated with Housing Unit 4A


-- building_user_mappings 
INSERT INTO building_user_mappings (id, building_id, user_id, created_datetime, modified_datetime) VALUES
(1, 1, 1, '2024-01-20 14:35:00', '2024-01-20 14:35:00'),  -- John associated with Building 123 Elm St
(2, 2, 2, '2024-02-22 14:35:00', '2024-02-22 14:35:00'),  -- Jane associated with Building 456 Oak Ave
(3, 3, 3, '2024-03-15 14:35:00', '2024-03-15 14:35:00'),  -- Emily associated with Building 789 Maple Blvd
(4, 4, 4, '2024-04-15 14:35:00', '2024-04-15 14:35:00'),  -- Luci associated with Building 111 Jojo St
(5, 2, 3, '2024-02-25 14:40:00', '2024-02-25 14:40:00'),  -- Emily also associated with Building 456 Oak Ave
(6, 3, 2, '2024-03-18 14:45:00', '2024-03-18 14:45:00');  -- Jane also associated with Building 789 Maple Blvd


-- Permission table
INSERT INTO permissions (id, name, created_datetime, modified_datetime) VALUES
(1, 'view_housing_units', '2024-01-01 10:00:00', '2024-01-01 10:00:00'),  -- GET access for housing units
(2, 'create_housing_units', '2024-01-01 10:00:00', '2024-01-01 10:00:00'),  -- POST access for housing units
(3, 'edit_housing_units', '2024-01-01 10:00:00', '2024-01-01 10:00:00'),  -- PATCH access for housing units
(4, 'view_buildings', '2024-01-01 10:00:00', '2024-01-01 10:00:00'),  -- GET access for buildings
(5, 'create_buildings', '2024-01-01 10:00:00', '2024-01-01 10:00:00'),  -- POST access for buildings
(6, 'edit_buildings', '2024-01-01 10:00:00', '2024-01-01 10:00:00'),  -- PATCH access for buildings
(7, 'view_only', '2024-01-01 10:00:00', '2024-01-01 10:00:00');  -- View-only access


-- permission_client_mappings 
INSERT INTO permission_client_mappings (id, permission_id, client_id, created_datetime, modified_datetime) VALUES

-- HousingForAll Permissions
(1, 1, 1, '2024-01-01 10:00:00', '2024-01-01 10:00:00'),  -- view_housing_units
(2, 2, 1, '2024-01-01 10:00:00', '2024-01-01 10:00:00'),  -- create_housing_units
(3, 3, 1, '2024-01-01 10:00:00', '2024-01-01 10:00:00'),  -- edit_housing_units
(4, 4, 1, '2024-01-01 10:00:00', '2024-01-01 10:00:00'),  -- view_buildings
(5, 5, 1, '2024-01-01 10:00:00', '2024-01-01 10:00:00'),  -- create_buildings
(6, 6, 1, '2024-01-01 10:00:00', '2024-01-01 10:00:00'),  -- edit_buildings

-- AccessibleHomes Permissions
(7, 1, 2, '2024-01-01 10:00:00', '2024-01-01 10:00:00'),  -- view_housing_units
(8, 4, 2, '2024-01-01 10:00:00', '2024-01-01 10:00:00'),  -- view_buildings
(9, 5, 2, '2024-01-01 10:00:00', '2024-01-01 10:00:00'),  -- create_buildings
(10, 6, 2, '2024-01-01 10:00:00', '2024-01-01 10:00:00'),  -- edit_buildings

-- BronxHousing Permissions (view-only for housing units)
(11, 1, 3, '2024-01-01 10:00:00', '2024-01-01 10:00:00'),  -- view_housing_units

-- HomeSweetHome Permissions (view-only for housing units)
(13, 1, 5, '2024-01-01 10:00:00', '2024-01-01 10:00:00'),  -- view_housing_units

-- BrooklynHousing Permissions (view-only for housing units and buildings)
(14, 1, 4, '2024-01-01 10:00:00', '2024-01-01 10:00:00'),  -- view_housing_units
(15, 4, 4, '2024-01-01 10:00:00', '2024-01-01 10:00:00');  -- view_buildings
```
