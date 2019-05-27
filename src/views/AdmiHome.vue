<template>
    <div class="container">
        <Header welcome-message="Good Job!"/>
        <Menu type="admi"/>
        <Navi @transfer="getSelect"/>
        <book-show v-bind:books="books.filter(data=>!books || data.bookType.includes(select))"/>
        <Footer/>
    </div>
</template>

<script>
    import Header from "../components/Header";
    import Menu from "../components/Menu";
    import Navi from "../components/Navi";
    import BookShow from "../components/BookShow";
    import Footer from "../components/Footer";
    export default {
        name: "AdmiHome",
        data:function(){
            return{
                select:'',
                books: [{ bookType:"热销书籍 外文原版 科技科普 动漫卡通",bookName:'SoGood', bookPrice:'30RMB', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookType:"热销书籍 小说传记 心灵鸡汤",bookName:'好叭', bookPrice:'$3888', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookType:"热销书籍 育儿家教 期刊报纸",bookName:'Stupid', bookPrice:'￥34', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookType:"热销书籍 软件编程 育儿家教",bookName:'真的好累', bookPrice:'￥324', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookType:"热销书籍 小说传记 科技科普",bookName:'写不完啊', bookPrice:'$3328', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookType:"热销书籍 软件编程 外文原版 经管营销",bookName:'太难了', bookPrice:'$38', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookType:"热销书籍 哲学宗教 育儿家教",bookName:'Died', bookPrice:'$3', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookType:"热销书籍 软件编程 政治军事",bookName:'活下去', bookPrice:'$388', pictureUrl:require('../assets/liulangdiqiu.jpg')},
                    { bookType:"热销书籍 期刊报纸 科技科普 教辅词典",bookName:'Meet Life', bookPrice:'$88', pictureUrl:require('../assets/liulangdiqiu.jpg')},]
            }
        },
        components: {Footer, BookShow, Navi, Menu, Header},
        methods:{
            getSelect:function (select) {
                this.select=select
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