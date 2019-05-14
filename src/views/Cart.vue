<template>
    <div class="container">
        <Header welcome-message="Look at what you have chosen!"></Header>
        <Menu/>
        <div class="navi">
            <Card/>
        </div>
        <div class="display">
            <Table placeholder="请输入书名"
                   search-item="bookName"
                   v-bind:table-column="[
                    {label:'书名',prop:'bookName'},
                    {label:'作者',prop:'author'},
                    {label:'语言',prop:'language'},
                    {label:'出版日期',prop:'date'},
                    {label:'购买数量', prop:'sales'}
                   ]"
                   v-bind:table-data="[
                    { bookName:'SoGood',author:'Girafboy',language:'Chinese',date:2019,code:'SE114',sales:123,remain:13, bookPrice:'30RMB', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookName:'好叭', author:'Giraf',language:'English',date:2018,code:'SE112',sales:532532,remain:1, bookPrice:'$3888', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookName:'Stupid',author:'boy',language:'France',date:2019,code:'SE113',sales:32,remain:0,  bookPrice:'￥34', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookName:'真的好累',author:'Girl',language:'Chinese',date:2018,code:'SE1233',sales:2333,remain:555,  bookPrice:'￥324', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookName:'写不完啊', author:'ahhhh',language:'Chinese',date:2019,code:'SE32',sales:1314,remain:33, bookPrice:'$3328', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookName:'太难了', author:'blue',language:'English',date:2019,code:'SE132',sales:520,remain:2, bookPrice:'$38', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookName:'Died', author:'Girafboy',language:'English',date:2012,code:'SE234',sales:888,remain:1, bookPrice:'$3', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookName:'活下去', author:'Girafboy',language:'Chinese',date:2019,code:'SE1432',sales:666,remain:1, bookPrice:'$388', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookName:'Meet Life',author:'Girafboy',language:'Spanish',date:1019,code:'SE332',sales:345,remain:233,  bookPrice:'$88', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    ]"/>
        </div>
        <Footer/>
    </div>
</template>

<script>
    import Header from "../components/Header";
    import Menu from "../components/Menu";
    import Footer from "../components/Footer";
    import Table from "../components/Table";
    import Card from "../components/Card";
    export default {
        name: 'Cart',
        components: {Card, Table, Footer, Menu, Header},
    }
</script>

<style scoped>
    @import url("../users/style.css");

</style>
