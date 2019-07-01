<template>
    <div class="container">
        <Header welcome-message="So much fans you got!"></Header>
        <Menu type="admi"/>
        <div class="navi">
            <Card/>
        </div>
        <div class="display">
          <el-table :data="users.filter( user => !search || user.userID.includes(search))"
                    ref="multipleTable"
                    stripe
                    style="width: 100%">
            <el-table-column type="index" ></el-table-column>
            <el-table-column label= '用户名' prop= 'userID' sortable width="150%"></el-table-column>
            <el-table-column label= '密码' prop= 'password' sortable width="100%"></el-table-column>
            <el-table-column label= '状态' prop= 'state' header-align="center" width="150%"></el-table-column>
            <el-table-column label= '邮箱' prop= 'email' header-align="center" width="150%"></el-table-column>
            <el-table-column align="right" >
              <template slot="header" slot-scope="scope">
                <el-input placeholder="请输入用户名" prefix-icon="el-icon-search"
                          type="mini" v-model="search"></el-input>
              </template>
              <template slot-scope="scope">
                <el-button type="danger" @click.native.prevent="forbid(scope.$index, users)">{{scope.row.state === "正常"?"禁用":"启用"}}</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
        <Footer/>
    </div>
</template>

<script>
import Card from '../components/Card'
import Header from '../components/Header'
import Menu from '../components/Menu'
import Table from '../components/Table'
import Footer from '../components/Footer'
export default {
  name: 'UserManage',
  data: function () {
    return {
      search: '',
      users: [{
        userID: String,
        password: String,
        role: String,
        state: String,
        email: String
      }]
    }
  },
  components: {Footer, Table, Menu, Header, Card},
  methods: {
    forbid (index, rows) {
      this.$axios.put('/user/forbid/' + rows[index].userID).then(function (response) {
        console.log(response)
        this.getUsers()
      }.bind(this)).catch(function (response) {
        console.log(response)
      })
    },
    getUsers: function () {
      this.$axios.get('/user/findAllUser').then(function (response) {
        console.log(response.data)
        this.users = response.data
      }.bind(this))
    }
  },
  created () {
    this.getUsers()
  }
}
</script>

<style scoped>
    ul a:link,ul a:visited{
        background-color: #12b2cc;
    }
    .head,.foot{
        background-color: #4b99ff;
    }
    .menu a:link,.menu a:visited,.navi li{
        background-color: #12b2cc;
    }
    .navi h2,h3{
        background-color: #4b99ff;
    }
</style>
