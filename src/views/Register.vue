<template>
    <div class="container">
        <Header welcome-message="Welcome to E-Book!"/>
        <div class="welcome">
        </div>
        <div class="login">
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
            <p class="inputAlert">{{warning}}</p>
            <input id="register" type="button" value="提 交" v-on:click="registerClick">
          </form>
        </div>
        <Footer/>
    </div>
</template>

<script>
import Header from '../components/Header'
import Footer from '../components/Footer'
import Form from '../components/Form'

export default {
  name: 'Login',
  components: {
    Header,
    Footer,
    Form
  },
  data: function () {
    return {
      username: '',
      mail: '',
      password: '',
      bi_password: '',
      warning: ''
    }
  },
  watch: {
    username: function (newname) {
      if (newname == null || newname === '') {
        this.warning = '请输入用户名'
      } else {
        this.$axios.get('/user/existUser/' + newname).then(function (response) {
          console.log(response)
          if (response.data.userID !== newname) {
            this.warning = '用户名通过啦'
          } else {
            this.warning = '用户名存在'
          }
        }.bind(this))
      }
    },
    mail: function (newmail) {
      if (newmail == null || newmail === '') {
        this.warning = '请输入邮箱'
      } else if (newmail.indexOf('@') === -1 || newmail.indexOf('.') === -1 || newmail.indexOf('@') >= newmail.indexOf('.')) {
        this.warning = '邮箱格式不正确'
      } else {
        this.warning = '邮箱通过'
      }
    },
    password: function (password) {
      if (password == null || password === '') {
        this.warning = '请输入密码'
      } else {
        this.warning = '请再次确认密码'
      }
    },
    bi_password: function (newpassword) {
      if (newpassword == null || newpassword === '') {
        this.warning = '请再次确认密码'
      } else if (this.password !== newpassword) {
        this.warning = '两次密码输入不相同'
      } else {
        this.warning = '密码核验通过'
      }
    }
  },

  methods: {
    registerClick: function () {
      if (this.username == null || this.username === '') {
        this.warning = '请输入用户名'
      } else if (this.mail == null || this.mail === '') {
        this.warning = '请输入邮箱'
      } else if (this.mail.indexOf('@') === -1 || this.mail.indexOf('.') === -1 || this.mail.indexOf('@') >= this.mail.indexOf('.')) {
        this.warning = '邮箱格式不正确'
      } else if (this.password == null || this.password === '') {
        this.warning = '请输入密码'
      } else if (this.bi_password == null || this.bi_password === '') {
        this.warning = '请再次确认密码'
      } else if (this.password !== this.bi_password) {
        this.warning = '两次密码输入不相同'
      } else {
        this.$axios.get('/user/existUser/' + this.username).then(function (response) {
          console.log(response)
          if (response.data === true) {
            this.warning = '用户名存在'
            return
          }
          this.registerSuccess()
        }.bind(this))
      }
    },
    registerSuccess: function () {
      let verify = confirm('您即将注册用户名为 ' + this.username + ' 的账号！')
      if (verify) {
        this.$router.push({path: '/login'})
        this.$axios.post('/user/addUser', {
          userID: this.username,
          password: this.password,
          email: this.mail
        }).then(function (response) {
          console.log(response)
        }).catch(function (error) {
          console.log(error)
        })
      }
    }
  }
}
</script>

<style scoped>
    @import url("../users/style.css");

</style>
