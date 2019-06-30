<template>
  <div id="box" class="container">
    <Header welcome-message="E-Book Start From Here"/>
    <Menu/>
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
// @ is an alias to /src
import Header from '../components/Header'
import Footer from '../components/Footer'
import Menu from '../components/Menu'
import Navi from '../components/Navi'
import BookShow from '../components/BookShow'

export default {
  name: 'home',
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
  components: {
    BookShow,
    Navi,
    Header,
    Menu,
    Footer
  },
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
    this.getSelect(this.select)
  }
}
</script>

<style scoped>
  @import url("../users/style.css");

</style>
