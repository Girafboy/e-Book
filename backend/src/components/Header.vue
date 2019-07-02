<template>
    <div class="head">
        <h1 id="welcomeMessage">{{ welcomeMessage}}</h1>
        <div id = "nav">
            <router-link to="/login">Login</router-link> |
            <router-link to="/register">Register</router-link>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Header",
        props:{
            welcomeMessage: String
        }
    }
</script>

<style>
    @import url("../users/style.css");
    #welcomeMessage{
        display: inline;
        line-height: 200%;
    }
    #nav{
        display: inline;
        float: right;
        line-height: 200%;
    }
</style>
