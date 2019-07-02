<template>
    <div class="book">
        <el-popover
          placement="top-start"
          title="本书详情"
          width="200"
          trigger="hover">
          <ul>
            <li><b>书名：</b><span>{{bookName}}</span></li>
            <li><b>作者：</b><span>{{author}}</span></li>
            <li><b>ISBN编号：</b><span>{{ISBN}}</span></li>
            <li><b>库存：</b><span>{{stock}}</span></li>
            <li><b>定价：</b><span>{{bookPrice}}元</span></li>
            <li><b>内容描述：</b><span>{{description}}</span></li>
          </ul>
          <el-button slot="reference" style="padding: 0">
            <router-link to="/detail"><img :src="pictureUrl"></router-link>
          </el-button>
        </el-popover>
        <ul>
          <li><router-link :to="{name:'detail',params:{bookID: bookId}}" ><h2 class="bookName" >{{bookName}}</h2></router-link></li>
          <li><router-link :to="{name:'detail',params:{bookID: bookId}}" ><h3 class="price" >￥ {{bookPrice}}</h3></router-link></li>
          <el-button @click="dialogVisible=true">加入购物车</el-button>
        </ul>
        <el-dialog title="加入购物车" :visible.sync="dialogVisible"
                 width="30%">
          <template v-if="stock!==0">
            <span>库存量：{{stock}}</span>
            <span>请选择购买数量</span>
            <el-input-number v-model="amount" :min="1" :max="stock"></el-input-number>
            <span slot="footer" class="dialog-footer">
            <el-button type="primary" @click="addCart">确定</el-button>
            </span>
          </template>
          <template v-if="stock===0">
            <span>抱歉~该书已经卖完了</span>
          </template>
        </el-dialog>
    </div>
</template>

<script>
export default {
  name: 'Book',
  data: function () {
    return {
      dialogVisible: false,
      amount: 1
    }
  },
  props: {
    bookId: Number,
    bookName: String,
    bookPrice: Number,
    pictureUrl: String,
    stock: Number,
    description: String,
    ISBN: String,
    author: String
  },
  methods: {
    addCart: function () {
      this.dialogVisible = false

      this.$axios.post('/cart/addCartItem/' + this.bookId +
        '/' + this.amount + '/' + this.GLOBAL.userID).then(function (response) {
        console.log(response)
      }).catch(function (response) {
        console.log(response)
      })
    }
  }
}
</script>

<style>
    @import url("../users/style.css");
    .book{
        float: left;
        margin-left: 15px;
        margin-right: 15px;
        margin-top: 50px;
    }
    .book a{
        text-decoration: none;
        text-align: center;
    }
    .book img{
        width: 200px;
        height: 250px;
    }
    .book h2,.book h3{
        margin: 0px;
        padding: 5px;
    }
</style>
