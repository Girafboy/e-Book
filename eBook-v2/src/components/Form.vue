<template>
    <div v-if="login" v-bind:key="login.id" class="login">
        <form>
            <h1>Welcome to E-Book!</h1>
            <input v-model="username" type="text" placeholder="请输入用户名">
            <br/>
            <input v-model="password" type="password" placeholder="请输入用户密码">
            <br/>
            <router-link :to="page"><input type="submit" value="登 录"></router-link>
            <router-link to="/register"><input type="button" value="注 册"></router-link>
        </form>
    </div >
    <div v-else-if="register" v-bind:key="register.id" class="login">
        <form>
            <h1>Welcome to E-Book!</h1>
            <input v-model="username" type="text" placeholder="请输入用户名">
            <br/>
            <input v-model="mail" type="email" placeholder="请输入联系邮箱">
            <br/>
            <input v-model="password" type="password" placeholder="请输入用户密码">
            <br/>
            <input v-model="bi_password" type="password" placeholder="请再次确认用户密码">
            <br/>
            <p id="inputAlert">{{warning}}</p>
            <input id="register" type="button" value="提 交" v-on:click="registerClick">
        </form>
    </div>
    <div v-else-if="setting" v-bind:key="setting.id" class="selfSetting">
        <form action="">
            <h1>修改个人信息</h1>
            <InputItem type="text" pre-message="用户名" v-bind:value="username" place-holder="请输入用户名"/>
            <InputItem type="password" pre-message="旧密码" v-bind:value="username" place-holder="请输入旧密码"/>
            <InputItem type="password" pre-message="新密码" v-bind:value="username" place-holder="请输入新密码"/>
            <InputItem type="password" pre-message="重复新密码" v-bind:value="username" place-holder="请重复新密码"/>
            <InputItem type="email" pre-message="邮箱" v-bind:value="username" place-holder="请输入邮箱"/>
            <InputItem type="text" pre-message="地区" v-bind:value="username" place-holder="请输入地区"/>
            <InputItem type="textarea" pre-message="个性签名" v-bind:value="username" place-holder="请输入个性签名"/>
            <InputItem type="submit" value="提 交" />
        </form>
    </div>

</template>

<script>
    import InputItem from "./InputItem";
    export default {
        name: "Form",
        components: {InputItem},
        props:{
            login:{
                type:Boolean,
                default:false
            },
            register:{
                type:Boolean,
                default:false
            },
            setting:{
                type:Boolean,
                default:false
            },
            username:String,
            mail:String,
            password:String,
            bi_password:String,
            warning:String,
            page:{
                type: String,
                default: '/login'
            }
        },
        watch:{
            username:function (newname) {
                if(newname==null||newname==='')
                    this.warning = "请输入用户名";
                else
                    this.warning = "用户名通过"
                if(newname==='admi')
                    this.page ="/admihome"
                else if(newname==='user')
                    this.page = '/'
                else
                    this.page = '/login'
            },
            mail:function (newmail) {
                if (newmail == null || newmail === "")
                    this.warning = "请输入邮箱";
                else if(newmail.indexOf('@') === -1 || newmail.indexOf('.') === -1 || newmail.indexOf('@') >= newmail.indexOf('.'))
                    this.warning = "邮箱格式不正确";
                else
                    this.warning = "邮箱通过"
            },
            password:function(password){
                if (password == null || password === "")
                    this.warning = "请输入密码";
                else
                    this.warning =  "请再次确认密码"
            },
            bi_password:function (newpassword) {
                if (newpassword == null || newpassword === "")
                    this.warning  = "请再次确认密码";
                else if (this.password !== newpassword)
                    this.warning  = "两次密码输入不相同"
                else
                    this.warning = "密码核验通过"
            }
        },

        methods: {
            registerClick:function() {
                if (this.username == null || this.username === "")
                    this.warning = "请输入用户名";
                else if (this.mail == null || this.mail === "")
                    this.warning = "请输入邮箱";
                else if (this.mail.indexOf('@') === -1 || this.mail.indexOf('.') === -1 || this.mail.indexOf('@') >= this.mail.indexOf('.'))
                    this.warning = "邮箱格式不正确";
                else if (this.password == null || this.password === "")
                    this.warning = "请输入密码";
                else if (this.bi_password == null || this.bi_password === "")
                    this.warning = "请再次确认密码";
                else if (this.password !== this.bi_password)
                    this.warning = "两次密码输入不相同";
                else {
                    let verify = confirm("您即将注册用户名为 " + this.username + " 的账号！");
                    if (verify)
                        this.$router.push({path:'/login'})
                }
            }
        }

    }
</script>

<style>
    @import url("../users/style.css");

</style>