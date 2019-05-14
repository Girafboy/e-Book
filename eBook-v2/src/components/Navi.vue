<template>
    <div class="navi">
        <input style="up:-100%" type="button" @click="get()" :value="tip"/>
        <ul>
            <li v-on:click="select='热销书籍'"><router-link to="">热销书籍</router-link></li>
            <li v-on:click="select='小说传记'"><router-link to="">小说传记</router-link></li>
            <li v-on:click="select='动漫卡通'"><router-link to="">动漫卡通</router-link></li>
            <li v-on:click="select='教辅词典'"><router-link to="">教辅词典</router-link></li>
            <li v-on:click="select='政治军事'"><router-link to="">政治军事</router-link></li>
            <li v-on:click="select='哲学宗教'"><router-link to="">哲学宗教</router-link></li>
            <li v-on:click="select='经管营销'"><router-link to="">经管营销</router-link></li>
            <li v-on:click="select='心灵鸡汤'"><router-link to="">心灵鸡汤</router-link></li>
            <li v-on:click="select='育儿家教'"><router-link to="">育儿家教</router-link></li>
            <li v-on:click="select='科技科普'"><router-link to="">科技科普</router-link></li>
            <li v-on:click="select='软件编程'"><router-link to="">软件编程</router-link></li>
            <li v-on:click="select='外文原版'"><router-link to="">外文原版</router-link></li>
            <li v-on:click="select='期刊报纸'"><router-link to="">期刊报纸</router-link></li>
        </ul>
    </div>
</template>

<script>
    export default {
        name: "Navi",
        data:function () {
            return{
                select:'',
                tip:''
            }
        },
        watch:{
            select:function () {
                this.$emit('transfer',this.select)
            }
        },
        methods:{
            get:function () {
                this.tip ="fs";
                this.$axios.get("/BookInfo").then(function (response) {
                    console.log(response);
                }).catch(function (error) {
                    alert("网络连接错误");
                    console.log(error);
                });
            }
        }
    }
</script>

<style>
    @import url("../users/style.css");
    .navi h2,h3{
        margin: 0px;
        padding: 5px;
    }
    .navi ul {
        list-style-type:none;
        position: relative;
        left: 30px;
        margin:0;
        padding:0;
    }
    .navi ul a:link,.navi ul a:visited {
        display:block;
        font-weight:bold;
        width:120px;
        text-align:center;
        padding:4px;
        text-decoration:none;
        text-transform:uppercase;
    }
</style>