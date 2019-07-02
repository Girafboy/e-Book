<template>
    <div class="container">
        <Header welcome-message="How about stocking more book?"/>
        <Menu type="admi"/>
        <div class="navi">
            <Card/>
        </div>
        <div class="display">
            <Table placeholder="请输入书名"
                   search-item="bookName"
                   v-bind:table-column="[
                    {label:'书名',prop:'bookName'},
                    {label:'作者',prop:'author'},
                    {label:'ISBN编号',prop:'code'},
                    {label:'销量', prop:'sales'},
                    {label:'库存', prop:'remain'}
                   ]"
                   v-bind:table-data="[
                    { bookName:'SoGood',author:'Girafboy',code:'SE114',sales:123,remain:13, bookPrice:'30RMB', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookName:'好叭', author:'Giraf',code:'SE112',sales:532532,remain:1, bookPrice:'$3888', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookName:'Stupid',author:'boy',code:'SE113',sales:32,remain:0,  bookPrice:'￥34', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookName:'真的好累',author:'Girl',code:'SE1233',sales:2333,remain:555,  bookPrice:'￥324', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookName:'写不完啊', author:'ahhhh',code:'SE32',sales:1314,remain:33, bookPrice:'$3328', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookName:'太难了', author:'blue',code:'SE132',sales:520,remain:2, bookPrice:'$38', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookName:'Died', author:'Girafboy',code:'SE234',sales:888,remain:1, bookPrice:'$3', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookName:'活下去', author:'Girafboy',code:'SE1432',sales:666,remain:1, bookPrice:'$388', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookName:'Meet Life',author:'Girafboy',code:'SE332',sales:345,remain:233,  bookPrice:'$88', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    ]"></Table>
        </div>
        <Footer/>
    </div>
</template>

<script>
    import Header from "../components/Header";
    import Menu from "../components/Menu";
    import Footer from "../components/Footer";
    import Card from "../components/Card";
    import Table from "../components/Table";
    export default {
        name: "Warehouse",
        components: {Table, Card, Footer, Menu, Header}
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
