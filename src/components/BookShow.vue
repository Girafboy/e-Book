<template>
        <div class="showcase">
            <book
                    v-for="book in books"
                    v-bind:book-id="book.bookID"
                    v-bind:book-name="book.bookName"
                    v-bind:book-price="book.price"
                    v-bind:picture-url="book.coverUrl"
                    v-bind:stock="book.stock"
                    v-bind:key="book.id"
            ></book>
        </div>
</template>

<script>
import Book from './Book'
export default {
  name: 'BookShow',
  components: {
    Book
  },
  props: {
    books: Array
  }
}
</script>

<style>
    @import url("../users/style.css");

</style>
