<template>
    <div class="container">
        <Header welcome-message="Welcome to E-Book!"/>
        <div class="welcome">
        </div>
        <div class="login">
            <form>
              <h1>Welcome to E-Book!</h1>
              <input v-model="userID" type="text" placeholder="请输入用户名">
              <br/>
              <input v-model="password" type="password" placeholder="请输入用户密码">
              <br/>
              <p class="inputAlert">{{warning}}</p>
              <router-link to="/login" @click.native="loginClick"><input type="submit" value="登 录"></router-link>
              <router-link to="/register"><input type="button" value="注 册"></router-link>
            </form>
        </div >
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
      userID: '',
      password: '',
      warning: ''
    }
  },
  watch: {
    username: function (username) {
      if (username == null || username === '') {
        this.warning = '请输入用户名'
      } else {
        this.warning = ''
      }
    },
    password: function (password) {
      if (password == null || password === '') {
        this.warning = '请输入密码'
      } else {
        this.warning = ''
      }
    }
  },

  methods: {
    loginClick: function () {
      this.$axios.post('/login', {
        userID: this.userID,
        password: this.password
      }).then(function (response) {
        console.log(response)
        if (response.data === 'USER') {
          this.$router.push('/')
          this.GLOBAL.userID = this.userID
          this.GLOBAL.role = 'user'
          this.GLOBAL.login = true
        } else if (response.data === 'ADMI') {
          this.$router.push('/AdmiHome')
          this.GLOBAL.userID = this.userID
          this.GLOBAL.role = 'admi'
          this.GLOBAL.login = true
        } else {
          this.$router.push('/Login')
          if (response.data === 'NOT_FOUND') {
            alert('不存在此用户，不如注册新用户哦~')
          }
          if (response.data === 'WRONG_PASSWORD') {
            alert('密码错误，重新输入试试吧~')
          }
          if (response.data === 'FORBIDDEN') {
            alert('您的账号已被禁用，请与管理员联系~')
          }
        }
      }.bind(this))
    }
  }

}
</script>

<style scoped>
    @import url("../users/style.css");

</style>
