<!DOCTYPE html>

<html lang="en">

<body>
    <h1>Application in ${environment} mode</h1>
    <strong>Date:</strong> ${time?date}
    <br>
    <strong>Time:</strong> ${time?time}
    <br>
    <strong>Message:</strong> ${message}


    <h1>Persons</h1>
    <#list persons as person>
        <ul>
          <li>${person.id} - ${person.name}</li>
        </ul>
    </#list>

</body>

</html>