<template>
    <div class="container">
        <Header welcome-message="Self Setting"></Header>
        <Menu/>
        <div class="navi">
            <Card/>
        </div>
        <div class="display">
            <Form/>
        </div>
        <Footer/>
    </div>
</template>

<script>
import Header from '../components/Header'
import Menu from '../components/Menu'
import Card from '../components/Card'
import Form from '../components/Form'
import Footer from '../components/Footer'
export default {
  name: 'Setting',
  components: {Footer, Form, Card, Menu, Header}
}
</script>

<style scoped>
    @import url("../users/style.css");

</style>
