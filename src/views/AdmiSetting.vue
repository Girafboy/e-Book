<template>
    <div class="container">
        <Header welcome-message="Self Setting"></Header>
        <Menu type="admi"/>
        <div class="navi">
            <Card/>
        </div>
        <div class="display">
            <Form :setting="true"/>
        </div>
        <Footer/>
    </div>
</template>

<script>
    import Header from "../components/Header";
    import Menu from "../components/Menu";
    import Card from "../components/Card";
    import Form from "../components/Form";
    import Footer from "../components/Footer";
    export default {
        name: "Setting",
        components: {Footer, Form, Card, Menu, Header}
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