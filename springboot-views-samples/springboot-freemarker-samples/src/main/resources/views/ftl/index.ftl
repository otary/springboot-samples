<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>freemarker</title>
    </head>
    <body>

        User: ${user.id} - ${user.name} - ${user.birth?string("yyyy-MM-dd HH:mm:ss")}

    </body>
</html>