<!DOCTYPE html>
<html>
    <head>
        <title>Spring Boot Form</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="/hello" method="get">
            <p>Message: <input type="text" name="msg" id="msg"></p>
            <p>
                <input type="submit" value="Submit" name="submit"> 
            </p>
        </form>
    </body>
</html>