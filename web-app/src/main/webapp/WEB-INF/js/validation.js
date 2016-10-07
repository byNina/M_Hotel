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

