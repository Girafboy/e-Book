<template>
    <div class="container">
        <Header welcome-message="Big Bang Money!"></Header>
        <Menu type="admi"/>
        <div class="navi">
            <Card/>
        </div>
        <div class="display">
          <el-table :data="orders.filter(order => !search || String(order.orderID).includes(search))"
                    ref="multipleTable"
                    stripe
                    style="width: 100%">
            <el-table-column type="index" ></el-table-column>
            <el-table-column type="expand">
              <template slot-scope="scope">
                <el-table :data="scope.row.orderItems"
                          stripe
                          border>
                  <el-table-column prop="book.bookName" label="书名"></el-table-column>
                  <el-table-column prop="book.author" label="作者"></el-table-column>
                  <el-table-column prop="book.price" label="单价"></el-table-column>
                  <el-table-column prop="amount" label="购买数量"></el-table-column>
                </el-table>
              </template>
            </el-table-column>
            <el-table-column label= '订单号' prop= 'orderID' sortable width="100%"></el-table-column>
            <el-table-column label= '订单总价' prop= 'totPrice' sortable width="100%"></el-table-column>
            <el-table-column label= '订单日期' prop= 'date' header-align="center" width="200%">
              <template slot-scope="scope">
                {{new Date(scope.row.date).format('yyyy-MM-dd hh:mm:ss')}}
              </template>
            </el-table-column>
            <el-table-column align="right" >
              <template slot="header" slot-scope="scope">
                <el-input placeholder="请输入订单号" prefix-icon="el-icon-search"
                          type="mini" v-model="search"></el-input>
              </template>
              <template slot-scope="scope">
                <el-button type="danger" @click.native.prevent="deleteRow(scope.$index, orders)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
        <Footer/>
    </div>
</template>

<script>
import Header from '../components/Header'
import Menu from '../components/Menu'
import Footer from '../components/Footer'
import Table from '../components/Table'
import Card from '../components/Card'
export default {
  name: 'Order',
  data: function () {
    return {
      search: '',
      orders: [{
        orderID: null,
        totPrice: null,
        date: null,
        orderItems: [{
          book: {
            bookName: null,
            author: null,
            price: null
          },
          amount: null
        }]
      }]
    }
  },
  components: {Card, Table, Footer, Menu, Header},
  methods: {
    deleteRow (index, rows) {
      this.$axios.delete('/order/delete/' + rows[index].orderID).then(function (response) {
        console.log(response)
      }).catch(function (response) {
        console.log(response)
      })
      rows.splice(index, 1)
    },
    getOrders: function () {
      this.$axios.get('/order/findAllOrder').then(function (response) {
        console.log(response.data)
        this.orders = response.data
      }.bind(this))
    }
  },
  created: function () {
    if (!this.GLOBAL.login || this.GLOBAL.role !== 'admi') {
      this.$message('为了更好地使用E-Book，请先登录哦~')
      this.$router.push({path: '/login'})
    }
    this.getOrders()
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
