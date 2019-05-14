<template>
    <div class="container">
        <Header welcome-message="So much fans you got!"></Header>
        <Menu type="admi"/>
        <div class="navi">
            <Card/>
        </div>
        <div class="display">
            <Table placeholder="请输入用户名"
                   search-item="userName"
                    v-bind:table-column="[
                    {label:'用户名',prop:'userName'},
                    {label:'密码',prop:'password'},
                    {label:'订购数',prop:'orderNum'},
                    {label:'状态', prop:'state'}
                   ]"
                   v-bind:table-data="[
                    {
                    userName: 'user',
                    password: 'hhh',
                    orderNum: 1024,
                    state: '正常'
                    },
                    {
                    userName: 'stupid',
                    password: 'xxx',
                    orderNum: 13,
                    state: '禁用'
                    },
                    ]"></Table>
        </div>
        <Footer/>
    </div>
</template>

<script>
    import Card from "../components/Card";
    import Header from "../components/Header";
    import Menu from "../components/Menu";
    import Table from "../components/Table";
    import Footer from "../components/Footer";
    export default {
        name: "UserManage",
        components: {Footer, Table, Menu, Header, Card}
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