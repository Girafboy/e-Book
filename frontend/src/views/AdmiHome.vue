<template>
    <div class="container">
        <Header welcome-message="Good Job!"/>
        <Menu type="admi"/>
        <Navi @transfer="getSelect"/>
        <div class="display">
          <el-input placeholder="请输入书名" prefix-icon="el-icon-search"
                    style="width: 300px" v-model="query"></el-input>
          <book-show v-bind:books = "books.filter(book => !books || book.bookName.includes(query))"/>
        </div>
        <Footer/>
    </div>
</template>

<script>
import Header from '../components/Header'
import Menu from '../components/Menu'
import Navi from '../components/Navi'
import BookShow from '../components/BookShow'
import Footer from '../components/Footer'

export default {
  name: 'AdmiHome',
  data: function () {
    return {
      query: '',
      select: '热销书籍',
      books: [{
        bookID: Number,
        bookName: String,
        price: Number,
        coverUrl: String,
        typeName: String,
        stock: 0
      }]
    }
  },
  components: {Footer, BookShow, Navi, Menu, Header},
  methods: {
    getSelect: function (select) {
      this.select = select
      this.$axios.get('/book/findBookByType/' + this.select).then(function (response) {
        console.log(response)
        this.books = response.data
      }.bind(this)).catch(function (error) {
        alert('网络连接错误')
        console.log(error)
      })
    }
  },
  created: function () {
    if (!this.GLOBAL.login || this.GLOBAL.role !== 'admi') {
      this.$message('为了更好地使用E-Book，请先登录哦~')
      this.$router.push({path: '/login'})
    }
    this.getSelect(this.select)
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
