<template>
    <div class="container">
        <Header welcome-message="How about stocking more book?"/>
        <Menu type="admi"/>
        <div class="navi">
            <Card/>
        </div>
        <div class="display">
          <el-table :data="books"
                    ref="multipleTable"
                    stripe
                    style="width: 100%">
            <el-table-column type="expand" width="100px">
              <template slot="header" slot-scope="scope">
                <el-button type="primary" size="small" @click.native.prevent="addBook">新增</el-button>
              </template>
              <template slot-scope="scope">
                <el-form label-position="left" inline class="demo-table-expand">
                  <el-form-item label="">
                    <div class="book" style="margin: 5px"><img :src="scope.row.coverUrl" alt="封面" width="10%"/></div>
                    <input v-if="showEdit[scope.$index]" type="file" @change="getFile($event,scope.$index)" style="width: 200px; font-size: xx-small"/>
                    <button v-if="showEdit[scope.$index]" @click="upload($event,scope.$index)">提交</button>
                  </el-form-item>
                  <el-form-item label="内容简介" >
                    <el-input v-if="showEdit[scope.$index]" type="textarea" v-model="scope.row.description" :rows="12"/>
                    <span v-if="!showEdit[scope.$index]" >{{ scope.row.description }}</span>
                  </el-form-item>
                  <el-form-item label="作者">
                    <el-input v-if="showEdit[scope.$index]" type="text" v-model="scope.row.author"/>
                    <span v-if="!showEdit[scope.$index]">{{ scope.row.author }}</span>
                  </el-form-item>
                  <el-form-item label="ISBN编号">
                    <el-input v-if="showEdit[scope.$index]" type="text" v-model="scope.row.ISBN"/>
                    <span v-if="!showEdit[scope.$index]">{{ scope.row.ISBN }}</span>
                  </el-form-item>
                </el-form>
              </template>
            </el-table-column>
            <el-table-column label= '书名' prop= 'bookName' sortable >
              <template slot-scope="scope">
                <el-input v-if="showEdit[scope.$index]" type="text" v-model="scope.row.bookName"/>
                <span v-if="!showEdit[scope.$index]">{{scope.row.bookName}}</span>
              </template>
            </el-table-column>
            <el-table-column label= '单价' prop= 'price' sortable width="100%">
              <template slot-scope="scope">
                <el-input v-if="showEdit[scope.$index]" type="float" v-model="scope.row.price"/>
                <span v-if="!showEdit[scope.$index]">{{scope.row.price}}</span>
              </template>
            </el-table-column>
            <el-table-column label= '库存' prop= 'stock' header-align="center" width="150%">
              <template slot-scope="scope">
                <el-input-number v-if="showEdit[scope.$index]" size="mini" :min="0" v-model="scope.row.stock"></el-input-number>
                <span v-if="!showEdit[scope.$index]">{{scope.row.stock}}</span>
              </template>
            </el-table-column>

            <el-table-column align="right" width="250%" >
              <template slot="header" slot-scope="scope">
                <el-input placeholder="请输入书名" prefix-icon="el-icon-search"
                          type="mini" v-model="search"></el-input>
              </template>
              <template slot-scope="scope">
                <el-button v-if="showBtn[scope.$index]" type="success" size="small" @click.native.prevent="handleUpdate(scope.$index,scope.row)">更新</el-button>
                <el-button v-if="showBtn[scope.$index]" type="info" size="small" @click.native.prevent="handleCancel(scope.$index,scope.row)">取消</el-button>
                <el-button v-if="!showBtn[scope.$index]" type="primary" size="small" @click.native.prevent="handleEdit(scope.$index,scope.row)">编辑</el-button>
                <el-button v-if="!showBtn[scope.$index]" type="danger" size="small" @click.native.prevent="handleDelete(scope.$index, books)">删除</el-button>
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
import Card from '../components/Card'
import Table from '../components/Table'
export default {
  name: 'Warehouse',
  data: function () {
    return {
      showEdit: [],
      showBtn: [],
      file: [],
      books: [{
        bookID: '',
        bookName: '',
        author: '',
        ISBN: '',
        price: Number,
        stock: 0,
        description: ''
      }],
      newbook: {
        bookName: '请输入书名',
        author: '请输入作者',
        ISBN: 'ISBNXXXXXXXXX',
        price: 0,
        stock: 0,
        description: '请写下对这本书的描述吧~'
      }
    }
  },
  components: {Table, Card, Footer, Menu, Header},
  methods: {
    handleEdit (index, row) {
      this.$set(this.showEdit, index, true)
      this.$set(this.showBtn, index, true)
    },
    handleCancel (index, row) {
      this.$set(this.showEdit, index, false)
      this.$set(this.showBtn, index, false)
      this.getBook()
    },
    handleUpdate (index, row) {
      this.$set(this.showEdit, index, false)
      this.$set(this.showBtn, index, false)
      this.$axios.put('/book/modify', row).then(reponse => {
        console.log(reponse)
      }).catch(response => {
        console.log(response)
      })
    },
    handleDelete (index, rows) {
      this.$axios.delete('/book/delete/' + rows[index].bookID).then(function (response) {
        console.log(response)
      }).catch(function (response) {
        console.log(response)
      })
      rows.splice(index, 1)
    },
    getBook: function () {
      this.$axios.get('/book/findAllBook').then(function (response) {
        console.log(response)
        this.books = response.data
      }.bind(this))
    },
    getFile (event, index) {
      this.file[index] = event.target.files[0]
      console.log(this.file)
    },
    upload: function (event, index) {
      event.preventDefault()
      let formData = new FormData()
      formData.append('file', this.file[index])

      this.$axios.post('/picture/upload/' + this.books[index].bookID, formData,
        {headers: {'Content-Type': 'multipart/form-data'}}).then(response => {
        console.log(response)
        this.getBook()
      }).catch(response => {
        console.log(response)
      })
    },
    addBook: function () {
      this.books.push(this.newbook)
      this.$axios.post('/book/addBook', this.books[this.books.length - 1]).then(response => {
        console.log(response)
      })
      this.$set(this.showBtn, this.books.length - 1, true)
      this.$set(this.showEdit, this.books.length - 1, true)
    }
  },
  created: function () {
    this.getBook()
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
