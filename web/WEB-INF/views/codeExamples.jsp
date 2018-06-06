<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Examples | JustLearnIT</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

<style type="text/css" media="screen">

    #editor {
        align-content: center;
        height: 500px;
        width: 100%;
    }

</style>


<jsp:include page="./parts/userMenu.jsp"/>

<div class="container">

    <div class="card border-primary mb-3">
        <div class="card-header" style="text-align: center; font-size: 24px">Example</div>

        <form:form modelAttribute="topic">

                <div class="card-body">
                    <p>${topic.codeExplanation}</p>
                </div>
                <div class="card-footer">
                    <div id="editor">${topic.codeExample}</div>
                </div>

        </form:form>

    </div>

    <form:form action="/FinishLesson" method="post">

        <input type="submit" value="Finish lesson" class="btn btn-success" style="float: right; margin: 16px;" />

    </form:form>



</div>


<script src="/resources/ace-ide/ace.js"></script>
<script>

    var editor = ace.edit("editor");
    editor.setShowPrintMargin(false);
    editor.setOptions({
        readOnly: true
    });
    editor.renderer.$cursorLayer.element.style.opacity = 0;

</script>


</body>
</html>
