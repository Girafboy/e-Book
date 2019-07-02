<template>
    <div class="container">
        <Header welcome-message="Welcome to E-Book!"/>
        <div class="welcome">
        </div>
        <Form :login="true"/>
        <Footer/>
    </div>
</template>

<script>
    import Header from "../components/Header";
    import Footer from "../components/Footer";
    import Form from "../components/Form";

    export default {
        name: "Login",
        components:{
            Header,
            Footer,
            Form
        }
    }
</script>

<style scoped>
    @import url("../users/style.css");

</style>
