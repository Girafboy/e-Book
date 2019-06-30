<template>
    <div class="container">
        <Header welcome-message="Look at what you have chosen!"></Header>
        <Menu/>
        <div class="navi">
            <Card/>
        </div>
        <div class="display">
            <el-table :data="carts"
                      ref="multipleTable"
                      @selection-change="handleSelectionChange"
                      stripe
                      style="width: 100%">
                <el-table-column type="selection" ></el-table-column>
                <el-table-column type="expand">
                    <template slot-scope="scope">
                        <el-form label-position="left" inline class="demo-table-expand">
                            <el-form-item label="书名" >
                                <span>{{ scope.row.book.bookName }}</span>
                            </el-form-item>
                            <el-form-item label="作者">
                                <span>{{ scope.row.book.author }}</span>
                            </el-form-item>
                            <el-form-item label="ISBN编号">
                                <span>{{ scope.row.book.ISBN }}</span>
                            </el-form-item>
                            <el-form-item label="单价">
                                <span>{{ scope.row.book.price }}</span>
                            </el-form-item>
                        </el-form>
                    </template>
                </el-table-column>
                <el-table-column label= '书名' prop= 'book.bookName' sortable ></el-table-column>
                <el-table-column label= '单价' prop= 'book.price' sortable width="100%"></el-table-column>
                <el-table-column label= '数量' prop= 'amount' header-align="center" width="150%">
                    <template slot-scope="scope">
                      <el-input-number v-if="scope.row.book.stock!==0" size="mini" :min="1" :max="scope.row.book.stock" v-model="scope.row.amount"
                                       @change="handleAmountChange"></el-input-number>
                      <el-input-number v-if="scope.row.book.stock===0" size="mini" :min="0" :max="0" v-model="scope.row.amount"
                                       @change="handleAmountChange"></el-input-number>
                      <p v-if="scope.row.book.stock===0">抱歉，该书已卖完</p>
                    </template>
                </el-table-column>
                <el-table-column align="right" width="250%" >
                    <template slot="header" slot-scope="scope" >
                        <el-tag>
                            购书体验<el-rate v-model="satisfy" type="mini"></el-rate>
                        </el-tag>
                    </template>
                    <template slot-scope="scope">
                        <el-button type="danger" @click.native.prevent="deleteRow(scope.$index, carts)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div>
                <el-tag>总价：{{consume}}元</el-tag>
                <el-button @click="dialogVisible=true">提交订单</el-button>
            </div>
            <el-dialog title="提示" :visible.sync="dialogVisible"
                       width="30%">
                <span>您确定提交订单吗？</span>
                <span slot="footer" class="dialog-footer">
                  <el-button @click="dialogVisible = false">我再想想</el-button>
                  <el-button type="primary" @click="submit">确认提交</el-button>
                </span>
            </el-dialog>
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
  name: 'Cart',
  data: function () {
    return {
      dialogVisible: false,
      satisfy: null,
      consume: 0,
      carts: [{
        id: '',
        book: {
          bookID: '',
          bookName: '',
          author: '',
          ISBN: '',
          price: Number,
          stock: 0
        },
        amount: Number
      }],
      selectionItems: []
    }
  },
  components: {Card, Table, Footer, Menu, Header},
  methods: {
    deleteRow (index, rows) {
      this.$axios.delete('/cart/delete/' + rows[index].id).then(function (response) {
        console.log(response)
      }).catch(function (response) {
        console.log(response)
      })
      rows.splice(index, 1)
    },
    handleSelectionChange (rows) {
      this.selectionItems = rows
      this.consume = 0
      rows.forEach(row => {
        this.consume += row.book.price * row.amount
        this.consume = Number(this.consume.toFixed(2))
      })
    },
    handleAmountChange () {
      this.consume = 0
      this.selectionItems.forEach(row => {
        this.consume += row.book.price * row.amount
        this.consume = Number(this.consume.toFixed(2))
      })
    },
    getCart: function () {
      this.$axios.get('/cart/findCart/' + this.GLOBAL.userID).then(function (response) {
        console.log(response)
        this.carts = response.data
      }.bind(this))
    },
    submit: function () {
      this.dialogVisible = false
      this.addOrder()
    },
    addOrder: function () {
      this.$axios.post('/order/addOrder/' + this.GLOBAL.userID, {
        orderItems: this.selectionItems
      }).then(function (response) {
        this.getCart()
        console.log(response)
      }.bind(this)).catch(function (error) {
        console.log(error)
      })
      //
      // this.selectionItems.forEach(row => {
      //   this.$axios.post('/order/addOrderItem/' + row.bookID + '/' + this.GLOBAL.userID).then(function (response) {
      //     this.getCart()
      //     console.log(response)
      //   }.bind(this)).catch(function (error) {
      //     console.log(error)
      //   })
      // })
    }
  },
  created: function () {
    this.getCart()
  }
}
</script>

<style scoped>
    @import url("../users/style.css");

</style>
