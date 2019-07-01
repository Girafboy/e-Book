<template>
    <div class="container">
        <Header welcome-message="Statistics!"></Header>
        <Menu type="admi"/>
        <div class="navi">
            <Card/>
        </div>
        <div class="display">
          <div>
            <el-radio-group v-model="radio">
              <el-radio-button label="书籍销量统计"></el-radio-button>
              <el-radio-button label="用户消费统计"></el-radio-button>
            </el-radio-group>
            <el-date-picker
              v-model="dateDuring"
              type="datetimerange"
              range-separator="至"
              start-placeholder="开始日期"
              end-placeholder="结束日期">
            </el-date-picker>
            <el-button type="success" icon="el-icon-search" @click="doClick"></el-button>
          </div>
          <el-table v-if="radio==='书籍销量统计'" :data="bookStatistic"
                    ref="multipleTable"
                    stripe
                    style="width: 100%">
            <el-table-column type="index" ></el-table-column>
            <el-table-column type="expand">
              <template slot-scope="scope">
                <el-form label-position="left" inline class="demo-table-expand">
                  <el-form-item label="">
                    <div class="book" style="margin: 5px"><img :src="scope.row.book.coverUrl" alt="封面" width="10%"/></div>
                  </el-form-item>
                  <el-form-item label="内容简介" >
                    <span>{{ scope.row.book.description }}</span>
                  </el-form-item>
                  <el-form-item label="作者">
                    <span>{{ scope.row.book.author }}</span>
                  </el-form-item>
                  <el-form-item label="ISBN编号">
                    <span>{{ scope.row.book.ISBN }}</span>
                  </el-form-item>
                </el-form>
              </template>
            </el-table-column>
            <el-table-column label="书名" prop="book.bookName"></el-table-column>
            <el-table-column label="ISBN编号" prop="book.ISBN"></el-table-column>
            <el-table-column label="单价" prop="book.price"></el-table-column>
            <el-table-column label="销量" prop="sales"></el-table-column>
          </el-table>
          <el-table v-if="radio==='用户消费统计'" :data="userStatistic"
                    ref="multipleTable"
                    stripe
                    style="width: 100%">
            <el-table-column type="index" ></el-table-column>
            <el-table-column type="expand">
              <template slot-scope="scope">
                <el-table :data="scope.row.bookStatistics"
                          ref="multipleTable"
                          stripe
                          style="width: 100%">
                  <el-table-column label="书名" prop="book.bookName"></el-table-column>
                  <el-table-column label="ISBN编号" prop="book.ISBN"></el-table-column>
                  <el-table-column label="单价" prop="book.price"></el-table-column>
                  <el-table-column label="购买数" prop="sales"></el-table-column>
                </el-table>
              </template>
            </el-table-column>
            <el-table-column label="用户名" prop="user.userID"></el-table-column>
            <el-table-column label="购买书籍总数" prop="buys"></el-table-column>
            <el-table-column label="购买书籍总花费" prop="costs"></el-table-column>
          </el-table>
        </div>
        <Footer/>
    </div>
</template>

<script>
import Header from '../components/Header'
import Menu from '../components/Menu'
import Card from '../components/Card'
import Form from '../components/Form'
import Footer from '../components/Footer'
export default {
  name: 'AdmiStatistic',
  data: function () {
    return {
      radio: '书籍销量统计',
      dateDuring: [new Date(2000, 0, 0, 24, 0), new Date()],
      bookStatistic: [{
        book: {
          ISBN: '',
          author: '',
          bookID: Number,
          bookName: '',
          bookTypes: [],
          coverUrl: '',
          description: '',
          price: 0,
          stock: 0
        },
        sales: 0
      }],
      userStatistic: [{
        bookStatistics: [{
          book: {
            ISBN: '',
            author: '',
            bookID: Number,
            bookName: '',
            bookTypes: [],
            coverUrl: '',
            description: '',
            price: 0,
            stock: 0
          },
          sales: 0}],
        buys: 0,
        costs: 0,
        user: {
          email: '',
          password: '',
          role: '',
          state: '',
          userID: ''
        }
      }]
    }
  },
  components: {Footer, Form, Card, Menu, Header},
  methods: {
    doClick: function () {
      if (this.radio === '书籍销量统计') { this.getSaleOfBook() }
      if (this.radio === '用户消费统计') { this.getSaleOfUser() }
    },
    getSaleOfBook: function () {
      this.$axios.get('/statistic/saleOfBook/' + this.dateDuring[0].getTime() +
        '/' + this.dateDuring[1].getTime()).then(function (response) {
        console.log(response)
        this.bookStatistic = response.data
      }.bind(this))
    },
    getSaleOfUser: function () {
      this.$axios.get('/statistic/saleOfUser/' + this.dateDuring[0].getTime() +
        '/' + this.dateDuring[1].getTime()).then(function (response) {
        console.log(response)
        this.userStatistic = response.data
      }.bind(this))
    }
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
