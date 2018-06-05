// Detect Key Events
// $(window).on("keydown", function(event){

var osc = {};

$(window).keydown(function (event) {
    var code = (event.keyCode ? event.keyCode : event.which);
    if ((code < 48 && code != 32) || (57 < code && 65 > code) || (code > 90 && code != 189 && code != 188)) {
        return;
    }
    if (code == 32) {
        if ($("li[data-code='32']").text() == "GetFocus") {
            $("li[data-code='32']").text("LoseFocus");
            $(".regexInput").focus();
        } else {
            $("li[data-code='32']").text("GetFocus");
            $(".regexInput").blur();
        }
        return false;
    }
    if ($("li[data-code='32']").text() == "LoseFocus") {
        return;
    }
    if (osc[code])
        return;
    $("li[data-code='" + code + "']").addClass("active")
    fillBox(code);
    var key = $("li[data-code='" + code + "']").data("key");
    var code = $("li[data-code='" + code + "']").data("code");
    console.log("KEYON:" + key + "/" + code + "@" + event.timeStamp);
});

$(window).keyup(function (event) {
    var code = (event.keyCode ? event.keyCode : event.which);
    $("li[data-code='" + code + "']").removeClass("active")
    var key = $("li[data-code='" + code + "']").data("key");
    var code = $("li[data-code='" + code + "']").data("code");
    console.log("KEYOFF:" + key + "/" + code + "@" + event.timeStamp);
    if (!osc[code])
        return;
    stopSound(code);
});

function fillBox(code) {
    var key = $("li[data-code='" + code + "']").data("classify");
    var str = $("li[data-code='" + code + "']").text();
    var textarea = $(".regexInput").val();
    str = str.replace(/[\s]/g, "");
    if (str == "All(ExceptLineBreaks)") {
        str = "All";
    }
    if (str == "NToMTimes") {
        str = "N,MTimes";
    }
    cleartextarea();
    var result = "";
    if (key == "bracket") {
        result = textarea + str + '() ';
    } else if (key == "pattern") {
        result = textarea + '\n';
    } else if (key == "times") {
        result = textarea + ":" + str + " ";
    } else if (key == "itself") {
        result = textarea + str + " ";
    } else if (key == "or") {
        result = textarea + str + ":(a|b|...) ";
    } else if (key == "aftercolon") {
        result = textarea + " :" + str + " ";
    } else if (key == "beforecolon") {
        result = textarea + str + ": ";
    } else if (key == "colonbracket") {
        result = textarea + str + ":() ";
    } else if (key == "squarebrackets") {
        result = textarea + str + "[] ";
    }
    result = result.replace(/[\r]/g, "");
    $(".regexInput").val(result);
}

function cleartextarea() {
    $(".regexInput").val("");
}


// Detect Mouse Events
$("li").mousedown(function (event) {
    $(this).addClass("active");
    var key = $(this).data("key");
    var code = $(this).data("code");
    console.log("MOUSEON:" + key + "/" + code + "@" + event.timeStamp);
    startSound();
});

$("li").mouseup(function (event) {
    $(this).removeClass("active");
    var key = $(this).data("key");
    var code = $(this).data("code");
    console.log("MOUSEOFF:" + key + "/" + code + "@" + event.timeStamp);
    stopSound();
});

//hover hint
$("li").mouseover(function (event) {
    $(".hintbox").text($(this).data("key"));
    $(this).addClass("active");
});
$("li").mouseout(function (event) {
    $(".hintbox").text("hint.")
    $(this).removeClass("active");
});
