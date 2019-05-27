<template>
    <div class="book">
        <router-link to="/detail"><img :src="pictureUrl"></router-link>
        <a><h2 class="bookName" onmousedown="bookNameClickdown(this)" onmouseup="bookNameClickup(this)">{{bookName}}</h2></a>
        <a><h3 class="price" onmousedown="bookNameClickdown(this)" onmouseup="bookNameClickup(this)">{{bookPrice}}</h3></a>
    </div>
</template>

<script>
    export default {
        name: "Book",
        props:{
            bookName:String,
            bookPrice:String,
            pictureUrl:String
        }
    }
</script>

<style>
    @import url("../users/style.css");
    .book{
        float: left;
        margin-left: 15px;
        margin-right: 15px;
        margin-top: 50px;
    }
    .book a{
        text-decoration: none;
        text-align: center;
    }
    .book img{
        width: 200px;
        height: 250px;
    }
    .book h2,.book h3{
        margin: 0px;
        padding: 5px;
    }
</style>