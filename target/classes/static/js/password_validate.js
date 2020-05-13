var pass = document.getElementById("pass_input");
var lower = document.getElementById("lower");
var upper = document.getElementById("upper");
var num = document.getElementById("number");
var pass_len = document.getElementById("length");

var retype = document.getElementById("retype_pass");

var submit = document.getElementById('submit');

var match = document.getElementById('match');
pass.onkeyup = function() {

    if(pass.value.match(/[a-z]/g)){
        lower.innerHTML = "True";
    } else {
        lower.innerHTML = "False";
    }


    if(pass.value.match(/[A-Z]/g)){
        upper.innerHTML = "True";
    } else {
        upper.innerHTML = "False";
    }


    if(pass.value.match(/[0-9]/g)){
        num.innerHTML = "True";
    } else {
        num.innerHTML = "False";
    }


    if(pass.value.length >= 10){
        pass_len.innerHTML = "True";
    } else {
        pass_len.innerHTML = "False";
    }

}

function confirm_pass(){
    if(pass.value == retype.value ){
        submit.disabled = false;
        match.innerText = "✔";

    }else{
        submit.disabled = true;
        match.innerText = "✖";
    }
}