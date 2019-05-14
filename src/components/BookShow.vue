<template>
    <div id="bookDisplay" class="display">
        <div class="showcase">
            <book
                    v-for="book in books"
                    v-bind:book-name="book.bookName"
                    v-bind:book-price="book.bookPrice"
                    v-bind:picture-url="book.pictureUrl"
                    v-bind:key="book.id"
            ></book>
        </div>
    </div>
</template>

<script>
    import Book from "./Book";
    export default {
        name: "BookShow",
        components:{
            Book
        },
        props:{
            books:Array
        }
    }
</script>

<style>
    @import url("../users/style.css");

</style>
