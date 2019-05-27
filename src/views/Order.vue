<template>
    <div class="container">
        <Header welcome-message="What do you want?"></Header>
        <Menu/>
        <div class="navi">
            <Card/>
        </div>
        <div class="display">
            <Table placeholder="请输入订单号"
                   search-item="orderID"
                   v-bind:table-column="[
                    {label:'订单号',prop:'orderID'},
                    {label:'书名',prop:'bookName'},
                    {label:'订单日期',prop:'date'},
                    {label:'购买数量', prop:'sales'}
                   ]"
                   v-bind:table-data="[
                    {orderID:'6273832823',bookName:'写不完啊',date:'2019.3.23 14:32:33',sales:123},
                    {orderID:'6273832824',bookName:'太难了',date:'2019.3.23 14:43:33',sales:52},
                    {orderID:'6273832832',bookName:'真的好累',date:'2019.3.23 22:32:33',sales:532},
                    {orderID:'6273832233',bookName:'真的好累',date:'2019.3.25 00:32:33',sales:132},
                    {orderID:'6273832433',bookName:'Died',date:'2019.4.1 10:32:33',sales:2},
                    {orderID:'6273835433',bookName:'太难了',date:'2019.3.28 14:11:33',sales:188},
                    {orderID:'1244322823',bookName:'Died',date:'2019.3.29 04:32:44',sales:65},
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
    @import url("../users/style.css");

</style>