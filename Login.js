function registerClick(){
    let username = document.getElementById("username").value;
    let mail = document.getElementById("mail").value;
    let password = document.getElementById("password").value;
    let bi_password = document.getElementById("bi_password").value;
    let inputAlert = document.getElementById("inputAlert");
    if(username==null||username=="")
        inputAlert.innerText="请输入用户名";
    else if(mail==null||mail=="")
        inputAlert.innerText="请输入邮箱";
    else if(mail.indexOf('@')==-1||mail.indexOf('.')==-1||mail.indexOf('@')>=mail.indexOf('.'))
        inputAlert.innerText="邮箱格式不正确";
    else if(password==null||password=="")
        inputAlert.innerText="请输入密码";
    else if(bi_password==null||bi_password=="")
        inputAlert.innerText="请再次确认密码";
    else if(password!=bi_password)
        inputAlert.innerText="两次密码输入不相同"
    else{
        let verify = confirm("您即将注册用户名为 " + username + " 的账号！")
        if(verify)
            location.assign("Login.html");
    }
}

