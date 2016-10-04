function validateForm() {
    var x = document.forms["loginForm"]["login"].value;
    if (x == null || x == "") {
        alert("Login must be filled out");
        return false;
    }
    var y = document.forms["loginForm"]["pass"].value;
    if (y == null || y == "") {
        alert("Password must be filled out");
        return false;
    }
}

function validateDate() {
    str = document.getElementById('Date1').value;
    var err = ["не корректная дата"]
    function TstDate() {
        str2 = str.split(".");
        if (str2.length != 3) {
            return false;
        }
        str2 = str2[2] + '-' + str2[1] + '-' + str2[0];
        if (new Date(str2) == 'Invalid Date') {
            return false;
        }
        return str;
    }
    var S = TstDate()
    if (S) {
        err.splice(0, 1);
        alert(str);
    } else alert(err);
}
