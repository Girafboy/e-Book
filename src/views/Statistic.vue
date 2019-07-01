<template>
    <div class="container">
        <Header welcome-message="Self Setting"></Header>
        <Menu/>
        <div class="navi">
            <Card/>
        </div>
        <div class="display">
          <div>
            <el-date-picker
              v-model="dateDuring"
              type="datetimerange"
              range-separator="至"
              start-placeholder="开始日期"
              end-placeholder="结束日期">
            </el-date-picker>
            <el-button type="success" icon="el-icon-search" @click="getBuyOfBook"></el-button>
            <el-table :data="bookStatistic"
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
              <el-table-column label="购买数量" prop="sales"></el-table-column>
            </el-table>
          </div>
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
  name: 'Setting',
  data: function () {
    return {
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
      }]
    }
  },
  components: {Footer, Form, Card, Menu, Header},
  methods: {
    getBuyOfBook: function () {
      this.$axios.get('/statistic/buyOfBook/' + this.dateDuring[0].getTime() +
        '/' + this.dateDuring[1].getTime() +
        '/' + this.GLOBAL.userID).then(function (response) {
        console.log(response)
        this.bookStatistic = response.data
      }.bind(this))
    }
  }
}
</script>

<style scoped>
    @import url("../users/style.css");

</style>
