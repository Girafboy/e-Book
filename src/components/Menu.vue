<template>
    <div class="menu">
        <span>e</span>
        <ul v-if="type ==='user'">
            <li><router-link to="/">主页</router-link></li>
            <li><router-link to="/cart">购物车</router-link></li>
            <li><router-link to="/order">我的订单</router-link></li>
            <li><router-link to="/setting">个人设置</router-link></li>
        </ul>
        <ul v-if="type === 'admi'" >
            <li><router-link style="width: 180px" to="/admihome">主页</router-link></li>
            <li><router-link style="width: 180px" to="/warehouse">仓库</router-link></li>
            <li><router-link style="width: 180px" to="/usermanage">用户管理</router-link></li>
            <li><router-link style="width: 180px" to="/admiorder">订单管理</router-link></li>
            <li><router-link style="width: 180px" to="/admisetting">个人设置</router-link></li>
        </ul>
    </div>
</template>

<script>
export default {
  name: 'Menu',
  props: {
    type: {
      type: String,
      default: 'user'
    }
  }
}
</script>

<style>
    @import url("../users/style.css");

</style>
