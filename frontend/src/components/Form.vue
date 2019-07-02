<template>
    <div class="selfSetting">
        <form>
            <h1>修改个人信息</h1>
            <ul class="inputItem">
              <li><span>旧密码</span></li>
              <li><input type="password" v-model="old_password" placeholder="请输入旧密码"/></li>
            </ul>
            <ul class="inputItem">
              <li><span>新密码</span></li>
              <li><input type="password" v-model="password" placeholder="请输入新密码"/></li>
            </ul>
            <ul class="inputItem">
              <li><span>重复新密码</span></li>
              <li><input type="password" v-model="bi_password" placeholder="请重复新密码"/></li>
            </ul>
            <ul class="inputItem">
              <li><span>邮箱</span></li>
              <li><input type="email" v-model="email" placeholder="请输入邮箱"/></li>
            </ul>
            <input type="button" @click="submit" value="提 交" />
            <p class="inputAlert">{{warning}}</p>

        </form>
    </div>

</template>

<script>
import InputItem from './InputItem'

export default {
  name: 'Form',
  components: {InputItem},
  data: function () {
    return {
      email: '',
      old_password: '',
      password: '',
      bi_password: '',
      warning: ''
    }
  },
  watch: {
    email: function (email) {
      if (email.indexOf('@') === -1 || email.indexOf('.') === -1 || email.indexOf('@') >= email.indexOf('.')) {
        this.warning = '邮箱格式不正确'
      } else {
        this.warning = '邮箱通过'
      }
    },
    old_password: function (oldPassword) {
      if (oldPassword == null || oldPassword === '') {
        this.warning = '请输入旧密码'
      } else {
        this.warning = '请输入新密码'
      }
    },
    password: function (password) {
      if (password == null || password === '') {
        this.warning = '请输入密码'
      } else {
        this.warning = '请再次确认密码'
      }
    },
    bi_password: function (biPassword) {
      if (biPassword == null || biPassword === '') {
        this.warning = '请再次确认密码'
      } else if (this.password !== biPassword) {
        this.warning = '两次密码输入不相同'
      } else {
        this.warning = '密码核验通过'
      }
    }
  },

  methods: {
    submit: function () {
      if (this.email.indexOf('@') === -1 || this.email.indexOf('.') === -1 || this.email.indexOf('@') >= this.email.indexOf('.')) {
        this.warning = '邮箱格式不正确'
      } else if (this.password == null || this.password === '') {
        this.warning = '请输入密码'
      } else if (this.bi_password == null || this.bi_password === '') {
        this.warning = '请再次确认密码'
      } else if (this.password !== this.bi_password) {
        this.warning = '两次密码输入不相同'
      } else {
        let verify = confirm('您真的真的真的确定要修改个人信息吗？')
        if (verify) {
          this.$axios.get('/UserValid', {
            params: {
              userID: this.GLOBAL.userID,
              password: this.old_password
            }
          }).then(function (response) {
            console.log(response)
            if (response.data === 'USER' || response.data === 'ADMI') {
              this.modifyInfo()
              alert('修改成功！')
            } else {
              alert('您的密码出错啦，重新输入试试吧~')
            }
          }.bind(this))
        }
      }
    },
    modifyInfo: function () {
      this.$axios.put('/UserInfo', {
        userID: this.GLOBAL.userID,
        email: this.email,
        password: this.password
      }).then(function (response) {
        console.log(response)
      })
    }
  }

}
</script>

<style>
    @import url("../users/style.css");

</style>
