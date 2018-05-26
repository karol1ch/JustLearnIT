<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>


<style type="text/css" media="screen">

    #editor {
        align-content: center;
        height: 500px;
        width: 100%;
    }

</style>


<div class="container">
    <div id="editor">${userCode}</div>
</div>


<script src="/resources/ace-ide/ace.js"></script>
<script>
    var editor = ace.edit("editor");
    editor.setShowPrintMargin(false);
    editor.setOptions({
        readOnly: true
    });
    editor.renderer.$cursorLayer.element.style.opacity = 0;

    <c:if test="${ideTheme != null}">
    editor.setTheme("ace/theme/${ideTheme}");
    </c:if>

    function getAceMode(language) {
        var aceMode;

        switch (language) {
            case "C++":
            case "C":
                aceMode = "c_cpp";
                break;
            case "C#":
                aceMode = "csharp";
                break;
            default:
                aceMode = language.toLowerCase();
        }

        return aceMode;
    }

    function updateLanguage(selectedLanguage) {
        var aceMode = getAceMode(selectedLanguage.value);
        editor.getSession().setMode("ace/mode/" + aceMode);
    }

</script>
