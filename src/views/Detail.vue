<template>
    <div class="container">
        <Header welcome-message="You really choose a good book!"></Header>
        <Menu/>
        <div class="mainBook">
            <div class="book">
                <a href=""><img :src="book.coverUrl"></a>
                <a href=""><h2 class="bookName">{{book.bookName}}</h2></a>
                <a href=""><h3 class="price">￥{{book.price}}</h3></a>
                <p>{{book.description}}</p>
            </div>
        </div>
        <div class="detailBlock">
            <div class="details">
                <ul>
                    <li>
                        <h3>基本信息</h3>
                        <ul>
                            <li><h6>书名</h6><span>{{book.bookName}}</span></li>
                            <li><h6>作者</h6><span>{{book.author}}</span></li>
                            <li><h6>类别</h6><span>科幻小说</span></li>
                            <li><h6>页数</h6><span>293页</span></li>
                            <li><h6>定价</h6><span>{{book.price}}元</span></li>
                            <li><h6>出版时间</h6><span>2008年11月</span></li>
                        </ul>
                    </li>
                    <hr/>
                    <li>
                        <h3>内容简介</h3>
                        <p>{{book.description}}</p>
                        <p>{{book.description}}</p>
                        <p>{{book.description}}</p>
                        <p>{{book.description}}</p>
                        <p>{{book.description}}</p>
                    </li>
                    <hr/>
                    <li>
                        <h3>作品目录</h3>
                        <ul>
                            <li><h6>中国太阳</h6></li>
                            <li><h6>乡村教师</h6></li>
                            <li><h6>全频带阻塞干扰</h6></li>
                            <li><h6>流浪地球</h6></li>
                            <li><h6>带上她的眼睛</h6></li>
                            <li><h6>地球大炮</h6></li>
                            <li><h6>镜子</h6></li>
                            <li><h6>赡养上帝</h6></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <Footer></Footer>
    </div>
</template>

<script>
import Header from '../components/Header'
import Footer from '../components/Footer'
import Menu from '../components/Menu'
export default {
  name: 'Detail',
  components: {Menu, Footer, Header},
  data: function () {
    return {
      books: [],
      book: {}
    }
  },
  methods: {
    getBookDetail: function () {
      this.$axios.get('/BookInfo', {
        params: {
          typeName: 'ALL'
        }
      }).then(function (response) {
        console.log(response)
        console.log(this.$route.params.bookID)
        this.books = response.data
        this.book = this.books.filter(book => book.bookID.includes(this.$route.params.bookID))[0]
      }.bind(this)).catch(function (error) {
        alert('网络连接错误')
        console.log(error)
      })
    }
  },
  created () {
    this.getBookDetail()
  }
}
</script>

<style scoped>
    @import url("../users/style.css");
    .detailBlock{
        width: 579px;
        float: left;
        border-left: 1px solid #12b2cc;
        text-align: left;
    }
    .details{
        margin: 20px;
    }
    .details h6{
        display: inline;
        line-height: 200%;
        margin-right: 100px;
        font-size: 16px;
    }
    hr{
        border-color: #12b2cc;
        border-top: #12b2cc;
    }
</style>
