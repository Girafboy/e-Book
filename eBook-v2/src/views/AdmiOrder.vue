<template>
    <div class="container">
        <Header welcome-message="Big Bang Money!"></Header>
        <Menu type="admi"/>
        <div class="navi">
            <Card/>
        </div>
        <div class="display">
            <Table placeholder="请输入订单号"
                   search-item="orderID"
                   v-bind:table-column="[
                    {label:'订单号',prop:'orderID'},
                    {label:'书名',prop:'bookName'},
                    {label:'买方',prop:'userName'},
                    {label:'订单日期',prop:'date'},
                    {label:'购买数量', prop:'sales'}
                   ]"
                   v-bind:table-data="[
                    {orderID:'6273832823',userName:'你可真是个小机灵鬼',bookName:'写不完啊',date:'2019.3.23 14:32:33',sales:123},
                    {orderID:'6273832824',userName:'皮皮皮',bookName:'太难了',date:'2019.3.23 14:43:33',sales:52},
                    {orderID:'6273832832',userName:'虾',bookName:'真的好累',date:'2019.3.23 22:32:33',sales:532},
                    {orderID:'6273832233',userName:'不好看',bookName:'真的好累',date:'2019.3.25 00:32:33',sales:132},
                    {orderID:'6273832433',userName:'好好玩',bookName:'Died',date:'2019.4.1 10:32:33',sales:2},
                    {orderID:'6273835433',userName:'写完了',bookName:'太难了',date:'2019.3.28 14:11:33',sales:188},
                    {orderID:'1244322823',userName:'真棒',bookName:'Died',date:'2019.3.29 04:32:44',sales:65},
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
        name: 'Order',
        components: {Card, Table, Footer, Menu, Header},
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