<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>


<style type="text/css" media="screen">

    #editor
    {
        align-content: center;
        height: 500px;
        width: 100%;
    }

</style>


<div class="container">

    <form:form action="/submitCode" id="ideForm" method="post" modelAttribute="submit">
        <div class="card border-primary mb-3">
            <div class="card-header">${problemName}</div>
            <div class="card-body">
                <form:textarea path="codeContent" style="display:none;"/>
                <div id="editor">place for your code</div>
            </div>
            <div class="card-footer">

                <div class="row">
                    <div class="col">
                        <form:select id="languageSelect" class="selectpicker form-control" path="programmingLanguage.name" style="float: left; margin: 16px; width: 50%" onchange="updateLanguage(this)">
                            <form:option selected="true" disabled="true" value="Choose language" />
                            <form:options items="${languages}"/>
                        </form:select>
                    </div>
                    <div class="col">
                        <button class="btn btn-primary" type="button" style="float: right; margin: 16px;" onclick="submitForm()">submit</button>
                    </div>
                </div>
            </div>
        </div>
    </form:form>

</div>


<div class="modal fade" id="chooseLanguageModal" tabindex="-1" role="dialog" aria-labelledby="chooseLanguageModalTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="chooseLanguageModalTitle">Code cannot be sent</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">Please choose a language</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="pleaseWaitDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1>Waiting for results...</h1>
            </div>
            <div class="modal-body">
                <div class="progress">
                    <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%"></div>
                </div>
            </div>
        </div>
    </div>
</div>



<script src="/resources/ace-ide/ace.js"></script>
<script>
    var editor = ace.edit("editor");
    editor.setShowPrintMargin(false);

    <c:if test="${ideTheme != null}">
    editor.setTheme("ace/theme/${ideTheme}");
    </c:if>

    function getAceMode(language)
    {
        var aceMode;

        switch(language)
        {
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

    function updateLanguage(selectedLanguage)
    {
        var aceMode = getAceMode(selectedLanguage.value);
        editor.getSession().setMode("ace/mode/" + aceMode);
        document.getElementById('textarea1').value = aceMode;
    }

    function submitForm() {
        var editor = ace.edit("editor");
        var code = editor.getSession().getValue();
        var select = document.getElementById("languageSelect");
        var language = select.options[select.selectedIndex].value;

        if (language === "Choose language")
        {
            $('#chooseLanguageModal').modal('show');
        }
        else
        {
            document.getElementById('codeContent').value = code;
            document.getElementById("ideForm").submit();

            var pleaseWait = $('#pleaseWaitDialog');

            pleaseWait.modal('show');

        }
    }
</script>
