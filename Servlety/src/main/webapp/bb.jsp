
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
    <head>

    </head>

        <body>
             <h1>
                 <b><c:out value="${requestScope.password}" /></b>
                 <b><c:out value="${requestScope.login}" /></b>
             </h1>
        </body>
</html>