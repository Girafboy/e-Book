<template>
    <ul class="inputItem">
        <li>
            <span>{{PreMessage}}</span>
        </li>
        <li>
            <input v-bind:type="type" v-model="value" v-bind:placeholder="placeHolder"/>
        </li>
    </ul>
</template>

<script>
    export default {
        name: "InputItem",
        props:{
            PreMessage:String,
            type:String,
            value:String,
            placeHolder:String,
        }
    }
</script>

<style>
    @import url("../users/style.css");
    .inputItem span{
        font-family: 方正喵呜体, serif;
        font-size:24px;
        line-height: 200%;
    }
    .inputItem ul{
        margin: 10px;
    }
    .inputItem li{
        display: inline;
        float: left;
        width: 200px;
    }
    input{
        width: 100%;
        height: 45px;
        background-color: #ffffff;
        border: none;
        color: #ff9777;
        font-family: 方正喵呜体, serif;
        font-size: 24px;
    }
    .inputItem input[type="submit"]{
        width: 80%;
        height: 45px;
        background-color: #bcff76;
        border: none;
        color: white;
        font-family: 方正喵呜体, serif;
        font-size: 24px;
    }
    .inputItem input[type="button"]{
        width:80%;
        height: 45px;
        background-color: #bcff76;
        border: none;
        color: white;
        font-family: 方正喵呜体, serif;
        font-size: 24px;
        text-align: center;
    }
    .inputItem input:hover, input:active{
        background-color: #ff9777;
        color:white;
    }
</style>
