<template>
  <form>
    <input type="text" v-model="bookName" placeholder="请输入书号"/>
    <input type="file" @change="getFile($event)"/>
    <button @click="upload($event)">提交</button>
  </form>
</template>

<script>
export default {
  data () {
    return {
      file: '',
      bookName: String
    }
  },
  methods: {
    getFile (event) {
      this.file = event.target.files[0]
      console.log(this.file)
    },
    upload: function () {
      event.preventDefault()
      let formData = new FormData()
      formData.append('file', this.file)

      this.$axios.post('/picture/upload/' + this.bookName, formData,
        {headers: {'Content-Type': 'multipart/form-data'}}).then(response => {
        console.log(response)
      }).catch(response => {
        console.log(response)
      })
    }
  }

}
</script>
