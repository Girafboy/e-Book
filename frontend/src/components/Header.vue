<template>
    <div class="head">
        <h1 class="welcomeMessage">{{ welcomeMessage}}</h1>
        <div v-if="GLOBAL.login" class = "nav">
          <p>
            Welcome! {{this.GLOBAL.userID}}  <el-button type="text" @click="logout">注销</el-button>
          </p>
        </div>
        <div v-else class = "nav">
          <router-link to="/login">Login</router-link> |
          <router-link to="/register">Register</router-link>
        </div>
    </div>
</template>

<script>
export default {
  name: 'Header',
  props: {
    welcomeMessage: String
  },
  methods: {
    logout: function () {
      this.GLOBAL.login = false
      this.GLOBAL.userID = ''
      this.GLOBAL.role = 'user'
      this.$router.push('/login')
      this.$axios.get('/logout').then(response => {
        if (response.data === 'LOGOUT') { alert('退出成功') }
      })
    }
  }
}
</script>

<style>
    @import url("../users/style.css");

</style>
