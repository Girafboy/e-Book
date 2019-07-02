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
  name: 'InputItem',
  props: {
    PreMessage: String,
    type: String,
    value: String,
    placeHolder: String
  }
}
</script>

<style>
    @import url("../users/style.css");
</style>
