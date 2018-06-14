<!DOCTYPE html>
<!-- from https://hellokoding.com/handling-form-submission-example-with-java-spring-boot-and-freemarker/ -->
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>This form submits to a new page</title>
    </head>
    <body>
        <h2 class="hello-title">FreeMarker with pre-deploy tests</h2>
        <#if user?? >
        Your submitted data<br>
        First name: ${user.firstName}<br>
        Last name: ${user.lastName}<br>
        <#else>
        <form action="/form" method="post">
            First name:<br>
            <input type="text" name="firstName">
            <br><br>
            Last name:<br>
            <input type="text" name="lastName">
            <br><br>
            <input type="submit" value="Submit">
        </form>
        </#if>
    </body>
</html>